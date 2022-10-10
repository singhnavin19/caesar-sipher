package com.cipher.service;

import org.springframework.stereotype.Component;

import com.cipher.model.CipherModel;
import com.cipher.util.CipherConstant;

@Component
public class CipherAsciiService extends CipherGenericService {
	@Override
	public String cypherType() {
		return CipherConstant.ASCIICODECIPHER;
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

	private Object decryptData(String encryptedOutput) {
		StringBuilder result = new StringBuilder();
		for (String s : encryptedOutput.split(",")) {
			result.append(Character.toString((char) Integer.parseInt(s)));
		}
		return result;
	}

	private Object encryptData(String input) {
		StringBuilder result = new StringBuilder();
		for (char c : input.toCharArray()) {
			result.append(Integer.toString(c) + ",");
		}
		return result;
	}

}