package de.fherfurt.persons.service.model;

import de.fherfurt.persons.service.persistence.repository.PersonAvatarRepository;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

/**
 * @author Tran Anh Hoang
 * The Class PersonAvatar has the main goal to convert an image into an ByteArray
 * and save it into an Avatar-Repository
 */

@Entity
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class PersonAvatar
{
    @Id
    @Column(name = "personAvatar", nullable = false)
    private long personAvatarId;
    private byte [] avatarByteArray;



    /**
     * @param imagePath absolute Path to the Image
     * @return Byte-Array of an Image
     * @throws IOException - throw an error if Image can't be converted.
     */
    public byte[] convertImageToByteArray(String imagePath) throws IOException {
        try{
            File userAvatar = new File(imagePath);
            if(userAvatar.length() == 0){
                throw new IOException();
            }
            else{
                return this.avatarByteArray = Files.readAllBytes(userAvatar.toPath());
            }
        }
        catch (IOException ioe){
            System.out.println("Image Error:" + ioe.getMessage());
            throw ioe;
        }
    }

    /**
     * Puts the personId and avatar into AvatarRepository
     * @param personId identification of a person
     */
    public void setAvatarByteArrayIntoAvatarRepositoryBy(int personId) {
        PersonAvatarRepository.getInstance().saveAvatarBy(personId, avatarByteArray);
    }
}
