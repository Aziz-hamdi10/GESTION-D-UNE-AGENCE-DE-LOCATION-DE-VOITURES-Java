package Agence;
import java.util.ArrayList;

public class Parc {	
	public ArrayList<Véhicules> pv;

	
public void affiche() {	System.out.println("__________________________________________________________________________");

	if(pv.size()==0)
	{
		System.out.println("	Aucun Voiture dans le parc");
	}
	for(int i=0;i<pv.size();i++)
	{ System.out.println("	Voiture numéro "+ (i+1));
		System.out.println( pv.get(i).toString());
	}
	System.out.println("__________________________________________________________________________");

}
public void afficheRep() {int z=0;
System.out.println("__________________________________________________________________________");

	if(pv.size()==0)
	{
		System.out.println("	Aucun Voiture dans le parc");
	}
	for(int i=0;i<pv.size();i++)
	{ if(pv.get(i).getEtat()=="En cours de repartation") { System.out.println("Voiture numéro " +z+1);	z++;
	
		System.out.println( pv.get(i).toString());}
	}
	if(z==0) {
		System.out.println("	Aucun voiture En Cours de repartation");
	}
	System.out.println("__________________________________________________________________________");

}
public void afficheloue() { int z=0;
System.out.println("__________________________________________________________________________");

	if(pv.size()==0)
	{
		System.out.println("	Aucun Voiture dans le parc");
	}
	else { System.out.println("		Les voiture loues sont :");
	for(int i=0;i<pv.size();i++)
	{ if((pv.get(i).getEtat())=="Indisponible") { System.out.println("Voiture numéro " +z+1); z++;
	
		System.out.println( pv.get(i).toString());}
	}
	if(z==0) {
		System.out.println("	 Aucun voiture loues");
	}
}
	System.out.println("__________________________________________________________________________");

}
public void affichedispo() { int z=0;	System.out.println("__________________________________________________________________________");

	if(pv.size()==0)
	{
		System.out.println("	 Aucun Voiture dans le parc");
	}
	else {System.out.println("	 Les voiture Disponible sont :");
	for(int i=0;i<pv.size();i++)
	{ if(pv.get(i).getEtat()=="Disponible") { System.out.println("Voiture numéro " +z+1);z++;
	
		System.out.println( pv.get(i).toString());}
	}
	if(z==0) {
		{System.out.println("	 Aucun voiture Disponible !");}
	
}
	}	System.out.println("__________________________________________________________________________");

}
public void Ajout()
{ Véhicules v=new Véhicules();
	v.saisir();
	if(this.contain(v.getNummat())!=-1)
	{
		System.out.println(" 	Matricule déja existe !");
	}
	else {
	pv.add(v);
	System.out.println("	 Ajout éffectué !");}
}
public Parc() {
	pv=new ArrayList<Véhicules>();
}
public int contain( String mat )
{ int i=0,p=-1;
while (i<pv.size()&&p==-1)
{	if(mat.equalsIgnoreCase( pv.get(i).getNummat()))
{
	p=i;
}
else 
	i++;
	
}
return p;	
}
public ArrayList<Véhicules> getPv() {
	return pv;
}
public void setPv(ArrayList<Véhicules> pv) {
	this.pv = pv;
}
public void supprimerv1(int i) {
	pv.remove(i);
}
public void supprimerv(String mat ) {
	if(this.contain(mat)==-1)
	{ System.out.println("		Matricule indisponible !");
	}
	else
	{
		pv.remove(this.contain(mat));
	}
}


	

}
