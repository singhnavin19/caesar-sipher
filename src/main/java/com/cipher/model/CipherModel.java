package com.cipher.model;

public class CipherModel {
	private String cipherType;
	private Boolean encrypt;
	private Boolean decrypt;
	private String input;
	private String decyptedOutput;
	private String encryptedOutput;
	public Boolean getDecrypt() {
		return this.decrypt;
	}

	public String getDecyptedOutput() {
		return this.decyptedOutput;
	}

	public void setDecyptedOutput(String decyptedOutput) {
		this.decyptedOutput = decyptedOutput;
	}

	public String getEncryptedOutput() {
		return this.encryptedOutput;
	}

	public void setEncryptedOutput(String encryptedOutput) {
		this.encryptedOutput = encryptedOutput;
	}

	public void setDecrypt(Boolean decrypt) {
		this.decrypt = decrypt;
	}

	public Boolean getEncrypt() {
		return this.encrypt;
	}

	public void setEncrypt(Boolean encrypt) {
		this.encrypt = encrypt;
	}

	public String getInput() {
		return this.input;
	}

	public void setInput(String input) {
		this.input = input;
	}

	public String getCipherType() {
		return this.cipherType;
	}

	public void setCipherType(String cipherType) {
		this.cipherType = cipherType;
	}

	public Boolean isSelectedCipherType(String cipherType) {
		if (this.cipherType != null) {
			return this.cipherType.equalsIgnoreCase(cipherType);
		}
		return false;
	}
}
