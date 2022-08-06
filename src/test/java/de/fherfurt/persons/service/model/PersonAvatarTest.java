package de.fherfurt.persons.service.model;

import org.junit.jupiter.api.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class PersonAvatarTest {

    @Test
    void converterImageToByteArray() throws IOException {

        //given
        PersonAvatar personAvatar01 = new PersonAvatar(new File("images\\Meme_Macron.png").getAbsoluteFile().toString());


        //when
        System.out.println(Arrays.toString(personAvatar01.getAvatarByteArray()));
    }

}