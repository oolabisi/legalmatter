package legalmanagement.data.entity;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "attorney", uniqueConstraints = {@UniqueConstraint(columnNames = {"username"}),
@UniqueConstraint(columnNames = {"email"})})
public class Attorney {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long attorneyId;

    @NotBlank
    @Column(name = "firstName")
    private String firstName;

    @NotBlank
    @Column(name = "lastName")
    private String lastName;

    @Column(name = "otherName")
    private String otherName;

    @NotBlank
    @Column(name = "title")
    private String title;

    @NotBlank
    @Column(name = "username")
    private String username;

    @NotBlank
    @Email
    @Column(name = "email")
    private String email;

    @NotBlank
    @Column(name = "password")
    private String password;

    @NotBlank
    @Column(name = "passwordConfirm")
    @Transient
    private String passwordConfirm;

    @NotBlank
    @Column(name = "phoneNumber")
    private String phoneNumber;

    @NotBlank
    @Column(name = "enrollmentNumber")
    private String enrollmentNumber;

    @NotBlank
    @Column(name = "enrollmentYear")
    private String enrollmentYear;

    @NotBlank
    @Column(name = "callToBarCertNumber")
     private String callToBarCertNumber;

    @NotBlank
    @Column(name = "nationality")
    private String nationality;

//    @Column(name = "Enabled")
//    private boolean enabled;

    @ManyToMany(fetch = FetchType.LAZY)
   // private LawFirm lawFirm;
    @JoinTable(name = "attorneyRoles", joinColumns = @JoinColumn(name = "attorneyId"),
            inverseJoinColumns = @JoinColumn(name = "roleId"))
    private Set<Role> roles = new HashSet<>();


// Class constructor

public Attorney() { }

 public Attorney(String firstName, String lastName, String otherName, String title, String email, String password,
                    String phoneNumber, String enrollmentNumber, String enrollmentYear, String callToBarCertNumber,
                    String nationality, String username) { //Set<Role> roles
    this.firstName = firstName;
    this.lastName = lastName;
    this.otherName = otherName;
    this.username = username;
    this.passwordConfirm = passwordConfirm;
    this.title = title;
    this.email = email;
    this.password = password;
    this.phoneNumber = phoneNumber;
    this.enrollmentNumber = enrollmentNumber;
    this.enrollmentYear = enrollmentYear;
    this.callToBarCertNumber = callToBarCertNumber;
    this.nationality = nationality;
  //  this.enabled = enabled;
}

    public Attorney(String firstName, String lastName, String username, String email, String password, String title, String otherName) {
    }
//
//    public Attorney(String username, String password, List<GrantedAuthority> grantList) {
//    }

    // Setters and Getters of Class Attribute

public Long getAttorneyId() {
       return attorneyId;
}

public void setAttorneyId(Long attorneyId) {
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

public String getUsername() { return username; }

public void setUsername(String username) {
    this.username = username;
    }

public String getCallToBarCertNumber() {
    return callToBarCertNumber;
    }

public void setCallToBarCertNumber(String callToBarCertNumber) {
    this.callToBarCertNumber = callToBarCertNumber;
    }

public String getPasswordConfirm() { return passwordConfirm; }

public void setPasswordConfirm(String passwordConfirm) { this.passwordConfirm = passwordConfirm; }

//public boolean isEnabled() { return enabled; }
//
//public void setEnabled(boolean enabled) { this.enabled = enabled; }

public Set<Role> getRoles() { return roles; }

public void setRoles(Set<Role> roles) { this.roles = roles; }


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
    sb.append("passwordConfirm='").append(passwordConfirm).append('\'');
    sb.append(", password='").append(password).append('\'');
    sb.append(", phoneNumber='").append(phoneNumber).append('\'');
    sb.append(", enrollmentNumber='").append(enrollmentNumber).append('\'');
    sb.append(", enrollmentYear='").append(enrollmentYear).append('\'');
    sb.append(", callToBarCertNumber='").append(callToBarCertNumber).append('\'');
    sb.append(", nationality='").append(nationality).append('\'');
    sb.append("username='").append(username).append('\'');
  //  sb.append("enabled=").append(enabled);
        //  sb.append(", roles=").append(roles);
    sb.append('}');
    return sb.toString();
    }
}