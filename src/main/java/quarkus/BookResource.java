package quarkus;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;

import java.util.List;
import java.util.NoSuchElementException;

@Path("/books")
@Transactional
public class BookResource {

    @Inject
    private BookRepository repo;

    @Inject
    private BookMapper mapper;

//    @GET
//    public List<Book> index() {
//        return repo.findAll().stream().toList();
//    }
@GET
public List<Book> listBooks(
        @QueryParam("q") String query,
        @QueryParam("genre") String genre
) {
    if (query != null && genre != null) {
        String criteria = "(title ILIKE ?1 OR description ILIKE ?2) AND genre = ?3";
        String freeQuery = "%" + query + "%";
        return repo.list(criteria, freeQuery, freeQuery, genre);
    } else if (query != null) {
        String criteria = "title ILIKE ?1 OR description ILIKE ?2";
        String freeQuery = "%" + query + "%";
        return repo.list(criteria, freeQuery, freeQuery);
    } else if (genre != null) {
        return repo.list("genre", genre);
    } else {
        return repo.listAll();
    }
}
    @POST
    public Book insert(Book givenBook) {
        Book b = new Book();
        b.setTitle(givenBook.getTitle());
        b.setDescription(givenBook.getDescription());
        b.setNumPages(givenBook.getNumPages());
        b.setPubDate(givenBook.getPubDate());
        b.persist();
        return b;
    }

    @GET
    @Path(("{id}"))
    public Response retrieveBook(@PathParam("id") Long id){
        Book book = repo.findById(id);
        if(book!=null){
            return Response.ok(book).build();
        }
        return Response.status(404).entity("Not Founf").build();
    }
    @DELETE
    @Path("{id}")
    public Response deleteBook(@PathParam("id") Long id) {
        if(repo.deleteById(id)){
            return Response.ok("Objeto borrado correctamente").build();
        } else {
            return Response.status(400).entity("No hay nada para borrar").build();
        }
    }
    @PUT
    @Path("{id}")

    public Book updateBook(@PathParam("id") Long id, Book bookData) {
        Book existingBook = repo.findById(id);
        if (existingBook == null) {
            throw new NoSuchElementException("Este libro no existe");
        }

        existingBook.setTitle(bookData.getTitle());
        existingBook.setDescription(bookData.getDescription());
        existingBook.setPubDate(bookData.getPubDate());
        existingBook.setNumPages(bookData.getNumPages());

        // El libro que persisctimos es el que nos entregó el ORM.
        repo.persist(existingBook);
        return existingBook;
    }
}
