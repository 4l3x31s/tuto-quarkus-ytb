package quarkus;

public class BookMapperImpl implements  BookMapper {
    @Override
    public Book fromCreate(CreateBookDto dto) {
        var b = new Book();
        b.setTitle(dto.title());
        b.setDescription(dto.description());
        b.setNumPages(dto.numPages());
        b.setPubDate(dto.pubDate());
        return b;
    }
}
