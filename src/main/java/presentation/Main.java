package presentation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import service.test;
/*import org.glassfish.jersey.client.authentication.HttpAuthenticationFeature;*/

@SpringBootApplication
public class Main {

  public static void main(String[] args) {

    SpringApplication.run(Main.class, args);
    test.generateContract();
  }

}
