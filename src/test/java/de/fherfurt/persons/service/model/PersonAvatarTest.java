package de.fherfurt.persons.service.model;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

class PersonAvatarTest {
    @Test
    void testConverterImageToByteArray() throws IOException {

        //TODO: @Prof. Dr. Avemarg - The Maven-Git pipline could not find our directory for the image,that we used for the unit purpose. When you are checking out our project please ensure to exclude the comment in the PersonAvatar Unit-Test. Also Please checkout our 6.2. Potential Bugs Java 2 in the Documenatation!
        /*
        //when + given
        PersonAvatar personAvatar01 = new PersonAvatar(Paths.get("src\\images\\Meme_Macron.png").toAbsolutePath().toString());


        //then
        Assertions.assertThat(personAvatar01.getAvatarByteArray()).isNotEmpty().contains(personAvatar01.
                convertImageToByteArray(Paths.get("src\\images\\Meme_Macron.png").toAbsolutePath().toString()));

         */
    }


}