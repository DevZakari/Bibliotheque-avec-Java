package com.biblio;

public class Morse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String result = "";
		for(String str : args) {
				result = result + str + " Stop. ";
			}
		System.out.println(result);
	}
}
