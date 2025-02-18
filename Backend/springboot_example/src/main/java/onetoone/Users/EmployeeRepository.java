package onetoone.Users;

import org.springframework.data.jpa.repository.JpaRepository;

import jakarta.transaction.Transactional;

/**
 * @author Peter Yehl
 */

public interface EmployeeRepository extends JpaRepository<Employee, Long>{
    Employee findById(int id);

    @Transactional
    void deleteById(int id);

    Employee findByLoginInfoId(int login_info_id);

    Employee findByName(String name);
}
