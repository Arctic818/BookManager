package com.springapp.mvc.repository;

import com.springapp.mvc.domain.Book;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Repository
@Transactional
public class BookRepository {

    @Autowired
    private SessionFactory sessionFactory;

    public void addBook(Book book){
        this.sessionFactory.getCurrentSession().save(book);
    }


    public void updateBook(Book book){
        System.out.println(book.getiD());
        System.out.println(book.getName());
        this.sessionFactory.getCurrentSession().update(book);
    }

    public List<Book> listAll(){
        return this.sessionFactory.getCurrentSession().createQuery("from Book").list();
    }

    public void removeBook(Integer iD){
        Book book = (Book)this.sessionFactory.getCurrentSession().load(Book.class, iD);
        if (null!=book){
            this.sessionFactory.getCurrentSession().delete(book);
        }
    }

    public Book getBook(Integer iD){
        Book book = (Book)this.sessionFactory.getCurrentSession().load(Book.class, iD);
        book.getiD();
        return book;
    }


}

