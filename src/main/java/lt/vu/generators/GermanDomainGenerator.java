package lt.vu.generators;

import lt.vu.entities.Author;

import javax.enterprise.inject.Alternative;

@Alternative
public class GermanDomainGenerator implements IWebsiteGenerator {
    @Override
    public String generateWebsite(Author author) {
        return "https://www." + author.getName().toLowerCase() + ".germany." + author.getSurname().toLowerCase() + ".de";
    }
}
