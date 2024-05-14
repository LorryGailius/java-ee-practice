package lt.vu.services;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Specializes;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@ApplicationScoped
@Specializes
public class GenreSortedService extends GenreService {

    @PersistenceUnit
    private EntityManagerFactory emf;

    public Map<String, Long> calculateGenrePopularity() {
        EntityManager em = emf.createEntityManager();

        try {
            Thread.sleep(3000); // Simulate intensive work
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        try {
            List<Object[]> genrePopularity = em.createQuery(
                            "SELECT g.Name, COUNT(b) FROM Book b JOIN b.Genres g GROUP BY g.Name ORDER BY COUNT(b) DESC",
                            Object[].class)
                    .getResultList();

            return genrePopularity.stream()
                    .collect(Collectors.toMap(
                            genre -> (String) genre[0],
                            amount -> (Long) amount[1],
                            (oldValue, newValue) -> oldValue,
                            LinkedHashMap::new
                    ));
        } finally {
            em.close();
        }
    }
}
