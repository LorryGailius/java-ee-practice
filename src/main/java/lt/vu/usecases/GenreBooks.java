package lt.vu.usecases;

import lombok.Getter;
import lt.vu.entities.Book;
import lt.vu.entities.Genre;
import lt.vu.persistence.BookDAO;
import lt.vu.persistence.GenreDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.Dictionary;
import java.util.List;
import java.util.Map;

@Model
public class GenreBooks {

    @Inject
    private GenreDAO genreDAO;
    @Inject
    private BookDAO bookDAO;

    @Getter
    private Genre genre;

    @Getter
    private List<Book> books;

    @PostConstruct
    public void init(){
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();

        Long genreId = Long.parseLong(requestParameters.get("genreId"));
        this.genre = genreDAO.findOne(genreId);
        this.books = findByGenre(genreId);
    }

    private List<Book> findByGenre(Long genreId) {
        return bookDAO.findByGenre(genreId);
    }

}
