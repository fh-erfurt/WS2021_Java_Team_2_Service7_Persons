package de.fherfurt.persons.service.core;

import de.fherfurt.persons.service.persistence.PersonAvatarRepository;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

/**
 * @author Tran Anh Hoang
 * The Class PersonAvatar has the main goal to convert an Image into an ByteArray
 * and save it into a Avatar-Repository
 */
public class PersonAvatar
{
    private byte [] AvatarByteArray;

    /**
     * @param ImagePath - absolute Path to the Image
     * @return Byte-Array of an Image
     * @throws IOException -
     */
    public byte[] convertImageToByteArray(String ImagePath) throws IOException {
        try{
            File UserAvatar = new File(ImagePath);
            return this.AvatarByteArray = Files.readAllBytes(UserAvatar.toPath());
        }
        catch (IOException ioe){
            System.out.println("Image Error:" + ioe.getMessage());
            throw ioe;
        }
    }

    public void setAvatarByteArrayIntoAvatarRepositoryBy(int PersonID) {
        PersonAvatarRepository.getInstance().saveAvatarBy(PersonID, AvatarByteArray);
    }
}
