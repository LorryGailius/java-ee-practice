package lt.vu.generators;

import lt.vu.entities.Author;

import javax.enterprise.inject.Alternative;
import javax.enterprise.inject.Default;

@Default
public class EnglishDomainGenerator implements IWebsiteGenerator{
    @Override
    public String generateWebsite(Author author) {
        return "https://www." + author.getName().toLowerCase() + ".com";
    }
}
