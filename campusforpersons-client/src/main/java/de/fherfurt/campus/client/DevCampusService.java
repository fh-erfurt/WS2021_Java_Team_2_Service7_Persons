package de.fherfurt.campus.client;

import java.util.ArrayList;

public class DevCampusService implements CampusForPersonsClient {

        static final private DevCampusService campus = new DevCampusService();
        private DevCampusService(){
        }

        private final ArrayList<String> listOfRooms = new ArrayList<>();

        public void saveRooms(String room){
                this.listOfRooms.add(room);
        }

        public ArrayList<String> getListOfRooms() {
                return listOfRooms;
        }

        public static DevCampusService getInstance(){
                return campus;
        }


        @Override
        public boolean checkRoomExist(String room) {
                return getListOfRooms().stream().anyMatch(result -> result.equals(room));
        }
}


