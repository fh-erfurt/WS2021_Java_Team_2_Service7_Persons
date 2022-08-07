package de.fherfurt.persons.service.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;



/**
 * @Author Milena Neumann
 */
class AddressTest {


    @Test
    void testCheckStringValid() {
        //given
        Address testAddressRight = new Address("Schlauchboot-Weg", "Neustadt", "98765");

        //when

        //then
        Assertions.assertThat(testAddressRight.getStreet())
               .isEqualTo("Schlauchboot-Weg");

        Assertions.assertThat(Address.checkStringValid(" ahnhofStraße"))
                .isFalse();

       Assertions.assertThat(Address.checkStringValid("Die Straße die einen ganz ganz langen Namen hat, damit wir über die 120 Zeichen kommen, weil das verboten ist. Alles für den Test"))
               .isFalse();

    }
}