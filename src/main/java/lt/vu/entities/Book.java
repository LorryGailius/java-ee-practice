package lt.vu.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@NamedQuery(name = "Book.findAll", query = "select b from Book b")
public class Book {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long Id;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    @ManyToOne(optional = false)
    private lt.vu.entities.Author Author;

    public lt.vu.entities.Author getAuthor() {
        return Author;
    }

    public void setAuthor(lt.vu.entities.Author author) {
        Author = author;
    }

    @ManyToMany
    private java.util.List<lt.vu.entities.Genre> Genres;

    public java.util.List<lt.vu.entities.Genre> getGenres() {
        return Genres;
    }

    public void setGenres(java.util.List<lt.vu.entities.Genre> genres) {
        Genres = genres;
    }

    @Basic(optional = false)
    private String Title;

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(Id, book.Id) && Objects.equals(Author, book.Author) && Objects.equals(Title, book.Title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id, Author, Title);
    }
}
