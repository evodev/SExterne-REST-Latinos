package presentation;

import business.ActeAuthentique;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class controller {
    @PostMapping("/archive")
  public ResponseEntity<String> archiveJson(@RequestBody String json) {
    try {
      // Désérialiser le JSON en une instance de la classe ActeAuthentique
      ObjectMapper mapper = new ObjectMapper();
      ActeAuthentique acteAuthentique = mapper.readValue(json, ActeAuthentique.class);

      // Traiter l'acte authentique ici
      System.out.println("Acte authentique reçu : " + acteAuthentique.toString());
      System.out.println();
      System.out.println("Ordre : " + acteAuthentique.getOrdreNum());
      System.out.println("Date : " + acteAuthentique.getDate());
      System.out.println("Minutaire : " + acteAuthentique.getMinutaireNum());
      System.out.println("Minute : " + acteAuthentique.getMinuteNum());
      System.out.println("Designation : " + acteAuthentique.getDesignation());
      System.out.println("Signature : " + acteAuthentique.getSignature());


      // Archiver l'acte authentique

      return new ResponseEntity<>("Acte authentique archivé avec succès", HttpStatus.OK);
    } catch (Exception e) {
      e.printStackTrace();
      return new ResponseEntity<>("Erreur lors de la désérialisation du JSON", HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

}
