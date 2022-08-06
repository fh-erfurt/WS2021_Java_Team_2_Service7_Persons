package de.fherfurt.persons.service.persistence.repository;

import de.fherfurt.persons.service.model.Address;
import de.fherfurt.persons.service.model.Faculty;

import java.util.List;

/**
 * @author Milena Neumann
 * Repository with exported faculty methods
 */
public interface FacultyRepository {
    List<Faculty> findAllFaculty();
    Faculty findFacultyBy(Long facultyId );
    boolean updateFacultyBy(Faculty faculty );
    boolean deleteFacultyBy(Long facultyId  );
}
