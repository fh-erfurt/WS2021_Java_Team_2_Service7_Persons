package de.fherfurt.persons.service.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;


/**
 * @Author Milena Neumann
 */
class FacultyTest {

    @Test
    void testCheckFacultyName() {

        //given
        String testFaculty = "ASP";
        Faculty testInstance = new Faculty("Architektur und Stadtplanung");
        //when

        //then
        Assertions.assertThat(testInstance.checkFacultyName("Architektur und Stadtplanung"))
                .isEqualTo(testFaculty)
                .isNotNull()
                .isNotEqualTo("Architektur und Stadtplanung");
    }
}