package lt.vu.generators;

import lt.vu.entities.Author;

import java.io.Serializable;

public interface IWebsiteGenerator extends Serializable {
    String generateWebsite(Author author);
}
