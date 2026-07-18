package hackforge.emprestapi.controller;

import hackforge.emprestapi.dto.EmployeeDto;
import hackforge.emprestapi.dto.EmployeeLoginDto;
import hackforge.emprestapi.exception.ResponseMsg;
import hackforge.emprestapi.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;
    @PostMapping("/emp")
    public ResponseEntity<EmployeeDto> addEmployee(@RequestBody EmployeeDto employeeDto)
    {
        EmployeeDto res=     employeeService.inserEmployee(employeeDto);
    return new ResponseEntity<EmployeeDto>(res, HttpStatus.CREATED);

    }

    @PutMapping("/edit")
    public ResponseEntity<EmployeeDto> editEmployee(@RequestBody EmployeeDto employeeDto)
    {
        EmployeeDto res=     employeeService.updateEmp(employeeDto);
        return new ResponseEntity<EmployeeDto>(res, HttpStatus.CREATED);

    }

    @GetMapping("/allemp")
        public ResponseEntity< List<EmployeeDto>> fetchAllEmployee(){
     List<EmployeeDto> res= employeeService.getAllEmployee();

     return new ResponseEntity<List<EmployeeDto>>(res,HttpStatus.OK);
    }

    @GetMapping("/emp/{empno}")
    public ResponseEntity<EmployeeDto> fetchEmpByNo(@PathVariable Integer empno)
    {
         EmployeeDto employeeDto=  employeeService.getEmpByNo(empno);

         return new ResponseEntity<EmployeeDto>(employeeDto,HttpStatus.OK);
    }

    @DeleteMapping("/delemp/{empno}")
    public ResponseEntity<ResponseMsg> delEmp(@PathVariable Integer empno)
    {
        employeeService.deleteEmpByNo(empno);
        return  ResponseEntity.ok(new ResponseMsg("Deleted Successfully"));
    }

    @PostMapping("/login")
    public ResponseEntity<ResponseMsg> checkUser(@RequestBody EmployeeLoginDto employeeLoginDto)
    {
        employeeService.checkLogin(employeeLoginDto);
        return ResponseEntity.ok(new ResponseMsg("Login Success"));
    }
}
