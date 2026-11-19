package ca.hccis.squash.repositories;

import ca.hccis.squash.jpa.entity.PlayerTrackerData;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerTrackerDataRepository extends CrudRepository<PlayerTrackerData, Integer> {
    /**
     * Use Spring Data JPA functionality to find a list  containing the
     * string passed in as a paramter.
     *
     * @param name The name to find
     * @return The list of items
     * @since 20261118
     * @author Thomas McNally
     */
    //https://www.baeldung.com/spring-jpa-like-queries
    List<PlayerTrackerData> findByPlayerFirstNameContaining(String name);
    List<PlayerTrackerData> findByPlayerLastNameContaining(String name);

}