package com.chen.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.chen.domain.Book;

public interface IBookService extends IService<Book> {

    IPage getPage(Integer current, Integer size);

    IPage getPage(Integer current, Integer size, Book book);
}
