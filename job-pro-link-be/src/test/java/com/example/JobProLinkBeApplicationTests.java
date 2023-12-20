package com.example;

import com.example.sys.entity.Users;
import com.example.sys.mapper.UsersMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
class JobProLinkBeApplicationTests {

    @Resource
    private UsersMapper usersMapper;
    @Test
    void testMapper() {
        List<Users> usersList = usersMapper.selectList(null);
        usersList.forEach(System.out::println);
    }

}
