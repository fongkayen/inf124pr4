package com.uci.rest;

/**
 * Created by tariqibrahim on 5/28/17.
 */
import com.uci.rest.model.Cart;
import com.uci.rest.model.Order;
import com.uci.rest.model.Plushie;
import com.uci.rest.service.OrderService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * This class contains the methods that will respond to the various endpoints that you define for your RESTful API Service.
 *
 */
//todos will be the pathsegment that precedes any path segment specified by @Path on a method.
@Path("/plushies")
public class OrderResource {
    //This method represents an endpoint with the URL /todos/{id} and a GET request ( Note that {id} is a placeholder for a path parameter)
    @Path("cart_id")
    @GET
    @Produces( { MediaType.APPLICATION_JSON }) //This provides only JSON responses
    public Response getOrderByCartId(@PathParam("cart_id") int id/* The {id} placeholder parameter is resolved */) {
        //invokes the DB method which will fetch a todo_list item object by id
        Cart cart = OrderService.getOrderByCartId(id);

        //Respond with a 404 if there is no such todo_list item for the id provided
        if(cart == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        //Respond with a 200 OK if you have a todo_list_item object to return as response
        return Response.ok(cart).build();
    }

    @Path("plushie_id")
    @GET
    @Produces( { MediaType.APPLICATION_JSON }) //This provides only JSON responses
    public Response getProductById(@PathParam("plushie_id") int id/* The {id} placeholder parameter is resolved */) {
        //invokes the DB method which will fetch a todo_list item object by id
        Plushie product = OrderService.getProductById(id);

        //Respond with a 404 if there is no such todo_list item for the id provided
        if(product == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        //Respond with a 200 OK if you have a todo_list_item object to return as response
        return Response.ok(product).build();
    }
    //This method represents an endpoint with the URL /todos and a GET request.
    // Since there is no @PathParam mentioned, the /todos as a relative path and a GET request will invoke this method.
    @GET
    @Produces( { MediaType.APPLICATION_JSON })
    public Response getAllPlushies() {
        List<Plushie> productList = OrderService.getAllProducts();

        if(productList == null || productList.isEmpty()) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        return Response.ok(productList).build();
    }

    //This method represents an endpoint with the URL /todos and a POST request.
    // Since there is no @PathParam mentioned, the /todos as a relative path and a POST request will invoke this method.
    @POST
    @Consumes({MediaType.APPLICATION_JSON}) //This method accepts a request of the JSON type
    public Response addOrder(Order order) {

        //The todo object here is automatically constructed from the json request. Jersey is so cool!
        if(OrderService.AddOrder(order)) {
            return Response.ok().entity("Order Added Successfully").build();
        }

        // Return an Internal Server error because something wrong happened. This should never be executed
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();


    }

    //Similar to the method above.
    @POST
    @Consumes({MediaType.APPLICATION_FORM_URLENCODED}) //This method accepts form parameters.
    //If you were to send a POST through a form submit, this method would be called.
    public Response addOrder(@FormParam("cartID") int cartID,
                            @FormParam("productID") int productID,
                            @FormParam("price") int price,
                            @FormParam("firstName") String firstName,
                            @FormParam("lastName") String lastName,
                            @FormParam("email") String email,
                            @FormParam("address1") String address1,
                            @FormParam("address2") String address2,
                            @FormParam("state") String state,
                            @FormParam("city") String city,
                            @FormParam("zipcode") String zipcode,
                            @FormParam("phone") String phone,
                            @FormParam("deliverymethod") String deliverymethod,
                            @FormParam("nameoncard") String nameoncard,
                            @FormParam("cardnumber") String cardnumber,
                            @FormParam("expirymonth") String expirymonth,
                            @FormParam("expiryyear") String expiryyear,
                            @FormParam("securitycode") String securitycode) {
        Order order = new Order();

        order.setCartID(cartID);
        order.setProductID(productID);
        order.setPrice(price);
        order.setFirstName(firstName);
        order.setLastName(lastName);
        order.setEmail(email);
        order.setAddress1(address1);
        order.setAddress2(address2);
        order.setState(state);
        order.setCity(city);
        order.setZipcode(zipcode);
        order.setPhone(phone);
        order.setDeliverymethod(deliverymethod);
        order.setNameoncard(nameoncard);
        order.setCardnumber(cardnumber);
        order.setExpirymonth(expirymonth);
        order.setExpiryyear(expiryyear);
        order.setSecuritycode(securitycode);
                
        System.out.println(order);

        if(OrderService.AddOrder(order)) {
            return Response.ok().entity("ORDER Added Successfully").build();
        }

        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
    }

    //This method represents a PUT request where the id is provided as a path parameter and the request body is provided in JSON
    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public Response updateOrder(@PathParam("cart_id") int cartID, @PathParam("order_id") int order_id, Order order) {

        // Retrieve the todo that you will need to change
        Order retrievedOrder = OrderService.getOrder(cartID, order_id);

        if(retrievedOrder == null) {
            //If not found then respond with a 404 response.
            return Response.status(Response.Status.NOT_FOUND).
                    entity("We could not find the requested resource").build();
        }

        // This is the todo_object retrieved from the json request sent.
        order.setCartID(cartID);


        // if the user has provided null, then we set the retrieved values.
        // This is done so that a null value is not passed to the todo object when updating it.
        if(order.getFirstName() == null) {
            order.setFirstName(retrievedOrder.getFirstName());
        }
        if (order.getLastName() == null) {
            order.setLastName(retrievedOrder.getLastName());
        }
        if (order.getEmail() == null) {
            order.setEmail(retrievedOrder.getEmail());
        }
        if (order.getAddress1() == null) {
            order.setAddress1(retrievedOrder.getAddress1());
        }
        if (order.getAddress2() == null) {
            order.setAddress2(retrievedOrder.getAddress2());
        }
        if (order.getState() == null) {
            order.setState(retrievedOrder.getState());
        }
        if (order.getCity() == null) {
            order.setCity(retrievedOrder.getCity());
        }
        if (order.getZipcode() == null) {
            order.setZipcode(retrievedOrder.getZipcode());
        }
        if (order.getPhone() == null) {
            order.setPhone(retrievedOrder.getPhone());
        }
        if (order.getDeliverymethod() == null) {
            order.setDeliverymethod(retrievedOrder.getDeliverymethod());
        }
        if (order.getNameoncard() == null) {
            order.setNameoncard(retrievedOrder.getNameoncard());
        }
        if (order.getCardnumber() == null) {
            order.setCardnumber(retrievedOrder.getCardnumber());
        }
        if (order.getExpirymonth() == null) {
            order.setExpirymonth(retrievedOrder.getExpirymonth());
        }
        if (order.getExpiryyear() == null) {
            order.setExpiryyear(retrievedOrder.getExpiryyear());
        }
        if (order.getSecuritycode() == null) {
            order.setSecuritycode(retrievedOrder.getSecuritycode());
        }

        //Same as above. We only change fields in the todo_resource when the user has entered something in a request.

        //This calls the JDBC method which in turn calls the the UPDATE SQL command
        if(OrderService.updateOrder(order)) {

            return Response.ok().entity(order).build();
        }

        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();


    }

    //This method represents a DELETE request where the id is provided as a path parameter and the request body is provided in JSON
    @DELETE
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_FORM_URLENCODED, MediaType.APPLICATION_JSON})
    public Response deleteTodo(@PathParam("id") int id) {

        //Retrieve the todo_object that you want to delete.
        Todo retrievedTodo = TodoService.getTodoById(id);

        if(retrievedTodo == null) {
            //If not found throw a 404
            return Response.status(Response.Status.NOT_FOUND).
                    entity("We could not find the requested resource").build();
        }

        // This calls the JDBC method which in turn calls the DELETE SQL command.
        if(TodoService.deleteTodo(retrievedTodo)) {
            return Response.ok().entity("TODO Deleted Successfully").build();
        }

        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
    }
}