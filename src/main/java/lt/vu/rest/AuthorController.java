package lt.vu.rest;

import lt.vu.entities.Author;
import lt.vu.persistence.AuthorDAO;
import lt.vu.rest.dto.AuthorDto;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.OptimisticLockException;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.stream.Collectors;

@Path("/authors")
@ApplicationScoped
public class AuthorController {
    @Inject
    private AuthorDAO authorsDAO;

    private AuthorDto toDTO(Author author) {
        return new AuthorDto(author.getId(), author.getName(), author.getSurname(), author.getWebsite());
    }

    private Author fromDTO(AuthorDto dto) {
        Author author = new Author();
        author.setName(dto.getName());
        author.setSurname(dto.getSurname());
        author.setWebsite(dto.getWebsite());
        return author;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllAuthors() {
        List<AuthorDto> dtos = authorsDAO.loadAll().stream().map(this::toDTO).collect(Collectors.toList());
        return Response.ok(dtos).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAuthorById(@PathParam("id") Long id) {
        Author author = authorsDAO.findOne(id);
        if (author != null) {
            return Response.ok(toDTO(author)).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @POST
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addAuthor(AuthorDto authorDTO) {
        Author author = fromDTO(authorDTO);
        this.authorsDAO.persist(author);
        return Response.status(Response.Status.CREATED).entity(toDTO(author)).build();
    }

    @PUT
    @Path("/{id}")
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateAuthor(@PathParam("id") Long id, AuthorDto updatedAuthorDTO) {
        Author currentAuthor = authorsDAO.findOne(id);
        if (currentAuthor == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        currentAuthor.setName(updatedAuthorDTO.getName());
        currentAuthor.setSurname(updatedAuthorDTO.getSurname());
        currentAuthor.setWebsite(updatedAuthorDTO.getWebsite());
        try{
            currentAuthor = authorsDAO.update(currentAuthor);
            return Response.ok(toDTO(currentAuthor)).build();
        } catch (OptimisticLockException e) {
            return Response.status(Response.Status.CONFLICT).build();
        }
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public Response deleteAuthor(@PathParam("id") Long id) {
        Author author = authorsDAO.findOne(id);
        if (author != null) {
            authorsDAO.delete(author);
            return Response.noContent().build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

}
