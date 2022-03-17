package de.fherfurt.persons.service.persistence;
import java.util.HashMap;

/**
 * @author Tran Anh Hoang
 *
 */

public class PersonAvatarRepository {
    private static final PersonAvatarRepository AVATAR_REPOSITORY = new PersonAvatarRepository();
    private HashMap<Integer , byte[]> AvatarStorage = new HashMap<>();

    public void saveAvatarBy(int PersonID, byte [] AvatarByteArray) {
        AvatarStorage.put(PersonID, AvatarByteArray);
    }

    public byte[] getAvatarStorageBy(int PersonID) {
        return AvatarStorage.get(PersonID);
    }

    public static PersonAvatarRepository getInstance(){
        return AVATAR_REPOSITORY;
    }
}
