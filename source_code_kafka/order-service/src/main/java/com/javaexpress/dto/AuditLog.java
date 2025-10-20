package com.javaexpress.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuditLog {

	private String serviceName;
	private String action;
	private String userId;
}
