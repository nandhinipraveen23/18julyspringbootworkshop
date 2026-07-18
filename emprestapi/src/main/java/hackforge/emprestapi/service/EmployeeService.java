package hackforge.emprestapi.service;

import hackforge.emprestapi.dto.EmployeeDto;
import hackforge.emprestapi.dto.EmployeeLoginDto;

import java.util.List;

public interface EmployeeService {
public EmployeeDto inserEmployee(EmployeeDto employeeDto);
public List<EmployeeDto> getAllEmployee();

public EmployeeDto getEmpByNo(Integer empno);

public void deleteEmpByNo(Integer empno);

    public EmployeeDto  updateEmp(EmployeeDto employeeDto);

    public void checkLogin(EmployeeLoginDto employeeLoginDto);
}
