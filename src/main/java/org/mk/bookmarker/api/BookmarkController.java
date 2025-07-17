package org.mk.bookmarker.api;

import org.mk.bookmarker.domain.Bookmark;
import org.mk.bookmarker.domain.BookmarkDTO;
import org.mk.bookmarker.domain.BookmarkService;
import org.mk.bookmarker.domain.BookmarksDTO;
import org.mk.bookmarker.domain.CreateBookmarkRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RestController
@RequestMapping("/api/bookmarks")
@RequiredArgsConstructor
public class BookmarkController {
  private final BookmarkService bookmarkService;

  @GetMapping
  public BookmarksDTO getBookmarks(@RequestParam(name = "page", defaultValue = "1") Integer page,
                                   @RequestParam(name = "size", defaultValue = "10") Integer size,
                                   @RequestParam(name = "query", required=false) String query) {
    if (query == null || query.isEmpty()) {
      return bookmarkService.getBookmarks(page, size);
    }
    return bookmarkService.searchBookmarks(query, page, size);
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public BookmarkDTO createBookmark(@RequestBody @Valid CreateBookmarkRequest bookmark) {
    return bookmarkService.createBookmark(bookmark);
  }
}
