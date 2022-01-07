package com.biblio;

import java.util.Arrays;
import java.io.Serializable;

public class Livre implements Serializable {
	
	private String Titre;
	private String [] Authors;
	private String ISBN;
	private double Prix;
	public Livre(String titre, String[] authors, String iSBN, double prix) {
		super();
		Titre = titre;
		Authors = authors;
		ISBN = iSBN;
		Prix = prix;
	}
	
	public String toString() {
		return "Livre -> [Titre=" + Titre + ", Authors=" + Arrays.toString(Authors) + ", ISBN=" + ISBN + ", Prix=" + Prix
				+ "]";
	}
	
	public boolean AuthorExist(String auth) {
		
		for(int i=0;i<Authors.length;i++)
		{
			if(Authors[i].contains(auth))
				return true;
		}
		return false;
	}
	

}
