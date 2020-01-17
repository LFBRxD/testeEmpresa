package br.com.prova.test.enums;

public enum PhoneCountries {
	BRAZIL("+55"), ITALY("+39"), NETHERLANDS("+31");

	private String countryCode;

	PhoneCountries(String code) {
		this.countryCode = code;
	}

	public String getCountryCode() {
		return countryCode;
	}
}
