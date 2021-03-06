package com.nepalaya.up.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "BOOK_HISTORIES")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookHistory extends BaseEntity<User> {

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "BOOK_ID", referencedColumnName = "ID")
    private Book book;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "USER_ID", referencedColumnName = "ID")
    private User user;

    @Column(name = "BOOK_TAKEN_DATE", nullable = false)
    private Date bookTakenDate;

    @Column(name = "BOOK_RETURNED_DATE")
    private Date bookReturnedDate;

    public BookHistory(Long id) {
        super(id);
    }
}
