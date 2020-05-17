package legalmanagement.data.entity;

import org.hibernate.annotations.NaturalId;

import javax.management.relation.Role;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.Set;


@Entity
@Table(name = "client", uniqueConstraints = {@UniqueConstraint(columnNames = {"username"}),
        @UniqueConstraint(columnNames = {"email"})})
public class Client {

    @Id
    @Column
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;

    @NotBlank
    @Column(name= "firstName")
    private String firstName;

    @NotBlank
    @Column(name = "lastName")
    private String lastName;

    @Column(name = "otherName")
    private String otherName;

    @NotBlank
    @Column(name = "username")
    private String userName;

    @NotBlank
    @NaturalId
    @Email
    @Column(name = "email")
    private String email;

    @NotBlank
    @Column(name = "phoneNumber")
    private String phoneNumber;

    @NotBlank
    @Column(name = "password")
    private String password;

    @NotBlank
    @Column(name= "nationality")
    private String nationality;


//    @OneToMany(mappedBy = "client")
//    private List<UserCompany> usercompany;

//    @ManyToMany(fetch = FetchType.LAZY)
//    @JoinTable(name = "client_roles", joinColumns = @JoinColumn(name = "id"),
//            inverseJoinColumns = @JoinColumn(name = "id"))
//    private Set<Role> roles = new HashSet<>();

    // Class Constructor

    public Client() {}

    public Client(String firstName, String lastName, String otherName, String email, String phoneNumber,
                  String password, String nationality, String userName, Set<Role> roles) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.otherName = otherName;
        this.email = email;
        this.userName = userName;
      //  this.roles = roles;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.nationality = nationality;
    }

    // Getters and Setters

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public String getUserName() { return userName; }

    public void setUserName(String userName) { this.userName = userName; }
//
//    public Set<Role> getRoles() { return roles; }
//
//    public void setRoles(Set<Role> roles) { this.roles = roles; }

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
        sb.append("id=").append(id);
        sb.append(", firstName='").append(firstName).append('\'');
        sb.append(", lastName='").append(lastName).append('\'');
        sb.append(", otherName='").append(otherName).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append(", phoneNumber='").append(phoneNumber).append('\'');
        sb.append(", password='").append(password).append('\'');
        sb.append(", nationality='").append(nationality).append('\'');
        sb.append("username='").append(userName).append('\'');
      //  sb.append(", roles=").append(roles);
        sb.append('}');
        return sb.toString();
    }
}