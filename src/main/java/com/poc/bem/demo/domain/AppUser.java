package com.poc.bem.demo.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private String id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "phone", unique = true)
    private String phone;

    @Column(name = "ip_address", unique = true)
    private String ipAddress;

    @Column(name = "create_prog_id")
    private String createProgramId;

    @Column(name = "modify_prog_id")
    private String modifyProgramId;

    @Column(name = "create_ts")
    private Timestamp createTimeStamp;

    @Column(name = "modify_ts")
    private Timestamp modifyTimeStamp;

    @Column(name = "create_user_id")
    private String createUserId;

    @Column(name = "modify_user_id")
    private String modifyUserId;

    @Version
    private Integer version;

    @Override
    public String toString() {
        return "{"
                + "\"firstName\": \"" + firstName + "\","
                + "\"lastName\": \"" + lastName + "\","
                + "\"email\": \"" + email + "\","
                + "\"phone\": \"" + phone + "\","
                + "\"ipAddress\": \"" + ipAddress + "\","
                + "\"modifyTs\": \"" + modifyTimeStamp + "\""
                + "}";
    }
}
