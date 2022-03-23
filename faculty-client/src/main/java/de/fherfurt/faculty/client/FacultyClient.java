package de.fherfurt.faculty.client;


import de.fherfurt.faculty.client.transfer.object.FacultyDto;


/**
 * This interface is given by the Campus Service
 * @author Faculty Team
 */
public interface FacultyClient {
     FacultyDto getFacultyByName (String facultyName);
}
