package com.zdm.mpdemo.bean;


import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.Version;
import lombok.Data;

import java.util.Date;

@Data
public class User {
    private Long id; //主键
    private String name; //姓名
    private String email; //邮箱
    private Integer age; //年龄
    @TableField(fill = FieldFill.INSERT) //添加自动填充，在插入时使用
    private Date createTime; //创建时间
    @TableField(fill = FieldFill.INSERT_UPDATE) //添加自动填充，在插入和修改时使用
    private Date updateTime; //更新时间
    @Version //mp实现乐观锁的注解
    @TableField(fill = FieldFill.INSERT) //添加自动填充，在插入时使用
    private Integer version; //实现乐观锁的版本号
    @TableLogic //mp自带的逻辑删除注解
    private Integer deleted; //删除标志


//    public void setId(Long id) {
//        this.id = id;
//    }
//    public void setName(String name) {
//        this.name = name;
//    }
//    public void setEmail(String email) {
//        this.email = email;
//    }
//    public void setAge(Integer age) {
//        this.age = age;
//    }
}
