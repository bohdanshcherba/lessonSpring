package ua.lviv.iot.lesson.contollers;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.lviv.iot.lesson.exception.OrderNotFoundException;
import ua.lviv.iot.lesson.models.Order;
import ua.lviv.iot.lesson.service.OrderService;

import java.util.List;
import java.util.logging.Logger;


@RestController
@RequestMapping("/order")
public class OrderController {

    private static final Logger LOGGER = Logger.getLogger("ua.lviv.iot.lesson.contollers.OrderContoller");

    @Autowired(required = false)
    private OrderService orderService = new OrderService();


    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrder(@PathVariable(name = "id") Integer id) {
        try {
            return new ResponseEntity<Order>(orderService.getOrder(id), HttpStatus.OK);
        }catch (OrderNotFoundException e){
            LOGGER.severe("Order must create without ID");
            return new ResponseEntity<Order>(HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping()
    public List<Order> getOrders() {
        return orderService.getOrders();
    }

    @PutMapping
    public ResponseEntity<Order> createOrder(@RequestBody Order order) {

        if (order.getId() == null) {
            return new ResponseEntity<Order>(orderService.addOrder(order), HttpStatus.OK);
        }
        LOGGER.severe("Order must create without ID");
        return new ResponseEntity<Order>(HttpStatus.BAD_REQUEST);
    }

    @PostMapping
    public ResponseEntity<Order> updateOrder(@RequestBody Order order) {

        if (order.getId() == null){
            LOGGER.severe("bCant update order without id - null");
            return new ResponseEntity<Order>(HttpStatus.BAD_REQUEST);

        }

        try {
            return new ResponseEntity<Order>(orderService.updateOrder(order), HttpStatus.OK);

        }catch (OrderNotFoundException e){
            LOGGER.severe("Can`t update an order with" + order.getId());
            return new ResponseEntity<Order>(HttpStatus.NOT_FOUND);
        }

    }
}