package de.fherfurt.persons.service.model;

import java.util.ArrayList;
import java.util.LinkedHashMap;

/**
 * @author Tran Anh Hoang
 * The SearchingHistory - Class will include and display the last 5 Elements of the UserSearch
 * so later the user can see his last 5 searchings and can search persons which he searches in last time easier
 */
public class SearchingHistory
{
    private final static SearchingHistory userSearchHistory = new SearchingHistory();
    private SearchingHistory() {}
    private final LinkedHashMap<Integer, ArrayList<String> > searchHistoryMap = new LinkedHashMap<>();
    private int HashMapKey = 0;


    public static SearchingHistory getInstance(){
        return userSearchHistory;
    }

    /**
     * The methode sets a HashMapKey and the DisplayName into a LinkedHashMap.
     * After using a HashMapKey which reaches the number 5. The methode will be using the else-branch and the HashMapKey reset to 0.
     * Because of the HashMapKey reset, the first element of map will be overwritten by the new DisplayName.
     * After that the methode will go back into the if-branch and overwrite the second element and so on.
     */
    public void setSearchHistoryMap(ArrayList<String> PersonInputData) {

        if(this.HashMapKey < 5) {
            searchHistoryMap.put(HashMapKey, PersonInputData);
            this.HashMapKey = HashMapKey + 1;
        }
        else{
            this.HashMapKey = 0;
            searchHistoryMap.put(HashMapKey, PersonInputData);
            this.HashMapKey = HashMapKey + 1;
        }

    }

    public LinkedHashMap<Integer, ArrayList<String>> getSearchHistoryMap() {
        return searchHistoryMap;
    }

    /**
     * Clears entire Map
     */
    public void clearEntireMap() {
        searchHistoryMap.clear();
    }
}
