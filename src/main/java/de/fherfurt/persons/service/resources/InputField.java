package de.fherfurt.persons.service.resources;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;


import java.util.ArrayList;

/**
 * @author Milena Neumann
 * The InputField Class is the place where the input from the user gets
 * checked and put into a list for the following service
 */
@Path("inputfield")
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


    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String info()
    {
        return "Insert Firstname, Lastname, Major and Faculty to search persons";
    }

}








