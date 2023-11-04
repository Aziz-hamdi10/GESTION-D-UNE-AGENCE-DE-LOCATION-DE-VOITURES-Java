package Agence;

import java.nio.file.spi.FileSystemProvider;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
public class LocEnCours {
	
private ArrayList<Location> listloc;

public static  boolean checkdate(int j ,int m ,int a) {
	boolean test=true;
	if (m==2)
	{if(j>=1&&j<=28)
		test=true;
	else
		test=false;
	}
	else
		{ if(m==4||m==6||m==11||m==9)
		{
			if(j>=1&&j<=30)
				test=true;
			else
				test=false;
			}
		else
		{if(m>12||m<1)
		{
			test=false;
		}
		else
		{
			if(j>=1&&j<=31)
				test=true;
			else
				test=false;
		}
			
		}
			
		}
	return test ;
}
public LocEnCours(){
	listloc=new  ArrayList<Location>() ; 
}
public void ajoutlocation(Véhicules v,Client c,float prix) { Date t2,t1;
int j,m,an;
SimpleDateFormat sdf=new SimpleDateFormat("EEEEE dd/MM/yyyy");
 if (v.getEtat()=="Disponible") { float avance=0;
 Scanner s =new Scanner(System.in);
 
 do { 
	 System.out.println("	Taper l'avance svp");
	 avance=s.nextFloat();
 }
	 while(avance<=0 || avance >prix);
 do {
		do
		{
		System.out.println("	Taper le date du t1 : ");
	 	System.out.print("Jour : ");
	 	j=s.nextInt();
	 	System.out.print("mois : ");
	 	m=s.nextInt();
	 	System.out.print("Année : ");
	 	an=s.nextInt();
		
		t1=new Date(an-1900,m-1,j);
		
		}while(!checkdate(j,m,an)||t1.compareTo(new Date(System.currentTimeMillis()))<0);
	 	

	 	
	 	do
	 	{
	 	System.out.println("	Taper le date du t2 : ");
	 	System.out.print("Jour : ");
	 	j=s.nextInt();
	 	System.out.print("mois : ");
	 	m=s.nextInt();
	 	System.out.print("Année : ");
	 	an=s.nextInt();
	 	}while(!checkdate(j,m,an));
	 	t2=new Date(an-1900,m-1,j);
		}while(t1.compareTo(t2)>0);
 		Location l=new Location(v,c,t1,t2,prix,avance);
 		listloc.add(l);
 		System.out.println("	Ajout éffectué !");
 		v.setEtat("	Indisponible");
	 
 }

 else {
	 if(v.getEtat()=="Indisponible")
	 { System.out.println("		Véhicules indisponible !");}
 else
 {
	 System.out.println("	Véhicules En cours de repartation !");}

 }
}

public int contain(String cin, String mat )
{ int i=0,p=-1;
while (i<listloc.size()&&p==-1)
{ 
if(cin.equalsIgnoreCase(this.getListloc().get(i).getC().getCin()) && mat.equalsIgnoreCase(this.getListloc().get(i).getV().getNummat()))
{
	p=i;
}
else 
	i++;
	
}
return p;	
}

public void suppLocation(String cin ,String mat,LocHistorique lh) {
	if(listloc.size()>0) {
	if(this.contain(cin,mat)>-1)
	{ Date  	t1=new Date(System.currentTimeMillis());	

	if(t1.compareTo(listloc.get(this.contain(cin, mat)).getDf())>0)
			{	lh.ajoutloch(listloc.get(this.contain(cin, mat)), false);
				listloc.remove(this.contain(cin, mat));
				System.out.println("	Suppresion Effectué !");
				System.out.println("	haha !");

				
			}
	else {
		lh.ajoutloch(listloc.get(this.contain(cin, mat)), true);
		listloc.remove(this.contain(cin, mat));
		System.out.println("	Suppresion Effectué !");
		
	}
		
	}
	else
	{
		System.out.println("	Location intouvable !");
	}}	
	else
	{
		 System.out.println("	Pas de lacation pour supprimer !");
	}
}
public void affiche() {
	System.out.println("__________________________________________________________________________");
	if(listloc.size()==0)
	{
		System.out.println("	Aucun location !");
	}
	else {
	for(int i=0;i<listloc.size();i++)
	{ System.out.println("	Location n° " +(i+1));
		listloc.get(i).affichloc(); 
	}
	}
	System.out.println("__________________________________________________________________________");

}
public LocEnCours listlocencours() {
	LocEnCours listencour=new  LocEnCours();
	
Date  	t1=new Date(System.currentTimeMillis());
	for(int i=0;i<listloc.size();i++)
	{	
		if(t1.compareTo(listloc.get(i).getDb())>=0	)
	{	listencour.getListloc().add((listloc.get(i)));
		 }
	}	
	return listencour;
}
public ArrayList<Location> getListloc() {
	return listloc;
}
public void setListloc(ArrayList<Location> listloc) {
	this.listloc = listloc;
}
@SuppressWarnings("deprecation")
public int nombreloc(LocHistorique lh) {
	SimpleDateFormat sdf=new SimpleDateFormat("EEEEE dd/MM/yyyy");

	Scanner s=new Scanner(System.in);

	int n=0,j,m,an;
	Date t1,t2;
	do {
	do
	{
	System.out.println("	Taper le date du t1 : ");
 	System.out.print("Jour : ");
 	j=s.nextInt();
 	System.out.print("mois : ");
 	m=s.nextInt();
 	System.out.print("Année : ");
 	an=s.nextInt();
	}
	while(!checkdate(j,m,an));
 	t1=new Date(an-1900,m-1,j);
 	do
 	{
 	System.out.println("	Taper le date du t2 : ");
 	System.out.print("Jour : ");
 	j=s.nextInt();
 	System.out.print("mois : ");
 	m=s.nextInt();
 	System.out.print("Année : ");
 	an=s.nextInt();
 	}while(!checkdate(j,m,an));
 	t2=new Date(an-1900,m-1,j);
	}while(t1.compareTo(t2)>0);

	for(int i=0;i<listloc.size();i++)
	{
		if(listloc.get(i).getDb().compareTo(t1)>=0&&listloc.get(i).getDb().compareTo(t2)<=0 || (t1.compareTo(listloc.get(i).getDb())>=0&&t1.compareTo(listloc.get(i).getDf())<=0))
		{
			n++;
		}
	}
	for(int i=0;i<lh.getListloceff().size();i++)
	{
		if(lh.getListloceff().get(i).getDb().compareTo(t1)>=0&&lh.getListloceff().get(i).getDb().compareTo(t2)<=0 || (t1.compareTo(lh.getListloceff().get(i).getDb())>=0&&t1.compareTo(lh.getListloceff().get(i).getDf())<=0))
		{
			n++;
		}
	}
 	System.out.print("	 Nombre du location entre :"+sdf.format(t1) +" et "+sdf.format(t2)+" : ");

	return n;

	
	
}
public float totalrev(LocHistorique lh) {
	Scanner s=new Scanner(System.in);
	SimpleDateFormat sdf=new SimpleDateFormat("EEEEE dd/MM/yyyy");

	float n=0;
	int j,m,an;
	Date t1,t2;
	do {
		do
		{
		System.out.println("	Taper le date du t1 : ");
	 	System.out.print("Jour : ");
	 	j=s.nextInt();
	 	System.out.print("mois : ");
	 	m=s.nextInt();
	 	System.out.print("Année : ");
	 	an=s.nextInt();
		}
		while(!checkdate(j,m,an));
	 	t1=new Date(an-1900,m-1,j);
	 	do
	 	{
	 	System.out.println("	Taper le date du t2 : ");
	 	System.out.print("Jour : ");
	 	j=s.nextInt();
	 	System.out.print("mois : ");
	 	m=s.nextInt();
	 	System.out.print("Année : ");
	 	an=s.nextInt();
	 	}while(!checkdate(j,m,an));
	 	t2=new Date(an-1900,m-1,j);
		}while(t1.compareTo(t2)>0);
 	for(int i=0;i<listloc.size();i++)
	{
		if(listloc.get(i).getDb().compareTo(t1)>=0&&listloc.get(i).getDb().compareTo(t2)<=0 || (t1.compareTo(listloc.get(i).getDb())>=0&&t1.compareTo(listloc.get(i).getDf())<=0))
		{
			n+=listloc.get(i).getPrix();
		}
	}
 	for(int i=0;i<lh.getListloceff().size();i++)
	{
		if(lh.getListloceff().get(i).getDb().compareTo(t1)>=0&&lh.getListloceff().get(i).getDb().compareTo(t2)<=0 || (t1.compareTo(lh.getListloceff().get(i).getDb())>=0&&t1.compareTo(lh.getListloceff().get(i).getDf())<=0))
		{
			n+=lh.getListloceff().get(i).getPrix();
		}
	}
 	System.out.print("	 Les revenus Total Entre :"+sdf.format(t1) +" et "+sdf.format(t2)+" : ");
	return n;

	
}
public void afficheclient(String cin) {
	if(listloc.size()==0)
	{
		System.out.println("	Pas des locations !");
	}
	else { int z=0;
			for(int i=0;i<listloc.size();i++) {
				if(cin.equals(listloc.get(i).getC().getCin()))
				{	System.out.println(" 	Location numéro :"+(z+1));
					z++;
					listloc.get(i).affichloc();
				}
			}
			if(z==0) {
				System.out.println(" 	Pas des location pour ce CIN !");
			}
	}
	
}
}
