package quarkus;

import java.time.LocalDate;

public record CreateBookDto(
        String title,
        String description,
        int numPages,
        LocalDate pubDate
) {
}
