package de.fherfurt.persons.service.model;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

class PersonAvatarTest {
    @Test
    void testConverterImageToByteArray() throws IOException {

        //when + given
        PersonAvatar personAvatar01 = new PersonAvatar(Paths.get("src\\images\\Meme_Macron.png").toAbsolutePath().toString());


        //then
        Assertions.assertThat(personAvatar01.getAvatarByteArray()).isNotEmpty().contains(personAvatar01.
                convertImageToByteArray((new File("src\\images\\Meme_Macron.png").getAbsoluteFile().toString())));
    }
}