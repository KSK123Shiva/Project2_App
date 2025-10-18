package com.app;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
//@XmlRootElement
@NoArgsConstructor
@AllArgsConstructor
public class Product {

	private Integer pid;
	private String pname;
	private Double price;

}