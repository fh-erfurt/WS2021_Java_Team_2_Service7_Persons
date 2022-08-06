package de.fherfurt.persons.service.model;
import de.fherfurt.persons.service.persistence.core.AbstractDatabaseEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;

/**
 * The class Person includes all the Information about a Person. It has an
 * Kind of InputField: otherEmployee,lecturer,student
 * @author  Tran Anh Hoang
 * @version  2.0.0.0
 */

// TODO @Milena reingucken bei Find all....
@Entity
@Setter
@Getter
@ToString
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
