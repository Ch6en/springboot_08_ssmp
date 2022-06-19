package com.chen.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chen.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BookServiceTest {

    @Autowired
    private IBookService bookService;

    @Test
    void add(){
        Book book = new Book();
        book.setType("计算机");
        book.setName("计算机");
        book.setDescription("计算机");
        bookService.save(book);
    }

    @Test
    void testUpdate(){
        Book book = new Book();
        book.setId(17);
        book.setType("计算机");
        book.setName("计算机");
        book.setDescription("计算机");
        bookService.updateById(book);
    }

    @Test
    void testDelete(){
        bookService.removeById(16);
    }

    @Test
    void testGetById(){
        System.out.println(bookService.getById(2));
    }

    @Test
    void testGetAll(){
        System.out.println(bookService.list());
    }

    @Test
    void testPage(){
        IPage page = new Page(1, 5);
        bookService.page(page);
        System.out.println(page.getPages());
        System.out.println(page.getCurrent());
        System.out.println(page.getSize());
        System.out.println(page.getTotal());
        System.out.println(page.getRecords());
    }


}
