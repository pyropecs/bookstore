package com.library.repositories;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.library.models.Book;
import com.library.models.User;

@Repository
public class BookRepository {
    @Autowired
    private SessionFactory sessionFactory;

    public void insertBook(Book book) {
        Session session = sessionFactory.openSession();
        try {
            session.save(book);
        } catch (Exception e) {
            System.out.println("Exception occurred " + e.getMessage() + " BookRepository.insertBook()");
            e.printStackTrace();
        } finally {
            session.close();
        }

    }


    public List<Book> getAllBooks() {
        Session session = sessionFactory.openSession();
        List<Book> books = null;
        try {
            Query query = session.createQuery("from Book");
            books = query.getResultList();
        } catch (Exception e) {
            System.out.println("Exception occurred " + e.getMessage() + " UserRepository.getAllBooks()");
            e.printStackTrace();
        } finally {
            session.close();
        }
        return books;
    }

}
