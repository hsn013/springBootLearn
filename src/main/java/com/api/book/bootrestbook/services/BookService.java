package com.api.book.bootrestbook.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.api.book.bootrestbook.entities.Book;

@Component
public class BookService {
    private static List<Book> list = new ArrayList<>();

        static{
            list.add(new Book(12,"java core","abc"));
            list.add(new Book(24,"java ","bcd"));
            list.add(new Book(36,"thing in java","cde"));
        }


    // show book
    public List<Book> getAllBooks(){
        return list;
    }

    // get single book
    public Book getBookById(int id){
        Book book = null;
        try{
            book= list.stream().filter(e->e.getId()==id).findFirst().get();
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        return book;
    }

    //add the book
    public Book addBook(Book b){

        list.add(b);
        return b;
    }

    //get book delete
    public void deleteBook(int bid){
        list=list.stream().filter(book->book.getId()!=bid).collect(Collectors.toList());
    }

    //get book update
    public void updateBook(Book book, int bookId){
        list = list.stream().map(b->{
            if(b.getId()==bookId) { b.setAuthor(book.getAuthor());
                b.setName(book.getName()); }return b;
        }).collect(Collectors.toList());
    }
}