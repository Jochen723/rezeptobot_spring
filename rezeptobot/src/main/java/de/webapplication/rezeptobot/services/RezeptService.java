package de.webapplication.rezeptobot.services;

import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import de.webapplication.rezeptobot.models.Rezept;
import de.webapplication.rezeptobot.models.Rezeptzutat;
import de.webapplication.rezeptobot.models.enums.EinheitenEnum;
import de.webapplication.rezeptobot.models.enums.ZutatenEnum;
import de.webapplication.rezeptobot.repositories.RezeptRepository;

@Service
public class RezeptService {

  @Autowired
  private RezeptRepository rezeptRepository;

  public List<Rezept> getAllRecipes() {
    return rezeptRepository.findAll();
  }

  public Rezept getRecipeById(Long id) {
    Optional<Rezept> rezept = rezeptRepository.findById(id);

    return rezept.get();
  }

  public Rezept save(Rezept rezept) {
    return rezeptRepository.save(rezept);
  }

  public void delete(Rezept rezept) {
    rezeptRepository.delete(rezept);
  }

  public List<Rezeptzutat> getRezeptzutatenByRezeptId(Long rezept_id) {
    return rezeptRepository.getRezeptZutatenByRezeptId(rezept_id);
  }

  public List<String> getAllAvailableIngredients() {
    return ZutatenEnum.getAllIngredients();
  }

  public List<String> getAllAvailableUnits() {
    return EinheitenEnum.getAllEinheiten();
  }

  public void saveRecipeWithImage(MultipartFile file, Rezept recipe) {

    try {
        byte[] imageBytes = Base64.getEncoder().encode(file.getBytes());
        recipe.setBild(Base64.getEncoder().encodeToString(imageBytes));
        Rezept tmpRecipe = save(recipe);
        recipe.setId(tmpRecipe.getId());
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
}
