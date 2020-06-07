package legalmanagement.data.entity;

import javax.persistence.*;


@Entity
@Table(name = "client_roles", uniqueConstraints = {@UniqueConstraint(name = "client_role_uk",
        columnNames = { "client_id", "role_id" }) })
public class Client_Role {
   @Id
   @GeneratedValue
   private Long id;

   @ManyToOne(fetch = FetchType.EAGER)
   @JoinColumn(name = "client_id")
   private Client client;

   @ManyToOne(fetch = FetchType.EAGER)
   @JoinColumn(name = "role_id")
   private Role role;


   // Constructor
    public Client_Role(Client client, Role role) {
        this.client = client;
        this.role = role;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Client getClient() { return client; }

    public void setClient(Client client) {
        this.client = client;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}