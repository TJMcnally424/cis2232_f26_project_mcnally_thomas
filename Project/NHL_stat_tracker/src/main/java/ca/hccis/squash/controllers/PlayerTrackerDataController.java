package ca.hccis.squash.controllers;

import ca.hccis.squash.bo.SkillsAssessmentSquashTechnicalValidationBO;
import ca.hccis.squash.entity.PlayerTrackerDataDto;
import ca.hccis.squash.jpa.entity.CodeValue;
import ca.hccis.squash.jpa.entity.PlayerTrackerData;
import ca.hccis.squash.repositories.CodeValueRepository;
import ca.hccis.squash.repositories.PlayerTrackerDataRepository;
import ca.hccis.squash.bo.PlayerTrackerBO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/playertrackerdata")
public class PlayerTrackerDataController {

    private final PlayerTrackerDataRepository _ptdcr;
    private final CodeValueRepository _cvr;

    @Autowired
    public PlayerTrackerDataController(PlayerTrackerDataRepository ptdcr, CodeValueRepository cvr) {
        _ptdcr = ptdcr;
        _cvr = cvr;
    }

    @Autowired
    private MessageSource messageSource;
    private static final Logger logger = LoggerFactory.getLogger(PlayerTrackerDataController.class);

    @RequestMapping("")
    public String home(Model model, HttpSession session) {

        //Example for dynamic list using CodeValue
        //Work with the CodeValueRepository
        Iterable<CodeValue> codeValues = _cvr.findAll();
        ArrayList<CodeValue> skillTypes = new ArrayList<>();
        for (CodeValue codeValue : codeValues) {
            final int CODE_TYPE_ID_SKILL_TYPES = 2;
            if (codeValue.getId().getCodeTypeId() == CODE_TYPE_ID_SKILL_TYPES) {
                skillTypes.add(codeValue);
            }
        }
        session.setAttribute("skillTypes", skillTypes);

        Iterable<PlayerTrackerData> assessments = _ptdcr.findAll();
        model.addAttribute("assessments", assessments);
        model.addAttribute("assessment", new PlayerTrackerData());
        return "playertrackerdata/list";
    }

    /**
     * Page to delete an entity
     *
     * @param id ID
     * @return redirect to the list page
     * @author BJM
     * @since 20251201
     */
    @RequestMapping("/delete/{id}")
    public String delete(Model model, @PathVariable int id) {
        try {
            _ptdcr.deleteById(id);
            model.addAttribute("messageSuccess", "Assessment deleted");
        } catch (Exception e) {
            model.addAttribute("messageError", "Exception deleting assessment");
        }
        Iterable<PlayerTrackerData> assessments = _ptdcr.findAll();
        model.addAttribute("assessments", assessments);
        model.addAttribute("assessment", new PlayerTrackerData());
        return "playertrackerdata/list";
    }

    /**
     * Page to add new entity. Taken from tutor app from 2022 (which was
     * also derived from class samples)
     *
     * @param model
     * @return add
     * @author BJM
     * @since 2025-12-01
     */
    @RequestMapping("/add")
    public String add(Model model, HttpSession session) {

        PlayerTrackerData playerTrackerData = new PlayerTrackerData();
        model.addAttribute("skillsAssessment", playerTrackerData);
        return "playertrackerdata/add";
    }

    /**
     * Page to edit
     *
     * @param id    ID
     * @param model
     * @author BJM
     * @since 20251201
     */
    @RequestMapping("/edit/{id}")
    public String edit(@PathVariable int id, Model model, HttpSession session) {

        Optional playerTrackerData = _ptdcr.findById(id);
        if (playerTrackerData.isPresent()) {
            model.addAttribute("skillsAssessment", playerTrackerData.get());
            return "playertrackerdata/add";
        }

        model.addAttribute("messageError", "Could not load the assessment");
        Iterable<PlayerTrackerData> assessments = _ptdcr.findAll();
        model.addAttribute("assessments", assessments);
        model.addAttribute("assessment", new PlayerTrackerData());
        return "playertrackerdata/list";
    }

    /**
     * Submit method that processes add and edit and any form submission
     *
     * @param model
     * @param request
     * @param playerTrackerData what is being added or modified
     * @return add with errors or busPass
     * @author CIS2232
     * @since 20251201
     */
    @RequestMapping("/submit")
    public String submit(Model model, HttpServletRequest request, @Valid @ModelAttribute("playerData") PlayerTrackerData playerTrackerData) {

        //Calculate stats before saving.
        playerTrackerData.setPlayerPoints(PlayerTrackerBO.totalPoints(playerTrackerData));
        playerTrackerData.setPlayerPointsPerGame(PlayerTrackerBO.pointsPerGame(playerTrackerData));
        playerTrackerData.setPlayerScoringPercentage(PlayerTrackerBO.scoringPercentage(playerTrackerData));
        _ptdcr.save(playerTrackerData);
        return "redirect:/playertrackerdata";
    }

    /**
     * Search for a player name
     *
     * @param model
     * @return view for list
     * @author BJM
     * @since 2025-12-01
     */
    @RequestMapping("/search")
    public String search(Model model, @ModelAttribute("assessment") PlayerTrackerData playerTrackerData) {

        //**********************************************************************
        //Use repository method created to find any entities which contain
        //the name entered on the list page.
        //**********************************************************************

        List<PlayerTrackerData> firstName = _ptdcr.findByPlayerFirstNameContaining(playerTrackerData.getPlayerFirstName());
        List<PlayerTrackerData> lastName = _ptdcr.findByPlayerLastNameContaining(playerTrackerData.getPlayerFirstName());

        //put in set to eliminate duplicates
        HashSet<PlayerTrackerData> playerTrackerDataSet = new HashSet<>();
        playerTrackerDataSet.addAll(firstName);
        playerTrackerDataSet.addAll(lastName);

        model.addAttribute("assessments", playerTrackerDataSet);
        //logger.debug("searched for name:" + playerTrackerData.getPlayerFirstName());
        return "playertrackerdata/list";
    }

    @RequestMapping("/list/edit")
    public String showCreateForm(Model model) {
        PlayerTrackerDataDto playerTrackerDataForm = new PlayerTrackerDataDto();


        Iterable<PlayerTrackerData> assessments = _ptdcr.findAll();
        ArrayList<PlayerTrackerData> tempList = new ArrayList<>();
        for (PlayerTrackerData current : assessments) {
            tempList.add(current);
        }
        playerTrackerDataForm.setAssessments(tempList);
        model.addAttribute("form", playerTrackerDataForm);
        return "playertrackerdata/listedit";
    }

    @RequestMapping("/list/edit/submit")
    public String listEditSubmit(@ModelAttribute PlayerTrackerDataDto form, Model model) {

        //TODO calculate all scores before saving

        _ptdcr.saveAll(form.getAssessments());

        PlayerTrackerDataDto playerTrackerDataForm = new PlayerTrackerDataDto();

        Iterable<PlayerTrackerData> assessments = _ptdcr.findAll();
        ArrayList<PlayerTrackerData> tempList = new ArrayList<>();
        for (PlayerTrackerData current : assessments) {
            tempList.add(current);
            //Calculate and save new values
            current.setPlayerPoints(PlayerTrackerBO.totalPoints(current));
            current.setPlayerPointsPerGame(PlayerTrackerBO.pointsPerGame(current));
            current.setPlayerScoringPercentage(PlayerTrackerBO.scoringPercentage(current));
            _ptdcr.save(current);
        }
        playerTrackerDataForm.setAssessments(tempList);
        model.addAttribute("form", playerTrackerDataForm);
        return "playertrackerdata/listedit";

    }
}

