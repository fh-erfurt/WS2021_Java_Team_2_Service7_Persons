package de.fherfurt.persons.service.model;

import de.fherfurt.persons.service.persistence.core.AbstractDatabaseEntity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.imageio.ImageIO;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Transient;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.logging.Logger;

/**
 * @author Tran Anh Hoang
 * The Class PersonAvatar has the main goal to convert an image into an ByteArray
 * and save it into an Avatar-Repository
 */

@Entity
@Getter
public class PersonAvatar extends AbstractDatabaseEntity {

    @Lob
    private byte [] avatarByteArray;

    @Transient
    private static final Logger LOGGER = Logger.getLogger( "Init PersonAvatar" );

    public PersonAvatar(){}

    public PersonAvatar(byte[] avatarByteArray){
        this.avatarByteArray = avatarByteArray;
    }

    public PersonAvatar(String userImagePath) throws IOException {
        this.avatarByteArray = convertImageToByteArray(userImagePath);
    }


    /**
     * @param userImagePath absolute Path to the Image
     * @return Byte-Array of an Image
     * @throws IOException - throw an error if Image can't be converted.
     */
    public byte[] convertImageToByteArray(String userImagePath) throws IOException {
        try{
            BufferedImage userAvatarImage = ImageIO.read(new File(userImagePath));
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ImageIO.write(userAvatarImage, "png", byteArrayOutputStream);
            return byteArrayOutputStream.toByteArray();

        }
        catch (IOException ioe){
            System.out.println("Image Error:" + ioe.getMessage());
            throw ioe;
        }
    }

}
