package de.fherfurt.persons.service.model;

import static org.junit.jupiter.api.Assertions.*;
import de.fherfurt.persons.service.model.PersonAvatar;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

class PersonAvatarTest {
    @Test
    void testConverterImageToByteArray() throws IOException {

        //when + given
        PersonAvatar personAvatar01 = new PersonAvatar(new File("src\\images\\Meme_Macron.png").getAbsoluteFile().toString());


        //then
        Assertions.assertThat(personAvatar01.getAvatarByteArray()).isNotEmpty().contains(personAvatar01.
                convertImageToByteArray((new File("src\\images\\Meme_Macron.png").getAbsoluteFile().toString())));
    }
}