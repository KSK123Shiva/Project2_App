package com.javaexpress.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaexpress.collections.AuditLog;
import com.javaexpress.repository.AuditLogRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AuditService {

	
	@Autowired
	private AuditLogRepository auditLogRepository;
	
	public AuditLog logEvent(AuditLog log) {
		log.setTimeStamp(new Date());
		return auditLogRepository.save(log);
	}
	
	public List<AuditLog> findAll(){
		return auditLogRepository.findAll();
	}
	
	
	public List<AuditLog> getLogsByServiceName(String serviceName) {
		return auditLogRepository.findByServiceName(serviceName);
	}
	
	
}
