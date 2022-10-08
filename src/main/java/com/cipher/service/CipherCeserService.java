package com.cipher.service;

import java.util.Scanner;

import org.springframework.stereotype.Component;

import com.cipher.model.CipherModel;
import com.cipher.util.CipherConstant;

@Component
public class CipherCeserService extends CipherGenericService {
	// ALPHABET string denotes alphabet from a-z
	public static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
	public static final String ALPHABET1 = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

	@Override
	public String cypherType() {
		return CipherConstant.CEASER;
	}

	@Override
	public CipherModel process(CipherModel cipherModel) {
		if (Boolean.TRUE.equals(cipherModel.getEncrypt()) && Boolean.TRUE.equals(cipherModel.getDecrypt())) {
			cipherModel.setEncryptedOutput(this.encryptData(cipherModel.getInput(), 0));
			cipherModel.setDecyptedOutput(this.decryptData(cipherModel.getEncryptedOutput(), 0));
			return cipherModel;
		}
		if (Boolean.TRUE.equals(cipherModel.getEncrypt())) {
			cipherModel.setEncryptedOutput(this.encryptData(cipherModel.getInput(), 0));
			cipherModel.setDecyptedOutput(null);
		}
		if (Boolean.TRUE.equals(cipherModel.getDecrypt())) {
			cipherModel.setDecyptedOutput(this.decryptData(cipherModel.getEncryptedOutput(), 0));
			cipherModel.setEncryptedOutput(null);
		}
		return cipherModel;
	}

	public static String encryptData(String inputStr, int shiftKey) {
		if (shiftKey == 0) {
			shiftKey = CipherConstant.DEFAULT_SHIFT_VALUE;
		}

		String encryptStr = "";

		for (int i = 0; i < inputStr.length(); i++) {
			if (Character.isUpperCase(inputStr.charAt(i))) {

				int pos = ALPHABET1.indexOf(inputStr.charAt(i));

				int encryptPos = (shiftKey + pos) % 26;
				char encryptChar = ALPHABET1.charAt(encryptPos);

				encryptStr += encryptChar;
			}

			else {
				if (Character.isLowerCase(inputStr.charAt(i))) {
					int pos = ALPHABET.indexOf(inputStr.charAt(i));

					int encryptPos = (shiftKey + pos) % 26;
					char encryptChar = ALPHABET.charAt(encryptPos);

					encryptStr += encryptChar;
				} else {
					encryptStr += inputStr.charAt(i);
				}

			}

		}

		return encryptStr;

	}

	// De//decryption
	public static String decryptData(String inputStr, int shiftKey) {
		if (shiftKey == 0) {
			shiftKey = CipherConstant.DEFAULT_SHIFT_VALUE;
		}

		String decryptStr = "";

		for (int i = 0; i < inputStr.length(); i++) {
			if (Character.isUpperCase(inputStr.charAt(i))) {

				int pos = ALPHABET1.indexOf(inputStr.charAt(i));

				int decryptPos = (pos - shiftKey) % 26;

				if (decryptPos < 0) {
					decryptPos = ALPHABET1.length() + decryptPos;
				}
				char decryptChar = ALPHABET1.charAt(decryptPos);

				decryptStr += decryptChar;
			} else {
				if (Character.isLowerCase(inputStr.charAt(i))) {
					int pos = ALPHABET.indexOf(inputStr.charAt(i));

					int decryptPos = (pos - shiftKey) % 26;

					if (decryptPos < 0) {
						decryptPos = ALPHABET.length() + decryptPos;
					}
					char decryptChar = ALPHABET.charAt(decryptPos);

					decryptStr += decryptChar;
				} else {
					decryptStr += inputStr.charAt(i);

				}

			}
		}
		return decryptStr;
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter a string for encryption: ");
		String inputStr = sc.nextLine();

		System.out.println("Enter shift");
		int shiftKey = Integer.valueOf(sc.nextLine());

		System.out.println("Encrypted Data  " + encryptData(inputStr, shiftKey));
		System.out.println("Decrypted Data = " + decryptData(encryptData(inputStr, shiftKey), shiftKey));

		sc.close();
	}

}