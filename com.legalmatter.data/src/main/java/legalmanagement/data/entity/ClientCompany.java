package legalmanagement.data.entity;

import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import javax.validation.constraints.Email;


@Entity
@Table(name = "clientCompany")
public class ClientCompany {

    @Id
    @Column
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long clientCompanyId;

    private String companyName;

    private String companyAddress;

    @NaturalId
    @Email
    private String companyEmail;

    private String companyPhoneNumber;

    private String city;

    private String lga;

    private String state;

    @ManyToOne(fetch = FetchType.LAZY)
    private Client client;


    // Class Constructor

    public ClientCompany() {}

    public ClientCompany(String companyName, String companyAddress, String companyEmail, String companyPhoneNumber,
                         String city, String lga, String state, Client client) {
        this.companyName = companyName;
        this.companyAddress = companyAddress;
        this.companyEmail = companyEmail;
        this.companyPhoneNumber = companyPhoneNumber;
        this.city = city;
        this.lga = lga;
        this.state = state;
        this.client = client;
    }

    // Getters and Setters
    public Long getClientCompanyId() {
        return clientCompanyId;
    }

    public void setClientCompanyId(Long clientCompanyId) {
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

    public String getCompanyPhoneNumber() {
        return companyPhoneNumber;
    }

    public void setCompanyPhoneNumber(String companyPhoneNumber) {
        this.companyPhoneNumber = companyPhoneNumber;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

      // toString
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ClientCompany{");
        sb.append("id=").append(clientCompanyId);
        sb.append(", companyName='").append(companyName).append('\'');
        sb.append(", companyAddress='").append(companyAddress).append('\'');
        sb.append(", companyEmail='").append(companyEmail).append('\'');
        sb.append(", companyPhoneNumber='").append(companyPhoneNumber).append('\'');
        sb.append(", city='").append(city).append('\'');
        sb.append(", lga='").append(lga).append('\'');
        sb.append(", state='").append(state).append('\'');
        sb.append("client=").append(client);
        sb.append('}');
        return sb.toString();
    }
}
