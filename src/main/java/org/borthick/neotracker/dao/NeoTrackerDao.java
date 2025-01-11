package org.borthick.neotracker.dao;

import org.borthick.neotracker.model.NearEarthObject;
import org.borthick.neotracker.service.impl.NeoTrackerServiceImpl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface NeoTrackerDao extends JpaRepository<NearEarthObject, Long> {

    /**
     * Find if an object is in the repository.
     * @param name The name of the near Earth object.
     * @return True if found, else false.
     */
    @Query("select (count(n) > 0) from NearEarthObject n where upper(n.name) = upper(:name)")
    boolean existsByName(@Param("name") @NonNull String name);

    /**
     * Find an object in the repository.
     * @param name The name of the near Earth object.
     * @return The object model.
     */
    @Query("select n from NearEarthObject n where upper(n.name) = upper(:name)")
    NearEarthObject findObjectByName(@Param("name") @NonNull String name);
}
