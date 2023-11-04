package Agence;

import java.text.SimpleDateFormat;
import java.util.Date;
public class Location {

private Véhicules v;
private Client c;
private Date db;
private Date df;
public float Prix ;
public float Avance;


public Location(Véhicules v, Client c, Date d,Date d2, float prix, float avance) {
		this.v = v;
		this.c = c;
		this.df=d2;
		this.db = d;
		Prix = prix;
		Avance = avance;
	}
public void affichloc() {
	SimpleDateFormat sdf=new SimpleDateFormat("EEEEE dd/MM/yyyy");
	System.out.println(v.toString());
	System.out.println(c.toString());
	System.out.println("Date du début = "+sdf.format(db));
	System.out.println("Date du fin =" +sdf.format(df));
	System.out.println("prix = "+Prix);
	System.out.println("Avance= "+Avance);
}

public Véhicules getV() {
	return v;
}


public void setV(Véhicules v) {
	this.v = v;
}


public Client getClient() {
	return c;
}


public void setClient(Client c) {
	this.c = c;
}


public Date getDb() {
	return db;
}


public void setDb(Date db) {
	this.db = db;
}


public Date getDf() {
	return df;
}


public void setDf(Date df) {
	this.df = df;
}


public float getPrix() {
	return Prix;
}


public void setPrix(float prix) {
	Prix = prix;
}


public float getAvance() {
	return Avance;
}


public void setAvance(float avance) {
	Avance = avance;
}
public Client getC() {
	return c;
}
public void setC(Client c) {
	this.c = c;
}
}
