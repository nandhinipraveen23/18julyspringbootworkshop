package hackforge.emprestapi.serviceimplementation;

import hackforge.emprestapi.dto.EmployeeDto;
import hackforge.emprestapi.dto.EmployeeLoginDto;
import hackforge.emprestapi.entities.Employee;
import hackforge.emprestapi.exception.InvalidUser;
import hackforge.emprestapi.exception.StudentNotFoundException;
import hackforge.emprestapi.repository.EmployeeRepository;
import hackforge.emprestapi.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImplementation implements EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    public Employee dtoToEntity(EmployeeDto employeeDto)
    {
        Employee emp = new Employee();
        emp.setName(employeeDto.getName());
        emp.setEmail(employeeDto.getEmail());
        emp.setPassword(employeeDto.getPassword());
    return emp;
    }

    public EmployeeDto entityToDto(Employee e){
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setEmpno(e.getEmpno());
        employeeDto.setName(e.getName());
        employeeDto.setEmail(e.getEmail());
        employeeDto.setPassword(e.getPassword());
    return  employeeDto;
    }
    @Override
    public EmployeeDto inserEmployee(EmployeeDto employeeDto) {

        Employee   emp=dtoToEntity(employeeDto);

     Employee res=   employeeRepository.save(emp);
     employeeDto.setEmpno(res.getEmpno());
        return employeeDto;
    }

    @Override
    public List<EmployeeDto> getAllEmployee() {
      // sumit, jay, abi
     List<Employee>allEmp=   employeeRepository.findAll();

     List<EmployeeDto> allEmpDto= new ArrayList<>();

     for(Employee e :allEmp )
     {
         EmployeeDto employeeDto =entityToDto(e);

         allEmpDto.add(employeeDto);
     }


     return allEmpDto;
    }

    @Override
    public EmployeeDto getEmpByNo(Integer empno) {


     Employee res=    employeeRepository.findById(empno)
             .orElseThrow(()->new StudentNotFoundException("Empno not Found"));
     EmployeeDto employeeDto = entityToDto(res);
     return employeeDto;
    }

    @Override
    public void deleteEmpByNo(Integer empno) {
        Employee res=    employeeRepository.findById(empno)
                .orElseThrow(()->new StudentNotFoundException("Empno not Found"));
        employeeRepository.delete(res);
    }

    @Override
    public EmployeeDto updateEmp(EmployeeDto employeeDto) {

        /*
       sumit, sumit@gmail, null
         */
        Employee oldEmp=    employeeRepository.findById(employeeDto.getEmpno())
                .orElseThrow(()->new StudentNotFoundException("Empno not Found"));

        if(employeeDto.getName()!=null)
        {
            oldEmp.setName(employeeDto.getName());
        }
        if(employeeDto.getEmail()!=null)
        {
            oldEmp.setEmail(employeeDto.getEmail());
        }
        if(employeeDto.getPassword()!=null)
        {
            oldEmp.setPassword(employeeDto.getPassword());
        }

        Employee updatedEmp=   employeeRepository.save(oldEmp);
        EmployeeDto employeeDto1= entityToDto(updatedEmp);
        return employeeDto1;
    }

    @Override
    public void checkLogin(EmployeeLoginDto employeeLoginDto) {

        employeeRepository.login(employeeLoginDto.getEmail(),employeeLoginDto.getPassword())
                .orElseThrow(()->new InvalidUser("invalid creditials"));
    }
}
