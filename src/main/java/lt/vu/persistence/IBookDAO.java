package lt.vu.persistence;

import lt.vu.entities.Book;

import java.util.List;

public interface IBookDAO {

    void persist(Book book);

    List<Book> findByGenres(List<Long> genreIds);

    List<Book> findByGenre(Long genreId);

    List<Book> loadAll();

    List<Book> findByTitle(String title);

    Book update(Book book);
}
