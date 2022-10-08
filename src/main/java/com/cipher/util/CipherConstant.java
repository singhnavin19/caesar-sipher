package com.cipher.util;

import java.util.ArrayList;
import java.util.List;

public class CipherConstant {

	public static final String CEASER = "Ceaser";
	public static final String POLYBIUS = "Polybius";
	public static final List<String> cipherTypes = new ArrayList<String>();

	static {
		cipherTypes.add(POLYBIUS);
		cipherTypes.add(CEASER);
	}
}
