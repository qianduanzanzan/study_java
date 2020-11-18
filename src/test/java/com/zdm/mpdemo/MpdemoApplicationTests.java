package com.zdm.mpdemo;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zdm.mpdemo.bean.User;
import com.zdm.mpdemo.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class MpdemoApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void findAll() {
        List<User> users = userMapper.selectList(null);
        System.out.println(users);
    }

    @Test
    public void addUser() {
        User user = new User();
        user.setId(3L);
        user.setName("小华3");
        user.setAge(21);
        user.setEmail("666666qweqasw7@qq.com");
        int insert = userMapper.insert(user);
        System.out.println(insert);
    }

    @Test
    public void updateUser() {
        User user = new User();
        user.setId(1328193003412590594L);
        user.setName("小明");
        user.setAge(24);
        user.setEmail("1248965034@qq.com");
        int insert = userMapper.updateById(user);
        System.out.println(insert);
    }

    //测试乐观锁
    @Test
    public void testlgs() {
        User user = userMapper.selectById(1328193003412590594L);
        user.setAge(240);
        int insert = userMapper.updateById(user);
        System.out.println(insert);
    }

    @Test
    public void testSelectDemo() {
        List<User> users = userMapper.selectBatchIds(Arrays.asList(1L, 2L, 3L));
        System.out.println(users);
    }

    //测试分页
    @Test
    public void testPagenation() {
        Page<User> iPage = new Page<>(1, 2);
        Page<User> userIPage = userMapper.selectPage(iPage, null);
        System.out.println(userIPage);

        System.out.println(iPage.getCurrent());
        System.out.println(iPage.getRecords());
        System.out.println(iPage.getSize());
        System.out.println(iPage.getTotal());
        System.out.println(iPage.getPages());

        System.out.println(iPage.hasNext());
        System.out.println(iPage.hasPrevious());


    }

    //测试逻辑删除
    @Test
    public void ljDelete() {
        int i = userMapper.deleteById(2L);
        System.out.println(i);
    }

}
