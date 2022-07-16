package de.fherfurt.persons.service.resources;
import de.fherfurt.persons.service.resources.SearchingHistory;
import de.fherfurt.persons.service.resources.SearchingSystem;


import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//TODO @Milena: Try it by yourself
/**
 * @author Milena Neumann
 * The InputField Class is the place where the input from the user gets
 * checked and put into a list for the following service
 */
public class InputField
{

    private String inFirstName;
    private String inLastName;
    private String inMajor;
    private String inFaculty;
    ArrayList<String> personInputData = new ArrayList<>();

    public InputField(String inFirstName, String inLastName, String inMajor, String inFaculty)
    {
        this.inFirstName = inFirstName;
        this.inLastName = inLastName;
        this.inMajor = inMajor;
        this.inFaculty = inFaculty;
    }

}








