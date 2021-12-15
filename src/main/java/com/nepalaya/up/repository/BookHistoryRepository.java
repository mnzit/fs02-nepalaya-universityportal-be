package com.nepalaya.up.repository;


import com.nepalaya.up.model.Book;
import com.nepalaya.up.model.BookHistory;
import com.nepalaya.up.response.BookHistoryResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookHistoryRepository extends JpaRepository<BookHistory, Long> {

    List<BookHistory> findBookHistoriesByBook(Book book);

}
