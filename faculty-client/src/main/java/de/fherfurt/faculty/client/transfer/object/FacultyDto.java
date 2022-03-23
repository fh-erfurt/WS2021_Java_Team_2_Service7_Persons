package de.fherfurt.faculty.client.transfer.object;

/**
 * @author Tran Anh Hoang
 * This enum class is the experimental implementation of the interface of the Faculty Service, structure was given by the Faculty Service.
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

    /**
     * Transform the constant Enums into the given Strings
     * @return return given Strings of the enums
     */
    public String toString() {
        return facultyName;
    }

    /**
     * @return Name of the Faculty
     */
    public String getFacultyName() {
        return facultyName;
    }

}

