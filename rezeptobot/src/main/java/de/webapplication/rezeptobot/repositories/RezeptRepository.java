package de.webapplication.rezeptobot.repositories;

import de.webapplication.rezeptobot.models.Rezept;
import de.webapplication.rezeptobot.models.Rezeptzutat;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RezeptRepository extends JpaRepository<Rezept, Long> {
  //Alle Rezeptzutaten eines Rezepts
  @Query(
    "Select distinct r from Rezeptzutat r inner join Rezept i on r.rezept.id = i.id where i.id = :rezept_id"
  )
  List<Rezeptzutat> getRezeptZutatenByRezeptId(
    @Param("rezept_id") Long rezept_id
  );
}
