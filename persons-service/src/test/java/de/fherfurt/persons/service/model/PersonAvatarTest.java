package de.fherfurt.persons.service.model;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.nio.file.Paths;


class PersonAvatarTest {
    @Test
    void shouldConvertImageToByteArray() throws IOException {

        //given
        String imagePath = Paths.get("Meme_Macron.png").toAbsolutePath().toString();
        PersonAvatar PersonImage = new PersonAvatar();
        //System.out.println(imagePath);

        //when
        byte[] personImageInByteCode = PersonImage.convertImageToByteArray(imagePath);


        //then
        Assertions.assertThat(personImageInByteCode)
                .isNotEmpty()
                .containsSequence(-119, 80, 78, 71, 13, 10, 26, 10, 0, 0, 0, 13, 73, 72, 68, 82, 0, 0, 2, 43, 0, 0, 2, 28, 8, 2, 0, 0, 0, -72, -77, 121, 106, 0, 0, 0, 9, 112, 72, 89, 115, 0, 0, 16, 117, 0, 0, 16, 117, 1);
    }
}