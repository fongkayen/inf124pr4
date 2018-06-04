package com.uci.rest.service;

import com.uci.rest.db.DatabaseConnector;
import com.uci.rest.db.DatabaseUtils;
import com.uci.rest.model.Todo;
import com.uci.rest.model.Order;
import com.uci.rest.model.Cart;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;


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
                    order.setCartID(resultSet.getInt("cart_id"));
                    order.setProductID(resultSet.getInt("product_id"));
                    order.setPrice(resultSet.getInt("price"));
                    order.setFirstName(resultSet.getString("first_name"));
                    order.setLastName(resultSet.getString("last_name"));
                    order.setEmail(resultSet.getString("email"));
                    order.setAddress1(resultSet.getString("address_one"));
                    order.setAddress2(resultSet.getString("address_two"));
                    order.setState(resultSet.getString("state"));
                    order.setCity(resultSet.getString("city"));
                    order.setZipcode(resultSet.getString("zipcode"));
                    order.setPhone(resultSet.getString("phone"));
                    order.setDeliverymethod(resultSet.getString("delivery_method"));
                    order.setNameoncard(resultSet.getString("name_on_card"));
                    order.setCardnumber(resultSet.getString("card_number"));
                    order.setExpirymonth(resultSet.getString("expiry_month"));
                    order.setExpiryyear(resultSet.getString("expiry_year"));
                    order.setSecuritycode(resultSet.getString("security_code"));
                    
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
        return DatabaseUtils.performDBUpdate(connection, sql, Integer.toString(order.getCartID()), Integer.toString(order.getProductID()),
                Integer.toString(order.getPrice()), order.getFirstName(), order.getLastName(), order.getEmail(), order.getAddress1(),
                order.getAddress2(), order.getState(), order.getCity(), order.getZipcode(), order.getPhone(), order.getDeliverymethod(),
                order.getNameoncard(), order.getCardnumber(), order.getExpirymonth(), order.getExpiryyear(), order.getSecuritycode()); //Kayen copy-paste params

    }

    public static boolean updateTodo(Order order) {

        String sql = "UPDATE TODOS SET cart_id=?, product_id=?, price=?, first_name=?, last_name=?, email=?, address_one=?, address_two=?,"
                + "state=?, city=?, zipcode=?, phone=?, delivery_method=?, name_on_card=?, card_number=?, expiry_month=?, expiry_year=?, security_code=?;";

        Connection connection = DatabaseConnector.getConnection();

        boolean updateStatus = DatabaseUtils.performDBUpdate(connection, sql, Integer.toString(order.getCartID()), Integer.toString(order.getProductID()),
                Integer.toString(order.getPrice()), order.getFirstName(), order.getLastName(), order.getEmail(), order.getAddress1(),
                order.getAddress2(), order.getState(), order.getCity(), order.getZipcode(), order.getPhone(), order.getDeliverymethod(),
                order.getNameoncard(), order.getCardnumber(), order.getExpirymonth(), order.getExpiryyear(), order.getSecuritycode());
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
