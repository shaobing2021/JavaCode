package com.shaobing.spring.service;

import com.shaobing.spring.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class BookService {
//    @Qualifier("bookDao2")
//    @Autowired(required = false)
//    @Resource(name="bookDao2")
    private BookDao bookDao;

    public BookService(BookDao bookDao) {
        System.out.println("bookDao...");
        this.bookDao = bookDao;
    }


//    public void setBookDao(@Autowired BookDao bookDao) {
//        this.bookDao = bookDao;
//    }

    public void print(){
        bookDao.print();
    }

    @Override
    public String toString() {
        return "BookService{" +
                "bookDao=" + bookDao +
                '}';
    }

}
