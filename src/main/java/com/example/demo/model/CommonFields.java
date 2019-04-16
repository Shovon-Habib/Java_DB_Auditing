
package com.example.demo.model;

import com.example.demo.config.BeanUtility;
import com.example.demo.repo.AuditLogRepo;
import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.PostPersist;
import javax.persistence.PrePersist;
import lombok.Data;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class CommonFields implements Serializable {

    private String createdBy;
    private LocalDateTime createdAt;

    @LastModifiedBy
    private String updatedBy;
    @LastModifiedDate
    private LocalDateTime updatedAt;

    @PrePersist
    void setData() {
        this.createdAt = LocalDateTime.now();
        this.createdBy = "Shovon First";
    }

    @PostPersist
    void onPersist() {
        AuditLog auditLog = new AuditLog();
        auditLog.setName(this.getClass().getSimpleName());
        auditLog.setAction(this.toString());
        AuditLogRepo logRepo = (AuditLogRepo) BeanUtility.getBean("auditLogRepo");
        logRepo.save(auditLog);
    }
}
