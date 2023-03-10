package de.webapplication.rezeptobot.models.enums;

import java.util.ArrayList;
import java.util.List;

public enum ZutatenEnum {
  AJVAR("Ajvar"),
  AMARETTINI("Amarettini"),
  MEHL("Mehl"),
  ZUCKER("Zucker");

  public final String displayname;

  private ZutatenEnum(String displayname) {
    this.displayname = displayname;
  }

  public static List<String> getAllIngredients() {
    List<String> ingredients = new ArrayList<>();

    for (ZutatenEnum ingredient : ZutatenEnum.values()) {
      ingredients.add(ingredient.displayname);
    }

    return ingredients;
  }
}
