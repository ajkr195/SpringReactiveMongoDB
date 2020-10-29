package com.spring.boot.rocks.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document(collection = "pets")
@Data

public class Pet {

	@Id
	private String id;
	private String name;
	private String age;
	private String email;
	private String address1;
	private String city;
	private String state;
	private String thumbnailImage;

}
