package de.fherfurt.faculty.client;


import de.fherfurt.faculty.client.transfer.object.FacultyDto;

public interface FacultyClient {
     FacultyDto getFacultyByName (String facultyName);
}
