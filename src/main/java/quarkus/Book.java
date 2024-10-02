package quarkus;
import jakarta.persistence.Entity;
import io.quarkus.hibernate.orm.panache.PanacheEntity;

import java.time.LocalDate;
import java.util.Objects;

@Entity
public class Book extends PanacheEntity {
    private String title;
    private String description;
    private int numPages;
    private LocalDate pubDate;
    private LocalDate createdAt;
    private int state;

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public Book() {
        // Sigue siendo necesario tener un constructor vacío.
        // Si es el único constructor, entonces no es obligatorio
        // ponerlo de acuerdo con las reglas del lenguaje Java.
    }

    public Book(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getNumPages() {
        return numPages;
    }

    public void setNumPages(int numPages) {
        this.numPages = numPages;
    }

    public LocalDate getPubDate() {
        return pubDate;
    }

    public void setPubDate(LocalDate pubDate) {
        this.pubDate = pubDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book book)) return false;
        return id == book.id && numPages == book.numPages && Objects.equals(title, book.title) && Objects.equals(description, book.description) && Objects.equals(pubDate, book.pubDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, description, numPages, pubDate);
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", numPages=" + numPages +
                ", pubDate=" + pubDate +
                ", id=" + id +
                '}';
    }
}



//package quarkus;
//
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.Id;
//
//import java.time.LocalDate;
//import java.util.Objects;
//
//@Entity
//public class Book {
//    @Id
//    @GeneratedValue
//    private Long id;
//    private String title;
//    private int numPages;
//    private LocalDate pubDate;
//    private String description;
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getTitle() {
//        return title;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//    public int getNumPages() {
//        return numPages;
//    }
//
//    public void setNumPages(int numPages) {
//        this.numPages = numPages;
//    }
//
//    public LocalDate getPubDate() {
//        return pubDate;
//    }
//
//    public void setPubDate(LocalDate pubDate) {
//        this.pubDate = pubDate;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Book book = (Book) o;
//        return numPages == book.numPages && Objects.equals(title, book.title) && Objects.equals(pubDate, book.pubDate) && Objects.equals(description, book.description);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(title, numPages, pubDate, description);
//    }
//}
