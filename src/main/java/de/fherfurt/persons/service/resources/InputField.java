package de.fherfurt.persons.service.resources;


import java.util.ArrayList;

//TODO: @Milena: Klasse modifizieren, so dass die Endpoints von außen erreichbar sind: BaseRessource --> InputField
//TODO: PersonRepository Interface auf die jeweilige Methoden anpassen und die dazugehörige Klasse RepositoryImp erweitern
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








