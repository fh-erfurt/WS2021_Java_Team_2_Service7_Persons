package de.fherfurt.persons.service.core;

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
        InputField UserInputTestObjOne = new InputField("Hannah", "Enfield", "BWL", "Wirtschaft-Logistik-Verkehr");

        ArrayList<String> TestList = new ArrayList<>();
        TestList.add("Hannah");
        TestList.add("Enfield");
        TestList.add("BWL");
        TestList.add("Wirtschaft Logistik Verkehr");


        ArrayList<String> TestListTwo = new ArrayList<>();
        TestListTwo.add("Eren");
        TestListTwo.add("Jaeger");
        TestListTwo.add("Informatik");
        TestListTwo.add("Gebaeudetechnik und Informatik");

        //when
        UserInputTestObjOne.setListSearchInput();
        UserInputTestObjOne.triggerSearchingHistory();

        //then
        Assertions.assertThat(SearchingHistory.getInstance().getSearchHistoryMap())
                .isNotEmpty()
                .containsKey(0)
                .containsValue(TestList);


        //System.out.println(SearchingHistory.getInstance().getSearchHistoryMap().get(0));

        //given
        InputField  UserInputTestObjTwo = new InputField("Justus", "Fritz", "BWL", "Wirtschaft-Logistik-Verkehr");
        InputField  UserInputTestObjThree = new InputField("Manfred", "Heinrich", "Informatik", "Gebaeudetechnik und Informatik");
        InputField  UserInputTestObjFour = new InputField("Alfred", "Gotha", "BWL", "Wirtschaft-Logistik-Verkehr");
        InputField  UserInputTestObjFive= new InputField("Mikasa", "Ackermann", "Informatik", "Gebaeudetechnik und Informatik");
        InputField  UserInputTestObjSix = new InputField("Eren", "Jaeger", "Informatik", "Gebaeudetechnik und Informatik");


        //then
        UserInputTestObjTwo.setListSearchInput();
        UserInputTestObjTwo.triggerSearchingHistory();

        UserInputTestObjThree.setListSearchInput();
        UserInputTestObjThree.triggerSearchingHistory();

        UserInputTestObjFour.setListSearchInput();
        UserInputTestObjFour.triggerSearchingHistory();

        UserInputTestObjFive.setListSearchInput();
        UserInputTestObjFive.triggerSearchingHistory();

        UserInputTestObjSix.setListSearchInput();
        UserInputTestObjSix.triggerSearchingHistory();


        //when
        Assertions.assertThat(SearchingHistory.getInstance().getSearchHistoryMap().get(0))
                .isNotEmpty()
                .contains("Eren", "Jaeger", "Informatik","Gebaeudetechnik und Informatik")
                .isEqualTo(TestListTwo);

        //System.out.println(SearchingHistory.getInstance().getSearchHistoryMap().get(0));
    }

    @Test
    public void clearEntireMap(){

        //when
        SearchingHistory.getInstance().clearEntireMap();

        //then
        Assertions.assertThat(SearchingHistory.getInstance().getSearchHistoryMap())
                .isEmpty();

        System.out.println(SearchingHistory.getInstance().getSearchHistoryMap());
   }
}