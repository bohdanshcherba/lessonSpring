package ua.lviv.iot.lesson.service;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;
import ua.lviv.iot.lesson.dal.OrderRepository;
import ua.lviv.iot.lesson.exception.OrderNotFoundException;
import ua.lviv.iot.lesson.models.Order;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repository;

    public List<Order> getOrders() {

        return repository.findAll();
    }

    public Order addOrder(Order order) {

        return repository.save(order);
    }

    public Order updateOrder(Order order) {
        if (repository.existsById(order.getId())) {
            return repository.save(order);
        }
        throw  new OrderNotFoundException("Order with " + order.getId() + "not found");
    }



    public Order getOrder(Integer id) {
        return repository.findById(id).orElseThrow();
    }
}

