package com.javaexpress.entities;

import lombok.Getter;


@Getter
public enum PaymentStatus {
	
	NOT_STARTED("not_started"),
	IN_PROGRESS("in_progress"),
	COMPLETED("completed"),
	FAILURE("FAILURE");
	
	private  String status;

	PaymentStatus(String status) {
		this.status = status;
	}
}
