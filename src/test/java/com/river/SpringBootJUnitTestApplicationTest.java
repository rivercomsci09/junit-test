package com.river;

import com.river.dao.UserRepository;
import com.river.model.User;
import com.river.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootJUnitTestApplicationTest {

    @Autowired
    private UserService service;

    @MockBean
    private UserRepository repository;

    @Test
    public void getUserTest(){
        when(repository.findAll()).thenReturn(Stream.of(
                new User(376,"Daniel", 31, "USA"),
                new User(958, "Huy", 35, "UK"))
                .collect(Collectors.toList()));
        assertEquals(2, service.getUsers().size());
    }

    @Test
    public void getUserByAddressTest(){
        String address = "Bangalore";
        when(repository.findUserByAddress(address)).thenReturn(Stream.of(
                new User(376,"Daniel", 31, "USA")).collect(Collectors.toList())
        );
        assertEquals(1, service.getUserByAddress(address).size());
    }

    @Test
    public void saveUserTest(){
        User user = new User(999, "Pranya", 37, "Pune");
        when(repository.save(user)).thenReturn(user);
        assertEquals(user,service.addUser(user));
    }

    @Test
    public void deleteUserTest(){
        User user = new User(999, "Pranya", 37, "Pune");
        service.deleteUser(user);
        verify(repository, times(1)).delete(user);
    }
}
