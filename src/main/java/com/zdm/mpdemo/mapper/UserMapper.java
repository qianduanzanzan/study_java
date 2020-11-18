package com.zdm.mpdemo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zdm.mpdemo.bean.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper extends BaseMapper<User> {
}
