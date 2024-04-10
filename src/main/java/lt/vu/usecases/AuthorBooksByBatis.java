package lt.vu.usecases;

import lombok.Getter;
import lombok.Setter;
import lt.vu.mybatis.dao.AuthorMapper;
import lt.vu.mybatis.dao.BookMapper;
import lt.vu.mybatis.dao.GenreMapper;
import lt.vu.mybatis.model.Author;
import lt.vu.mybatis.model.Book;
import lt.vu.mybatis.model.Genre;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import java.io.Console;
import java.util.List;
import java.util.Map;

@Model
public class AuthorBooksByBatis {

    @Inject
    private BookMapper bookMapper;

    @Inject
    private AuthorMapper authorMapper;

    @Inject
    private GenreMapper genreMapper;

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
        this.author = authorMapper.selectByPrimaryKey(authorId);
        bookToCreate.setAuthor(this.author);
        bookToCreate.setAuthorId(authorId);
        this.availableGenres = genreMapper.selectAll();
    }

    public void createBook(){
        if(this.author.getBooks().contains(bookToCreate)){
            return;
        }
        bookMapper.insert(bookToCreate);
    }
}
