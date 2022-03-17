package de.fherfurt.faculty.client;

enum FacultyDto {
    ASW("Angewandte Sozialwisschenschaft"),
    ASP("Architektur und Stadtplaung"),
    BKR("Bauingenieurwesen und Konservierung Restaurierung"),
    GTI("Gebaeudetechnik und Informatik"),
    LGF("Landschaftsarchitektur Gartenbau und Forst"),
    WLV("Wirtschaft Logistik Verkehr");

    FacultyDto(String s) {
    }

    public String equalsName(FacultyDto inFaculty) {
        String result;
        switch (inFaculty) {
            case GTI -> result = "Gebäudetechnik und Informatik";
            case LGF -> result = "Landschaftsarchitektur, Gartenbau und Forst";
            case WLV -> result = "Wirtschaft-Logistik-Verkehr";
            case BKR -> result = "Bauingenieurwesen und Konservierung/Restaurierung";
            case ASP -> result = "Architektur und Stadtplanung";
            case ASW -> result = "Angewandte Sozialwissenschaften";
            default -> {
                System.out.println("Die eingegebene Fakultät existiert nicht oder ist falsch geschrieben");
                result = " ";
            }
        }
        return result;
    }


}