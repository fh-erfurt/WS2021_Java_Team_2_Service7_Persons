package de.fherfurt.persons.service.model;

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
        InputField testInputField = new InputField("Frank", "Schneider", "Mathematik", "Gebaeudetechnik und Informatik");  //warum muss ich faculty davor schreiben wenn im construktor der Typ ist`?
        ArrayList<String> listToCompare = new ArrayList<>();
        listToCompare.add("Frank");
        listToCompare.add("Schneider");
        listToCompare.add("Mathematik");
        listToCompare.add("Gebaeudetechnik und Informatik");

        //when
        testInputField.setListSearchInput();

        //then
        System.out.println(testInputField.getListSearchInput());
        Assertions.assertThat(testInputField.getListSearchInput())
                .isEqualTo(listToCompare)
                .isNotNull()
                .isNotEqualTo("3");
    }


    /**
     * @author Milena Neumann
     * This testszenario should print aut some errormessages because I test if the error control is functioning.
     * in this case it behaves like expected
     * the consoltext comes from the classes itself, not from the test
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