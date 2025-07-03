package org.mk.bookmarker.domain;

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

  @Transactional(readOnly = true)
  public BookmarksDTO getBookmarks(Integer page, Integer size) {
    int pageNumber = page < 1 ? 0 : page - 1;
    Pageable pageable = PageRequest.of(pageNumber, size, Sort.Direction.DESC, "createdAt");
    return new BookmarksDTO(repository.findAll(pageable));
  }
}
