package quarkus;

public interface BookMapper {
    Book fromCreate(CreateBookDto dto);
}
