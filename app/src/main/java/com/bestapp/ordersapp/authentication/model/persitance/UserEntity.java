package com.bestapp.ordersapp.authentication.model.persitance;

import com.fasterxml.jackson.annotation.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;


@Entity
@Table(name = "users", schema = "orders")
@JsonAutoDetect
public class UserEntity {
    @CreationTimestamp
    private Timestamp created_on;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String password;
    private Role role;

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public UserEntity() { super(); }

    public Long getId() {
        return this.id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(final String password) {
        this.password = password;
    }

    public Timestamp getCreated_on() {
        return this.created_on;
    }

    public void setCreated_on(final Timestamp created_on) {
        this.created_on = created_on;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", created_on=" + created_on + '\'' +
                ", role='" + role + '\'' +

                '}';
    }
}
