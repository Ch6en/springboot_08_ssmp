package com.chen.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chen.dao.BookDao;
import com.chen.domain.Book;
import com.chen.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl2 implements BookService {

    @Autowired
    private BookDao bookDao;

    @Override
    public Boolean add(Book book) {
        return bookDao.insert(book) >0;
    }

    @Override
    public Boolean update(Book book) {
        return bookDao.updateById(book) >0;
    }

    @Override
    public Boolean deleteById(Integer id) {
        return bookDao.deleteById(id) >0;
    }

    @Override
    public Book getById(Integer id) {
        return bookDao.selectById(id);
    }

    @Override
    public List<Book> getAll() {
        return bookDao.selectList(null);
    }

    @Override
    public IPage<Book> getPage(Integer current, Integer size) {
        IPage page = new Page<Book>(current, size);
        return bookDao.selectPage(page, null);
    }
}
