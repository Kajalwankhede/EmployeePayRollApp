package com.example.employeepayrollapp.Controller;
import com.example.employeepayrollapp.DTO.EmployeePayrollDTO;
import com.example.employeepayrollapp.DTO.ResponseDTO;
import com.example.employeepayrollapp.Model.EmployeePayrollData;
import com.example.employeepayrollapp.Service.IEmployeePayrollService;
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

 @RequestMapping(value = {"", "/", "/get"})
  public ResponseEntity<ResponseDTO> getEmployeePayrollData() {
     List<EmployeePayrollData> empDataList=null;
     empDataList=iEmployeePayrollService.getEmployeePayrollData();
     ResponseDTO responseDTO = new ResponseDTO("Get Call Successful", empDataList);
         return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
 }
@GetMapping("/get/{empId}")
    public ResponseEntity<ResponseDTO> getEmployeePayrollData(@PathVariable("empId") int empId) {
        EmployeePayrollData empData = null;
        empData =  iEmployeePayrollService.getEmployeePayrollDataById(empId);
        ResponseDTO responseDTO = new ResponseDTO("Get Call Successful", empData);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
 }
 @PostMapping("/create")
     public ResponseEntity<ResponseDTO> addEmployeePayrollData(@RequestBody EmployeePayrollDTO employeePayrollDTO) {
         EmployeePayrollData empData = null;
         empData = iEmployeePayrollService.createEmployeePayrollData(employeePayrollDTO);
         ResponseDTO responseDTO = new ResponseDTO("Created Employee Payroll Data Successfully", empData);
         return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
 }

 @PutMapping("update")
  public ResponseEntity<ResponseDTO> updateEmployeePayrollData(@RequestBody EmployeePayrollDTO employeePayrollDTO) {
    EmployeePayrollData empData = null;
    empData = new EmployeePayrollData(1, employeePayrollDTO);
    ResponseDTO responseDTO = new ResponseDTO("Updated Employee Payroll Data for: " , empData);
     return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
 }


 @DeleteMapping("/delete/{empId}")
 public ResponseEntity<ResponseDTO> deleteEmployeePayrollData(@PathVariable("empId") int empId) {
         ResponseDTO responseDTO = new ResponseDTO("Delete call success for Id: " , empId);
         return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);

     }
}