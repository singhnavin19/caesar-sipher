package com.cipher.service;
//package com.atharva.service;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Scanner;
//
//public class AsciDecimalToAlpha {
//    public static void main(String[] args) {
//		String input = "";
//		char h;
//		List<Character> outputArray = new ArrayList<>();
//		Scanner sc = new Scanner(System.in);
//		input = sc.nextLine();
//		int sum=0;
//		sum=sum+(int)Math.pow(10, 3);
//		Math.pow(a, b)
//		System.out.println(input);
//		for (String no : input.split(" ")) {
//			int n = Integer.parseInt(no);
//			outputArray.add((char) n);
//		}
//		System.out.println(outputArray);
//        int min = 0;
//        int max = 128;
//        for (int i = min; i < max; i++) {
//            char ch = (char) i;
//            String display = "";
//            if (Character.isWhitespace(ch)) {
//                switch (ch) {
//                    case '\r':
//                        display = "\\r";
//                        break;
//                    case '\t':
//                        display = "\\t";
//                        break;
//                    case '\n':
//                        display = "\\n";
//                        break;
//                    case '\f':
//                        display = "\\f";
//                        break;
//                    case ' ':
//                        display = "space";
//                        break;
//                    default:
//                        display = "whitespace";
//                        break;
//                }
//            } else if (Character.isISOControl(ch)) {
//                display = "control";
//            } else {
//                display = Character.toString(ch);
//            }
//        }
//    }
//}