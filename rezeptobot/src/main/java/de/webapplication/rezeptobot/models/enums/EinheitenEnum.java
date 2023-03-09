package de.webapplication.rezeptobot.models.enums;

import java.util.ArrayList;
import java.util.List;

public enum EinheitenEnum {
  BECHER("Becher"),
  BEUTEL("Beutel"),
  BLATT_BLAETTER("Blatt/Blätter"),
  BUND("Bund"),
  DOSE_DOSEN("Dose/n"),
  ESSLOEFFEL("Esslöffel"),
  GLAS_GLAESER("Glas/Gläser"),
  GRAMM("Gramm"),
  HANDVOLL("Handvoll"),
  KUGEL_KUGELN("Kugel/n"),
  MESSERSPITZE_MESSERSPITZEN("Messerspitze/n"),
  MILLILITER("Milliliter"),
  PACKUNG_PACKUNGEN("Packung/en"),
  PRISE("Prise"),
  SCHEIBE_SCHEIBEN("Scheibe/n"),
  SCHUSS("Schuss"),
  STANGE_STANGEN("Stange/n"),
  STUECK_STUECKE("Stück/e"),
  TAFEL_TAFELN("Tafel/n"),
  TASSE_TASSEN("Tasse/n"),
  TEELOEFFEL("Teelöffel"),
  TROPFEN("Tropfen"),
  TUBE_TUBEN("Tube/n"),
  ZEHE_ZEHEN("Zehe/n");

  public final String anzeigename;

  private EinheitenEnum(String anzeigename) {
    this.anzeigename = anzeigename;
  }

  public static List<String> getAllEinheiten() {
    List<String> einheiten = new ArrayList<>();

    for (EinheitenEnum iterable_element : EinheitenEnum.values()) {
      einheiten.add(iterable_element.anzeigename);
    }

    return einheiten;
  }
}
