package lt.vu.usecases;

import lombok.Getter;
import lombok.Setter;
import lt.vu.entities.Author;
import lt.vu.generators.IWebsiteGenerator;
import lt.vu.persistence.AuthorDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.OptimisticLockException;
import javax.transaction.Transactional;
import java.io.Console;
import java.io.Serializable;
import java.util.Map;

@ViewScoped
@Named
@Getter @Setter
public class UpdateAuthor implements Serializable {
    @Getter @Setter
    private Author authorToUpdate;

    @Inject
    AuthorDAO authorDAO;

    @Inject
    IWebsiteGenerator websiteGenerator;

    @Getter @Setter
    private String authorId;

    @PostConstruct
    public void init() {
        Map<String, String> requestParameters = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Long authorId = Long.parseLong(requestParameters.get("authorId"));
        this.setAuthorToUpdate(authorDAO.findOne(authorId));
        this.authorId = authorId.toString();
        if(authorToUpdate.getWebsite() == null) {
            System.out.println("Website is null");
        }
    }

    @Transactional
    public String updateAuthor() {
        try{
            authorDAO.update(authorToUpdate);
        } catch (OptimisticLockException e) {
            return "/authorDetails.xhtml?faces-redirect=true&authorId=" + this.authorToUpdate.getId() + "&error=optimistic-lock-exception";
        }
        return "authorDetails?faces-redirect=true&authorId=" + this.authorToUpdate.getId();
    }

    public void generateWebsite() {
        authorToUpdate.setWebsite(websiteGenerator.generateWebsite(authorToUpdate));
    }
}
