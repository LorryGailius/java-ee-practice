package lt.vu.usecases;


import lombok.Getter;
import lombok.Setter;
import lt.vu.entities.Book;
import lt.vu.persistence.BookDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import java.util.List;

@Model
public class Books {

    @Inject
    private BookDAO bookDAO;

    @Getter
    private List<Book> allBooks;

    @Getter @Setter
    private String searchTitle;

    public List<Book> loadAllBooks() {
        return bookDAO.loadAll();
    }

    @PostConstruct
    public void init() {
        this.allBooks = loadAllBooks();
    }

    public void getBooksByTitle() {
        this.allBooks = bookDAO.findByTitle(searchTitle);
    }
}
