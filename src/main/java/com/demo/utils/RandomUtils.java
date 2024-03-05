package com.demo.utils;

public final class RandomUtils {

	private RandomUtils() {

	}

	public static int getID() {
		return FakerUtils.getNumber(30, 5000);
	}

	public static String getRandomFirstName() {
		return FakerUtils.getFirstName();
	}

	public static String getRandomLastName() {
		return FakerUtils.getLastName();
	}

	public static String getRandomEmailID() {
		return FakerUtils.getEmail();
	}

	public static String getRandomProfessionTitle() {
		return FakerUtils.getProfession();
	}

}
