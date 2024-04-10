package lt.vu.persistence;

import lt.vu.entities.Genre;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class GenreDAO {

    @Inject
    private EntityManager em;

    public void persist(Genre genre) {
        this.em.persist(genre);
    }

    public Genre findOne(Long id) {
        return em.find(Genre.class, id);
    }

    public List<Genre> loadAll() {
        return em.createNamedQuery("Genre.findAll", Genre.class).getResultList();
    }
}