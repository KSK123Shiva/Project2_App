package com.javaexpress.collections;

import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "auditlogs")
@Data
@NoArgsConstructor
public class AuditLog {

	private String id;
	private String serviceName;
	private String action;
	private String userId;
	private Date timeStamp;
	
	public AuditLog(String serviceName, String action, String userId) {
		super();
		this.serviceName = serviceName;
		this.action = action;
		this.userId = userId;
		this.timeStamp = new Date();
	}
	
	
}
