package onetoone.Users;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * @author Peter Yehl
 */

 @Tag(name = "Employee", description = "Employee API")
 @RestController
public class EmployeeController {
    
    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    LoginInfoRepository loginInfoRepository;

    private String success = "{\"message\":\"success\"}";
    private String failure = "{\"message\":\"failure\"}";

    @Operation(summary = "Get all Employees")
    @GetMapping(path = "/employees")
    List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }

    @Operation(summary = "Get employee by LoginInfo")
    @GetMapping(path = "/employee/{id}")
    Employee getEmployeeByLoginId(@PathVariable int id){
        return employeeRepository.findByLoginInfoId(id);
    }

    @Operation(summary = "Get a specific Employee by their ID")
    @GetMapping(path = "/employees/{id}")
    Employee getEmployeeById(@PathVariable int id){return employeeRepository.findById(id);}

    @Operation(summary = "Get a specific Employee by their name")
    @GetMapping(path = "/employeesbyname/{name}")
    Employee getEmployeeByName(@PathVariable String name){return employeeRepository.findByName(name);}

    @Operation(summary = "Create a new Employee")
    @PostMapping(path = "/employees")
    String createEmployee(@RequestBody Employee employee){
        if (employee == null)
            return failure;
        employeeRepository.save(employee);
        return success;
    }

    @Operation(summary = "Change a specific Employee")
    @PutMapping("/employees/{id}")
    Employee updateEmployee(@PathVariable int id, @RequestBody Employee request){
        Employee user = employeeRepository.findById(id);
        if(user == null)
            return null;
        if(request.getName() != null){
            user.setName(request.getName());
        }
        employeeRepository.save(user);
        return employeeRepository.findById(id);
    }

    @Operation(summary = "Delete a specific Employee")
    @DeleteMapping(path = "/employees/{id}")
    String deleteEmployee(@PathVariable int id){
        Employee employee = employeeRepository.findById(id);
        employee.setOrders(null);
        LoginInfo loginInfo = employee.getLoginInfo();
        loginInfoRepository.deleteById(loginInfo.getId());
        employeeRepository.deleteById(id);
        return success;
    }
}
