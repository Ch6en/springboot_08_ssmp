package com.chen.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.chen.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BookServiceTestCase {

    @Autowired
    private BookService bookService;

    @Test
    void add(){
        Book book = new Book();
        book.setType("计算机");
        book.setName("计算机");
        book.setDescription("计算机");
        bookService.add(book);
    }

    @Test
    void testUpdate(){
        Book book = new Book();
        book.setId(17);
        book.setType("计算机abc");
        book.setName("计算机abc");
        book.setDescription("计算机");
        bookService.update(book);
    }

    @Test
    void testDelete(){
        bookService.deleteById(19);
    }

    @Test
    void testGetById(){
        System.out.println(bookService.getById(1));
    }

    @Test
    void testGetAll(){
        System.out.println(bookService.getAll());
    }

    @Test
    void testPage(){
        IPage page = bookService.getPage(2, 5);
        System.out.println(page.getPages());
        System.out.println(page.getCurrent());
        System.out.println(page.getSize());
        System.out.println(page.getTotal());
        System.out.println(page.getRecords());
    }


}
