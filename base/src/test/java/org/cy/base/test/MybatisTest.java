package org.cy.base.test;

import org.cy.base.domain.User;
import org.cy.base.mapper.UserMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MybatisTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void test() {
        userMapper.insert("zs", 19);
        userMapper.insert("lisa", 18);
        User user = userMapper.findUserByName("lisa");
        Assert.assertEquals(new Integer(18), user.getAge());
    }
}
