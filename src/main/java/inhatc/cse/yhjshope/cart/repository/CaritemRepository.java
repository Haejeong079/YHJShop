package inhatc.cse.yhjshope.cart.repository;

import inhatc.cse.yhjshope.cart.entity.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CaritemRepository extends JpaRepository<CartItem,Long> {

}
