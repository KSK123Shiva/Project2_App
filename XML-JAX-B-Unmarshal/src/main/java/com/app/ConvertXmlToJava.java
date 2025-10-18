package com.app;

import java.io.File;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Unmarshaller;

public class ConvertXmlToJava {

	public static void main(String[] args) throws Exception {

		File xmlfile = new File("Person.xml");

		JAXBContext context = JAXBContext.newInstance(Person.class);

		Unmarshaller unmarshaller = context.createUnmarshaller();

		Object object = unmarshaller.unmarshal(xmlfile);

		Person person = (Person) object;
		
		System.out.println(person);
	}
}