package de.fherfurt.persons.service.model;

import de.fherfurt.persons.service.persistence.core.AbstractDatabaseEntity;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import javax.imageio.ImageIO;
import javax.persistence.Entity;
import javax.persistence.Transient;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.logging.Logger;

/**
 * @author Tran Anh Hoang
 * The Class PersonAvatar has the main goal to convert an image into an ByteArray
 * and save it into an Avatar-Repository
 */

@Entity
public class PersonAvatar extends AbstractDatabaseEntity {
    private byte [] avatarByteArray;

    @Transient
    private static final Logger LOGGER = Logger.getLogger( "PersonAvatar" );

    public PersonAvatar(){}

    public PersonAvatar(String imageName) throws IOException {
       this.avatarByteArray = convertImageToByteArray(imageName);
    }




    /**
     * @param imageName absolute Path to the Image
     * @return Byte-Array of an Image
     * @throws IOException - throw an error if Image can't be converted.
     */
    public byte[] convertImageToByteArray(String imageName) throws IOException {
        try{
            File userAvatar = new File(imageName);
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

}
