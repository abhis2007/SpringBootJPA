package com.example.SpringBoot_JPA.Model;

import jakarta.persistence.*;
import jdk.jfr.Timestamp;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;

@Entity

//Some more info on the table
@Table(
        name = "UserRecords",
        schema = "springjpadb",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "uniq_email",
                        columnNames = "email"
                )
        }
)
public class UserRecord {

    /*
    * There are 4 types of Strategy -
    * 1. AUTO - Default, persistence provider pick the strategy.
    * 2. Identity - by db itself using auto increment, relies on the db native support.
    * 3. SEQUENCE - user can give their own strategy else provide will pass the default strategy.
    * 4. TABLE - uses separate db table to generate teh PK, provider takes care of it.
    * */

    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "userIdSequence Generator")
    @SequenceGenerator(
            name = "userIdSequence Generator",
            sequenceName = "userid Sequence",
            allocationSize = 1
    )
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    int id;

    @Column(name = "userName", nullable = false)
    private String name;
    private String email;

    public Instant getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Instant createdOn) {
        this.createdOn = createdOn;
    }

    public Instant getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Instant lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    @CreationTimestamp
    private Instant createdOn;

    @UpdateTimestamp
    private Instant lastUpdated;

    @Column(length = 100)
    private String address;

    public UserRecord() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
