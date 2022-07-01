package de.fherfurt.persons.service.model;
import de.fherfurt.faculty.client.FacultyClient;
import de.fherfurt.faculty.client.transfer.object.FacultyDto;


import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * @author Milena Neumann
 * The InputField Class is the place where the input from the user gets
 * checked and put into a list for the following service
 */
public class InputField implements FacultyClient
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

    /**
     * getter for the next service to get the input data for following operations
     * @return the data-list of searched person information from user
     */
    public ArrayList<String> getListSearchInput()
    {
        return personInputData;
    }

    /**
     * the checked and edited input from the user is added into the personInputData-List
     */
    public void setListSearchInput()
    {
        if ((checkStringValid(this.inFirstName)) && (checkStringValid(this.inLastName)) && (checkStringValid(this.inMajor)))
        {
            personInputData.add(this.inFirstName);
            personInputData.add(this.inLastName);
            personInputData.add(this.inMajor);
            personInputData.add(getFacultyByName(inFaculty).toString());
        }
        else
        {
            System.out.println("Bei der Eingabe ist etwas schiefgelaufen, bitte versuchen Sie es erneut");
        }
    }

    /**
     * The method checks if there are some mistakes like not allowed special characters.
     * if there are mistakes it throws some messages for the user, so he knows what was wrong with the input.
     *
     * @param stringToCheck the input string which will be checked for different mistakes.
     * @return if the string is appropriate returns true, if there is a problem it returns false.
     */
    public static boolean checkStringValid(String stringToCheck)
    {
        char firstCharacterOfTheString = stringToCheck.charAt(0);
        if (stringToCheck.length() > 30)
        {
            System.out.println("Der eingegebene Name ist zu lang!\nErlaubte Anzahl an Zeichen: 30");
            return false;
        }

        if (firstCharacterOfTheString == ' ')
        {
            System.out.println("Das erste Zeichen darf kein Leerzeichen sein, bitte prüfen");
            return false;
        }

        if (stringToCheck.trim().isEmpty())
        {
            System.out.println("Die Zeichenkette hat ein falsches Format");
            return false;
        }

        Pattern p = Pattern.compile("[^A-Za-z -]");
        Matcher m = p.matcher(stringToCheck);
        boolean b = m.find();
        if (b)
        {
            System.out.println("Es ist ein nicht erlaubtes Zeichen in der Eingabe\n Erlaubte Zeichen sind: Großbuchstaben, Kleinbuchstaben, Leerzeichen und Bindestrich");
            return false;
        }
        return true;
    }

    @Override
    public FacultyDto getFacultyByName(String facultyName)
    {
        FacultyDto result;
        switch (facultyName)
        {
            case "Gebaeudetechnik und Informatik" -> result = FacultyDto.GTI;
            case "Landschaftsarchitektur, Gartenbau und Forst" -> result = FacultyDto.LGF;
            case "Wirtschaft-Logistik-Verkehr" -> result = FacultyDto.WLV;
            case "Bauingenieurwesen und Konservierung/Restaurierung" -> result = FacultyDto.BKR;
            case "Architektur und Stadtplanung" -> result = FacultyDto.ASP;
            case "Angewandte Sozialwissenschaften" -> result = FacultyDto.ASW;
            default -> result = FacultyDto.NULL;
        }
        return result;
    }

    /**
     * @author Tran Anh Hoang
     * Triggers the following service
     */
    public void triggerFindPersonUsingIteratorBy(){
        SearchingSystem testSearch = new SearchingSystem();
        testSearch.findPersonBy(this.inFirstName, this.inLastName , this.inMajor, this.inFaculty );
    }

    /**
     * @author Tran Anh Hoang
     * Triggers the following service
     */
    public void triggerSearchingHistory(){
        SearchingHistory.getInstance().setSearchHistoryMap(this.personInputData);
    }
}








