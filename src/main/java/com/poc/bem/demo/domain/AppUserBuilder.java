package com.poc.bem.demo.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.sql.Timestamp;

@NoArgsConstructor
@Getter
public class AppUserBuilder {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String ipAddress;
    private String createProgramId;
    private String modifyProgramId;
    private Timestamp createTimestamp;
    private Timestamp modifyTimestamp;
    private String createUserId;
    private String modifyUserId;
    private int version;

    public AppUserBuilder(@NonNull AppUser user) {
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

    public AppUserBuilder id(int id) {
        this.id = id;
        return this;
    }

    public AppUserBuilder firstName(@NonNull String firstName) {
        this.firstName = firstName;
        return this;
    }

    public AppUserBuilder lastName(@NonNull String lastName) {
        this.lastName = lastName;
        return this;
    }

    public AppUserBuilder email(@NonNull String email) {
        this.email = email;
        return this;
    }

    public AppUserBuilder phone(@NonNull String phone) {
        this.phone = phone;
        return this;
    }

    public AppUserBuilder ipAddress(@NonNull String ipAddress) {
        this.ipAddress = ipAddress;
        return this;
    }

    public AppUserBuilder createProgramId(@NonNull String createProgramId) {
        this.createProgramId = createProgramId;
        return this;
    }

    public AppUserBuilder modifyProgramId(@NonNull String modifyProgramId) {
        this.modifyProgramId = modifyProgramId;
        return this;
    }

    public AppUserBuilder createTimestamp(@NonNull Timestamp createTimestamp) {
        this.createTimestamp = createTimestamp;
        return this;
    }

    public AppUserBuilder modifyTimestamp(@NonNull Timestamp modifyTimestamp) {
        this.modifyTimestamp = modifyTimestamp;
        return this;
    }

    public AppUserBuilder createUserId(@NonNull String createUserId) {
        this.createUserId = createUserId;
        return this;
    }

    public AppUserBuilder modifyUserId(@NonNull String modifyUserId) {
        this.modifyUserId = modifyUserId;
        return this;
    }

    public AppUserBuilder version(int version) {
        this.version = version;
        return this;
    }

    /**
     * Build an AppUser object based on the builder properties.
     * @return an AppUser object
     */
    public AppUser build() {
        return new AppUser(this);
    }

    /**
     * Build an AppUser object based on another AppUser's properties.
     * @return an AppUser object
     */
    public AppUser build(AppUser user) {
        return user;
    }
}
