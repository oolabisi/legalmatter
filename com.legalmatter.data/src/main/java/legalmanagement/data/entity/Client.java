package legalmanagement.data.entity;

import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import java.util.ArrayList;
import java.util.List;



@Entity
@Table(name = "client",
        uniqueConstraints = {@UniqueConstraint(columnNames = {"username"}), @UniqueConstraint(columnNames = {"email"})})
public class Client {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private String firstName;

    private String lastName;

    private String otherName;

    private String username;

    private String title;

    @NaturalId
    @Email(message = "{errors.invalid_email}")
    @Column(name = "email", unique = true)
    private String email;

    private String phoneNumber;

    @NotBlank
    @Size(min = 8)
    private String password;

    private String nationality;

    private boolean enabled;

    private String verificationToken;

    @ManyToMany(cascade =CascadeType.MERGE)
    @JoinTable(name = "client_role", joinColumns = {@JoinColumn(name = "client_id")},
            inverseJoinColumns= {@JoinColumn(name="role_id")})
    private List<Role> roles;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)     //fetch = FetchType.LAZY, mappedBy = "client")
    @JoinColumn(name = "client_id")
    private List<ClientCompany> clientCompanies  = new ArrayList<>();


    // Class Constructor

    public Client() {}

    public Client(String firstName, String lastName, String otherName, String username, String email, boolean enabled,
                  String phoneNumber, String password, String nationality, String verificationToken, List<Role> roles,
                  String title, List<ClientCompany> clientCompanies) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.otherName = otherName;
        this.username = username;
        this.title = title;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.nationality = nationality;
        this.enabled = false;
        this.verificationToken = verificationToken;
        this.roles = roles;
        this.clientCompanies = clientCompanies;
    }

    // Getters and Setters

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getFirstName() { return firstName;  }

    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }

    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getUsername() { return username; }

    public void setUsername(String username) { this.username = username; }

    public String getOtherName() { return otherName; }

    public void setOtherName(String otherName) { this.otherName = otherName; }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public String getPhoneNumber() { return phoneNumber; }

    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }

    public String getNationality() { return nationality; }

    public void setNationality(String nationality) { this.nationality = nationality; }

    public boolean isEnabled() { return enabled; }

    public void setEnabled(boolean enabled) { this.enabled = enabled; }

    public String getVerificationToken() { return verificationToken; }

    public void setVerificationToken(String verificationToken) { this.verificationToken = verificationToken; }

    public List<Role> getRoles() { return roles; }

    public void setRoles(List<Role> roles) { this.roles = roles; }

    public List<ClientCompany> getClientCompanies() { return clientCompanies; }

    public void setClientCompanies(List<ClientCompany> clientCompanies) { this.clientCompanies = clientCompanies; }


    // toString
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Client{");
        sb.append("id=").append(id);
        sb.append(", firstName='").append(firstName).append('\'');
        sb.append(", lastName='").append(lastName).append('\'');
        sb.append(", otherName='").append(otherName).append('\'');
        sb.append(", username='").append(username).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append(", phoneNumber='").append(phoneNumber).append('\'');
        sb.append(", password='").append(password).append('\'');
        sb.append(", nationality='").append(nationality).append('\'');
        sb.append(", enabled=").append(enabled);
        sb.append(", roles='").append(roles).append('\'');
        sb.append(", verificationToken='").append(verificationToken).append('\'');
        sb.append(", clientCompanies=").append(clientCompanies);
        sb.append('}');
        return sb.toString();
    }
}