package de.fherfurt.persons.service.core;

import java.util.ArrayList;
import java.util.LinkedHashMap;

/**
 * @author Tran Anh Hoang
 * The SearchingHistory - Class will include and display the last 5 Elements of the UserSearch
 */
public class SearchingHistory
{
    private final static SearchingHistory UserSearchHistory = new SearchingHistory();

    private final LinkedHashMap<Integer, ArrayList<String> > SearchHistoryMap = new LinkedHashMap<>();
    private int HashMapKey = 0;

    /**
     * The Methode set a HashMapKey and the DisplayName into a LinkedHashMap.
     * After using a HashMapKey reach the Number 5. The methode will be using the else-branch and the HashMapKey reset to 0.
     * Because of the HashMapKey reset. The First Element of Map the will be overrite by new DisplayName.
     * After that the Methode will go back inti the if-branch and overwrite the second element and so on.
     */

    public static SearchingHistory getInstance(){
        return UserSearchHistory;
    }

    /**
     *
     * @param PersonInputData
     */
    public void setSearchHistoryMap(ArrayList<String> PersonInputData ) {

        if(this.HashMapKey < 6) {
            SearchHistoryMap.put(HashMapKey, PersonInputData);
            this.HashMapKey = HashMapKey + 1;
        }
        else{
            this.HashMapKey = 0;
            SearchHistoryMap.put(HashMapKey, PersonInputData);
            this.HashMapKey = HashMapKey + 1;
        }

    }

    public LinkedHashMap<Integer, ArrayList<String> > getSearchHistoryMap() {
        return SearchHistoryMap;
    }

    /**
     * Clear entire Map
     */
    private void clearEntireMap() {
        SearchHistoryMap.clear();
    }

}
