package com.andrewn.java2305bookshelf.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class BookForm {
    private String title;
    private String author;

    @Override
    public String toString() {
        return "BookForm{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
