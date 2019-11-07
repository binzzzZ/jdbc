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
        userDao.listUser2(50, 3).forEach(n -> System.out.println(n));

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

    /*
      update、delete、insert DML update()，select ->query
     */

    /**
     * 根据ID修改数据
     * @param id ID
     */
    private void updateUser(Integer id) {
        String sql = "update sys_user set name ='马小跳' where id =?";
        template.update(sql, id);
    }

    /**
     * 根据ID删除数据
     * @param id ID
     */
    private void deleteUser(Integer id) {
        String sql = "delete from sys_user where id=?";
        template.update(sql, id);
    }

    /**
     * 添加一行数据
     * @param user 用户数据信息
     */
    private void addUser(User user) {
        String sql = "insert into sys_user(name,age,sex,create_time) values( ?,?,?,?)";
        template.update(sql, user.getName(), user.getAge(), user.getSex(), user.getCreateTime());
    }

    /**
     * 查询所有数据
     * @return 返回结果集
     */
    private List<User> listUser() {
        String sql = "select * from sys_user";
        return template.query(sql, new BeanPropertyRowMapper<>(User.class));
    }

    /**
     * 根据age
     * @param age 年龄
     * @param page 页
     * @return 返回查询结果集
     */
    private List<User> listUser2(Integer age, Integer page) {
        String sql = "select * from sys_user where age>? limit ?,3";
        return template.query(sql, new BeanPropertyRowMapper<>(User.class), age, page);
    }

    /**
     * 根据ID查询数据
     * @param id ID
     * @return 返回一个user
     */
    private User selectUser(Integer id) {
        String sql = "select * from sys_user where id=?";
        return template.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), id);
    }

}
