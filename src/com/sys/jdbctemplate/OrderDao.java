package com.sys.jdbctemplate;

import com.sys.entity.Order;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class OrderDao {
    private JdbcTemplate template = new JdbcTemplate(JdbcTemplateUtil.getDataSource());

    public static void main(String[] args) {
        OrderDao dao = new OrderDao();
        Order order = new Order();
//        添加数据
//        for (int i = 0; i < 10; i++) {
//            dao.addOrder(i % 2 + 1, String.valueOf(i), "201911081111", String.valueOf(i));
//        }

        //查询数据
        List<Order> list1 = dao.list(order, 1);
        List<Order> list2 = dao.list(order, 2);

        list1.addAll(list2);
        list1.forEach(System.out::println);
    }

    public List<Order> list(Order order, Integer index) {
        String sql = "select * from order_?";
        return template.query(sql, new BeanPropertyRowMapper<>(Order.class), index);
    }

    public void addOrder(Integer index, String id, String number, String userId) {
        String sql = "insert into order_? values(?,?,?)";
        template.update(sql, index, id, number, userId);
    }
}
