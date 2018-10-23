package com.soumen.bootmongo;

import com.soumen.bootmongo.model.Pets;
import com.soumen.bootmongo.repository.PetsRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class BootMongoApplication implements CommandLineRunner {
    @Autowired
    PetsRepository petsRepository;

    public static void main(String[] args) {
        SpringApplication.run(BootMongoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        List<Pets> pets = Arrays.asList(
                new Pets(new ObjectId(), "Jack", "Dog", "Alsesian"),
                new Pets(new ObjectId(), "Kate", "Dog", "Doberman"),
                new Pets(new ObjectId(), "Micky", "Cat", "Test"));

        pets.stream().forEach(petsRepository::save);
        petsRepository.findAll().stream().forEach(System.out::println);

    }
}
