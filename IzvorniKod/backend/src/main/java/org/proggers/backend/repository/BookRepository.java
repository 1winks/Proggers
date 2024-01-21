package org.proggers.backend.repository;

import org.proggers.backend.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findByTitle(String title);

    List<Book> findByAuthor(String author);

    List<Book> findByPublisher(String publisher);

    List<Book> findByPublicationYear(int publicationYear);

    List<Book> findByPublisherCategory(Book.PublisherCategory publisherCategory);

    List<Book> findByGenre(String genre);

    List<Book> findByIsbn(String isbn);

    List<Book> findByCondition(Book.Condition condition);

    List<Book> findByCopies(int copies);

    List<Book> findByDescription(String description);

    List<Book> findByLanguageTag(Book.LanguageTag languageTag);

}
