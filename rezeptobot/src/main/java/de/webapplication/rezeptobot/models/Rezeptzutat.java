package de.webapplication.rezeptobot.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "rezeptzutat")
public class Rezeptzutat {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column(name = "anzahl")
  private Double anzahl;

  @Column(name = "einheit")
  private String einheit;

  @Column(name = "bezeichnung")
  private String bezeichnung;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn
  private Rezept rezept;

  public Rezeptzutat(
    Long id,
    Double anzahl,
    String einheit,
    String bezeichnung,
    Rezept rezept
  ) {
    this.id = id;
    this.anzahl = anzahl;
    this.einheit = einheit;
    this.bezeichnung = bezeichnung;
    this.rezept = rezept;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Rezept)) return false;
    return id != null && id.equals(((Rezept) o).getId());
  }

  @Override
  public int hashCode() {
    return getClass().hashCode();
  }

  public Rezeptzutat() {}

  public Double getAnzahl() {
    return anzahl;
  }

  public void setAnzahl(Double anzahl) {
    this.anzahl = anzahl;
  }

  public String getEinheit() {
    return einheit;
  }

  public void setEinheit(String einheit) {
    this.einheit = einheit;
  }

  public String getBezeichnung() {
    return bezeichnung;
  }

  public void setBezeichnung(String bezeichnung) {
    this.bezeichnung = bezeichnung;
  }

  public Rezept getRezept() {
    return rezept;
  }

  public void setRezept(Rezept rezept) {
    this.rezept = rezept;
  }
}
