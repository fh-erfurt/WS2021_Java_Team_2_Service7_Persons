package de.fherfurt.faculty.client.transfer.object;

import java.util.stream.Stream;

/**
 * @author Tran Anh Hoang
 */
public enum FacultyDto {
    ASW("Angewandte Sozialwisschenschaft"),
    ASP("Architektur und Stadtplaung"),
    BKR("Bauingenieurwesen und Konservierung Restaurierung"),
    GTI("Gebaeudetechnik und Informatik"),
    LGF("Landschaftsarchitektur Gartenbau und Forst"),
    WLV("Wirtschaft Logistik Verkehr"),
    NULL(null);

    private final String facultyName;

    FacultyDto(String facultyName) {
        this.facultyName = facultyName;
    }

    public String toString() {
        return facultyName;
    }

    public String getFacultyName() {
        return facultyName;
    }

}

