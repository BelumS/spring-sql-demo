package com.poc.bem.demo.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.sql.Timestamp;

/**
 * A value object for transferring data to/from the UI.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@NoArgsConstructor
@Getter
public class AppUserDTO {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String ipAddress;

    @JsonIgnore
    private String createProgramId;

    @JsonIgnore
    private String modifyProgramId;

    @JsonIgnore
    private Timestamp createTimestamp;

    @JsonIgnore
    private Timestamp modifyTimestamp;

    @JsonIgnore
    private String createUserId;

    @JsonIgnore
    private String modifyUserId;

    @JsonIgnore
    private int version;

    public AppUserDTO(@NonNull AppUser user) {
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

    @Override
    public String toString() {
        return "{"
                + "\"id\": \"" + id + "\","
                + "\"firstName\": \"" + firstName + "\","
                + "\"lastName\": \"" + lastName + "\","
                + "\"email\": \"" + email + "\","
                + "\"phone\": \"" + phone + "\","
                + "\"ipAddress\": \"" + ipAddress + "\""
                + "}";
    }
}
