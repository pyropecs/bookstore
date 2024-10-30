package com.library;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.library.models.User;

@Repository
public class UserRepository {

    @Autowired
    private SessionFactory sessionFactory ;

    public void insertUser(User user) {
        Session session = sessionFactory.openSession();
        try {
            session.save(user);
        } catch (Exception e) {
            System.out.println("Exception occurred " + e.getMessage() + " UserRepository.insertUser()");
            e.printStackTrace();
        } finally {
            session.close();
        }

    }

    public List<User> getAllUsers() {
        Session session = sessionFactory.openSession();
        List<User> users = null;
        try {
            Query query = session.createQuery("from User");
            users = query.getResultList();
        } catch (Exception e) {
            System.out.println("Exception occurred " + e.getMessage() + " UserRepository.getAllUsers()");
            e.printStackTrace();
        } finally {
            session.close();
        }
        return users;
    }
}
