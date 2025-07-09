package org.mk.bookmarker.domain;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class BookmarkService {
  private final BookmarkRepository repository;
  private final BookmarkMapper bookmarkMapper;

  @Transactional(readOnly = true)
  public BookmarksDTO getBookmarks(Integer page, Integer size) {
    int pageNumber = page < 1 ? 0 : page - 1;
    Pageable pageable = PageRequest.of(pageNumber, size, Sort.Direction.DESC, "createdAt");
    Page<BookmarkDTO> bookmarkPage =
            repository.findBookmarks(pageable);
    return new BookmarksDTO(bookmarkPage);
  }

  @Transactional(readOnly = true)
  public BookmarksDTO searchBookmarks(String query, Integer page, Integer size) {
    int pageNumber = page < 1 ? 0 : page - 1;
    Pageable pageable = PageRequest.of(pageNumber, size, Sort.Direction.DESC, "createdAt");
    Page<BookmarkDTO> bookmarkPage =
            repository.findByTitleContainsIgnoreCase(query, pageable);
    return new BookmarksDTO(bookmarkPage);
  }
}
