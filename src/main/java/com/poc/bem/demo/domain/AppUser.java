package com.poc.bem.demo.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "APP_USER", indexes = {
        @Index(name = "IDX_EMAIL", columnList = "email"),
        @Index(name = "IDX_PHONE", columnList = "phone")
})
@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Slf4j
public class AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private Integer id;

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
    private Timestamp createTimestamp;

    @Column(name = "modify_ts")
    private Timestamp modifyTimestamp;

    @Column(name = "create_user_id")
    private String createUserId;

    @Column(name = "modify_user_id")
    private String modifyUserId;

    @Version
    private Integer version;

    public AppUser(AppUserBuilder builder) {
        this.id = builder.getId();
        this.firstName = builder.getFirstName();
        this.lastName = builder.getLastName();
        this.email = builder.getEmail();
        this.phone = builder.getPhone();
        this.ipAddress = builder.getIpAddress();
        this.createProgramId = builder.getCreateProgramId();
        this.modifyProgramId = builder.getModifyProgramId();
        this.createTimestamp = builder.getCreateTimestamp();
        this.modifyTimestamp = builder.getModifyTimestamp();
        this.createUserId = builder.getCreateUserId();
        this.modifyUserId = builder.getModifyUserId();
        this.version = builder.getVersion();
    }

    public AppUser(AppUser user) {
        this.id = user.getId();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.email = user.getEmail();
        this.phone = user.getPhone();
        this.ipAddress = user.getIpAddress();
        this.createProgramId = user.getCreateProgramId();
        this.modifyProgramId = user.getModifyProgramId();
        this.createTimestamp = user.getCreateTimestamp();
        this.modifyTimestamp = user.getModifyTimestamp();
        this.createUserId = user.getCreateUserId();
        this.modifyUserId = user.getModifyUserId();
        this.version = user.getVersion();
    }

    public AppUserBuilder builder() {
        return new AppUserBuilder();
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return "{"
                + "\"firstName\": \"" + firstName + "\","
                + "\"lastName\": \"" + lastName + "\","
                + "\"email\": \"" + email + "\","
                + "\"phone\": \"" + phone + "\","
                + "\"ipAddress\": \"" + ipAddress + "\","
                + "\"modifyTs\": \"" + modifyTimestamp + "\""
                + "}";
    }
}
