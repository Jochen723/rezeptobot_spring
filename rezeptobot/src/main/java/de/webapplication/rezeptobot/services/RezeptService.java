package de.webapplication.rezeptobot.services;

import de.webapplication.rezeptobot.models.Rezept;
import de.webapplication.rezeptobot.models.Rezeptzutat;
import de.webapplication.rezeptobot.repositories.RezeptRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RezeptService {

  @Autowired
  private RezeptRepository rezeptRepository;

  public Iterable<Rezept> getAll() {
    return rezeptRepository.findAll();
  }

  public Rezept getById(Long id) {
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
}
