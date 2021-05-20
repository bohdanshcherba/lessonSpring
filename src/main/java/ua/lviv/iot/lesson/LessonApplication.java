package ua.lviv.iot.lesson;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@SpringBootApplication
@ComponentScan("ua.lviv.iot.lesson.contollers")
public class LessonApplication {

	public static void main(String[] args) {
		SpringApplication.run(LessonApplication.class, args);
	}

}
