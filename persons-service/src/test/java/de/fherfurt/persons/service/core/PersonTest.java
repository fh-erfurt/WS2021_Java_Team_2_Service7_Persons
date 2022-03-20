package de.fherfurt.persons.service.core;

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
        switch (facultyName)
        {
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
}