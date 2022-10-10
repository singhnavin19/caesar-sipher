package com.cipher.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.cipher.model.CipherModel;
import com.cipher.util.CipherConstant;

@Component
public class CipherCryptexService extends CipherGenericService {

	private static Map<String, String> mapData = datSet();
	@Override
	public String cypherType() {
		return CipherConstant.CRYPTEX;
	}

	@Override
	public CipherModel process(CipherModel cipherModel) {
		if (Boolean.TRUE.equals(cipherModel.getEncrypt()) && Boolean.TRUE.equals(cipherModel.getDecrypt())) {
			cipherModel.setEncryptedOutput(this.encryptData(cipherModel.getInput()).toString());
			cipherModel.setDecyptedOutput(this.decyptData(cipherModel.getEncryptedOutput()).toString());

			return cipherModel;
		}
		if (Boolean.TRUE.equals(cipherModel.getEncrypt())) {
			cipherModel.setEncryptedOutput(this.encryptData(cipherModel.getInput()).toString());
			cipherModel.setDecyptedOutput(null);
		}
		if (Boolean.TRUE.equals(cipherModel.getDecrypt())) {
			cipherModel.setDecyptedOutput(this.encryptData(cipherModel.getInput()).toString());
			cipherModel.setEncryptedOutput(null);
		}

		return null;
	}

	private Object decyptData(String encryptedOutput) {
		StringBuilder result = new StringBuilder();
		for (String s : encryptedOutput.split("")) {
			if (mapData.containsKey(s)) {
				result.append(mapData.get(s));
			} else {
				result.append(s);
			}
		}
		return result;
	}

	private Object encryptData(String input) {
		StringBuilder result=new StringBuilder();
		for(String s:input.split("")) {
			if (mapData.containsKey(s)) {
				result.append(mapData.get(s));
			} else {
				result.append(s);
			}
		}
		return result;
	}

	public static Map<String, String> datSet() {
		Map<String, String> map=new HashMap<String, String>();

		map.put("a ","z");
		map.put("b","y");
		map.put("c","x");
		map.put("d","w");
		map.put("e","v");
		map.put("f","u");
		map.put("g","t");
		map.put("h","s");
		map.put("i","r");
		map.put("j","q");
		map.put("k","p");
		map.put("l","o");
		map.put("m","n");
		map.put("n","m");
		map.put("o","l");
		map.put("p","k");
		map.put("q","j");
		map.put("r","i");
		map.put("s","h");
		map.put("t","g");
		map.put("u","f");
		map.put("v","e");
		map.put("w","d");
		map.put("x","c");
		map.put("y","b");
		map.put("z","a");
		map.put("A ","A ");
		map.put("B","B");
		map.put("C","C");
		map.put("D","D");
		map.put("E","E");
		map.put("F","F");
		map.put("G","G");
		map.put("H","H");
		map.put("I","I");
		map.put("J","J");
		map.put("K","K");
		map.put("L","L");
		map.put("M","M");
		map.put("N","N");
		map.put("O","O");
		map.put("P","P");
		map.put("Q","Q");
		map.put("R","R");
		map.put("S","S");
		map.put("T","T");
		map.put("U","U");
		map.put("V","V");
		map.put("W","W");
		map.put("X","X");
		map.put("Y","Y");
		map.put("Z","Z");

		return map;
	}


}