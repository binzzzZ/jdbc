package com.sys.jdbctemplate;

import com.sys.entity.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class UserDao {
    private JdbcTemplate template = new JdbcTemplate(JdbcTemplateUtil.getDataSource());

    public static void main(String[] args) {
        UserDao userDao = new UserDao();

        //查询所有数据
//        userDao.listUser().forEach(n -> System.out.println(n));

        //分页查询
        userDao.listUser2(50, 1, 3).forEach(n -> System.out.println(n));

        //查询一行数据
//        User user = userDao.selectUser(1);
//        System.out.println(user);

        //添加数据
//        User user = new User();
//        user.setName("孙悟空");
//        user.setAge(1000);
//        user.setSex("1");
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
//        user.setCreateTime(sdf.format(new Date()));
//
//        userDao.addUser(user);

        //删除数据
//        userDao.deleteUser(11);

        //修改数据
//        userDao.updateUser(9);
    }

    private void updateUser(Integer id) {
        String sql = "update sys_user set name ='马小跳' where id =?";
        template.update(sql, id);
    }

    private void deleteUser(Integer id) {
        String sql = "delete from sys_user where id=?";
        template.update(sql, id);
    }

    private void addUser(User user) {
        String sql = "insert into sys_user(name,age,sex,create_time) values( ?,?,?,?)";
        template.update(sql, user.getName(), user.getAge(), user.getSex(), user.getCreateTime());
    }

    private List<User> listUser() {
        String sql = "select * from sys_user";
        return template.query(sql, new BeanPropertyRowMapper<>(User.class));
    }

    private List<User> listUser2(Integer age, Integer page, Integer pageSize) {
        String sql = "select * from sys_user where age>? limit ?,?";
        return template.query(sql, new BeanPropertyRowMapper<>(User.class), age, page, pageSize);
    }

    private User selectUser(Integer id) {
        String sql = "select * from sys_user where id=?";
        return template.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), id);
    }

}
