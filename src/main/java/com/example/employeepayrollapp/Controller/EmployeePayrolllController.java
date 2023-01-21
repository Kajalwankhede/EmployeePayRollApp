package com.example.employeepayrollapp.Controller;
import com.example.employeepayrollapp.DTO.EmployeePayrollDTO;
import com.example.employeepayrollapp.DTO.ResponseDTO;
import com.example.employeepayrollapp.Exception.EmployeePayrollException;
import com.example.employeepayrollapp.Model.EmployeePayrollData;
import com.example.employeepayrollapp.Service.IEmployeePayrollService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/employeepayrollservice")
public class EmployeePayrolllController {
    @Autowired
    private IEmployeePayrollService iEmployeePayrollService;
// Getting all the employee list
@GetMapping(value = {"", "/", "/getAll"})
    public ResponseEntity<ResponseDTO> getEmployeePayrollData() {
        List<EmployeePayrollData> empDataList = null;
        empDataList = iEmployeePayrollService.getEmployeePayrollData();
        ResponseDTO respDTO = new ResponseDTO("Get Call Success", empDataList);
        return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
    }

 // Getting Department wise employee list using department
 @GetMapping("/getdepartment/{department}")
    public ResponseEntity<ResponseDTO> getDepartmentById(@PathVariable("department") String department){
        List<EmployeePayrollData> empDataList = null;
        empDataList =iEmployeePayrollService.getEmployeePayrollByDepartment(department);
        ResponseDTO respDTO = new ResponseDTO("Get call success", empDataList);
        return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
 }

 // Getting employee details by id from the Database
@GetMapping("/getdata/{empId}")
    public ResponseEntity<ResponseDTO> getEmployeePayrollData(@PathVariable("empId") int empId) {
        EmployeePayrollData empPayrollData = null;
        empPayrollData = iEmployeePayrollService.getEmployeePayrollDataById(empId);
        ResponseDTO respDTO = new ResponseDTO("Get Call for Id Successfull", empPayrollData);
        return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
}

// Creating an Employee Data and save to Database
@PostMapping("/create")
    public ResponseEntity<ResponseDTO> createEmployeePayrollData(@Valid @RequestBody EmployeePayrollDTO empPayrollDTO) {
        EmployeePayrollData empData = null;
        empData = iEmployeePayrollService.createEmployeePayrollData(empPayrollDTO);
        ResponseDTO respDTO = new ResponseDTO("Created Employee Payroll Data Successfully", empData);
        return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
    }

// Updating an Employee Details by using id from Database
@PutMapping(path = "/update/{empId}")
    public ResponseEntity<ResponseDTO> updateEmployeePayrollData(@Valid @PathVariable("empId") int empId,
                                                                 @RequestBody EmployeePayrollDTO empPayrollDTO) {
    EmployeePayrollData empData = null;
        empData = iEmployeePayrollService.updateEmployeePayrollData(empId, empPayrollDTO);
        ResponseDTO respDTO = new ResponseDTO("Updated Employee payroll Data for: ", empData);
        return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
 }

// Deleting an Employee Details using id from the Database
    @DeleteMapping("/delete/{empId}")
    public ResponseEntity<ResponseDTO> deleteEmployeePayrollData(@PathVariable("empId") int empId) {
        iEmployeePayrollService.deleteEmployeePayrollDTO(empId);
        ResponseDTO respDTO = new ResponseDTO("Deleted Successfully", "Deleted id: " + empId);
        return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
    }
}