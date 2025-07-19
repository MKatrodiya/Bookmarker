package org.mk.bookmarker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

@SpringBootApplication
public class BookmarkerApplication {

  public static void main(String[] args) {
    SpringApplication.run(BookmarkerApplication.class, args);
  }

}
