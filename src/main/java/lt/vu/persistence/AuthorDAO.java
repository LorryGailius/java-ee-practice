package lt.vu.persistence;

import lt.vu.entities.Author;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class AuthorDAO {

    @Inject
    private EntityManager em;

    public void persist(Author author) {
        this.em.persist(author);
    }

    public Author findOne(Long id) {
        return em.find(Author.class, id);
    }

    public List<Author> loadAll() {
        return em.createNamedQuery("Author.findAll", Author.class).getResultList();
    }
}
