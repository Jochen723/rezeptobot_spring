package de.webapplication.rezeptobot.models;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "rezept")
public class Rezept {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	private String titel;

	private String durchfuehrung;

	private int anzahlPersonen;

	private int kochzeitInMinuten;

	private int vorbereitsungszeitInMinuten;

	private Date hinzugefuegt;
	
	public Rezept() {
		
	}

	public Rezept(String titel, String durchfuehrung, int anzahlPersonen, int kochzeitInMinuten,
			int vorbereitsungszeitInMinuten, Date hinzugefuegt) {
		super();
		this.titel = titel;
		this.durchfuehrung = durchfuehrung;
		this.anzahlPersonen = anzahlPersonen;
		this.kochzeitInMinuten = kochzeitInMinuten;
		this.vorbereitsungszeitInMinuten = vorbereitsungszeitInMinuten;
		this.hinzugefuegt = hinzugefuegt;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitel() {
		return titel;
	}

	public void setTitel(String titel) {
		this.titel = titel;
	}

	public String getDurchfuehrung() {
		return durchfuehrung;
	}

	public void setDurchfuehrung(String durchfuehrung) {
		this.durchfuehrung = durchfuehrung;
	}

	public int getAnzahlPersonen() {
		return anzahlPersonen;
	}

	public void setAnzahlPersonen(int anzahlPersonen) {
		this.anzahlPersonen = anzahlPersonen;
	}

	public int getKochzeitInMinuten() {
		return kochzeitInMinuten;
	}

	public void setKochzeitInMinuten(int kochzeitInMinuten) {
		this.kochzeitInMinuten = kochzeitInMinuten;
	}

	public int getVorbereitsungszeitInMinuten() {
		return vorbereitsungszeitInMinuten;
	}

	public void setVorbereitsungszeitInMinuten(int vorbereitsungszeitInMinuten) {
		this.vorbereitsungszeitInMinuten = vorbereitsungszeitInMinuten;
	}

	public Date getHinzugefuegt() {
		return hinzugefuegt;
	}

	public void setHinzugefuegt(Date hinzugefuegt) {
		this.hinzugefuegt = hinzugefuegt;
	}
}
