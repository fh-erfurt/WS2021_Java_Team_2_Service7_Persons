package de.fherfurt.persons.service.persistence;
import java.util.HashMap;

/**
 * @author Tran Anh Hoang
 * Repository to save avatars from persons
 * The PersonRepository has a Singleton Pattern,and it exists only one instance of this class!
 */
public class PersonAvatarRepository {
    private static final PersonAvatarRepository avatarRepository  = new PersonAvatarRepository();
    private final HashMap<Integer , byte[]> avatarStorage = new HashMap<>();
    private PersonAvatarRepository() {}

    /**
     * Save the personId and avatarByteArray in a Hashmap.
     * @param personId is the key value of the HashMap, and it is equal to the personId of a person in the ArrayList of the class PersonRepository
     * @param avatarByteArray Image of a Person as a byte array
     */
    public void saveAvatarBy(int personId, byte [] avatarByteArray) {
        avatarStorage.put(personId, avatarByteArray);
    }

    /**
     * Search and get a Person Avatar in the Hashmap by the personId.
     * @param personId is the key value of the HashMap, and it is equal to the personId of a person in the ArrayList of the class PersonRepository
     * @return byte array of a image
     */
    public byte[] getAvatarStorageBy(int personId) {
        return avatarStorage.get(personId);
    }

    /**
     * Accessing Point of the class.
     * @return the instance PersonAvatarRepository
     */
    public static PersonAvatarRepository getInstance(){
        return avatarRepository;
    }
}
