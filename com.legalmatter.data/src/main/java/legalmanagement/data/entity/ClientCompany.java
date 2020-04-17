package legalmanagement.data.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GenerationType;


@Entity
@Table(name = "clientCompany")
public class ClientCompany {

    @Id
    @Column
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int clientCompanyId;

    @Column(name = "companyName")
    private String companyName;

    @Column(name = "companyAddress")
    private String companyAddress;

    @Column(name = "companyEmail")
    private String companyEmail;

    @Column(name = "companyPhoneNumber")
    private String companyPhoneNumber;

    @Column(name = "city")
    private String city;

    @Column(name = "LGA")
    private String lga;

    @Column(name = "state")
    private String state;

//    @ManyToOne
//    @JoinColumn(name = "")
//    private Client client;


    // Class Constructor

    public ClientCompany() {}

    public ClientCompany(String companyName, String companyAddress,
                         String companyEmail, String companyPhone, String city, String lga, String state) {
        this.companyName = companyName;
        this.companyAddress = companyAddress;
        this.companyEmail = companyEmail;
        this.companyPhoneNumber = companyPhone;
        this.city = city;
        this.lga = lga;
        this.state = state;
    }

    // Getters and Setters
    public int getClientCompanyId() {
        return clientCompanyId;
    }

    public void setClientCompanyId(int clientCompanyId) {
        this.clientCompanyId = clientCompanyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }

    public String getCompanyEmail() {
        return companyEmail;
    }

    public void setCompanyEmail(String companyEmail) {
        this.companyEmail = companyEmail;
    }

    public String getCompanyPhone() {
        return companyPhoneNumber;
    }

    public void setCompanyPhone(String companyPhone) {
        this.companyPhoneNumber = companyPhone;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getLga() {
        return lga;
    }

    public void setLga(String lga) {
        this.lga = lga;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    // toString
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ClientCompany{");
        sb.append("clientCompanyId=").append(clientCompanyId);
        sb.append(", companyName='").append(companyName).append('\'');
        sb.append(", companyAddress='").append(companyAddress).append('\'');
        sb.append(", companyEmail='").append(companyEmail).append('\'');
        sb.append(", companyPhoneNumber='").append(companyPhoneNumber).append('\'');
        sb.append(", city='").append(city).append('\'');
        sb.append(", lga='").append(lga).append('\'');
        sb.append(", state='").append(state).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
