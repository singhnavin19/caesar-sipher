package com.cipher.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.cipher.model.CipherModel;
import com.cipher.util.CipherConstant;

@Component
public class CipherPolybiusService extends CipherGenericService {

	@Override
	public String cypherType() {
		return CipherConstant.POLYBIUS;
	}

	@Override
	public CipherModel process(CipherModel cipherModel) {
		if (Boolean.TRUE.equals(cipherModel.getEncrypt()) && Boolean.TRUE.equals(cipherModel.getDecrypt())) {
			cipherModel.setEncryptedOutput(this.encryptData(cipherModel.getInput()).toString());
			cipherModel.setDecyptedOutput(this.decryptData(cipherModel.getEncryptedOutput()).toString());

			return cipherModel;
		}
		if (Boolean.TRUE.equals(cipherModel.getEncrypt())) {
			cipherModel.setEncryptedOutput(this.encryptData(cipherModel.getInput()).toString());
			cipherModel.setDecyptedOutput(null);
		}
		if (Boolean.TRUE.equals(cipherModel.getDecrypt())) {
			cipherModel.setDecyptedOutput(this.decryptData(cipherModel.getInput()).toString());
			cipherModel.setEncryptedOutput(null);
		}

		return cipherModel;
	}

	private StringBuilder encryptData(String input) {
		Map<String, String> encryptMap = getEncryptMap();
		StringBuilder encryptedResult = new StringBuilder();

		for (String s : input.split("")) {
			String value = encryptMap.get(s.toUpperCase());
			if (value != null) {
				encryptedResult.append(value + ",");
			} else {
				encryptedResult.append(s + ",");
			}
		}
		return encryptedResult;
	}

	private StringBuilder decryptData(String input) {
		Map<String, String> decryptMap = getDecyptMap();
		StringBuilder decryptedResult = new StringBuilder();

		for (String s : input.split(",")) {
			String value = decryptMap.get(s);
			if (value != null) {
				decryptedResult.append(value);
			} else {
				decryptedResult.append(s);
			}
		}
		return decryptedResult;
	}

	private static Map<String, String> getEncryptMap() {
		Map<String, String> encryptMap = new HashMap<String, String>();
		encryptMap.put("A", "11");
		encryptMap.put("B", "12");
		encryptMap.put("C", "13");
		encryptMap.put("D", "14");
		encryptMap.put("E", "15");
		encryptMap.put("F", "21");
		encryptMap.put("G", "22");
		encryptMap.put("H", "23");
		encryptMap.put("I", "24");
		encryptMap.put("J", "24");
		encryptMap.put("K", "25");
		encryptMap.put("L", "31");
		encryptMap.put("M", "32");
		encryptMap.put("N", "33");
		encryptMap.put("O", "34");
		encryptMap.put("P", "35");
		encryptMap.put("Q", "41");
		encryptMap.put("R", "42");
		encryptMap.put("S", "43");
		encryptMap.put("T", "44");
		encryptMap.put("U", "45");
		encryptMap.put("V", "51");
		encryptMap.put("W", "52");
		encryptMap.put("X", "53");
		encryptMap.put("Y", "54");
		encryptMap.put("Y", "55");

		return encryptMap;
	}

	private static Map<String, String> getDecyptMap() {
		Map<String, String> decryptMap = new HashMap<String, String>();
		decryptMap.put("11", "A");
		decryptMap.put("12", "B");
		decryptMap.put("13", "C");
		decryptMap.put("14", "D");
		decryptMap.put("15", "E");
		decryptMap.put("21", "F");
		decryptMap.put("22", "G");
		decryptMap.put("23", "H");
		decryptMap.put("24", "I");
		decryptMap.put("25", "K");
		decryptMap.put("31", "L");
		decryptMap.put("32", "M");
		decryptMap.put("33", "N");
		decryptMap.put("34", "O");
		decryptMap.put("35", "P");
		decryptMap.put("41", "Q");
		decryptMap.put("42", "R");
		decryptMap.put("43", "S");
		decryptMap.put("44", "T");
		decryptMap.put("45", "U");
		decryptMap.put("51", "V");
		decryptMap.put("52", "W");
		decryptMap.put("53", "X");
		decryptMap.put("54", "Y");
		decryptMap.put("55", "Y");

		return decryptMap;
	}

}
