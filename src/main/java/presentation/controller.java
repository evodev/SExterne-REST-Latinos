package presentation;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import service.contract;

@RestController
public class controller {
  @PostMapping("/archiveracte")
  public String archiveActe(@RequestBody String anneeNaissance, String signature, int minuteNum, int minutaireNum, String designation) throws Exception {
    return contract.setRecord(anneeNaissance,signature, minuteNum, minutaireNum,designation);
  }

  @GetMapping("/afficheracte")
  public String afficheracte(@RequestParam int id) throws Exception {
    return contract.getRecord(id);
  }
}
