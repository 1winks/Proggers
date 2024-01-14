package hr.fer.repository;

import hr.fer.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
    int countByTitle(String title);
    int countByAuthor(String author);
    int countByCover(String cover);
    int countByDescription(String description);
    int countByGenre(String genre);

    void removeBookByTitleAndAuthor(String title, String author);
}
