//package legalmanagement.data.entity;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.Id;
//import javax.persistence.Table;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
////import javax.persistence.OneToMany;
////import java.util.List;
//
//@Entity
//@Table(name = "lawFirm")
//public class LawFirm {
//
//      @Id
//      @Column
//      @GeneratedValue(strategy= GenerationType.IDENTITY)
//      private long id;
//
//      @Column(name = "lawFirmRegNumber")
//      private int lawFirmRegNumber;
//
//      @Column(name = "lawFirmName")
//      private String lawFirmName;
//
//      @Column(name = "lawFirmEmail")
//      private String lawFirmEmail;
//
//      @Column(name = "lawFirmPhoneNumber")
//      private String lawFirmPhoneNumber;
//
//      @Column(name = "lawFirmAddress")
//      private String lawFirmAddress;
//
//      @Column(name = "city")
//      private String city;
//
//      @Column(name = "LGA")
//      private String lga;
//
//      @Column(name = "state")
//      private String state;
//
//
//
//      //@OneToMany(mappedBy="lawFirm")
//      //private List<Attorney> attorney;
//
//      // Class Constructor
//
//      public LawFirm() { }
//
//      public LawFirm(String lawFirmName, String lawFirmEmail, String lawFirmPhoneNumber,
//                     String lawFirmAddress, String city, String lga, String state, int lawFirmRegNumber) {
//            this.lawFirmName = lawFirmName;
//            this.lawFirmEmail = lawFirmEmail;
//            this.lawFirmPhoneNumber = lawFirmPhoneNumber;
//            this.lawFirmAddress = lawFirmAddress;
//            this.city = city;
//            this.lga = lga;
//            this.state = state;
//            this.lawFirmRegNumber = lawFirmRegNumber;
//      }
//
//      // Getters and Setters
//
//      public long getId() {
//            return id;
//      }
//
//      public void setId(long id) {
//            this.id = id;
//      }
//
//      public int getLawFirmRegNumber() {
//            return lawFirmRegNumber;
//      }
//
//      public void setLawFirmRegNumber(int lawFirmRegNumber) {
//            this.lawFirmRegNumber = lawFirmRegNumber;
//      }
//
//      public String getLawFirmName() {
//            return lawFirmName;
//      }
//
//      public void setLawFirmName(String lawFirmName) {
//            this.lawFirmName = lawFirmName;
//      }
//
//      public String getLawFirmEmail() {
//            return lawFirmEmail;
//      }
//
//      public void setLawFirmEmail(String lawFirmEmail) {
//            this.lawFirmEmail = lawFirmEmail;
//      }
//
//      public String getLawFirmPhoneNumber() {
//            return lawFirmPhoneNumber;
//      }
//
//      public void setLawFirmPhoneNumber(String lawFirmPhoneNumber) {
//            this.lawFirmPhoneNumber = lawFirmPhoneNumber;
//      }
//
//      public String getLawFirmAddress() {
//            return lawFirmAddress;
//      }
//
//      public void setLawFirmAddress(String lawFirmAddress) {
//            this.lawFirmAddress = lawFirmAddress;
//      }
//
//      public String getCity() {
//            return city;
//      }
//
//      public void setCity(String city) {
//            this.city = city;
//      }
//
//      public String getLga() {
//            return lga;
//      }
//
//      public void setLga(String lga) {
//            this.lga = lga;
//      }
//
//      public String getState() {
//            return state;
//      }
//
//      public void setState(String state) {
//            this.state = state;
//      }
//
//      // toString
//
//
//      @Override
//      public String toString() {
//            final StringBuilder sb = new StringBuilder("legalFirm{");
//            sb.append("id=").append(id);
//            sb.append(", firmRegNumber=").append(lawFirmRegNumber);
//            sb.append(", firmName='").append(lawFirmName).append('\'');
//            sb.append(", firmEmail='").append(lawFirmEmail).append('\'');
//            sb.append(", firmPhoneNumber='").append(lawFirmPhoneNumber).append('\'');
//            sb.append(", firmAddress='").append(lawFirmAddress).append('\'');
//            sb.append(", city='").append(city).append('\'');
//            sb.append(", lga='").append(lga).append('\'');
//            sb.append(", state='").append(state).append('\'');
//            sb.append('}');
//            return sb.toString();
//      }
//}