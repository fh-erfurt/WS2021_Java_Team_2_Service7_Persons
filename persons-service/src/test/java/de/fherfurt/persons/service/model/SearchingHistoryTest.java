package de.fherfurt.persons.service.model;

import de.fherfurt.persons.service.resources.InputField;
import de.fherfurt.persons.service.resources.SearchingHistory;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

/**
 * @author Tran Anh Hoang
 */
public class SearchingHistoryTest  {

    @Test
    public void testSetSearchHistoryMap() {
        //given
        InputField userInputTestObjOne = new InputField("Hannah", "Enfield", "BWL", "Wirtschaft-Logistik-Verkehr");

        ArrayList<String> testList = new ArrayList<>();
        testList.add("Hannah");
        testList.add("Enfield");
        testList.add("BWL");
        testList.add("Wirtschaft Logistik Verkehr");

        ArrayList<String> testListTwo = new ArrayList<>();
        testListTwo.add("Eren");
        testListTwo.add("Jaeger");
        testListTwo.add("Informatik");
        testListTwo.add("Gebaeudetechnik und Informatik");

        //when
        userInputTestObjOne.setListSearchInput();
        userInputTestObjOne.triggerSearchingHistory();

        //then
        Assertions.assertThat(SearchingHistory.getInstance().getSearchHistoryMap())
                .isNotEmpty()
                .containsKey(0)
                .containsValue(testList);

        //given
        InputField userInputTestObjTwo = new InputField("Justus", "Fritz", "BWL", "Wirtschaft-Logistik-Verkehr");
        InputField userInputTestObjThree = new InputField("Manfred", "Heinrich", "Informatik", "Gebaeudetechnik und Informatik");
        InputField userInputTestObjFour = new InputField("Alfred", "Gotha", "BWL", "Wirtschaft-Logistik-Verkehr");
        InputField userInputTestObjFive= new InputField("Mikasa", "Ackermann", "Informatik", "Gebaeudetechnik und Informatik");
        InputField userInputTestObjSix = new InputField("Eren", "Jaeger", "Informatik", "Gebaeudetechnik und Informatik");

        //then
        userInputTestObjTwo.setListSearchInput();
        userInputTestObjTwo.triggerSearchingHistory();

        userInputTestObjThree.setListSearchInput();
        userInputTestObjThree.triggerSearchingHistory();

        userInputTestObjFour.setListSearchInput();
        userInputTestObjFour.triggerSearchingHistory();

        userInputTestObjFive.setListSearchInput();
        userInputTestObjFive.triggerSearchingHistory();

        userInputTestObjSix.setListSearchInput();
        userInputTestObjSix.triggerSearchingHistory();

        //when
        Assertions.assertThat(SearchingHistory.getInstance().getSearchHistoryMap().get(0))
                .isNotEmpty()
                .contains("Eren", "Jaeger", "Informatik","Gebaeudetechnik und Informatik")
                .isEqualTo(testListTwo);
    }

    @Test
    public void clearEntireMap(){

        //when
        SearchingHistory.getInstance().clearEntireMap();

        //then
        Assertions.assertThat(SearchingHistory.getInstance().getSearchHistoryMap())
                .isEmpty();
   }
}