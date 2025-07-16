package com.example.springbootfirst.services;

import com.example.springbootfirst.models.Employee;
import com.example.springbootfirst.repository.EmployeeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class EmployeeServiceTest {

    @Mock
    private EmployeeRepository employeeRepository;

    @InjectMocks
    private EmployeeService employeeService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetMethod() {
        Employee emp1 = new Employee();
        Employee emp2 = new Employee();

        when(employeeRepository.findAll()).thenReturn(Arrays.asList(emp1, emp2));

        // Assert: Validate that the service returns the expected number of employees
        List<Employee> result = employeeService.getMethod();

        assertEquals(2, result.size());
    }

    @Test
    void testAddMethod(){
        Employee e = new Employee();
        e.setEmpID(2);
        e.setName("Mukesh");
        e.setJob("SDE");

//        when(employeeRepository.findByEmpID(2)).thenReturn(e);
//
        Employee emp = employeeService.getEmployeeById(2);

//        String isAdded = employeeService.addEmployee(e);

        assertEquals("Mukesh", emp.getName());
//        assertEquals("Employee Added Successfully!!!", isAdded);
    }
}
