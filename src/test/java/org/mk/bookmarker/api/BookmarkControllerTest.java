package org.mk.bookmarker.api;

import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mk.bookmarker.domain.Bookmark;
import org.mk.bookmarker.domain.BookmarkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@TestPropertySource(
        properties = {
                "spring.datasource.url=jdbc:tc:postgresql:14-alpine:///bookmarker_test",
        }
)
class BookmarkControllerTest {
  @Autowired
  private MockMvc mvc;

  @Autowired
  BookmarkRepository bookmarkRepository;

  List<Bookmark> bookmarks;

  @BeforeEach
  void setUp() {
    bookmarkRepository.deleteAllInBatch();

    bookmarks = new ArrayList<>();

    bookmarks.add(new Bookmark(null, "Java Documentation", "https://docs.oracle.com/javase/8/docs/api/", Instant.now()));
    bookmarks.add(new Bookmark(null, "Spring Framework", "https://spring.io/projects/spring-framework", Instant.now()));
    bookmarks.add(new Bookmark(null, "JUnit 5 User Guide", "https://junit.org/junit5/docs/current/user-guide/", Instant.now()));
    bookmarks.add(new Bookmark(null, "Maven Central Repository", "https://search.maven.org/", Instant.now()));
    bookmarks.add(new Bookmark(null, "React Documentation", "https://reactjs.org/docs/getting-started.html", Instant.now()));
    bookmarks.add(new Bookmark(null, "Angular Documentation", "https://angular.io/docs", Instant.now()));
    bookmarks.add(new Bookmark(null, "Vue.js Documentation", "https://vuejs.org/v2/guide/", Instant.now()));
    bookmarks.add(new Bookmark(null, "Node.js Documentation", "https://nodejs.org/en/docs/", Instant.now()));
    bookmarks.add(new Bookmark(null, "Python Documentation", "https://docs.python.org/3/", Instant.now()));
    bookmarks.add(new Bookmark(null, "Django Documentation", "https://docs.djangoproject.com/en/stable/", Instant.now()));
    bookmarks.add(new Bookmark(null, "Flask Documentation", "https://flask.palletsprojects.com/en/2.0.x/", Instant.now()));
    bookmarks.add(new Bookmark(null, "Ruby on Rails Guides", "https://guides.rubyonrails.org/", Instant.now()));
    bookmarks.add(new Bookmark(null, "Go Documentation", "https://golang.org/doc/", Instant.now()));
    bookmarks.add(new Bookmark(null, "Rust Documentation", "https://doc.rust-lang.org/book/", Instant.now()));
    bookmarks.add(new Bookmark(null, "Kotlin Documentation", "https://kotlinlang.org/docs/home.html", Instant.now()));
    bookmarks.add(new Bookmark(null, "Swift Documentation", "https://swift.org/documentation/", Instant.now()));
    bookmarks.add(new Bookmark(null, "PHP Documentation", "https://www.php.net/docs.php", Instant.now()));
    bookmarks.add(new Bookmark(null, "Laravel Documentation", "https://laravel.com/docs", Instant.now()));
    bookmarks.add(new Bookmark(null, "ASP.NET Core Documentation", "https://docs.microsoft.com/en-us/aspnet/core/", Instant.now()));
    bookmarks.add(new Bookmark(null, "Elixir Documentation", "https://elixir-lang.org/docs.html", Instant.now()));

    bookmarkRepository.saveAll(bookmarks);
  }

  @ParameterizedTest
  @CsvSource({
       "1, 20, 2, 1, true, false, true, false",
       "2, 20, 2, 2, false, true, false, true",
  })
  void shouldGetBookmarks(int pageNumber, int totalElements, int totalPages, int currentPage,
                          boolean isFirstPage, boolean isLastPage, boolean hasNextPage,
                          boolean hasPreviosPage) throws Exception {
    mvc.perform(MockMvcRequestBuilders.get("/api/bookmarks?page=" + pageNumber))
       .andExpect(status().isOk())
       .andExpect(jsonPath("$.totalElements", CoreMatchers.equalTo(totalElements)))
       .andExpect(jsonPath("$.totalPages", CoreMatchers.equalTo(totalPages)))
       .andExpect(jsonPath("$.currentPage", CoreMatchers.equalTo(currentPage)))
       .andExpect(jsonPath("$.isFirstPage", CoreMatchers.equalTo(isFirstPage)))
       .andExpect(jsonPath("$.isLastPage", CoreMatchers.equalTo(isLastPage)))
       .andExpect(jsonPath("$.hasNextPage", CoreMatchers.equalTo(hasNextPage)))
       .andExpect(jsonPath("$.hasPreviousPage", CoreMatchers.equalTo(hasPreviosPage)));
  }
}