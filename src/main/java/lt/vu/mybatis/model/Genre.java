package lt.vu.mybatis.model;

import java.util.List;

public class Genre {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.GENRE.ID
     *
     * @mbg.generated Wed Apr 10 02:12:58 EEST 2024
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.GENRE.NAME
     *
     * @mbg.generated Wed Apr 10 02:12:58 EEST 2024
     */
    private String Name;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.GENRE.ID
     *
     * @return the value of PUBLIC.GENRE.ID
     *
     * @mbg.generated Wed Apr 10 02:12:58 EEST 2024
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.GENRE.ID
     *
     * @param id the value for PUBLIC.GENRE.ID
     *
     * @mbg.generated Wed Apr 10 02:12:58 EEST 2024
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.GENRE.NAME
     *
     * @return the value of PUBLIC.GENRE.NAME
     *
     * @mbg.generated Wed Apr 10 02:12:58 EEST 2024
     */
    public String getName() {
        return Name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.GENRE.NAME
     *
     * @param Name the value for PUBLIC.GENRE.NAME
     *
     * @mbg.generated Wed Apr 10 02:12:58 EEST 2024
     */
    public void setName(String Name) {
        this.Name = Name;
    }

    private List<Book> books;

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}