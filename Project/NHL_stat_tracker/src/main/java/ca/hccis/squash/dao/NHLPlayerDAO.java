package ca.hccis.squash.dao;

import ca.hccis.squash.jpa.entity.Playertrackerdata;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * DAO class to access db.
 *
 * @author bjmaclean
 * @since 20251009
 */
public class NHLPlayerDAO {

    private static ResultSet rs;
    private static Connection conn = null;
    private static final Logger logger = LoggerFactory.getLogger(NHLPlayerDAO.class);

    public NHLPlayerDAO() {

        String propFileName = "application";
        ResourceBundle rb = ResourceBundle.getBundle(propFileName);
        String connectionString = rb.getString("spring.datasource.url");
        String userName = rb.getString("spring.datasource.username");
        String password = rb.getString("spring.datasource.password");

        try {
            conn = DriverManager.getConnection(connectionString, userName, password);
        } catch (SQLException e) {
            logger.error(e.toString());
        }

    }

    /**
     * Select all
     *
     * @since 20210924
     * @author BJM
     */
    public ArrayList<Playertrackerdata> selectAll() {
        ArrayList<Playertrackerdata> assessments = null;
        Statement stmt = null;

        //******************************************************************
        //Use the DriverManager to get a connection to our MySql database.  Note
        //that in the dependencies, we added the Java connector to MySql which 
        //will allow us to connect to a MySql database.
        //******************************************************************
        //******************************************************************
        //Create a statement object using our connection to the database.  This 
        //statement object will allow us to run sql commands against the database.
        //******************************************************************
        try {

            stmt = conn.createStatement();
            rs = stmt.executeQuery("select * FROM PlayerTrackerData;");

            //******************************************************************
            //Loop through the result set using the next method.  
            //******************************************************************
            assessments = new ArrayList();

            while (rs.next()) {

                Playertrackerdata player = new Playertrackerdata();
                player.setId(rs.getInt("id"));
                player.setPlayerFirstName(rs.getString("playerFirstName"));
                player.setPlayerLastName(rs.getString("playerLastName"));
                player.setPlayerMatches(rs.getInt("playerMatches"));
                player.setPlayerWins(rs.getInt("playerWins"));
                player.setPlayerLosses(rs.getInt("playerLosses"));
                player.setPlayerShots(rs.getInt("playerShots"));
                player.setPlayerGoals(rs.getInt("playerGoals"));
                player.setPlayerAssists(rs.getInt("playerAssists"));
                player.setPlayerPoints(rs.getInt("playerPoints"));
                player.setPlayerScoringPercentage(rs.getInt("playerScoringPercentage"));
                player.setPlayerPenaltyMin(rs.getFloat(("playerPenaltyMin")));
                player.setPlayerSaves(rs.getInt("playerSaves"));
                player.setPlayerPosition(rs.getString("playerPosition"));
                player.setPlayerPointsPerGame(rs.getInt("playerPointsPerGame"));

                assessments.add(player);
            }

        } catch (SQLException e) {

            e.printStackTrace();

        } finally {

            try {
                stmt.close();
            } catch (SQLException ex) {
                System.out.println("There was an error closing");
            }
        }
        return assessments;
    }

    /**
     * Select all by athlete/assessor name
     *
     * @since 20251009
     * @author BJM
     */
    public ArrayList<Playertrackerdata> selectByNameAndPosition(String lastName, String position) {
        ArrayList<Playertrackerdata> assessments = null;
        Statement stmt = null;

        //******************************************************************
        //Use the DriverManager to get a connection to our MySql database.  Note
        //that in the dependencies, we added the Java connector to MySql which
        //will allow us to connect to a MySql database.
        //******************************************************************
        //******************************************************************
        //Create a statement object using our connection to the database.  This
        //statement object will allow us to run sql commands against the database.
        //******************************************************************
        try {

            stmt = conn.createStatement();
            String sqlStatement = "select * from PlayerTrackerData " +
                    "where playerLastName = '"+lastName+"' and playerPosition = '"+position+"' " +
                    "ORDER BY playerPointsPerGame DESC;";
            rs = stmt.executeQuery(sqlStatement);

            //******************************************************************
            //Loop through the result set using the next method.
            //******************************************************************
            assessments = loadList(rs);

        } catch (SQLException e) {

            e.printStackTrace();

        } finally {

            try {
                stmt.close();
            } catch (SQLException ex) {
                System.out.println("There was an error closing");
            }
        }
        return assessments;
    }


    public ArrayList<Playertrackerdata> loadList(ResultSet rs) throws SQLException {
        ArrayList<Playertrackerdata> assessments = new  ArrayList();

        while (rs.next()) {

            Playertrackerdata player = new Playertrackerdata();
            player.setId(rs.getInt("id"));
            player.setPlayerFirstName(rs.getString("playerFirstName"));
            player.setPlayerLastName(rs.getString("playerLastName"));
            player.setPlayerMatches(rs.getInt("playerMatches"));
            player.setPlayerWins(rs.getInt("playerWins"));
            player.setPlayerLosses(rs.getInt("playerLosses"));
            player.setPlayerShots(rs.getInt("playerShots"));
            player.setPlayerGoals(rs.getInt("playerGoals"));
            player.setPlayerAssists(rs.getInt("playerAssists"));
            player.setPlayerPoints(rs.getInt("playerPoints"));
            player.setPlayerScoringPercentage(rs.getInt("playerScoringPercentage"));
            player.setPlayerPenaltyMin(rs.getFloat(("playerPenaltyMin")));
            player.setPlayerSaves(rs.getInt("playerSaves"));
            player.setPlayerPosition(rs.getString("playerPosition"));
            player.setPlayerPointsPerGame(rs.getInt("playerPointsPerGame"));

            assessments.add(player);
        }
        return assessments;
    }


}
