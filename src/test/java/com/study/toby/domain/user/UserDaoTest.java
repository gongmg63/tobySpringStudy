package com.study.toby.domain.user;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class UserDaoTest {
    private UserDao userDao;

    @BeforeEach
    void setUp() {
        userDao = new UserDao();
    }

    @AfterEach
    void tearDown() throws ClassNotFoundException, SQLException {
    }

    @Test
    void addAndGet() throws ClassNotFoundException, SQLException{
        //given
        User user = new User();
        user.setId("whiteShip");
        user.setName("백기선");
        user.setPassword("married");

        //when
        userDao.add(user);

        User user2 = userDao.get(user.getId());

        //then
        assertNotNull(user2, "조회된 사용자는 Null이 아니어야 함");
        assertEquals(user.getId(), user2.getId());
        assertEquals(user.getName(), user2.getName());
        assertEquals(user.getPassword(), user2.getPassword());

    }
}
