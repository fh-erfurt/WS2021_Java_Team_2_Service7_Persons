package de.fherfurt.persons.service.core;

public class Person
{
    private  String address;
    private  int PersonID;
    private  String firstname;
    private  String lastname;
    private  String email;
    private  String phonenumber;
    private  String title;
    private  String hireDate;
    private  Enum faculty;
    private  Boolean teachingFlag;
    private  String room;
    private  String major;
    private  String immatriculationDate;
    private  String exmatriculationDate;
    private  Boolean tutorFlag;
    private  Boolean scientificWorkerFlag;
    private  String jobTitle;

    private Person(int PersonID, String firstname, String lastname, String address, String email, String phonenumber, String title, String hireDate,
                   Enum faculty, Boolean teachingFlag, String room, String major, String immatriculationDate,
                   String exmatriculationDate, Boolean tutorFlag, Boolean scientificWorkerFlag, String jobTitle) {
        this.PersonID = PersonID;
        this.firstname = firstname;
        this.lastname = lastname;
        this.address = address;
        this.email = email;
        this.phonenumber = phonenumber;
        this.title = title;
        this.hireDate = hireDate;
        this.faculty = faculty;
        this.teachingFlag = teachingFlag;
        this.room = room;
        this.major = major;
        this.immatriculationDate = immatriculationDate;
        this.exmatriculationDate = exmatriculationDate;
        this.tutorFlag = tutorFlag;
        this.scientificWorkerFlag = scientificWorkerFlag;
        this.jobTitle = jobTitle;
    }

    //Singleton
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {

        private int PersonID;
        private String firstname;
        private String lastname;
        private String address;
        private String email;
        private String phonenumber;
        private String title;
        private String hireDate;
        private Enum faculty;
        private Boolean teachingFlag;
        private String room;
        private String major;
        private String immatriculationDate;
        private String exmatriculationDate;
        private Boolean tutorFlag;
        private Boolean scientificWorkerFlag;
        private String jobTitle;

        private Builder() {
        }

        public Person build() {
            return new Person(PersonID, firstname, lastname, address, email, phonenumber, title, hireDate, faculty, teachingFlag,
                    room, major, immatriculationDate, exmatriculationDate, tutorFlag, scientificWorkerFlag, jobTitle);
        }

        public Builder setPersonID(int PersonID)
        {
            this.PersonID = PersonID;
            return this;
        }

        public Builder setFirstname(String firstname) {
            this.firstname = firstname;
            return this;
        }

        public Builder setLastname(String lastname) {
            this.lastname = lastname;
            return this;
        }

        public Builder setAddress(String address) {
            this.address = address;
            return this;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder setPhonenumber(String phonenumber) {
            this.phonenumber = phonenumber;
            return this;
        }

        public Builder setTitle(String title) {
            this.title = title;
            return this;
        }

        public Builder setHireDate(String hireDate) {
            this.hireDate = hireDate;
            return this;
        }

        public Builder setFaculty(Enum faculty) {
            this.faculty = faculty;
            return this;
        }

        public Builder setTeachingFlag(Boolean teachingFlag) {
            this.teachingFlag = teachingFlag;
            return this;
        }

        public Builder setRoom(String room) {
            this.room = room;
            return this;
        }

        public Builder setMajor(String major) {
            this.major = major;
            return this;
        }

        public Builder setImmatriculationDate(String immatriculationDate) {
            this.immatriculationDate = immatriculationDate;
            return this;
        }

        public Builder setExmatriculationDate(String exmatriculationDate) {
            this.exmatriculationDate = exmatriculationDate;
            return this;
        }

        public Builder setTutorFlag(Boolean tutorFlag) {
            this.tutorFlag = tutorFlag;
            return this;
        }

        public Builder setScientificWorkerFlag(Boolean scientificWorkerFlag) {
            this.scientificWorkerFlag = scientificWorkerFlag;
            return this;
        }

        public Builder setJobTitle(String jobTitle) {
            this.jobTitle = jobTitle;
            return this;
        }
        
        public int getPersonID()
        {
            return PersonID;
        }

        public String getFirstname()
        {
            return firstname;
        }

        public String getLastname()
        {
            return lastname;
        }

        public String getAddress()
        {
            return address;
        }

        public String getEmail()
        {
            return email;
        }

        public String getPhonenumber()
        {
            return phonenumber;
        }

        public String getTitle()
        {
            return title;
        }

        public String getHireDate()
        {
            return hireDate;
        }

        public Enum getFaculty()
        {
            return faculty;
        }

        public Boolean getTeachingFlag()
        {
            return teachingFlag;
        }

        public String getRoom()
        {
            return room;
        }

        public String getMajor()
        {
            return major;
        }

        public String getImmatriculationDate()
        {
            return immatriculationDate;
        }

        public String getExmatriculationDate()
        {
            return exmatriculationDate;
        }

        public Boolean getTutorFlag()
        {
            return tutorFlag;
        }

        public Boolean getScientificWorkerFlag()
        {
            return scientificWorkerFlag;
        }

        public String getJobTitle()
        {
            return jobTitle;
        }

    }

    //only needed for other employees
    public static Person otherEmployee(int PersonID, String firstname,String lastname,String email,String jobTitle){
        return builder().setPersonID(PersonID).setFirstname(firstname).setLastname(lastname).setEmail(email).setJobTitle(jobTitle).build();
    }

    //only needed for lecturers
    public static Person lecturer(int PersonID, String firstname,String lastname,String email,String phonenumber, String title, String hireDate, Enum faculty, Boolean teachingFlag, String room){
        return builder().setPersonID(PersonID).setFirstname(firstname).setLastname(lastname).setEmail(email).setPhonenumber(phonenumber).setTitle(title).setHireDate(hireDate).setFaculty(faculty).setTeachingFlag(teachingFlag).setRoom(room).build();
    }

    //only needed for students
    public static Person student(int PersonID, String firstname,String lastname,String email,String major, String immatriculationDate, String exmatriculationDate, Boolean tutorFlag, Boolean scientificWorkerFlag){
        return builder().setPersonID(PersonID).setFirstname(firstname).setLastname(lastname).setEmail(email).setMajor(major).setImmatriculationDate(immatriculationDate).setExmatriculationDate(exmatriculationDate).setTutorFlag(tutorFlag).setScientificWorkerFlag(scientificWorkerFlag).build();
    }


    /**
     * @author Tran Anh Hoang
     */

    @Override
    public String toString()
    {
        return "Person: {" +
                "PersonID='" + PersonID + '\'' +
                " ,firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'';
                /*
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", phonenumber='" + phonenumber + '\'' +
                ", title='" + title + '\'' +
                ", hireDate='" + hireDate + '\'' +
                ", faculty=" + faculty +
                ", teachingFlag=" + teachingFlag +
                ", room='" + room + '\'' +
                ", major='" + major + '\'' +
                ", immatriculationDate='" + immatriculationDate + '\'' +
                ", exmatriculationDate='" + exmatriculationDate + '\'' +
                ", tutorFlag=" + tutorFlag +
                ", scientificWorkerFlag=" + scientificWorkerFlag +
                ", jobTitle='" + jobTitle + '\'' +
                */
    }

    /**
     * @author Tran Anh Hoang
     */
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPersonID() {
        return PersonID;
    }

    public void setPersonID(int personID) {
        PersonID = personID;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getHireDate() {
        return hireDate;
    }

    public void setHireDate(String hireDate) {
        this.hireDate = hireDate;
    }

    public Enum getFaculty() {
        return faculty;
    }

    public void setFaculty(Enum faculty) {
        this.faculty = faculty;
    }

    public Boolean getTeachingFlag() {
        return teachingFlag;
    }

    public void setTeachingFlag(Boolean teachingFlag) {
        this.teachingFlag = teachingFlag;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getImmatriculationDate() {
        return immatriculationDate;
    }

    public void setImmatriculationDate(String immatriculationDate) {
        this.immatriculationDate = immatriculationDate;
    }

    public String getExmatriculationDate() {
        return exmatriculationDate;
    }

    public void setExmatriculationDate(String exmatriculationDate) {
        this.exmatriculationDate = exmatriculationDate;
    }

    public Boolean getTutorFlag() {
        return tutorFlag;
    }

    public void setTutorFlag(Boolean tutorFlag) {
        this.tutorFlag = tutorFlag;
    }

    public Boolean getScientificWorkerFlag() {
        return scientificWorkerFlag;
    }

    public void setScientificWorkerFlag(Boolean scientificWorkerFlag) {
        this.scientificWorkerFlag = scientificWorkerFlag;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }


}
