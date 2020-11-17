package com.poc.bem.demo.listeners;

import com.poc.bem.demo.domain.AppUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.sql.Timestamp;
import java.time.Instant;

@Slf4j
public class AppUserListener {

    @Value("${spring.application.name}")
    private String appName;

    /**
     * Invoked before data is inserted.
     *
     * @param user the record being inserted
     */
    @PrePersist
    public void prePersist(AppUser user) {
        log.debug("In AppUserListener.prePersist()");
        final Timestamp currentDate = new Timestamp(Instant.now().toEpochMilli());
        user.setCreateTimeStamp(currentDate);
        user.setModifyTimeStamp(currentDate);
        user.setCreateProgramId(appName);
        user.setModifyProgramId(appName);
        user.setCreateUserId(appName);
        user.setModifyUserId(appName);
    }

    /**
     * Invoked before data is updated.
     *
     * @param user the record being updated
     */
    @PreUpdate
    public void preUpdate(AppUser user) {
        log.debug("In AppUserListener.preUpdate()");
        user.setModifyTimeStamp(new Timestamp(Instant.now().toEpochMilli()));
        user.setModifyUserId(appName);
        user.setModifyProgramId(appName);
    }
}
