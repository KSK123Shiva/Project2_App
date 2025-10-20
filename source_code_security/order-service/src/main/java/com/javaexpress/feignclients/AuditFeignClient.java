package com.javaexpress.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.javaexpress.dto.AuditLog;


//url = "http://localhost:8093"
@FeignClient(name="audit-service",path="/api/audits")
public interface AuditFeignClient {

	@PostMapping("/log")
	public ResponseEntity<String> logEvent(@RequestBody AuditLog log);
}
