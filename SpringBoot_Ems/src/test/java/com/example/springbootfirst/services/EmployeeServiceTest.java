package com.example.springbootfirst.services;

import com.example.springbootfirst.models.Employee;
import com.example.springbootfirst.repository.EmployeeRepository;
import com.example.springbootfirst.repository.RolesRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class EmployeeServiceTest {

    @Mock
    private EmployeeRepository employeeRepository;

    @Mock
    private RolesRepository rolesRepository;

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

        List<Employee> result = employeeService.getMethod();

        assertEquals(2, result.size());
    }

    @Test
    void testGetEmployeeById() {
        Employee emp = new Employee();
        emp.setEmpId(2);
        emp.setName("Mukesh");

        when(employeeRepository.findByEmpID(2)).thenReturn(emp);

        Employee result = employeeService.getEmployeeById(2);

        assertEquals("Mukesh", result.getName());
    }

    @Test
    void testGetEmployeeByJob() {
        Employee emp1 = new Employee();
        emp1.setJob("SDE");
        Employee emp2 = new Employee();
        emp2.setJob("SDE");

        when(employeeRepository.findByJob("SDE")).thenReturn(Arrays.asList(emp1, emp2));

        List<Employee> result = employeeService.getEmployeeByJob("SDE");

        assertEquals(2, result.size());
        assertEquals("SDE", result.get(0).getJob());
    }

    @Test
    void testAddEmployee() {
        Employee emp = new Employee();
        emp.setEmpId(3);
        emp.setName("Ravi");

        when(employeeRepository.save(emp)).thenReturn(emp);

        String result = employeeService.addEmployee(emp);

        assertEquals("Employee Added Successfully!!!", result);
        verify(employeeRepository, times(1)).save(emp);
    }

    @Test
    void testUpdateEmployee() {
        Employee emp = new Employee();
        emp.setEmpId(4);
        emp.setName("Kiran");

        when(employeeRepository.save(emp)).thenReturn(emp);

        String result = employeeService.updateEmployee(emp);

        assertEquals("Employee Updated Successfully!!!", result);
        verify(employeeRepository, times(1)).save(emp);
    }

    @Test
    void testUpdateEmployeeById() {
        Employee existing = new Employee();
        existing.setEmpId(5);
        existing.setName("Old Name");
        existing.setJob("Old Job");

        Employee updated = new Employee();
        updated.setName("New Name");
        updated.setJob("New Job");

        when(employeeRepository.findById(5)).thenReturn(Optional.of(existing));
        when(employeeRepository.save(existing)).thenReturn(existing);

        String result = employeeService.updateEmployeeById(5, updated);

        assertEquals("Employee with ID 5 updated successfully.", result);
        assertEquals("New Name", existing.getName());
        assertEquals("New Job", existing.getJob());
    }

    @Test
    void testUpdateEmployeeByIdNotFound() {
        Employee updated = new Employee();
        updated.setName("New Name");
        updated.setJob("New Job");

        when(employeeRepository.findById(999)).thenReturn(Optional.empty());

        Exception exception = assertThrows(RuntimeException.class, () -> {
            employeeService.updateEmployeeById(999, updated);
        });

        assertEquals("Employee not found with ID: 999", exception.getMessage());
    }

    @Test
    void testDeleteEmployeeById() {
        int id = 6;

        doNothing().when(employeeRepository).deleteById(id);

        String result = employeeService.deleteEmployeeById(id);

        assertEquals("Employee Deleted Successfully!!!", result);
        verify(employeeRepository, times(1)).deleteById(id);
    }
}