package org.mk.bookmarker;

import org.mk.bookmarker.domain.Bookmark;
import org.mk.bookmarker.domain.BookmarkRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.Instant;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {
  private final BookmarkRepository bookmarkRepository;

  @Override
  public void run(String... args) throws Exception {
    int currentInstant = (int) Instant.now().getEpochSecond();
    bookmarkRepository.save(new Bookmark(
        null,
        "Spring Boot Documentation",
        "https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/",
        Instant.ofEpochSecond(currentInstant - 10000)
    ));
    bookmarkRepository.save(new Bookmark(
        null,
        "Java Tutorials",
        "https://docs.oracle.com/javase/tutorial/",
        Instant.ofEpochSecond(currentInstant - 9000)
    ));
    bookmarkRepository.save(new Bookmark(
        null,
        "GitHub",
        "https://github.com",
        Instant.ofEpochSecond(currentInstant - 8000)
    ));
    bookmarkRepository.save(new Bookmark(
        null,
        "Stack Overflow",
        "https://stackoverflow.com",
        Instant.ofEpochSecond(currentInstant - 7000)
    ));
    bookmarkRepository.save(new Bookmark(
        null,
        "MDN Web Docs",
        "https://developer.mozilla.org",
        Instant.ofEpochSecond(currentInstant - 6000)
    ));
    bookmarkRepository.save(new Bookmark(
        null,
        "Wikipedia",
        "https://www.wikipedia.org",
        Instant.ofEpochSecond(currentInstant - 5000)
    ));
    bookmarkRepository.save(new Bookmark(
        null,
        "JavaScript Info",
        "https://javascript.info",
        Instant.ofEpochSecond(currentInstant - 4000)
    ));
    bookmarkRepository.save(new Bookmark(
        null,
        "CSS Tricks",
        "https://css-tricks.com",
        Instant.ofEpochSecond(currentInstant - 3000)
    ));
    bookmarkRepository.save(new Bookmark(
        null,
        "FreeCodeCamp",
        "https://www.freecodecamp.org",
        Instant.ofEpochSecond(currentInstant - 2000)
    ));
    bookmarkRepository.save(new Bookmark(
        null,
        "W3Schools",
        "https://www.w3schools.com",
        Instant.ofEpochSecond(currentInstant - 1000)
    ));
    bookmarkRepository.save(new Bookmark(
        null,
        "Codecademy",
        "https://www.codecademy.com",
        Instant.ofEpochSecond(currentInstant - 500)
    ));
    bookmarkRepository.save(new Bookmark(
        null,
        "Khan Academy",
        "https://www.khanacademy.org",
        Instant.ofEpochSecond(currentInstant - 250)
    ));
    bookmarkRepository.save(new Bookmark(
        null,
        "Coursera",
        "https://www.coursera.org",
        Instant.ofEpochSecond(currentInstant - 125)
    ));
    bookmarkRepository.save(new Bookmark(
        null,
        "edX",
        "https://www.edx.org",
        Instant.ofEpochSecond(currentInstant)
    ));
    bookmarkRepository.save(new Bookmark(
        null,
        "Udemy",
        "https://www.udemy.com",
        Instant.ofEpochSecond(currentInstant + 250)
    ));
    bookmarkRepository.save(new Bookmark(
        null,
        "Pluralsight",
        "https://www.pluralsight.com",
        Instant.ofEpochSecond(currentInstant + 500)
    ));
    bookmarkRepository.save(new Bookmark(
        null,
        "LinkedIn Learning",
        "https://www.linkedin.com/learning",
        Instant.ofEpochSecond(currentInstant + 1000)
    ));
    bookmarkRepository.save(new Bookmark(
        null,
        "Google Developers",
        "https://developers.google.com",
        Instant.ofEpochSecond(currentInstant + 2000)
    ));
    bookmarkRepository.save(new Bookmark(
        null,
        "Mozilla Developer Network",
        "https://developer.mozilla.org/en-US/",
        Instant.ofEpochSecond(currentInstant + 3000)
    ));
    bookmarkRepository.save(new Bookmark(
        null,
        "DevDocs",
        "https://devdocs.io",
        Instant.ofEpochSecond(currentInstant + 4000)
    ));
    bookmarkRepository.save(new Bookmark(
        null,
        "Tutorialspoint",
        "https://www.tutorialspoint.com",
        Instant.ofEpochSecond(currentInstant + 5000)
    ));
    bookmarkRepository.save(new Bookmark(
        null,
        "GeeksforGeeks",
        "https://www.geeksforgeeks.org",
        Instant.ofEpochSecond(currentInstant + 6000)
    ));
    bookmarkRepository.save(new Bookmark(
        null,
        "MDN Web Docs - CSS",
        "https://developer.mozilla.org/en-US/docs/Web/CSS",
        Instant.ofEpochSecond(currentInstant + 7000)
    ));
    bookmarkRepository.save(new Bookmark(
        null,
        "MDN Web Docs - JavaScript",
        "https://developer.mozilla.org/en-US/docs/Web/JavaScript",
        Instant.ofEpochSecond(currentInstant + 8000)
    ));

  }
}
