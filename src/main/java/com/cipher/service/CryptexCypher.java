package com.cipher.service;

import java.util.Scanner;

public class CryptexCypher {

	static void Reversalphabet(String word) {
		char ch;
		for (int i = 0; i < word.length(); i++) {

			ch = word.charAt(i);

			if (Character.isLetter(ch)) {

				if (Character.isLowerCase(ch)) {
					ch = (char) (122 - (ch) + 97);
				}

				else if (Character.isUpperCase(ch)) {
					ch = (char) (90 - (ch) + 65);
				}
			}

			System.out.print(ch);
		}
	}

	public static void main(String[] args) {
		System.out.println("please enter a letter");
		Scanner sc = new Scanner(System.in);
		String name = sc.nextLine();
		sc.close();

		System.out.print("The reversed of " + name + " is - " + "\n");

		Reversalphabet(name);

	}
}