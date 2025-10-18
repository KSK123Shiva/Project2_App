package com.app;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JavaToJsonConverter {

	public static void main(String[] args) throws Exception {

		Author author = new Author();
		author.setAuthorName("Rod Johnson");
		author.setAuthorEmail("r.john@gmail.com");
		author.setAuthorPhno(86868686l);

		Book book = new Book();
		book.setId(101);
		book.setName("Spring");
		book.setPrice(450.00);
		book.setAuthor(author);

		ObjectMapper mapper = new ObjectMapper();

		// converting java obj to json and store into a file
		mapper.writeValue(new File("book.json"), book);

		System.out.println("Conversion Completed....");
	}
}

