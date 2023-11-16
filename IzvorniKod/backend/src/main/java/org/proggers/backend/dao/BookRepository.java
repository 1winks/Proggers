package org.proggers.backend.dao;

import org.proggers.backend.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BookRepository extends JpaRepository<Book, Long> {
    // TODO: Write custom SQL commands here using @Query. (https://stackoverflow.com/questions/33153271/how-do-you-create-a-spring-jpa-repository-findby-query-using-a-property-that-con)
    int countByTitle(String title);
    int countByAuthor(String author);
    int countByCover(String cover);
    int countByDescription(String description);
    int countByGenre(String genre);



}
