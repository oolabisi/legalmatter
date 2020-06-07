package legalmanagement.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.hibernate.annotations.NaturalId;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

import javax.validation.constraints.Email;



@Entity
@Table(name = "lawFirm")
public class LawFirm {

      @Id
      @GeneratedValue(strategy= GenerationType.IDENTITY)
      private Long lawFirmId;

      private String lawFirmRegNumber;

      private String lawFirmName;

      @NaturalId
      @Email
      private String lawFirmEmail;

      private String lawFirmPhoneNumber;

      private String lawFirmAddress;

      private String city;

      private String lga;

      private String state;

      @ManyToOne(fetch = FetchType.EAGER)
      @OnDelete(action = OnDeleteAction.CASCADE)
      @JsonIgnore
      private Attorney attorney;


      // Class Constructor

      public LawFirm() { }

      public LawFirm(String lawFirmName, String lawFirmEmail, String lawFirmPhoneNumber,
                     String lawFirmAddress, String city, String lga, String state, String lawFirmRegNumber) {
            this.lawFirmName = lawFirmName;
            this.lawFirmEmail = lawFirmEmail;
            this.lawFirmPhoneNumber = lawFirmPhoneNumber;
            this.lawFirmAddress = lawFirmAddress;
            this.city = city;
            this.lga = lga;
            this.state = state;
            this.lawFirmRegNumber = lawFirmRegNumber;
      }

      // Getters and Setters

      public Long getLawFirmId() {
            return lawFirmId;
      }

      public void setLawFirmId(Long lawFirmId) {
            this.lawFirmId = lawFirmId;
      }

      public String getLawFirmRegNumber() {
            return lawFirmRegNumber;
      }

      public void setLawFirmRegNumber(String lawFirmRegNumber) {
            this.lawFirmRegNumber = lawFirmRegNumber;
      }

      public String getLawFirmName() {
            return lawFirmName;
      }

      public void setLawFirmName(String lawFirmName) {
            this.lawFirmName = lawFirmName;
      }

      public String getLawFirmEmail() {
            return lawFirmEmail;
      }

      public void setLawFirmEmail(String lawFirmEmail) {
            this.lawFirmEmail = lawFirmEmail;
      }

      public String getLawFirmPhoneNumber() {
            return lawFirmPhoneNumber;
      }

      public void setLawFirmPhoneNumber(String lawFirmPhoneNumber) {
            this.lawFirmPhoneNumber = lawFirmPhoneNumber;
      }

      public String getLawFirmAddress() {
            return lawFirmAddress;
      }

      public void setLawFirmAddress(String lawFirmAddress) {
            this.lawFirmAddress = lawFirmAddress;
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
            final StringBuilder sb = new StringBuilder("legalFirm{");
            sb.append("id=").append(lawFirmId);
            sb.append(", firmRegNumber=").append(lawFirmRegNumber);
            sb.append(", firmName='").append(lawFirmName).append('\'');
            sb.append(", firmEmail='").append(lawFirmEmail).append('\'');
            sb.append(", firmPhoneNumber='").append(lawFirmPhoneNumber).append('\'');
            sb.append(", firmAddress='").append(lawFirmAddress).append('\'');
            sb.append(", city='").append(city).append('\'');
            sb.append(", lga='").append(lga).append('\'');
            sb.append(", state='").append(state).append('\'');
            sb.append('}');
            return sb.toString();
      }
}