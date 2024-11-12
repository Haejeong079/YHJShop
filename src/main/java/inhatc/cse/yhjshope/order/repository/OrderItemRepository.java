package inhatc.cse.yhjshope.order.repository;

import inhatc.cse.yhjshope.order.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
