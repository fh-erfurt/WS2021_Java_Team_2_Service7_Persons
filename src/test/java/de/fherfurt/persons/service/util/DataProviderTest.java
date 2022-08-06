package de.fherfurt.persons.service.util;

import de.fherfurt.persons.service.model.PersonAvatar;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

class DataProviderTest {

    @Test
    void converterImageToByteArray() throws IOException {

        //when + given
        //System.out.println(new File("src\\images\\Meme_Macron.png").getAbsoluteFile().toString());
        PersonAvatar personAvatar01 = new PersonAvatar(new File("src\\images\\Meme_Macron.png").getAbsoluteFile().toString());


        //then
        Assertions.assertThat(personAvatar01.getAvatarByteArray()).isNotEmpty();


    }

}