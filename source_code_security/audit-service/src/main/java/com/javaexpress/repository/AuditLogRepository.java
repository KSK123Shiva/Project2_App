package com.javaexpress.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.javaexpress.collections.AuditLog;

public interface AuditLogRepository extends MongoRepository<AuditLog, String>{

	List<AuditLog> findByServiceName(String serviceName);
}
