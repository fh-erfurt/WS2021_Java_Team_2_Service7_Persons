package de.fherfurt.persons.service.model;
import de.fherfurt.persons.service.persistence.core.AbstractDatabaseEntity;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.Entity;

@Entity
@Setter
@Getter
public class Faculty extends AbstractDatabaseEntity {


    private String facultyName;

    public Faculty() {
    }

    public Faculty(String facultyName) {
        this.facultyName = checkFacultyName(facultyName);
    }

    public String checkFacultyName(String facultyName){
        String result;
            switch (facultyName) {
                case "Gebaeudetechnik und Informatik":
                    result = "GTI";
                    break;
                case "Landschaftsarchitektur, Gartenbau und Forst":
                    result = "LGF";
                    break;

                case "Architektur und Stadtplanung":
                    result = "ASP";
                    break;

                case "Wirtschaft-Logistik-Verkehr":
                    result = "WLV";
                    break;

                case "Bauingenieurwesen und Konservierung/Restaurierung":
                    result = "BKR";
                    break;

                case "Angewandte Sozialwissenschaften":
                    result = "ASW";
                    break;

                default:
                    result = "Others";
                    break;
            }
        return result;
    }

}
