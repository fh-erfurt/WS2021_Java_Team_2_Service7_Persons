package de.fherfurt.persons.service.persistence.repository;

import de.fherfurt.persons.service.model.Address;
import de.fherfurt.persons.service.model.Faculty;

import java.util.List;


/**
 * The interface FacultyRepository represent the abstract layer between FacultyResources and Repository-Layer.
 *
 * @author Tran Anh Hoang
 * @version 2.0.0.0
 */
public interface FacultyRepository {
    List<Faculty> findAllFaculty();

    Faculty findFacultyBy(Long facultyId);

    boolean updateFacultyBy(Faculty faculty);

    boolean deleteFacultyBy(Long facultyId);
}
