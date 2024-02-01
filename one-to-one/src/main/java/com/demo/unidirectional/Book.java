package com.demo.unidirectional;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "books")
@Getter
@Setter
@NoArgsConstructor
public class Book {
    @Id
    @Column(name = "book_id")
    private Long bookId;

    @Column(name = "title")
    private String title;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "publisher_id_fk", referencedColumnName = "publisher_id_pk")
    private Publisher publisher;
}
