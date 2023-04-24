package presentation;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class controller {

  @GetMapping("/hello")
  public String helloWorld() {
    return "Lucas la petite Salooope!";
  }
}
