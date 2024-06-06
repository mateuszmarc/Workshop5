package pl.coderslab;

import lombok.*;

import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Book {
    private Long id;
    private String isbn;
    private String title;
    private String author;
    private String publisher;
    private String type;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(id, book.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
    
    public void updateBook(Book bookNewData) {
        this.setIsbn(bookNewData.getIsbn());
        this.setType(bookNewData.getType());
        this.setTitle(bookNewData.getTitle());
        this.setAuthor(bookNewData.getAuthor());
        this.setPublisher(bookNewData.getPublisher());
    }
}
