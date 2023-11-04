package Agence;

import java.util.Scanner;

public class Véhicules {
private String nummat ;
private String etat ;
private String marque ;
public Véhicules()
{
	this.nummat ="";
	this.etat ="Disponible";
	this.marque = "";
}
public Véhicules(String nummat, String etat, String marque) {
	super();
	this.nummat = nummat;
	this.etat = etat;
	this.marque = marque;
}

public String getNummat() {
	return nummat;
}
public void setNummat(String nummat) {
	this.nummat = nummat;
}
public String getEtat() {
	return etat;
}
public void setEtat(String etat) {
	this.etat = etat;
}
public String getMarque() {
	return marque;
}
public void setMarque(String marque) {
	this.marque = marque;
}
public String toString() {
	return "Véhicules [numéro de mat=" + nummat + ", etat=" + etat + ", marque=" + marque + "]";
}
public void saisir() {
	Scanner s=new Scanner(System.in);
	System.out.println("	Taper le num mat svp :");
	this.setNummat(s.next());
	System.out.println("	Taper la Marque  svp :");
	this.setMarque(s.next());
	System.out.println("	Taper Etat svp :");
	this.modifEtat();
	
	
}
public void modifEtat() { int x;
Scanner s=new Scanner(System.in);

	do {
		System.out.println("2 si en cours de repartation| 1 si Disponible | 0 si Indisponible !");
		x=s.nextInt();}while(x!=0&&x!=1&&x!=2);
		
	if(x==1)
	{this.setEtat("Disponible");}
	else {
		if(x==0)
		{
			this.setEtat("Indisponible");
		}
		else {
			this.setEtat("En cours de repartation");
		}
	}
}




}
