package de.fherfurt.persons.service.core;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

/**
 * @author Milena Neumann
 */
class InputFieldTest
{

    /**
     * @author Milena Neumann
     */
    @Test
    void getListSearchInput()
    {
        //given
        InputField TestInputField = new InputField("Frank", "Schneider", "Mathematik", "Gebaeudetechnik und Informatik");  //warum muss ich faculty davor schreiben wenn im construktor der Typ ist`?
        ArrayList<String> ListToCompare = new ArrayList<>();
        ListToCompare.add("Frank");
        ListToCompare.add("Schneider");
        ListToCompare.add("Mathematik");
        ListToCompare.add("Gebaeudetechnik und Informatik");
        //when
        TestInputField.setListSearchInput();
        //then
        System.out.println(TestInputField.getListSearchInput());
        Assertions.assertThat(TestInputField.getListSearchInput())
                .isEqualTo(ListToCompare)
                .isNotNull()
                .isNotEqualTo("3");
    }


    /**
     * @author Milena Neumann
     * This testszenario should print aut some errormessges because we test if the error control is functioning.
     * in this case it behaves like expected
     */
    @Test
    void checkStringValid()
    {
                //given
        String testStringA = "HelloIAmAVeryLongStringAndIAmVerySorryForThat";
        String testStringB = " FirstLetterIsASpace";
        String testStringC = "!?!";
        String testStringD = "Anna-Maria Elisabeth";
        //when

        //then
        Assertions.assertThat(InputField.checkStringValid(testStringA))
                .isFalse();
        Assertions.assertThat(InputField.checkStringValid(testStringB))
                .isFalse();
        Assertions.assertThat(InputField.checkStringValid(testStringC))
                .isFalse();

        Assertions.assertThat(InputField.checkStringValid(testStringD))
                .isTrue();
    }
}