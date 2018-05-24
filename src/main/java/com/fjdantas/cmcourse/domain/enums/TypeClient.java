package com.fjdantas.cmcourse.domain.enums;


public enum TypeClient {
	//configuration of enums for saving into database
	PHYSICALPERSON(1, "Physical Person"), 
	LEGALPERSON(2, "Legal Person");
	
	private int code;
	private String description;
	
	/*
	 * private constructor enum to receive  the code and description as parameters
	 */
	private TypeClient(int code, String description) {
		this.code = code;
		this.description = description;
	}
	
	public int getCode() {
		return code;
	}
	
	public String getDescription() {
		return description;
	}
	
	/*
	 * operation to receive a code and return an object of type TypeClient 
	 * instantiated and configuration or a exception into static method
	 */	
	public static TypeClient toEnum(Integer code) {
		if(code == null) {
			return null;
		}
		for(TypeClient x : TypeClient.values()) {
			if(code.equals(x.getCode())) {
				return x;
			}
		}
		throw new IllegalArgumentException("Invalid Id" + code);
	}

}
