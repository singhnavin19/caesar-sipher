package com.cipher.service;
import java.util.Scanner;

import org.springframework.stereotype.Component;

import com.cipher.model.CipherModel;
import com.cipher.util.CipherConstant;

@Component
public class CipherRailFenceService extends CipherGenericService {

	@Override
	public String cypherType() {
		return CipherConstant.RAIL_FENCE;
	}

	@Override
	public CipherModel process(CipherModel cipherModel) {
		if (Boolean.TRUE.equals(cipherModel.getEncrypt()) && Boolean.TRUE.equals(cipherModel.getDecrypt())) {
			cipherModel.setEncryptedOutput(this.encryption(cipherModel.getInput(), 0));
			cipherModel.setDecyptedOutput(this.decryption(cipherModel.getEncryptedOutput(), 0));

			return cipherModel;
		}
		if (Boolean.TRUE.equals(cipherModel.getEncrypt())) {
			cipherModel.setEncryptedOutput(this.encryption(cipherModel.getInput(), 0));
			cipherModel.setDecyptedOutput(null);
		}
		if (Boolean.TRUE.equals(cipherModel.getDecrypt())) {
			cipherModel.setDecyptedOutput(this.decryption(cipherModel.getEncryptedOutput(), 0));
			cipherModel.setEncryptedOutput(null);
		}
		return cipherModel;
	}

	public static void main(String arg[]) {

		System.out.println("Enter the number of rails:");
		Scanner in = new Scanner(System.in);
		int rails = in.nextInt();

		System.out.println("Enter the plaintext for encryption");
		Scanner inn = new Scanner(System.in);
		String plaintext = inn.next();

//  .encryption(plaintext,rails);

		System.out.println("------------------Decryption process start----------");

		System.out.println("Enter the number of rails:");
		rails = in.nextInt();
		System.out.println("Enter the ciphertext for decryption:");
		String ciphertext = in.next();
//		this.decryption(ciphertext, rails);

	}

	public String encryption(String str, int rails) {

		boolean checkdown = false; // check whether it is moving downward or upward
		int j = 0;
		if (rails == 0) {
			rails = CipherConstant.DEFAULT_SHIFT_VALUE;
		}

		int row = rails; // no of row is the no of rails entered by user
		int col = str.length(); // column length is the size of string
		char[][] a = new char[row][col];
		// we create a matrix of a of row *col size

		for (int i = 0; i < col; i++) { // matrix visitin in rails order and putting the character of plaintext

			if (j == 0 || j == row - 1)
				checkdown = !checkdown;
			a[j][i] = str.charAt(i);
			if (checkdown) {

				j++;
			} else
				j--;
		}

		// visiting the matrix in usual order to get ciphertext
		for (int i = 0; i < row; i++) {
			for (int k = 0; k < col; k++) {
				System.out.print(a[i][k] + "  ");
			}
			System.out.println();
		}
		String en = "";

		for (int i = 0; i < row; i++) {
			for (int k = 0; k < col; k++) {
				if (a[i][k] != 0)
					en = en + a[i][k];

			}

		}
		System.out.println(en);// printing the ciphertext
		return en;
	}

	public String decryption(String str, int rails) {
		boolean checkdown = false;
		int j = 0;
		if (rails == 0) {
			rails = CipherConstant.DEFAULT_SHIFT_VALUE;
		}
		int row = rails;
		int col = str.length();
		char[][] a = new char[row][col];

		// first of all mark the rails position by * in the matrix
		for (int i = 0; i < col; i++) {
			if (j == 0 || j == row - 1)
				checkdown = !checkdown;

			a[j][i] = '*';
			if (checkdown)
				j++;
			else
				j--;

		}

		// now enter the character of ciphertext in the matrix positon that have *
		// symbol
		int index = 0;

		for (int i = 0; i < row; i++) {
			for (int k = 0; k < col; k++) {

				if (a[i][k] == '*' && index < str.length()) {
					a[i][k] = str.charAt(index++);

				}

			}

		}

// visit each character in rails order as character are put in the encryption function
		for (int i = 0; i < row; i++) {
			for (int k = 0; k < col; k++) {
				System.out.print(a[i][k] + "\t");
			}
			System.out.println();
		}

		checkdown = false;
		String s = "";
		j = 0;

		for (int i = 0; i < col; i++) {
			if (j == 0 || j == row - 1)
				checkdown = !checkdown;

			s += a[j][i];

			if (checkdown)
				j++;
			else
				j--;

		}

		System.out.print(s);// print the plaintext that was decrypted by rail fence cipher

		return s;

	}

}