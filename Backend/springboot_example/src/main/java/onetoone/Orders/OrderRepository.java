package onetoone.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

public class OrderRepository extends JpaRepository<Order, Long> {
    Order findById(int id);

    List<Order> findAllByEmployee_Id(int id);

    List<Order> findAllByDate(String date);

    @Transactional
    void deleteById(int id);

    Order findByEmployee_Id(int id);
}