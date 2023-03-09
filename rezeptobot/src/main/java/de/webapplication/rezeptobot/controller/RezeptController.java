package de.webapplication.rezeptobot.controller;

import de.webapplication.rezeptobot.models.Rezept;
import de.webapplication.rezeptobot.models.enums.EinheitenEnum;
import de.webapplication.rezeptobot.models.enums.ZutatenEnum;
import de.webapplication.rezeptobot.repositories.RezeptRepository;
import de.webapplication.rezeptobot.services.RezeptService;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RezeptController {

  @Autowired
  private RezeptRepository rezeptRepository;

  @Autowired
  private RezeptService rezeptService;

  @GetMapping("/uebersicht")
  public ModelAndView getAllRecipes() {
    ModelAndView modelAndView = new ModelAndView("/uebersicht");

    List<Rezept> liste = rezeptRepository.findAll();
    modelAndView.addObject("recipes", liste);
    return modelAndView;
  }

  @GetMapping("/rezeptdetails/{id}")
  public ModelAndView getRecipeDetails(@PathVariable("id") Long id) {
    ModelAndView modelAndView = new ModelAndView("/rezeptdetails");
    Rezept rezept = rezeptService.getById(id);
    modelAndView.addObject("recipe", rezept);

    return modelAndView;
  }

  @GetMapping("/neuesrezept")
  public ModelAndView newRecipe() {
    ModelAndView modelAndView = new ModelAndView("neuesrezept");

    List<String> zutaten = Stream
      .of(ZutatenEnum.values())
      .map(ZutatenEnum::name)
      .collect(Collectors.toList());
    List<String> einheiten = EinheitenEnum.getAllEinheiten();

    modelAndView.addObject("rezept", new Rezept());
    modelAndView.addObject(
      "verfuegbareZutaten",
      onlyFirstLetterUppercase(zutaten)
    );
    modelAndView.addObject("verfuegbareEinheiten", einheiten);

    return modelAndView;
  }

  @PostMapping("/process_neues_rezept")
  public ModelAndView processRegister(
    Rezept rezept,
    @RequestParam("image") MultipartFile multipartFile
  ) {
    ModelAndView modelAndView = new ModelAndView("uebersicht");

    String fileName = StringUtils.cleanPath(
      multipartFile.getOriginalFilename()
    );

    byte[] test = null;

    try {
      test = Base64.getEncoder().encode(multipartFile.getBytes());
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    if (fileName.contains("..")) {
      System.out.println("not a valid file");
    }

    rezept.setBild(Base64.getEncoder().encodeToString(test));

    rezeptService.save(rezept);

    /* 
    
    );
    rezept.setBild(fileName);

    String uploadDir = "user-photos/";

    try {
      FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    */

    return modelAndView;
  }

  private List<String> onlyFirstLetterUppercase(List<String> textListe) {
    List<String> tmpTexListe = new ArrayList<String>();

    for (String string : textListe) {
      String tmpText = string.toLowerCase();
      String text = tmpText.replaceAll("_", "/");

      String[] arr = text.split("/");
      StringBuffer sb = new StringBuffer();

      for (int i = 0; i < arr.length; i++) {
        sb
          .append(Character.toUpperCase(arr[i].charAt(0)))
          .append(arr[i].substring(1));
        if (arr.length - i > 1) {
          sb.append("/");
        }
      }
      tmpTexListe.add(sb.toString().trim());
    }

    return tmpTexListe;
  }
}
