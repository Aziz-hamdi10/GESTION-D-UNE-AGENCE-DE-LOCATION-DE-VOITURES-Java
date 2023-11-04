package Agence;

import java.util.Scanner;

public class Client {
	Scanner s=new Scanner(System.in);

private String cin;
private String Nom;
private String Prenom;
private String Adresse;
public String toString() {	
	return "Client [cin=" + cin + ", Nom=" + Nom + ", Prenom=" + Prenom + ", Adresse=" + Adresse + "]";
}
public String getCin() {
	return cin;
}
public void setCin(String cin) {
	this.cin = cin;
}
public String getNom() {
	return Nom;
}
public void setNom(String nom) {
	Nom = nom;
}
public String getPrenom() {
	return Prenom;
}
public void setPrenom(String prenom) {
	Prenom = prenom;
}
public String getAdresse() {
	return Adresse;
}
public void setAdresse(String adresse) {
	Adresse = adresse;
}
public Client(String cin, String nom, String prenom, String adresse) {
	super();
	this.cin = cin;
	Nom = nom;
	Prenom = prenom;
	Adresse = adresse;
}
public Client() {
	this.cin = "";
	Nom = "";
	Prenom = "";
	Adresse = "";	
}
public void saisir() { 
	do {
	System.out.println("Taper Cin svp");
	cin=s.next();}while(cin.length()!=8);
	do {
		System.out.println("Taper Nom svp");
		Nom=s.next();}while(Nom.length()==0);
	do {
		System.out.println("Taper Prenom svp");
		Prenom=s.next();}while(Prenom.length()==0);
	do {
		System.out.println("Taper Adresse svp");
		Adresse=s.next();}while(Adresse.length()==0);
	
}




}
