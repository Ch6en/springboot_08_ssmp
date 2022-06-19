package com.chen.dao;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chen.domain.Book;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BookDaoTest {

    @Autowired
    private BookDao bookDao;

    @Test
    void testAdd(){
        Book book = new Book();
        book.setType("计算机");
        book.setName("计算机");
        book.setDescription("计算机");
        bookDao.insert(book);
    }

    @Test
    void testUpdate(){
        Book book = new Book();
        book.setId(17);
        book.setType("计算机666");
        book.setName("计算机666");
        book.setDescription("计算机");
        bookDao.updateById(book);
    }

    @Test
    void testDelete(){
        bookDao.deleteById(18);
    }

    @Test
    void testGetById(){
        System.out.println(bookDao.selectById(1));
    }

    @Test
    void testGetAll(){
        System.out.println(bookDao.selectList(null));
    }

    @Test
    void testPage(){
        IPage page = new Page(2, 5);
        bookDao.selectPage(page,null);
        System.out.println(page.getPages());
        System.out.println(page.getCurrent());
        System.out.println(page.getSize());
        System.out.println(page.getTotal());
        System.out.println(page.getRecords());
    }

    @Test
    void testGetBy(){
        QueryWrapper<Book> qw = new QueryWrapper<>();
        qw.like("name", "Java");
        bookDao.selectList(qw);
    }

    @Test
    void testGetBy2(){
        String name = "Java";
        LambdaQueryWrapper<Book> lqw = new LambdaQueryWrapper<>();
//       lqw.like(Book::getName, "Java");
       lqw.like(name!=null, Book::getName, name);
        bookDao.selectList(lqw);
    }

}
