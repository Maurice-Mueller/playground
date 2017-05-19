package moepad.playground.spring.data;

import moepad.playground.derby.derby.DerbyHandler;
import moepad.playground.derby.tables.TableHandler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class SpringDataApplication {

	public static void main(String[] args) {
		createDBWithTables();
		SpringApplication.run(SpringDataApplication.class, args);
	}

	private static void createDBWithTables() {
		TableHandler tableHandler = new TableHandler(new DerbyHandler("springBootTestDB", false));
		tableHandler.createTableIfNotExists("users", Arrays.asList("age int, firstname varchar(40), surname varchar(40)"));
	}
}
