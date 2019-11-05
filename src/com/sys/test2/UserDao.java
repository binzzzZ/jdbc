package com.sys.test2;

import com.sys.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao {

    public static void main(String[] args) {
        //分页查询
        PageBean pageBean = new PageBean();
        pageBean.setPage(3);
        findAll(pageBean).forEach(System.out::println);

        //添加数据
//        User user = new User();
//        user.setName("吴用");
//        user.setAge(53);
//        user.setSex("0");
//        Date date = new Date();
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
//        String dateStr = sdf.format(date);
//        user.setCreateTime(dateStr);
//
//        addUser(user);

        //删除数据
//        deleteUser(13);

        //修改数据
//        updateUser("马云");
    }

    private static void updateUser(String name) {
        Connection conn = DBUtil.getConn();
        PreparedStatement ps = null;
        String sql = "update sys_user set name ='马化腾' where name=?";

        try {
            ps = conn.prepareStatement(sql);
            ps.setObject(1, name);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(conn, ps, null);
        }
    }

    private static void deleteUser(Integer id) {
        Connection conn = DBUtil.getConn();
        PreparedStatement ps = null;
        String sql = "delete from sys_user where id=?";

        try {
            ps = conn.prepareStatement(sql);
            ps.setObject(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(conn, ps, null);
        }

    }

    private static void addUser(User user) {
        Connection conn = DBUtil.getConn();
        PreparedStatement ps = null;
        String sql = "insert into sys_user(name,age,sex,create_time) values( ?,?,?,?)";

        try {
            ps = conn.prepareStatement(sql);
            ps.setObject(1, user.getName());
            ps.setObject(2, user.getAge());
            ps.setObject(3, user.getSex());
            ps.setObject(4, user.getCreateTime());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(conn, ps, null);
        }
    }

    private static List<User> findAll(PageBean page) {
        List<User> list = new ArrayList<>();
        Connection conn = DBUtil.getConn();
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            String sql = "select * from sys_user where 1=1 limit ?,?";
            ps = conn.prepareStatement(sql);
            ps.setObject(1, (page.getPage() - 1) * (page.getPageSize()));
            ps.setObject(2, page.getPageSize());
            rs = ps.executeQuery();

            User user;
            while (rs.next()) {
                user = new User();

                Integer id = rs.getInt("id");
                String name = rs.getString("name");
                Integer age = rs.getInt("age");
                String sex = rs.getString("sex");
                String createTime = rs.getString("create_time");
                String delFlag = rs.getString("del_flag");

                user.setId(id);
                user.setName(name);
                user.setAge(age);
                user.setSex(sex);
                user.setCreateTime(createTime);
                user.setDelFlag(delFlag);

                list.add(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(conn, ps, rs);
        }
        return list;
    }

}
