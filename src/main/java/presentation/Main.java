package presentation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import service.contract;
/*import org.glassfish.jersey.client.authentication.HttpAuthenticationFeature;*/

@SpringBootApplication
public class Main {

  public static void main(String[] args) throws Exception {

    contract.connectContract();
    SpringApplication.run(Main.class, args);
  }

}
