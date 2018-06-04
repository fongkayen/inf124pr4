package com.uci.rest.service;

import com.uci.rest.db.DatabaseConnector;
import com.uci.rest.db.DatabaseUtils;
import com.uci.rest.model.Todo;
import com.uci.rest.model.Order;
import com.uci.rest.model.Cart;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class OrderService {
    private final static String ALL_ORDERS_QUERY = "SELECT * FROM ORDERS";

    public static Cart getOrderByCartId(int id) {
        //Get a new connection object before going forward with the JDBC invocation.
        Connection connection = DatabaseConnector.getConnection();
        ResultSet resultSet = DatabaseUtils.retrieveQueryResults(connection, ALL_ORDERS_QUERY + " WHERE CART_ID = " + id);

        Cart myCart = new Cart();
        
        if (resultSet != null) {
            try {
                while (resultSet.next()) {
                    myCart.addOrder(new Order());

                    Order order = new Order();
                    order.setCartid(resultSet.getInt("cart_id"));
                    order.setProductid(resultSet.getInt("product_id"));
                    order.setPrice(resultSet.getInt("price"));
                    order.setFirstname(resultSet.getInt("first_name"));
                    order.setLastname(resultSet.getInt("last_name"));
                    order.setEmail(resultSet.getInt("email"));
                    order.setAddress1(resultSet.getInt("address_one"));
                    order.setAddress2(resultSet.getInt("address_two"));
                    order.setState(resultSet.getInt("state"));
                    order.setCity(resultSet.getInt("city"));
                    order.setZipcode(resultSet.getInt("zipcode"));
                    order.setPhone(resultSet.getInt("phone"));
                    order.setDeliverymethod(resultSet.getInt("delivery_method"));
                    order.setNameoncard(resultSet.getInt("name_on_card"));
                    order.setCardnumber(resultSet.getInt("card_number"));
                    order.setExpirymonth(resultSet.getInt("expiry_month"));
                    order.setExpiryyear(resultSet.getInt("expiry_year"));
                    order.setSecuritycode(resultSet.getInt("security_code"));
                    
                    myCart.addOrder(order);
                }
                
                return myCart;
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    // We will always close the connection once we are done interacting with the Database.
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return null;
    }

//    public static List<Todo> getAllTodos() {
//        List<Todo> todos = new ArrayList<Todo>();
//
//        Connection connection = DatabaseConnector.getConnection();
//        ResultSet resultSet = DatabaseUtils.retrieveQueryResults(connection, ALL_ORDERS_QUERY);
//
//        if (resultSet != null) {
//            try {
//                while (resultSet.next()) {
//                    Todo todo = new Todo();
//
//                    todo.setId(resultSet.getInt("TODO_ID"));
//                    todo.setDescription(resultSet.getString("TODO_DESC"));
//                    todo.setSummary(resultSet.getString("TODO_SUMMARY"));
//
//                    todos.add(todo);
//
//                }
//            } catch (SQLException e) {
//                e.printStackTrace();
//            } finally {
//                try {
//                    connection.close();
//                } catch (SQLException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//
//        return todos;
//    }

    public static boolean AddOrder(Order order) {

        String sql = "INSERT INTO ORDERS  (cart_id, product_id, price, first_name, last_name, email, address_one, address_two,"
                + "state, city, zipcode, phone, delivery_method, name_on_card, card_number, expiry_month, expiry_year, security_code)" +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        Connection connection = DatabaseConnector.getConnection();
        return DatabaseUtils.performDBUpdate(connection, sql, order.getCartid(), order.getProductid(),
                order.getPrice(), order.getFirstname(), order.getLastname(), order.getEmail(), order.getAddress1(),
                order.getAddress2(), order.getState(), order.getCity(), order.getZipcode(), order.getPhone(), order.getDeliverymethod(),
                order.getNameoncard(), order.getCardnumber(), order.getExpirymonth(), order.getExpiryyea(), order.getSecuritycode()); //Kayen copy-paste params

    }

    public static boolean updateTodo(Order order) {

        String sql = "UPDATE TODOS SET cart_id=?, product_id=?, price=?, first_name=?, last_name=?, email=?, address_one=?, address_two=?,"
                + "state=?, city=?, zipcode=?, phone=?, delivery_method=?, name_on_card=?, card_number=?, expiry_month=?, expiry_year=?, security_code=?;";

        Connection connection = DatabaseConnector.getConnection();

        boolean updateStatus = DatabaseUtils.performDBUpdate(connection, sql, todo.getSummary(), todo.getDescription(),
                String.valueOf(todo.getId())); //Kayen copy-paste params

        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return updateStatus;

    }

    public static boolean deleteTodo(Todo retrievedTodo) {

        String sql = "DELETE FROM TODOS WHERE TODO_ID=?;";

        Connection connection = DatabaseConnector.getConnection();

        boolean updateStatus = DatabaseUtils.performDBUpdate(connection, sql, String.valueOf(retrievedTodo.getId()));

        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return updateStatus;
    }
}
