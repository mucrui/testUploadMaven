package com.galaxy.springboot;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.test.context.junit4.SpringRunner;

import com.galaxy.springboot.entity.Student;

@RunWith(SpringRunner.class)
//需要@SpringBootTest 实例化IOC容器 =>ApplicatioinContext ac = new ClassPathXMLApplicationContext("配置文件的地址")
//如果没有SpringBootTest注解，一定会报控制针异常。
@SpringBootTest(classes = {HelloWorldApplication.class})
public class testJDBC {

	@Resource    // 自动注入，spring boot会帮我们实例化一个对象
    private JdbcTemplate jdbcTemplate;   // 一个通过JDBC连接数据库的工具类，可以通过这个工具类对数据库进行增删改查

    @Test
    public void mySqlTest(){
        String sql = "select uid,username,password from tb_user";
        List<Student> students = jdbcTemplate.query(sql, new RowMapper<Student>() {
            @Override
            public Student mapRow(ResultSet resultSet, int i) throws SQLException {
                Student student = new Student();
                student.setUid(resultSet.getInt("uid"));
                student.setUsername(resultSet.getString("username"));
                student.setPassword(resultSet.getString("password"));
                return student;
            }
        });

        for (Student student : students) {
			System.out.println(student.toString());
		}
        
    }
    
    @Test
    public void testInsert() {
    	String sql = "insert into tb_user(username,password) values ('hehe','hehe')";
    	jdbcTemplate.update(sql);
    }
    
    @Test
    public void testDelete() {
    	String sql = "delete from tb_user where uid = 10";
    	jdbcTemplate.update(sql);
    }

}
