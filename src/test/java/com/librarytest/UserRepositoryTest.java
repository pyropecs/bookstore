package com.librarytest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.library.models.Book;
import com.library.models.User;
import com.library.repositories.BookRepository;
import com.library.repositories.UserRepository;

@RunWith(MockitoJUnitRunner.class)
public class UserRepositoryTest {
      @InjectMocks
    private UserRepository userRepository;  // BookRepository will be injected with mocked sessionFactory

    @Mock
    private SessionFactory sessionFactory;  // Mock SessionFactory

    @Mock
    private Session session;  // Mock Session

    @Mock
    private Criteria criteria;  // Mock Criteria


    @Mock
    private Transaction transaction;  // Mock Transaction

    @Mock
    private Query query;

    private User user;
    private User user2;
    @Before
    public void setup(){
        user  = new User();
        user.setId(1);
        user.setName("praveen");
        user.setDepartment("electrical");
        user.setDesignation("electronics");
          when(sessionFactory.openSession()).thenReturn(session);
        when(session.createCriteria(User.class)).thenReturn(criteria);
        
       


    }
    @Test
    public void AddBookTest() {
        // Call method to test
        String message = userRepository.insertUser(user);

        // Assert the expected behavior
        Assert.assertEquals("user created successfully", message);

        // Verify interactions with the mocks
        verify(session).save(user);
        verify(session).close();
    }

    @Test
    public void AddBookExceptionTest() {
        when(session.save(any())).thenThrow(new HibernateException("something went wrong"));
        String message = userRepository.insertUser(user);

        Assert.assertEquals("something went wrong.users couldnt be created successfully", message);

        verify(session).save(user);
        verify(session).close();
    }

    

    @Test
    public void getAllBooksTest(){
        List<User> users = new LinkedList<>();
        users.add(user);
        users.add(user2); 
        String expectedHql = "from User";
        when(session.createQuery(anyString())).thenReturn( query);
        when(query.getResultList()).thenReturn(users);


        
         users =  userRepository.getAllUsers();
         verify(session).createQuery(expectedHql);
         
         Assert.assertArrayEquals(users.toArray(new User[0]), users.toArray(new User[0]));
    }



    @Test
    public void getAllBooksExceptionTest(){
        List<User> users = new LinkedList<>();
        users.add(user);
        users.add(user2); 
        when(session.createQuery(anyString())).thenReturn( query);
        when(query.getResultList()).thenThrow(new RuntimeException());



         users =  userRepository.getAllUsers();
         Assert.assertNull(users);
    }


        @Test
    public void testGetAllUsersWithBookIds() {
        // Given
        Integer[] bookidIntegers = {1};
        String expectedHql = "Select u from User u join u.books b where b.id = 1";

        when(sessionFactory.openSession()).thenReturn(session);
        when(session.createQuery(expectedHql)).thenReturn(query);
        when(query.getResultList()).thenReturn(Arrays.asList(new User(), new User())); // Replace with actual User objects as needed

        
        List<User> result = userRepository.getAllUsers(bookidIntegers);


        
        verify(session).createQuery(expectedHql);
      
        verify(session).close();
        assertNotNull(result);
        assertEquals(2, result.size());
    }
}
