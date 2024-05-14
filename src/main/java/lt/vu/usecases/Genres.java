package lt.vu.usecases;

import lombok.Getter;
import lombok.Setter;
import lt.vu.entities.Genre;
import lt.vu.persistence.GenreDAO;
import lt.vu.services.GenreService;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

@Model
public class Genres {

    @Inject
    private GenreDAO genreDAO;

    @Getter @Setter
    private Genre genreToCreate = new Genre();

    @Getter
    private List<Genre> allGenres;

    private void loadAllGenres(){
        this.allGenres = genreDAO.loadAll();
    }

    @PostConstruct
    public void init(){
        loadAllGenres();
    }

    @Transactional
    public void createGenre(){
        this.genreDAO.persist(genreToCreate);
    }
}
