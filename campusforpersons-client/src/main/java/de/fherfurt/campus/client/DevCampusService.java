package de.fherfurt.campus.client;

import java.util.ArrayList;

public class DevCampusService implements CampusForPersonsClient {

        static final private DevCampusService Campus = new DevCampusService();
        private DevCampusService(){
        }

        private final ArrayList<String> ListOfRooms = new ArrayList<>();

        public void saveRooms(String Rooms){
                this.ListOfRooms.add(Rooms);
        }

        public ArrayList<String> getListOfRooms() {
                return ListOfRooms;
        }

        public static DevCampusService getInstance(){
                return Campus;
        }


        @Override
        public boolean checkRoomExist(String Room) {
                return getListOfRooms().stream().allMatch(result -> result.equals(Room));
        }
}


