package com.cipher.util;

import java.util.ArrayList;
import java.util.List;

public class CipherConstant {

	public static final String RAIL_FENCE = "Rail Fence";
	public static final String CEASER = "Ceaser";
	public static final String POLYBIUS = "Polybius";
	public static final String CRYPTEX = "Cryptex";
	public static final String ASCIICODECIPHER = "Asci Code Cypher";

	public static final List<String> cipherTypes = new ArrayList<String>();
	public static final int DEFAULT_SHIFT_VALUE = 2;


	static {
		cipherTypes.add(POLYBIUS);
		cipherTypes.add(CEASER);
		cipherTypes.add(RAIL_FENCE);
		cipherTypes.add(CRYPTEX);
		cipherTypes.add(ASCIICODECIPHER);

	}
}
