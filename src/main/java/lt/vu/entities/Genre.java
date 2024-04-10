package lt.vu.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@NamedQuery(name="Genre.findAll", query="SELECT a FROM Genre a")
public class Genre {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long Id;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    @ManyToMany(mappedBy = "Genres")
    private java.util.List<lt.vu.entities.Book> Books;

    public java.util.List<lt.vu.entities.Book> getBooks() {
        return Books;
    }

    public void setBooks(java.util.List<lt.vu.entities.Book> books) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Genre genre = (Genre) o;
        return Objects.equals(Id, genre.Id) && Objects.equals(Name, genre.Name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id, Name);
    }
}
