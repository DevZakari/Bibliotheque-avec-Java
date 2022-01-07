package com.biblio;


public class Somme {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int s=0;
		String result;
		for(String str :args)
		{
			try {
				s=s+ Integer.parseInt(str);
			}
			catch(NumberFormatException e)
			{
				System.out.println(e);
			}
		}
	
		System.out.println("La somme est : " + s);
	}
}
