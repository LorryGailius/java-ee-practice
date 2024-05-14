package lt.vu.persistence;

import lt.vu.entities.Book;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@Decorator
public abstract class BookDAODecorator implements IBookDAO {

    @Inject
    @Delegate
    private IBookDAO bookDAO;

    @Override
    public List<Book> loadAll() {
        List<Book> books = bookDAO.loadAll();
        for (Book book : books) {
            book.setTitle(book.getTitle().toUpperCase());
        }
        return books;
    }
}
