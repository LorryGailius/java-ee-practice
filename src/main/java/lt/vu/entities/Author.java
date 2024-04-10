package lt.vu.entities;

import javax.persistence.*;
import java.lang.reflect.Type;
import java.util.List;

@Entity
@NamedQuery(name="Author.findAll", query="SELECT a FROM Author a")
public class Author {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long Id;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    @OneToMany(mappedBy = "Author")
    private List<Book> Books;

    public List<Book> getBooks() {
        return Books;
    }

    public void setBooks(List<Book> books) {
        Books = books;
    }

    @Basic
    private String Name;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    @Basic
    private String Surname;

    public String getSurname() {
        return Surname;
    }

    public void setSurname(String surname) {
        Surname = surname;
    }
}
