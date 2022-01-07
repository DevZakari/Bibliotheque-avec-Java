package com.biblio;

import java.lang.Exception;
import java.util.Enumeration;
import java.util.*;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.*;

public class TestBiblio {

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		
		
		
		
		Scanner clavier = new Scanner(System.in);
		Scanner Livre = new Scanner(System.in);
		Scanner Auteur = new Scanner(System.in);
		
		// Si l'utilisateur veut Créer une bibliotheque : 
		int faireBiblio;
		System.out.println("Voulez Vous Créer Votre Propre Bibliothèque : ");
		faireBiblio = clavier.nextInt();
		Bibliotheque Bib=new Bibliotheque(10);
		if(faireBiblio == 1)
		{
			int NombreMAXLivre;
			System.out.println("Donnez Le nombre Max de livre : ");
			NombreMAXLivre = clavier.nextInt(); 
			Bibliotheque BibProp = new Bibliotheque(NombreMAXLivre);
			Bib=BibProp;
		}
		
		// le choix : 
		int choix;
		// Menu : 
		do {
			System.out.println("************* Welcome to OUR Library *************");
			System.out.println("1. Afficher votre Bibliotheque .");
			System.out.println("2. Ajouter Un Livre Dans votre Bibliotheque .");
			System.out.println("3. Chercher Les livres par un Auth .");
			System.out.println("4. Serializer votre Bibliotheque .");
			System.out.println("5. Deserializer votre Bibliotheque .");
			System.out.println("0. Sortir!"); 
			System.out.println("Entre Votre Choix :  ");
			choix = clavier.nextInt();
			
			switch(choix)
			{
			case 1 : System.out.println(Bib);break;
			case 2 : System.out.println("Entrez les informations de votre livre: ");
					 System.out.println(" Titre du livre   : ");
					 String Liv = Livre.nextLine();
					 System.out.println(" ISBN du livre    : ");
					 String Isbn = clavier.next();
					 System.out.println(" Le PRIX du livre : ");
					 double Prix = clavier.nextDouble();
					 System.out.println(" Donnez le nombre des auteurs : ");
					 int NbrAuteur = clavier.nextInt();
					 String [] Les_Auths = new String[NbrAuteur];
					 for(int i=0; i< Les_Auths.length; i++)
					 {
						 System.out.println(" Nom d'auteur Num : "+(i+1));
						 Les_Auths[i] = Auteur.nextLine();
					 }
					 Livre L = new Livre(Liv,Les_Auths,Isbn,Prix);
					 Bib.Ajouter_Livre(L);
					 break;
			case 3 : 
					 Scanner nom_pre = new Scanner(System.in);
					 System.out.println("Donnez le nom ou le préfix du Auteur : ");
					 String author = nom_pre.next();
					 Vector<Livre> v_auth = new Vector<Livre>();
					 v_auth = Bib.Livres_Pour_Auth(author);
					 for(Enumeration<Livre> liv_auth =v_auth.elements(); liv_auth.hasMoreElements(); ) {
						 System.out.println(liv_auth.nextElement());
					 }
					 break;
					 
			case 4 :
					 ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("file_object.txt"));
					 try {
						 // on ecrit l'object Bib
						 oos.writeObject(Bib);
						 // on vide le buffer : 
						 oos.flush();
					 } finally {
						 oos.close();
					 }
					 
					 break;
			case 5 : 
					ObjectInputStream ois = new ObjectInputStream(new FileInputStream("file_object.txt"));
					try {
						// on va lire notre object Bib :
						Bib = (Bibliotheque)ois.readObject();
						// et on affiche : 
						System.out.println(" ** Votre Bibliotheque Archivée  **");
						System.out.println(Bib);
					} finally {
						ois.close();
					}
					break;		
			case 0 : break;		
			default: System.out.println("Votre Choix est errone. Reessayez! ");
			}
			 try {
				char ch = (char) System.in.read();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 if(choix == 0) break;
		}while(choix != 0);
		
	}

}
