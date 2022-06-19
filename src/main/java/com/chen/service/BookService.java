package com.chen.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.chen.domain.Book;

import java.util.List;

public interface BookService {

    Boolean add(Book book);

    Boolean update(Book book);

    Boolean deleteById(Integer id);

    Book getById(Integer id);

    List<Book> getAll();

    IPage getPage(Integer current, Integer size);

}
