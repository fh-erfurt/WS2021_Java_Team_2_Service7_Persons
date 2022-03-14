package de.fherfurt.persons.service.core;

import java.util.ArrayList;
import java.util.LinkedHashMap;


/**
 * @author Tran Anh Hoang
 * The SearchingHistory - Class will include and display the last 5 Elements of the UserSearch
 */
public class SearchingHistory
{
    ArrayList <String> ShortedUserSearchList                            = new ArrayList<>();
    private LinkedHashMap<Integer, String> SearchHistoryMap             = new LinkedHashMap<>();
    private String SubStringFirstName;
    private String SubStringLastName;
    private String DisplayName;
    private int HashMapKey = 0;
    private int FirstElementOfArrayList = 0;
    private int SecondElementOfArrayList = 1;


    /**
     * //keySet()      - get all keys in the map
     * //iterator()    - looping through the each key of the map
     * //next ()       - returns the next element of the list
     * //keySet().iterator().next() --> return the first Key-Element of the Map
     */

    private Object FirstMapKey = SearchHistoryMap.keySet().iterator().next();


    /**
     * pull the ArrayList from the InputSearch and get the First Element of this Array List, which is always the Firstname of a Person
     */
    //Set the first Element from the ArrayList in SubStringFirstName
    public void getSubStringFirstNameFromArrayList() {
        SearchingSystem UserSearch = new SearchingSystem();
        this.SubStringFirstName = UserSearch.getSearchInputData().get(this.FirstElementOfArrayList);
    }

    /**
     *  pull the ArrayList from the InputSearch and get the First Element of this Array List, which is always the Lastname of a Person
     */
    //Set the second Element from the ArrayList in SubStringLastName
    public void getSubStringLastNameFromArrayList() {
        SearchingSystem UserSearch = new SearchingSystem();
        this.SubStringLastName = UserSearch.getSearchInputData().get(this.SecondElementOfArrayList);
    }


    /**
     * Concat the First- and Lastname from the UserInput ArrayList into a string DisplayName
     */
    //concat SubStringLastName and SubStringFirstName to DisplayName
    public void concatUserSearchName() {
        this.DisplayName = SubStringFirstName + SubStringFirstName;
    }

    /**
     * The Mothode set a HashMapKey and the DisplayName into a LinkedHashMap.
     * After using a HashMapKey reach the Number 5. The methode will be using the else-branch and the HashMapKey reset to 0.
     * Because of the HashMapKey reset. The First Element of Map the will be overrite by new DisplayName.
     * After that the Methode will go back inti the if-branch and overwrite the second element and so on.
     */

    public void setSearchHistoryMap() {
        if(this.HashMapKey < 6) {
            SearchHistoryMap.put(HashMapKey, DisplayName);
            this.HashMapKey = HashMapKey + 1;
        }
        else{
            this.HashMapKey = 0;
            SearchHistoryMap.put(HashMapKey, DisplayName);
            this.HashMapKey = HashMapKey + 1;
        }

    }

    public LinkedHashMap<Integer, String> getSearchHistoryMap() {
        return SearchHistoryMap;
    }

    /**
     * Clear entire Map
     */
    private void clearEntireMap() {
        SearchHistoryMap.clear();
    }

}
