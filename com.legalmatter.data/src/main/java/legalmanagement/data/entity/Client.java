package legalmanagement.data.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;


@Entity
@Table(name = "client")
public class Client {

    @Id
    @Column
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int clientId;

    @Column(name= "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "otherName")
    private String otherName;

    @Column(name = "email")
    private String email;

    @Column(name = "phoneNumber")
    private String phoneNumber;

    @Column(name = "password")
    private String password;

    @Column(name= "nationality")
    private String nationality;


//    @OneToMany(mappedBy = "client")
//    private List<UserCompany> usercompanies;

    // Class Constructor

    public Client() {}

    public Client(String firstName, String lastName, String otherName,
                  String email, String phoneNumber, String password, String nationality) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.otherName = otherName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.nationality = nationality;
    }

    // Getters and Setters

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
        final StringBuilder sb = new StringBuilder("Client{");
        sb.append("id=").append(clientId);
        sb.append(", firstName='").append(firstName).append('\'');
        sb.append(", lastName='").append(lastName).append('\'');
        sb.append(", otherName='").append(otherName).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append(", phoneNumber='").append(phoneNumber).append('\'');
        sb.append(", password='").append(password).append('\'');
        sb.append(", nationality='").append(nationality).append('\'');
        sb.append('}');
        return sb.toString();
    }
}