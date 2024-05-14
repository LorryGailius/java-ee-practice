package lt.vu.persistence;

import lt.vu.entities.Author;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class AuthorDAO {

    @Inject
    private EntityManager em;

    public void persist(Author author) {
        if(author.getWebsite() == null) {
            author.setWebsite("");
        }
        this.em.persist(author);
    }

    public Author findOne(Long id) {
        return em.find(Author.class, id);
    }

    public List<Author> loadAll() {
        return em.createNamedQuery("Author.findAll", Author.class).getResultList();
    }

    public Author update(Author author) {
        return em.merge(author);
    }

    public void delete(Author author) {
        em.remove(author);
    }
}
