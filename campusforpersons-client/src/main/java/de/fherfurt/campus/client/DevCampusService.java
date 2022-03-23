package de.fherfurt.campus.client;

import java.util.ArrayList;

/**
 * @author Tran Anh Hoang
 * This class is the experimental implementation of the interface of the Campus Service. Structure was given by the Campus Service.
 */
public class DevCampusService implements CampusForPersonsClient {

        static final private DevCampusService Campus = new DevCampusService();
        private DevCampusService(){
        }

        private final ArrayList<String> ListOfRooms = new ArrayList<>();

        /**
         * Save the existing rooms from the FH-Erfurt in an ArrayList
         * @param Rooms String of a Room from the FH-Erfurt
         */
        public void saveRooms(String Rooms){
                this.ListOfRooms.add(Rooms);
        }

        /**
         * @return ListOfRooms as an ArrayList<String>
         */
        public ArrayList<String> getListOfRooms() {
                return ListOfRooms;
        }

        /**
         * Accessing point of the class DevCampusService
         * @return Instance of class DevCampusService
         */
        public static DevCampusService getInstance(){
                return Campus;
        }


        /**
         * Implementation of the Interface Methods of Campus
         * @param Room existing room from the FH-Erfurt
         * @return true -> room exist, false -> room don't exist
         */
        @Override
        public boolean checkRoomExist(String Room) {
                return getListOfRooms().stream().anyMatch(result -> result.equals(Room));
        }
}


