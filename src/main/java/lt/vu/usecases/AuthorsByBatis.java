package lt.vu.usecases;

import lombok.Getter;
import lombok.Setter;
import lt.vu.mybatis.dao.AuthorMapper;
import lt.vu.mybatis.model.Author;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Model
public class AuthorsByBatis {

    @Inject
    private AuthorMapper authorMapper;

    @Getter
    private List<Author> allAuthors;

    @Getter @Setter
    private Author authorToCreate = new Author();

    public void loadAllAuthors() {
        this.allAuthors = authorMapper.selectAll();
    }

    @PostConstruct
    public void init(){
        loadAllAuthors();
    }

    @Transactional
    public String createAuthor(){
        authorMapper.insert(authorToCreate);
        return "/myBatis/authors?faces-redirect=true";
    }

}
