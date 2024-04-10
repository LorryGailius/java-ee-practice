package lt.vu.mybatis.dao;

import java.util.List;
import lt.vu.mybatis.model.Genre;
import org.mybatis.cdi.Mapper;

@Mapper
public interface GenreMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.GENRE
     *
     * @mbg.generated Wed Apr 10 02:12:58 EEST 2024
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.GENRE
     *
     * @mbg.generated Wed Apr 10 02:12:58 EEST 2024
     */
    int insert(Genre record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.GENRE
     *
     * @mbg.generated Wed Apr 10 02:12:58 EEST 2024
     */
    Genre selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.GENRE
     *
     * @mbg.generated Wed Apr 10 02:12:58 EEST 2024
     */
    List<Genre> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.GENRE
     *
     * @mbg.generated Wed Apr 10 02:12:58 EEST 2024
     */
    int updateByPrimaryKey(Genre record);
}