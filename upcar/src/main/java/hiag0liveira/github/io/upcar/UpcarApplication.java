package hiag0liveira.github.io.upcar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class UpcarApplication {

		public static void main(String[] args) {
			SpringApplication.run(UpcarApplication.class, args);
//			System.out.println(new BCryptPasswordEncoder().encode("123456"));
		}
}