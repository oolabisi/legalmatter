package legalmanagement.data.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Entity;

@Entity
@Table(name = "attorney")
public class Attorney {

        @Id
        @Column
        @GeneratedValue(strategy= GenerationType.IDENTITY)
        private int attorneyId;

        @Column(name = "firstName")
        private String firstName;

        @Column(name = "lastName")
        private String lastName;

        @Column(name = "otherName")
        private String otherName;

        @Column(name = "title")
        private String title;

        @Column(name = "email")
        private String email;

        @Column(name = "password")
        private String password;

        @Column(name = "phoneNumber")
        private String phoneNumber;

        @Column(name = "enrollmentNumber")
        private String enrollmentNumber;

        @Column(name = "enrollmentYear")
        private String enrollmentYear;

         @Column(name = "callToBarCertNumber")
         private String callToBarCertNumber;

        @Column(name = "nationality")
        private String nationality;


    // Class constructor

    public Attorney() { }

    public Attorney(String firstName, String lastName, String otherName,
                    String title, String email, String password, String phoneNumber, String enrollmentNumber,
                    String enrollmentYear, String callToBarCertNumber, String nationality) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.otherName = otherName;
        this.title = title;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.enrollmentNumber = enrollmentNumber;
        this.enrollmentYear = enrollmentYear;
        this.callToBarCertNumber = callToBarCertNumber;
        this.nationality = nationality;
    }
    // Setters and Getters of Class Attribute

    public int getAttorneyId() {
           return attorneyId;
    }

    public void setAttorneyId(int attorneyId) {
           this.attorneyId = attorneyId;
    }

    public String getFirstName() {
           return firstName;
    }

    public void setFirstName(String firstName) {
           this.firstName = firstName;
    }

    public String getLastName() {
           return lastName;
    }

    public void setLastName(String lastName) {
           this.lastName = lastName;
    }

    public String getOtherName() {
           return otherName;
    }

    public void setOtherName(String otherName) {
           this.otherName = otherName;
    }

    public String getTitle() {
           return title;
    }

    public void setTitle(String title) {
           this.title = title;
    }

    public String getEmail() {
           return email;
    }

    public void setEmail(String email) {
           this.email = email;
    }

    public String getPassword() {
          return password;
    }

    public void setPassword(String password) {
           this.password = password;
    }

    public String getPhoneNumber() {
           return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
           this.phoneNumber = phoneNumber;
    }

    public String getEnrollmentNumber() {
           return enrollmentNumber;
    }

    public void setEnrollmentNumber(String enrollmentNumber) {
           this.enrollmentNumber = enrollmentNumber;
    }

    public String getEnrollmentYear() {
           return enrollmentYear;
    }

    public void setEnrollmentYear(String enrollmentYear) {
           this.enrollmentYear = enrollmentYear;
    }

    public String getNationality() {
           return nationality;
    }

    public void setNationality(String nationality) {
           this.nationality = nationality;
    }

    // toString

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Attorney{");
        sb.append("attorneyId=").append(attorneyId);
        sb.append(", firstName='").append(firstName).append('\'');
        sb.append(", lastName='").append(lastName).append('\'');
        sb.append(", otherName='").append(otherName).append('\'');
        sb.append(", title='").append(title).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append(", password='").append(password).append('\'');
        sb.append(", phoneNumber='").append(phoneNumber).append('\'');
        sb.append(", enrollmentNumber='").append(enrollmentNumber).append('\'');
        sb.append(", enrollmentYear='").append(enrollmentYear).append('\'');
        sb.append(", callToBarCertNumber='").append(callToBarCertNumber).append('\'');
        sb.append(", nationality='").append(nationality).append('\'');
        sb.append('}');
        return sb.toString();
    }
}