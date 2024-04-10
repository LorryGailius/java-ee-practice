package lt.vu.usecases;

import lombok.Getter;
import lombok.Setter;
import lt.vu.entities.Author;
import lt.vu.entities.Book;
import lt.vu.entities.Genre;
import lt.vu.persistence.AuthorDAO;
import lt.vu.persistence.BookDAO;
import lt.vu.persistence.GenreDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;

@Model
public class AuthorBooks {

    @Inject
    private AuthorDAO authorDAO;
    @Inject
    private BookDAO bookDAO;
    @Inject
    private GenreDAO genreDAO;

    @Getter
    private Author author;
    @Getter @Setter
    private Book bookToCreate = new Book();
    @Getter
    private List<Genre> availableGenres;

    @PostConstruct
    public void init(){
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Long authorId = Long.parseLong(requestParameters.get("authorId"));
        this.author = authorDAO.findOne(authorId);
        bookToCreate.setAuthor(this.author);
        this.availableGenres = genreDAO.loadAll();
    }

    @Transactional
    public void createBook(){
        if(this.author.getBooks().contains(bookToCreate)){
            return;
        }
        this.bookDAO.persist(bookToCreate);
    }
}
