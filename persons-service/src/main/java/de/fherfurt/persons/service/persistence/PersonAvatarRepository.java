package de.fherfurt.persons.service.persistence;
import java.util.HashMap;

/**
 * @author Tran Anh Hoang
 * Repository so save all avatars from persons
 */
public class PersonAvatarRepository {
    private static final PersonAvatarRepository avatarRepository  = new PersonAvatarRepository();
    private HashMap<Integer , byte[]> avatarStorage = new HashMap<>();
    private PersonAvatarRepository() {}

    public void saveAvatarBy(int personId, byte [] avatarByteArray) {
        avatarStorage.put(personId, avatarByteArray);
    }

    public byte[] getAvatarStorageBy(int personId) {
        return avatarStorage.get(personId);
    }

    public static PersonAvatarRepository getInstance(){
        return avatarRepository;
    }
}
