package de.webapplication.rezeptobot.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
@Table(name = "event")
public class Event implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @DateTimeFormat(iso = ISO.DATE)
  private Date kochdatum;

  private String titel;

  private String hintergrundfarbe;

  private String beschreibungSonstigesGericht;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Date getKochdatum() {
    return kochdatum;
  }

  public void setKochdatum(Date kochdatum) {
    this.kochdatum = kochdatum;
  }

  public String getTitel() {
    return titel;
  }

  public void setTitel(String titel) {
    this.titel = titel;
  }

  public String getHintergrundfarbe() {
    return hintergrundfarbe;
  }

  public void setHintergrundfarbe(String hintergrundfarbe) {
    this.hintergrundfarbe = hintergrundfarbe;
  }

  public String getBeschreibungSonstigesGericht() {
    return beschreibungSonstigesGericht;
  }

  public void setBeschreibungSonstigesGericht(
    String beschreibungSonstigesGericht
  ) {
    this.beschreibungSonstigesGericht = beschreibungSonstigesGericht;
  }

  @Override
  public String toString() {
    return "ToStringUser!";
  }
}
