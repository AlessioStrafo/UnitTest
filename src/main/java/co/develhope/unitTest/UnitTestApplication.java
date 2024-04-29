package co.develhope.unitTest;
//scrivi una applicazione web Spring Boot con le dipendenze neccessarie che:
//creano entità User
//ha un Controller per le operazioni CRUD sull'entità User
//scrivi gli unit test delle operazioni CRUD
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UnitTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(UnitTestApplication.class, args);
	}

}
