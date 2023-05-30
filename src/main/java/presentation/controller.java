package presentation;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import service.contract;

@RestController
public class controller {
  @PostMapping("/archiveracte")
  public String archiveActe(@RequestBody String body) throws Exception {
    ObjectMapper mapper = new ObjectMapper();
    JsonNode jsonNode = mapper.readTree(body);

    // Extraire les valeurs du JSON
    String anneeNaissance = jsonNode.get("anneeNaissance").asText();
    String signature = jsonNode.get("signature").asText();
    int minuteNum = jsonNode.get("minuteNum").asInt();
    int minutaireNum = jsonNode.get("minutaireNum").asInt();
    String designation = jsonNode.get("designation").asText();
    return contract.setRecord(anneeNaissance,signature, minuteNum, minutaireNum,designation);
  }

  @GetMapping("/afficheracte")
  public String afficheracte(@RequestParam int id) throws Exception {
    return contract.getRecord(id);
  }
}
