package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Orders;
import za.ac.cput.repository.OrdersRepository;

import java.util.List;

@Service
public class OrdersService implements IService<Orders, Long>{

    @Autowired
    private final OrdersRepository ordersRepository;

    public OrdersService(OrdersRepository ordersRepository) {
        this.ordersRepository = ordersRepository;
    }


    @Override
    public Orders create(Orders orders) {
        return ordersRepository.save(orders);
    }

    @Override
    public Orders read(Long aLong) {
        return ordersRepository.findById(aLong).orElseThrow(() -> new IllegalStateException("Order with Id " +
                aLong + " does not exist"));
    }

    @Override
    public Orders update(Orders orders) {
        if (ordersRepository.existsById(orders.getOrderId())){
            return ordersRepository.save(orders);
        } else {
            throw new IllegalStateException("Order with Id " + orders.getOrderId() + " does not exist");
        }
    }

    @Override
    public boolean delete(Long d) {
        if (ordersRepository.existsById(d)){
            ordersRepository.deleteById(d);
            return true;
        } else {
            throw new IllegalStateException("Order with Id " + d + " does not exist");
        }
    }

    @Override
    public List<Orders> getAll() {
        return ordersRepository.findAll();
    }
}
