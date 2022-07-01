package de.fherfurt.persons.service.model;

import de.fherfurt.campus.client.DevCampusService;
import de.fherfurt.persons.service.persistence.repository.PersonRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import de.fherfurt.faculty.client.transfer.object.FacultyDto;

/**
 * @author Tran Anh Hoang
 */
public class PersonTest {

    @Test
    public void testGetFacultyByName()
    {
        //given
        String result;
        String facultyName = "Gebaeudetechnik und Informatik";

        //then
        switch (facultyName) {
            case "Gebaeudetechnik und Informatik" -> result = FacultyDto.GTI.toString();
            case "Landschaftsarchitektur, Gartenbau und Forst" -> result = FacultyDto.LGF.toString();
            case "Wirtschaft-Logistik-Verkehr" -> result = FacultyDto.WLV.toString();
            case "Bauingenieurwesen und Konservierung/Restaurierung" -> result = FacultyDto.BKR.toString();
            case "Architektur und Stadtplanung" -> result = FacultyDto.ASP.toString();
            case "Angewandte Sozialwissenschaften" -> result = FacultyDto.ASW.toString();
            default -> result = FacultyDto.NULL.toString();
        }

        //when
        Assertions.assertThat(result).isEqualTo("Gebaeudetechnik und Informatik");
    }

    @Test
    public void testCheckIfRoomExist(){
        //given
        SearchingSystem testSearch = new SearchingSystem();
        String firstRoom = "Audimax";
        String secondRoom = "5.E.09";
        String thirdRoom = "5.E.10";
        String fourthRoom = "5.E.11";
        String fifthRoom = "5.E.12";

        //then
        DevCampusService.getInstance().saveRooms(firstRoom);
        DevCampusService.getInstance().saveRooms(secondRoom);
        DevCampusService.getInstance().saveRooms(thirdRoom);
        DevCampusService.getInstance().saveRooms(fourthRoom);
        DevCampusService.getInstance().saveRooms(fifthRoom);
        PersonRepository.getInstance().persist(Person.lecturer(41, "Micheal", "Rhöse", "MichealRhöse@fh-erfurt.de",
                "+49/2561925", "Dozent", "18.08.2021", "Gebaeudetechnik und Informatik", true, "5.E.12", false));

        //when
        Assertions.assertThat(testSearch.findPersonBy(41).orElseThrow().getRoom()).isEqualTo("5.E.12");
    }
}