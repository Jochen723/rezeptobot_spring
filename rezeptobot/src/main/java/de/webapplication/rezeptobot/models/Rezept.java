package de.webapplication.rezeptobot.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "rezept")
public class Rezept {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id")
  private Long id;

  private String titel;

  @Column(length = 1000000)
  private String durchfuehrung;

  private int anzahlPersonen;

  private int kochzeitInMinuten;

  private int vorbereitsungszeitInMinuten;

  private Date hinzugefuegt;

  @Lob
  @Column(columnDefinition = "MEDIUMBLOB")
  private String bild;

  @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
  private List<Rezeptzutat> rezeptzutaten = new ArrayList<>();

  public Rezept() {}

  public Rezept(
    String titel,
    String durchfuehrung,
    int anzahlPersonen,
    int kochzeitInMinuten,
    int vorbereitsungszeitInMinuten,
    String bild,
    Date hinzugefuegt
  ) {
    super();
    this.titel = titel;
    this.durchfuehrung = durchfuehrung;
    this.anzahlPersonen = anzahlPersonen;
    this.kochzeitInMinuten = kochzeitInMinuten;
    this.vorbereitsungszeitInMinuten = vorbereitsungszeitInMinuten;
    this.bild = bild;
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

  public String getBild() {
    byte[] decoded = Base64.getDecoder().decode(bild);
    return new String(decoded, StandardCharsets.UTF_8);
  }

  public void setBild(String bild) {
    this.bild = bild;
  }

  public List<Rezeptzutat> getRezeptzutaten() {
    return rezeptzutaten;
  }

  public void setRezeptzutaten(List<Rezeptzutat> rezeptzutaten) {
    this.rezeptzutaten = rezeptzutaten;
  }

  public void addRezeptzutat(Rezeptzutat rezeptzutat) {
    rezeptzutaten.add(rezeptzutat);
    rezeptzutat.setRezept(this);
  }

  public void removeRezeptzutat(Rezeptzutat rezeptzutat) {
    rezeptzutaten.remove(rezeptzutat);
    rezeptzutat.setRezept(null);
  }
}
