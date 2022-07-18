package de.fherfurt.persons.service.model;

//TODO @Milena: Erweitere checkFacultyName Abkürzungen
//TODO @Milena: Erstelle Repo Interfaces
//TODO @Milena: Überschreibe Methoden für die Interfaces


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
            case "Gebaeudetechnik und Informatik" -> result = "GTI";
            case "Landschaftsarchitektur, Gartenbau und Forst" -> result = "LGF";
            case "Wirtschaft-Logistik-Verkehr" -> result = "WLV";
            case "Bauingenieurwesen und Konservierung/Restaurierung" -> result = "BKR";
            case "Architektur und Stadtplanung" -> result = "ASP";
            case "Angewandte Sozialwissenschaften" -> result = "ASW";
            default -> result = "Others";
        }
        return result;
    }

}
