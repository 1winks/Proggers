package hr.fer.repository;

import hr.fer.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    int countByTitle(String title);
    int countByAuthor(String author);
    int countByCover(String cover);
    int countByDescription(String description);
    int countByGenre(String genre);
    List<Book> findByTitleAndAuthor (String title, String author);

    List<Book> findByTitle(String title);

    List<Book> findByAuthor(String author);

    List<Book> findByGenre(String genre);
    void removeBookByTitleAndAuthor(String title, String author);
}
