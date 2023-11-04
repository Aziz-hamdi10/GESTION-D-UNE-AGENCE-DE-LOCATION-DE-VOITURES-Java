package Agence;

import java.util.ArrayList;
import java.util.Scanner;

public class LocHistorique {
private ArrayList<Location> listloceff;
private boolean [][]rtr;

public LocHistorique() {
	listloceff=new ArrayList<Location>();
	rtr=new boolean[50][2];
	
}
public void afficheloc() {
	if (listloceff.size()==0)
	{
		System.out.println("Pas du locations");
	}
	else
	{
		for(int i=0 ;i<listloceff.size();i++)
		{
			listloceff.get(i).affichloc();
		}
	}
}
public void ajoutloch(Location l,boolean v) {int x;
Scanner s =new Scanner(System.in);
	Location l1=new Location(l.getV(), l.getC(),l.getDb(),l.getDf(), l.getPrix(),l.getAvance());
	do {
	System.out.println("Taper l'etat du voiture svp");
	System.out.println("1 | si ok  //// 0 si non !");
	x=s.nextInt();
	}while(x!=0&&x!=1);
	if(x==1)
		{rtr[listloceff.size()][0]=true;
		l.getV().setEtat("Disponible");}
	else 
	{rtr[listloceff.size()][0]=false;
	l.getV().setEtat("En cours de repartation");}
	rtr[listloceff.size()][1]=v;
	
				
	listloceff.add(l1);
	
}
public void afficheloch() {
	System.out.println("__________________________________________________________________________");

	if(listloceff.size()==0)
	{
		System.out.println("Aucun location Enregistrer !");
	}
	for(int i=0;i<listloceff.size();i++)
	{ System.out.println("Location n° " +i+1);
		listloceff.get(i).affichloc();
		if(rtr[i][0])
		{
			System.out.println("Etat du voiture : okay");

		}
		else
		{
			System.out.println("Etat du voiture : Mal !");

		}
		if(rtr[i][1]) {
			System.out.println("Rendre au temps : Au temps");

		}
		else
			System.out.println("Rendre au temps : Pas au temps !");


	}	System.out.println("__________________________________________________________________________");

}
public ArrayList<Location> getListloceff() {
	return listloceff;
}
public void setListloceff(ArrayList<Location> listloceff) {
	this.listloceff = listloceff;
}
public boolean[][] getRtr() {
	return rtr;
}
public void setRtr(boolean[][] rtr) {
	this.rtr = rtr;
}
public void affichclientrisque() {
	if(listloceff.size()==0) {
		System.out.println("	 pas des location enregister !");
		
	}
	else 
	{ int z=0;
		for(int i=0;i<listloceff.size();i++)
		{	if(rtr[i][0]==false||rtr[i][1]==false)
		{ z++;
				System.out.println(" 	Client risqué :");
			System.out.println(listloceff.get(i).getC().toString());
		}
			
		}
		if(z==0) {
			System.out.println("	 Pas du client Risquée !");
		}
	}
}
public int occurence(Client c,LocEnCours l)
{ int z=0;
	for (int i=0;i<l.getListloc().size();i++)
	{
		if(l.getListloc().get(i).getC().getCin().equalsIgnoreCase(c.getCin()))
		{
			z++;
		}
	}
	for(int i=0;i<listloceff.size();i++)
	{
		z++;
	}
	return z;
}
public void affichclient(LocEnCours l) {
	int z=0;
	if(l.getListloc().size()==0&&listloceff.size()==0)
	{
		System.out.println(" 	Pas du location !");
	}
	for(int i=0;i<listloceff.size();i++)
	{	if(occurence(listloceff.get(i).getC(),l)>z)
	{
		z=occurence(listloceff.get(i).getC(),l);
	}
		
	}
	for(int i=0;i<listloceff.size();i++)
	{	if(occurence(listloceff.get(i).getC(),l)==z)
	{
		System.out.println(listloceff.get(i).getC().toString());
	}
		
	}
	
	
}
}

