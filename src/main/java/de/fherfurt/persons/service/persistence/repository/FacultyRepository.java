package de.fherfurt.persons.service.persistence.repository;

import de.fherfurt.persons.service.model.Faculty;

/**
 * @author Milena Neumann
 * Repository with exported faculty methods
 */
public interface FacultyRepository {
    String checkFacultyName( String facultyName );
}
