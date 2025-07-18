package org.mk.bookmarker.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.springframework.data.domain.Page;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BookmarksDTO {
  private List<BookmarkDTO> data;
  private long totalElements;
  private int totalPages;
  private int currentPage;
  @JsonProperty("isFirstPage")
  private boolean isFirstPage;
  @JsonProperty("isLastPage")
  private boolean isLastPage;
  private boolean hasNextPage;
  private boolean hasPreviousPage;

  public BookmarksDTO(Page<BookmarkDTO> bookmarkPage) {
    this.setData(bookmarkPage.getContent());
    this.setTotalElements(bookmarkPage.getTotalElements());
    this.setTotalPages(bookmarkPage.getTotalPages());
    this.setCurrentPage(bookmarkPage.getNumber() + 1);
    this.setFirstPage(bookmarkPage.isFirst());
    this.setLastPage(bookmarkPage.isLast());
    this.setHasNextPage(bookmarkPage.hasNext());
    this.setHasPreviousPage(bookmarkPage.hasPrevious());
  }
}
