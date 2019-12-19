package com.galaxy.springboot;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.test.context.junit4.SpringRunner;

import com.galaxy.springboot.entity.Student;
import com.galaxy.springboot.entity.TbUser;
import com.galaxy.springboot.mapper.TbUserMapper;

@RunWith(SpringRunner.class)
@MapperScan(basePackages= {"com.galaxy.springboot.mapper"}) //扫描com.galaxy.springboot.mapper包下添加@Mapper注解的类，
@SpringBootTest(classes = {HelloWorldApplication.class})
public class testMybatis {

	@Resource    // 自动注入，spring boot会帮我们实例化一个对象
    private TbUserMapper tbUserMapper;

    @Test
    public void mybatisTest(){
        List<TbUser> lists = tbUserMapper.selectByExample(null);
        for (TbUser tbUser : lists) {
			System.out.println(tbUser);
		}
    }
    
   

}
