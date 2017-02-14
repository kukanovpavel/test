package hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@ComponentScan
@EnableAutoConfiguration
public class Application {


    private static ConfigurableApplicationContext context = SpringApplication.run(Application.class);
    private static CustomerRepository repository = context.getBean(CustomerRepository.class);

    public static void main(String[] args) {

            repository.save(new Person("Jack", "Bauer"));
            repository.save(new Person("Chloe", "O'Brian"));
            repository.save(new Person("Kim", "Bauer"));
            repository.save(new Person("David", "Palmer"));
            repository.save(new Person("Michelle", "Dessler"));

    }

    public static Iterable<Person> getAllPerson(){
        List<Person> list = new ArrayList<>();
        return  repository.findAll();
    }

    public static Person getPersonByID(long id){
        return  repository.findOne(id);
    }
}