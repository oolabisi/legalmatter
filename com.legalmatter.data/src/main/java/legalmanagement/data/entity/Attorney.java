package legalmanagement.data.entity;

import org.hibernate.annotations.NaturalId;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import java.util.Collection;
import java.util.Set;

@Entity
@Table(name = "attorney", uniqueConstraints = {@UniqueConstraint(columnNames = {"username"}),
@UniqueConstraint(columnNames = {"email"})})
public class Attorney {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long attorneyId;

    private String firstName;

    private String lastName;

    private String otherName;

    private String title;

    private String username;

    @NaturalId
    @Email(message = "{errors.invalid_email}")
    //@Email(message = "Please provide a valid e-mail")
    @Column(name = "email", unique = true)
    private String email;

    @NotBlank
    @Size(min = 8)
    private String password;

    private String phoneNumber;

    private String enrollmentNumber;

    private String enrollmentYear;

    private String callToBarCertNumber;

    private String nationality;

    private boolean enabled;

    private String verificationToken;

    @ManyToMany(cascade = CascadeType.MERGE)    //(fetch = FetchType.LAZY)
    @JoinTable(name = "attorney_roles", joinColumns = {@JoinColumn(name = "attorney_id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id")})
    private Set<Role> roles; // private List<Role> role;


// Class constructor

    public Attorney() { }

    public Attorney(String email, String password, Set grantedAuthorities) { }

    public Attorney(String firstName, String lastName, String username, String email, String password, String title,
                    String otherName) {  }

    public Attorney(String firstName, String lastName, String otherName, String title, String email, String password,
                    String phoneNumber, String enrollmentNumber, String enrollmentYear, String callToBarCertNumber,
                    String nationality, String username, boolean enabled, String verificationToken) { //Set<Role> roles
        this.firstName = firstName;
        this.lastName = lastName;
        this.otherName = otherName;
        this.username = username;
        this.title = title;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.enrollmentNumber = enrollmentNumber;
        this.enrollmentYear = enrollmentYear;
        this.callToBarCertNumber = callToBarCertNumber;
        this.nationality = nationality;
        this.enabled = false;
        this.verificationToken = verificationToken;
    }

    public Collection<GrantedAuthority> getAuthorities() {
        return null;
    }

    // Setters and Getters of Class Attribute

    public Long getAttorneyId() { return attorneyId; }

    public void setAttorneyId(Long attorneyId) { this.attorneyId = attorneyId; }

    public String getFirstName() { return firstName; }

    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }

    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getOtherName() { return otherName; }

    public void setOtherName(String otherName) { this.otherName = otherName; }

    public String getTitle() { return title; }

    public void setTitle(String title) { this.title = title; }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }

    public String getPhoneNumber() { return phoneNumber; }

    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    public String getEnrollmentNumber() { return enrollmentNumber; }

    public void setEnrollmentNumber(String enrollmentNumber) { this.enrollmentNumber = enrollmentNumber; }

    public String getEnrollmentYear() { return enrollmentYear; }

    public void setEnrollmentYear(String enrollmentYear) { this.enrollmentYear = enrollmentYear;  }

    public String getNationality() { return nationality; }

    public void setNationality(String nationality) { this.nationality = nationality; }

    public String getUsername() { return username; }

    public void setUsername(String username) { this.username = username; }

    public String getCallToBarCertNumber() { return callToBarCertNumber; }

    public void setCallToBarCertNumber(String callToBarCertNumber) { this.callToBarCertNumber = callToBarCertNumber;}

    public Set<Role> getRoles() { return roles; }

    public void setRoles(Set<Role> roles) { this.roles = roles; }

    public boolean isEnabled() { return enabled; }

    public void setEnabled(boolean enabled) { this.enabled = enabled; }

    public String getVerificationToken() { return verificationToken; }

    public void setVerificationToken(String verificationToken) { this.verificationToken = verificationToken; }


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
        sb.append("verificationToken='").append(verificationToken).append('\'');
        sb.append(", password='").append(password).append('\'');
        sb.append(", phoneNumber='").append(phoneNumber).append('\'');
        sb.append(", enrollmentNumber='").append(enrollmentNumber).append('\'');
        sb.append(", enrollmentYear='").append(enrollmentYear).append('\'');
        sb.append(", callToBarCertNumber='").append(callToBarCertNumber).append('\'');
        sb.append(", nationality='").append(nationality).append('\'');
        sb.append("username='").append(username).append('\'');
        sb.append("enabled=").append(enabled);
        sb.append(", roles=").append(roles);
        sb.append('}');
        return sb.toString();
    }

}