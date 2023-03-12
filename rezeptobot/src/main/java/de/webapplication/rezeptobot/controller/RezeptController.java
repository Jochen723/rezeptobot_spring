package de.webapplication.rezeptobot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import de.webapplication.rezeptobot.models.Rezept;
import de.webapplication.rezeptobot.services.RezeptService;

@Controller
public class RezeptController {

  @Autowired
  private RezeptService rezeptService;

  /**
   * Rezeptübersicht
   * 
   * @return
   */
  @GetMapping("/rezepte")
  public ModelAndView getAllRecipes() {
    ModelAndView modelAndView = new ModelAndView("/rezepte");

    List<Rezept> liste = rezeptService.getAllRecipes();
    modelAndView.addObject("recipes", liste);
    return modelAndView;
  }

  /**
   * Rezeptdetails für ein spezifisches Rezept
   * 
   * @param id
   * @return
   */
  @GetMapping("/rezeptdetails/{id}")
  public ModelAndView getRecipeDetails(@PathVariable("id") Long id) {
    ModelAndView modelAndView = new ModelAndView("/rezeptdetails");
    Rezept rezept = rezeptService.getRecipeById(id);
    modelAndView.addObject("recipe", rezept);

    return modelAndView;
  }

  /**
   * Eingabe eines neuen Rezepts
   * 
   * @return
   */
  @GetMapping("/neuesrezept")
  public ModelAndView newRecipe() {
    ModelAndView modelAndView = new ModelAndView("neuesrezept");

    modelAndView.addObject("rezept", new Rezept());

    modelAndView.addObject(
        "verfuegbareZutaten",
        rezeptService.getAllAvailableIngredients());
    modelAndView.addObject("verfuegbareEinheiten", rezeptService.getAllAvailableUnits());

    return modelAndView;
  }

  /**
   * Speichern eines neuen Rezept
   * 
   * @param rezept
   * @param multipartFile
   * @return
   */
  @PostMapping("/neuesrezept")
  public ModelAndView processRegister(
      Rezept rezept,
      @RequestParam("image") MultipartFile multipartFile) {
    rezeptService.saveRecipeWithImage(multipartFile, rezept);
    ModelAndView modelAndView = new ModelAndView("redirect:/rezeptdetails/" + rezept.getId());

    return modelAndView;
  }

  @GetMapping("/rezeptdetails/editieren/{id}")
  public ModelAndView changeRecipe(@PathVariable("id") Long id) {
    ModelAndView modelAndView = new ModelAndView("editieren");
    Rezept rezept = rezeptService.getRecipeById(id);
    modelAndView.addObject("rezept", rezept);

    return modelAndView;

  }
}
