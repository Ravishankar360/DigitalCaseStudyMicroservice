package com.demo.util;

import java.io.Serializable;

public enum Salutation implements Serializable {
	
	Dr("Dr"),Prof("Prof"),Mr("Mr"),Ms("Ms"),Mrs("Mrs"),Miss("Miss"),Asst("Asst");
	
	private String action;

	private Salutation(String action) {
		this.action = action;
	}

}