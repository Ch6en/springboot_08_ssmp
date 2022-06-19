package com.chen.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.chen.controller.utils.Result;
import com.chen.domain.Book;
import com.chen.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private IBookService bookService;

    @PostMapping
    public Result add(@RequestBody Book book) throws IOException {
        if ("123".equals(book.getName())) throw new IOException();
        boolean flag = bookService.save(book);
        return new Result(flag, flag ? "添加成功" : "添加失败");
    }

    @PutMapping
    public Result updateById(@RequestBody Book book){
        return new Result(true, bookService.updateById(book));
    }

    @DeleteMapping("{id}")
    public Result deleteById(@PathVariable Integer id){
        return new Result(true, bookService.removeById(id));
    }

    @GetMapping("{id}")
    public Result getById(@PathVariable Integer id){
        return new Result(true, bookService.getById(id));
    }

    @GetMapping
    public Result getAll(){
        return new Result(true, bookService.list());
    }

//    @GetMapping("{current}/{size}")
//    public Result getPage(@PathVariable Integer current, @PathVariable Integer size){
//        IPage<Book> page = bookService.getPage(current, size);
//        if (current > page.getPages()) {
//            page = bookService.getPage((int) page.getPages(), size);
//        }
//        return new Result(true, page);
//    }

    @GetMapping("{current}/{size}")
    public Result getPage(@PathVariable Integer current, @PathVariable Integer size, Book book){
        IPage<Book> page = bookService.getPage(current, size, book);
        if (current > page.getPages()) {
            page = bookService.getPage((int) page.getPages(), size, book);
        }
        return new Result(page != null, page);
    }


}
