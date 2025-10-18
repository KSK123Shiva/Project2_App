package com.app;

import lombok.Data;

@Data
public class Order {
	private Integer orderId;
	private String orderBy;
	private String orderStatus;
	private String billAmt;

}
