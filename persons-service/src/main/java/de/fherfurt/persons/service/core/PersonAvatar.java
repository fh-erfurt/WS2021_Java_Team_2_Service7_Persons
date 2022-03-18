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
     * @param ImagePath
     * @return Byte-Array of an Image
     * @throws IOException
     */
    public byte[] convertImageToByteArray(String ImagePath) throws IOException
    {
        //  "/home/hoang/Desktop/WS2021_Java_Team_2_Service_persons/Screenshot_20220228_155257.png";
        File UserAvatar = new File(ImagePath);
        return this.AvatarByteArray = Files.readAllBytes(UserAvatar.toPath());
    }

    public void setAvatarByteArrayIntoAvatarRepositoryBy(int PersonID)
    {
        PersonAvatarRepository.getInstance().saveAvatarBy(PersonID, AvatarByteArray);
    }
}
