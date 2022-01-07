package com.biblio;

import java.io.*;
import java.lang.Exception;
import java.io.NotSerializableException;
import java.util.Arrays;
import java.util.Vector;


public class Bibliotheque implements Serializable {

	private Livre [] livres;
	private int nbrLivre;
	private int nbrMaxLivre;
	private static final long serialVersionUID = 1L;
	// constructor :
	public Bibliotheque(int nbrMaxLivre) {
		super();
		this.nbrMaxLivre = nbrMaxLivre;
		livres = new Livre[nbrMaxLivre];
		nbrLivre =0;
	}
	
	public int CapaciteBiblio() {
		return nbrMaxLivre;
	}
	
	public boolean Ajouter_Livre(Livre L) {
		if(nbrLivre == nbrMaxLivre)
			return false;
		else {
			livres[nbrLivre++] = L;
			return true;
		}
	}
	public int NumberOfLivresExist() {
		return nbrLivre;
	}

	@Override
	public String toString() {
		
		String result =  "Bibliotheque  " + ", nbrLivre=" + nbrLivre + " , nbrMaxLivre="
				+ nbrMaxLivre  + "\n ******* Les livres disponible ******* \n";
		for(int i =0; i< this.nbrLivre ; i++)
		{
			result+= "\t -> " + livres[i].toString() + "\n"; 
		}
		return result;
	}
	
	public Vector<Livre> Livres_Pour_Auth(String auth) {
		
		Vector<Livre> vec = new Vector<Livre>();
		for(int i=0;i<this.nbrLivre;i++)
		{
			if(livres[i].AuthorExist(auth))
				vec.add(livres[i]);
		}
		return vec;
	}
	
	
	public void save() throws FileNotFoundException, IOException // ,NotSerializableException
	{
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("sereal.txt"));

		try {

			oos.writeObject(this);
			oos.flush();

		} finally {
			oos.close();
		}

	}

	public Bibliotheque readlib() throws FileNotFoundException, IOException, ClassNotFoundException {
		Bibliotheque Bibli;

		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("sereal.txt"));

		try {

			Bibli = (Bibliotheque) ois.readObject();

		} finally {
			ois.close();
		}

		return Bibli;
	}
	

	

}
