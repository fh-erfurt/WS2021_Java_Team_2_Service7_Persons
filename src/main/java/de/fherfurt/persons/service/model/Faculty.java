package de.fherfurt.persons.service.model;


//TODO @Milena: Erstelle Repo Interfaces - Fertig
//TODO @Milena: Überschreibe Methoden für die Interfaces - Fertig?

import de.fherfurt.persons.service.persistence.core.AbstractDatabaseEntity;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.Entity;

@Entity
public class Faculty extends AbstractDatabaseEntity {

    @Setter
    @Getter
    private String facultyName;

    public Faculty(String facultyName) {
        this.facultyName = checkFacultyName(facultyName);
    }

    public String checkFacultyName(String facultyName){
        String result = facultyName;
        switch (facultyName) {
            case "Gebaeudetechnik und Informatik", "GTI" -> result = "GTI";
            case "Landschaftsarchitektur, Gartenbau und Forst", "LGF" -> result = "LGF";
            case "Wirtschaft-Logistik-Verkehr", "WLV" -> result = "WLV";
            case "Bauingenieurwesen und Konservierung/Restaurierung", "BKR" -> result = "BKR";
            case "Architektur und Stadtplanung", "ASP" -> result = "ASP";
            case "Angewandte Sozialwissenschaften", "ASW" -> result = "ASW";
            default -> result = "Others";
        }
        return result;
    }

}
