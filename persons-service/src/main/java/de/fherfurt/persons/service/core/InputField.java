package de.fherfurt.persons.service.core;
import de.fherfurt.faculty.client.FacultyClient;
import de.fherfurt.faculty.client.transfer.object.FacultyDto;


import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * The InputField Class is the place where the Input from the searching user gets
 * checked and put into a list for the Following service
 *
 * @author Milena Neumann
 */
public class InputField implements FacultyClient
{

    private String inFirstName;
    private String inLastName;
    private String inModul;
    private String inFaculty;
    ArrayList<String> PersonInputData = new ArrayList<>();

    public InputField(String inFirstName, String inLastName, String inModul, String inFaculty) // Konstruktor String inFirstName, String inLastName, String inModul, Faculty inFaculty
    {
        this.inFirstName = inFirstName;
        this.inLastName = inLastName;
        this.inModul = inModul;
        this.inFaculty = inFaculty;
    }

    /**
     * getter for comparing
     *
     * @return the data-list of person information
     */
    public ArrayList<String> getListSearchInput()
    {
        return PersonInputData;
    }


    /**
     * the checked and edit input from the user is added into the PersonInputDate-List
     */
    public void setListSearchInput()
    {
        if ((checkStringValid(this.inFirstName)) && (checkStringValid(this.inLastName)) && (checkStringValid(this.inModul)))
        {
            PersonInputData.add(this.inFirstName);
            PersonInputData.add(this.inLastName);
            PersonInputData.add(this.inModul);
            PersonInputData.add(checkInputEqualsEnums(inFaculty)); // Enum wurde geprüft und passender String wird in die Liste eingetragen
        }
        else
        {
            System.out.println("Bei der Eingabe ist etwas schiefgelaufen, bitte versuchen Sie es erneut");
        }
    }

    /**
     * The function checks if there are some mistakes like not allowed special characters
     *
     * @param StringToCheck the input string which will be checked for different mistakes
     * @return if the string is appropriate returns true, if there is a problem it returns false
     * <p>
     * src https://qastack.com.de/programming/1795402/check-if-a-string-contains-a-special-character
     */
    public static boolean checkStringValid(String StringToCheck)   // public damit auch andere auf die Checkfunktion zugreifen können
    {
        char FirstCharacterOfTheString = StringToCheck.charAt(0);

        if (StringToCheck.length() > 30)
        {
            System.out.println("Der eingegebene Name ist zu lang!\nErlaubte Anzahl an Zeichen: 30");
            return false;
        }

        if (FirstCharacterOfTheString == ' ')
        {
            System.out.println("Das erste Zeichen darf kein Leerzeichen sein, bitte prüfen");
            return false;
        }

        if (StringToCheck.trim().isEmpty())
        {
            System.out.println("Die Zeichenkette hat ein falsches Format");
            return false;
        }

        Pattern p = Pattern.compile("[^A-Za-z -]");
        Matcher m = p.matcher(StringToCheck);
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

    public String checkInputEqualsEnums(String inFaculty)
    {
        if (getFacultyByName(inFaculty) == FacultyDto.GTI || getFacultyByName(inFaculty) == FacultyDto.LGF || getFacultyByName(inFaculty) == FacultyDto.WLV || getFacultyByName(inFaculty) == FacultyDto.ASP || getFacultyByName(inFaculty) == FacultyDto.ASW) {
            return inFaculty;
        }
        else {
            return null;
        }
    }
}








