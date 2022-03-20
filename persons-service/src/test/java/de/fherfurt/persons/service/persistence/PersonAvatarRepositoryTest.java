package de.fherfurt.persons.service.persistence;

import de.fherfurt.persons.service.core.PersonAvatar;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

class PersonAvatarRepositoryTest {

    @Test
    void saveAvatarBy() throws IOException {
        //given
        PersonAvatar imageOfPerson = new PersonAvatar();
        String imagePath = Paths.get("Meme_Macron.png").toAbsolutePath().toString();

        //then
        PersonAvatarRepository.getInstance().saveAvatarBy(1, imageOfPerson.convertImageToByteArray(imagePath));

        //when
        Assertions.assertThat(PersonAvatarRepository.getInstance().getAvatarStorageBy(1))
                .isNotEmpty()
                .isEqualTo(imageOfPerson.convertImageToByteArray(imagePath));
    }
}