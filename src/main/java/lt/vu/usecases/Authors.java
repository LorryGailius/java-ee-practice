package lt.vu.usecases;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.java.Log;
import lt.vu.entities.Author;
import lt.vu.interceptors.LoggedInvocation;
import lt.vu.persistence.AuthorDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Model
public class Authors {

    @Inject
    private AuthorDAO authorDAO;

    @Getter @Setter
    private Author authorToCreate = new Author();

    @Getter
    private List<Author> allAuthors;

    @PostConstruct
    public void init(){
        loadAllAuthors();
    }

    @Transactional
    @LoggedInvocation
    public void createAuthor(){
        this.authorDAO.persist(authorToCreate);
    }

    private void loadAllAuthors(){
        this.allAuthors = authorDAO.loadAll();
    }
}
