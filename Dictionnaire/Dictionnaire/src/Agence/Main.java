package Agence;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) throws IOException { 
		Parc p=new Parc();	
		LocEnCours lc=new LocEnCours();
		LocHistorique lh=new LocHistorique();
		menu(p,lc,lh);

}

	public static void menu( Parc p,LocEnCours lc, LocHistorique lh) {float prix;
		int choix,i,w;
		String cin,mat;
		Client c=new Client();
		Véhicules v=new Véhicules();
		Scanner s=new Scanner(System.in);
		do {	System.out.println("__________________________________________________________________________");
    			System.out.println();
	    	System.out.println("			Welcome !");
		System.out.println("	Taper 1 pour Accéder au gestion du parc de l'agence");
		System.out.println("	Taper 2 pour Accéder  au Gestion Locations :");
		System.out.println("	Taper 3 pour Accéder au Statistiques :");
		System.out.println("	Taper 4 pour Quitter :");
		 System.out.println("	Quel est votre choix? taper 1, 2 ,3 ou 4 :");
		System.out.print("__________________________________________________________________________");
		 System.out.println();
		System.out.print("Votre choix: ");
		  choix=s.nextInt();
		} while (choix<1||choix>4);

switch (choix)
		  {
		    case 1:
		    	System.out.println("__________________________________________________________________________");
		    	System.out.println("			Welcome !");
				System.out.println("		Gestion du Parc de l’Agence :");
				
				do {
					System.out.println("	Taper 1 pour Ajouter un Nouvelle véhicule ");
					System.out.println("	Taper 2 pour Modification de l’Etat d’un Véhicule :");
					System.out.println("	Taper 3 pour Supprimer un véhicule :");
					System.out.println("	Taper 4 pour Afficher tous les voiture dans le parc :");
					System.out.println("	Taper 5 pour Afficher tous les voiture loué(indisponible) dans le parc :");
					System.out.println("	Taper 6 pour Afficher tous les voiture en cours de répartation :");
					System.out.println("	Taper 7 pour Afficher tous les voiture disponible dans le parc :");
					System.out.println("	Taper 8 pour Revenir au menu :");

					 System.out.println("		Quel est votre choix? taper 1, 2, 3, 4, 5, 6, 7 ou 8 :");
					 System.out.print("__________________________________________________________________________");
					 System.out.println();
						System.out.print("Votre choix: ");
					 i=s.nextInt();
					} while (i<1||i>8);
		       switch(i){
		        case 1: 
					 System.out.println("__________________________________________________________________________");
		        	System.out.println("		Ajout d'une Voiture !");
		        	p.Ajout();
					 System.out.print("__________________________________________________________________________");

		            break; 
		        case 2:System.out.println("		Modification d'etat d'une Voiture !");
		        	p.affiche();
		        if(p.getPv().size()>0) {
		        do {
					System.out.println("	Taper Le numéro du voiture ! :");
					System.out.print("Votre choix: ");
					System.out.println("	Taper 104 pour quitter ! :");
					w=s.nextInt();
				}while((w<=0||w>p.getPv().size())&&w!=104);
		        if(w!=104) {
		        p.getPv().get(w-1).modifEtat();
		        System.out.println("	Etat modifiée avec succées !");}
		        }
		            break;
		        case 3:
		        	System.out.println("__________________________________________________________________________");
		        	System.out.println("		Suppresion d'une Voiture !");
		        	p.affiche(); 
		        if(p.getPv().size()>0) {

		        do {
				System.out.println("	Taper Le numéro du voiture ! :");
				System.out.println("	Taper 104 pour quitter ! :");

				System.out.print("Votre choix: ");

				w=s.nextInt();
			}while((w<=0||w>p.getPv().size())&&w!=104);
		        if(w!=104) {
		        		p.supprimerv1(w-1);}
		        }
		   
		        	break;
		        case 4:p.affiche();
		            break;
		        case 5:p.afficheloue();
		            break;
		        case 6:p.afficheRep();
		            break;
		        case 7:p.affichedispo();
		            break;
		        case 8:menu(p,lc,lh);
		            break;

		       }
		       break;
		    case 2:
				 System.out.println("__________________________________________________________________________");

		    	System.out.println("			Welcome !");
				System.out.println(" 		Gestion Locations :");
				do {
					System.out.println("	Taper 1 pour Ajouter un Nouvelle Location :");
					System.out.println("	Taper 2 pour supprimer un Location :");
					System.out.println("	Taper 3 pour Afficher tous les location en cours :");
					System.out.println("	Taper 4 pour afficher les location loue par un client :");

					System.out.println("	Taper 5 pour Revenir au menu :");

					 System.out.println("	Quel est votre choix? taper 1, 2, 3, 4 ou 5 ");
					 System.out.println("__________________________________________________________________________");

						System.out.print("Votre choix: ");
					  i=s.nextInt();
					} while (i<1||i>5);
			     switch(i){
			        case 1:	System.out.println("__________________________________________________________________________");
		        	System.out.println("		Ajoutation d'une Allocation !");
			        	if(p.getPv().size()>0) {
			        	c.saisir();
			        do {
			        	
			      
			        System.out.println(" 	Liste du voiture en parc !");
			        	p.affiche();
			        

			        do {
			        		System.out.println("	Taper votre choix :Numéro du voiture !");
			        		System.out.println("	Taper 104 pour quitter ! :");
			        		w=s.nextInt();					

			        }while((w<=0||w>p.getPv().size())&&w!=104);
			        if(w!=104) {
			        		if(p.getPv().get(w-1).getEtat()=="Indisponible" || p.getPv().get(w-1).getEtat()=="En cours de repartation")
			        		{
			        			System.out.println("	Voiture est "+p.getPv().get(w-1).getEtat());
			        			do 
			        			{ System.out.println("	Taper 9 pour choisir une autre voiture ");
			        				System.out.println("	Taper 0 pour revenir au menu Iniale");
			        				w=s.nextInt();
			        			
			        			}while(w!=9&&w!=0);
			        		}}
			        }while (w==9);
			        if(w==0) {
			        	menu(p,lc,lh);
			        }
			        else {	if(w!=104) {
			        		System.out.println("	Taper le prix svp : !");
			        		prix=s.nextFloat();
			        	lc.ajoutlocation(p.getPv().get(w-1),c,prix);}
			        }}
			        else
				     { System.out.println("	Pas du Vihicules Disponible !");
				    	 menu(p,lc,lh);
				            break; 
				     }
			            break;
			        case 2:
			        	System.out.println("__________________________________________________________________________");
			        	System.out.println("		Suppresion d'une Allocation !");
			        	if(lc.getListloc().size()>0)
			        	{System.out.println("	Taper CIN svp :!");
			        	cin=s.next();
			        	System.out.println("	Taper Matricule svp :!");
			        	mat=s.next();
			        	lc.suppLocation(cin,mat,lh);}
			        	else
			        	{
			        		System.out.println(" 	Pas du lacation !");
			        	}
			            break;
			        case 3:System.out.println("__________________________________________________________________________");
		        	System.out.println("		Affichage !");
			        	lc.affiche();
			        	break;
			        case 4:if(lc.getListloc().size()>0) {
			        	System.out.println("		Taper le Cin svp :");
			        cin=s.next();
			        	lc.afficheclient(cin);}
			        else
			        {
			        	System.out.println("	 Pas des loctaion !");
			        }
			            break;
			        case 5:menu(p,lc,lh);
			            break; 
			       }
		       break;
		    case 3:
				 System.out.println("__________________________________________________________________________");
		    	System.out.println("			Welcome !");
				System.out.println("		Statistiques :");
				do {
					System.out.println("	Taper 1 pour Afficher les nombre du location pour un period  :");
					System.out.println("	Taper 2 pour affiches les revenus pour une period donnée:");
					System.out.println("	Taper 3 pour Afficher la liste du client a risque:");

					System.out.println("	Taper 4 pour Afficher les locations Historique :");
					System.out.println("	Taper 5 pour Afficher les fideles Client  :");

					System.out.println("	Taper 6 pour Revenir au menu :");

					 System.out.println("	Quel est votre choix? taper 1, 2, 3, ou 4 ");
					 System.out.println("__________________________________________________________________________");

						System.out.print("Votre choix: ");

					  i=s.nextInt();
					} while (i<1||i>5);
				switch(i){
		        case 1:
		        	System.out.println("__________________________________________________________________________");
		        	System.out.println("		Nombre du location pour un period !");
		        	System.out.println( lc.nombreloc(lh));
		            break;
		        case 2:
		        	System.out.println("__________________________________________________________________________");
		        	System.out.println("		Total des reveunus pour un period !");
		        	System.out.println(lc.totalrev(lh)+" Dt");
		            break;
		        case 3: 
		        	lh.affichclientrisque();
		        	break;
		        case 4:
		        		lh.afficheloch();
		        case 5:lh.affichclient(lc);
		        case 6:menu(p,lc,lh);
		            break; 
		       }
		    break;
		    default:System.exit(1);
		}menu(p,lc,lh);

		}


}