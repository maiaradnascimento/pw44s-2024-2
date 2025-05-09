package br.edu.utfpr.pb.pw44s.server.controller;

import br.edu.utfpr.pb.pw44s.server.dto.OrderDTO;
import br.edu.utfpr.pb.pw44s.server.model.Order;
import br.edu.utfpr.pb.pw44s.server.service.ICrudService;
import br.edu.utfpr.pb.pw44s.server.service.IOrderService;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("order")
public class OrderController extends CrudController<Order, OrderDTO, Long> {
    private static IOrderService orderService;
    private static ModelMapper modelMapper;

    public OrderController(IOrderService orderService, ModelMapper modelMapper) {
        super(Order.class, OrderDTO.class);
        OrderController.orderService = orderService;
        OrderController.modelMapper = modelMapper;
    }

    @Override
    protected ICrudService<Order, Long> getService() {
        return orderService;
    }

    @Override
    protected ModelMapper getModelMapper() {
        return modelMapper;
    }

    @GetMapping("/user/{userId}")
    public List<OrderDTO> findAllByUser(@PathVariable Long userId) {
        List<Order> orders = orderService.findAllByUser(userId);
        return orders.stream()
                .map(order -> modelMapper.map(order, OrderDTO.class))
                .toList();
    }
}
