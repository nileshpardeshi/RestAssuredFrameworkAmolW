package com.demo.utils;

import com.github.javafaker.Faker;

public final class FakerUtils {

	private FakerUtils() {

	}

	private static Faker faker = new Faker();

	static int getNumber(int startingNumber, int endingNumber) {
		return faker.number().numberBetween(startingNumber, endingNumber);
	}

	static String getFirstName() {
		return faker.name().firstName();
	}

	static String getLastName() {
		return faker.name().lastName();
	}

	static String getEmail() {
		return faker.internet().emailAddress();
	}

	static String getProfession() {
		return faker.job().title();
	}

}
