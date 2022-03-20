package de.fherfurt.persons.service.persistence;
import java.util.HashMap;
public class PersonAvatarRepository {
    private static final PersonAvatarRepository AvatarRepository  = new PersonAvatarRepository();
    private HashMap<Integer , byte[]> AvatarStorage = new HashMap<>();
    private PersonAvatarRepository() {}

    public void saveAvatarBy(int PersonID, byte [] AvatarByteArray) {
        AvatarStorage.put(PersonID, AvatarByteArray);
    }

    public byte[] getAvatarStorageBy(int PersonID) {
        return AvatarStorage.get(PersonID);
    }

    public static PersonAvatarRepository getInstance(){
        return AvatarRepository;
    }
}
