package lt.vu.persistence;

import lt.vu.entities.Book;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class BookDAO {

    @Inject
    private EntityManager em;

    public void persist(Book book) {
        this.em.persist(book);
    }

    public List<Book> findByGenres(List<Long> genreIds) {
        return em.createQuery("select b from Book b where b.Genres in :genres", Book.class)
                .setParameter("genres", genreIds)
                .getResultList();
    }

    public List<Book> findByGenre(Long genreId) {
        return em.createQuery("SELECT b FROM Book b JOIN b.Genres g WHERE g.Id = :genreId", Book.class)
                .setParameter("genreId", genreId)
                .getResultList();
    }

    public List<Book> loadAll() {
        return em.createNamedQuery("Book.findAll", Book.class).getResultList();
    }

    public List<Book> findByTitle(String title) {
        if(title == null || title.trim().isEmpty()){
            return loadAll();
        }

        return em.createQuery("SELECT b FROM Book b WHERE LOWER(b.Title) LIKE :title", Book.class)
                .setParameter("title", "%" + title.toLowerCase() + "%")
                .getResultList();
    }

    public Book update(Book book) {
        return em.merge(book);
    }
}
