
package com.example.demo.repo;

import com.example.demo.model.AuditLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuditLogRepo extends JpaRepository<AuditLog, Long>{
    
}
