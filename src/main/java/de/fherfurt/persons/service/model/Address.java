package de.fherfurt.persons.service.model;
import de.fherfurt.persons.service.persistence.core.AbstractDatabaseEntity;
import de.fherfurt.persons.service.persistence.repository.RepositoryFactory;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.persistence.Entity;
import javax.persistence.Transient;
import java.util.logging.Logger;

/**
 * The class Address is an Entity in the Database.  The class Address includes the street, city and zipCode of a Person
 * @author  Tran Anh Hoang
 * @version  2.0.0.0
 */
@Entity
@Getter
@Setter
@ToString
public class Address extends AbstractDatabaseEntity{


    private String street;
    private String city;
    private String zipCode;

    @Transient
    final static Logger LOGGER = Logger.getLogger( RepositoryFactory.class.getSimpleName() );

    public Address() {}

    public Address( String street, String city, String zipCode ) {
        this.street = checkStringValid(street) ? street : "not allowed street name";
        this.city = checkStringValid(city) ? city : "not allowed city name";
        this.zipCode =  checkStringValid(zipCode) ? zipCode : "not allowed zipCode";
    }


    /**
     * Created by Milena Neumann, extended by Tran Anh Hoang
     * The method checks if there are some mistakes like not allowed special characters.
     * if there are mistakes it throws some messages for the user, so he knows what was wrong with the input.
     * @param stringToCheck the input string which will be checked for different mistakes.
     * @return if the string is appropriate returns true, if there is a problem it returns false.
     */
    public static boolean checkStringValid(String stringToCheck)
    {
        char firstCharacterOfTheString = stringToCheck.charAt(0);
        if (stringToCheck.length() > 120)
        {
            LOGGER.info("The String is too long. Must be under 120 Characters! ");
            return false;
        }

        if (firstCharacterOfTheString == ' ') {
            LOGGER.info("The String is has no value.");
            return false;
        }

        if (stringToCheck.trim().isEmpty()) {
            LOGGER.info("The String is empty.");
            return false;
        }

        //Pattern patternRules = Pattern.compile("[^A-Za-z -]");
        //Matcher patternCheckResult = patternRules.matcher(stringToCheck);
        //boolean bool = patternCheckResult.find();

        //if (bool) {
        //    LOGGER.info("The String include not permitted Character! ");
        //    return false;
        //}
        return true;
    }
}
