package org.mk.bookmarker.domain;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface
BookmarkRepository extends JpaRepository<Bookmark, Long> {
  @Query("SELECT new org.mk.bookmarker.domain.BookmarkDTO(b.id, b.title, b.url, b.createdAt) FROM" +
                 " " +
                 "Bookmark b ORDER BY b" +
                 ".createdAt DESC")
  Page<BookmarkDTO> findBookmarks(Pageable pageable);
}
