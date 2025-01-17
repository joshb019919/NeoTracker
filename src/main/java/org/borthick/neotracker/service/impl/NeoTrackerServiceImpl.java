package org.borthick.neotracker.service.impl;

import org.borthick.neotracker.dao.NeoTrackerDao;
import org.borthick.neotracker.model.NearEarthObject;
import org.borthick.neotracker.service.NeoTrackerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NeoTrackerServiceImpl implements NeoTrackerService {
    private final NeoTrackerDao neoTrackerDao;

    @Autowired
    public NeoTrackerServiceImpl(NeoTrackerDao neoTrackerDao) {
        this.neoTrackerDao = neoTrackerDao;
    }

    /**
     * Save an object to the database if not present.
     *
     * @param object The name of the near Earth object.
     * @return The
     */
    public String saveObject(NearEarthObject object) {
        String saved = null;
        if (this.existsByName(object.getName())) {
            neoTrackerDao.save(object);
            saved = object.getName();
        }
        return saved;
    }

    /**
     * Save a list of objects to the database where not present.
     *
     * @param objects The near Earth objects to save.
     * @return A list of the names of which objects were saved.
     */
    public List<String> saveObjects(List<NearEarthObject> objects) {
        List<String> saved = new java.util.ArrayList<>();
        objects.forEach(o -> {
            if (this.existsByName(o.getName())) {
                saveObject(o);
            }
            saved.add(o.getName());
        });
        return saved;
    }

    /**
     * Find an object in the database.
     *
     * @param name The name of the near Earth object.
     * @return True if found, else false.
     */
    public boolean existsByName(String name) {
        return neoTrackerDao.existsByName(name);
    }

    /**
     * Find an object in the database.
     *
     * @param name The name of the near Earth object.
     * @return The near Earth object if found, else null.
     */
    public NearEarthObject findObjectByName(String name) {
        return neoTrackerDao.findObjectByName(name);
    }
}
