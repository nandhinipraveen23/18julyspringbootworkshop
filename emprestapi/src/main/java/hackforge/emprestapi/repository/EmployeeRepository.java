package hackforge.emprestapi.repository;

import hackforge.emprestapi.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository  extends JpaRepository<Employee,Integer> {
//select * from emptbl where email=empEmail and password=empPassword
@Query("select s from Employee s where s.email=:empEmail and s.password=:empPassword")
public Optional<Employee> login(String empEmail, String empPassword);
}
