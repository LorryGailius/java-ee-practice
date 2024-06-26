package lt.vu.mybatis.dao;

import java.util.List;
import lt.vu.mybatis.model.Book;
import org.apache.ibatis.annotations.Param;
import org.mybatis.cdi.Mapper;

@Mapper
public interface BookMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.BOOK
     *
     * @mbg.generated Wed Apr 10 02:12:58 EEST 2024
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.BOOK
     *
     * @mbg.generated Wed Apr 10 02:12:58 EEST 2024
     */
    int insert(Book record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.BOOK
     *
     * @mbg.generated Wed Apr 10 02:12:58 EEST 2024
     */
    Book selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.BOOK
     *
     * @mbg.generated Wed Apr 10 02:12:58 EEST 2024
     */
    List<Book> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.BOOK
     *
     * @mbg.generated Wed Apr 10 02:12:58 EEST 2024
     */
    int updateByPrimaryKey(Book record);

    void insertBookGenre(@Param("bookId") Long bookId, @Param("genreId") Long genreId);

}