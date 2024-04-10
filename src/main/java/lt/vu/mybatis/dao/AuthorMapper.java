package lt.vu.mybatis.dao;

import java.util.List;
import lt.vu.mybatis.model.Author;
import org.mybatis.cdi.Mapper;

@Mapper
public interface AuthorMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.AUTHOR
     *
     * @mbg.generated Wed Apr 10 02:12:58 EEST 2024
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.AUTHOR
     *
     * @mbg.generated Wed Apr 10 02:12:58 EEST 2024
     */
    int insert(Author record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.AUTHOR
     *
     * @mbg.generated Wed Apr 10 02:12:58 EEST 2024
     */
    Author selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.AUTHOR
     *
     * @mbg.generated Wed Apr 10 02:12:58 EEST 2024
     */
    List<Author> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.AUTHOR
     *
     * @mbg.generated Wed Apr 10 02:12:58 EEST 2024
     */
    int updateByPrimaryKey(Author record);
}