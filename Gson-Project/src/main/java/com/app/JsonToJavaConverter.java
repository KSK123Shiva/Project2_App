package com.app;

import java.io.File;
import java.io.FileReader;

import com.google.gson.Gson;

public class JsonToJavaConverter {

	public static void main(String[] args) throws Exception {

		Order order = new Order();
		order.setOrderId(101);
		order.setOrderBy("Shiva");
		order.setOrderStatus("Confirmed");
		order.setBillAmt("1034");

		Gson gson = new Gson();

		String json = gson.toJson(order);
		System.out.println(json);

		Order fromJson = gson.fromJson(new FileReader(new File("order.json")), Order.class);
		System.out.println(fromJson);

	}
}
