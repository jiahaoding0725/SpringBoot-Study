package com.ding.dao;

import com.ding.pojo.Department;
import com.ding.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class EmployeeDao {

    private static Map<Integer, Employee> employees = null;
    @Autowired
    private DepartmentDao departmentDao;

    static {
        employees = new HashMap<Integer, Employee>();
        employees.put(1001, new Employee(1001, "AA", "A1023921169@qq.com", 1, new Department(101, "教学部")));
        employees.put(1002, new Employee(1002, "BB", "B1023921169@qq.com", 0, new Department(102, "市场部")));
        employees.put(1003, new Employee(1003, "CC", "C1023921169@qq.com", 1, new Department(103, "教研部")));
        employees.put(1004, new Employee(1004, "DD", "D1023921169@qq.com", 0, new Department(104, "运营部")));
        employees.put(1005, new Employee(1005, "EE", "E1023921169@qq.com", 1, new Department(105, "后勤部")));
    }

    // 主键自增
    private static Integer initId = 1006;
    // 增加一个员工
    public void save(Employee employee) {
        if (employee.getId() == null) {
            employee.setId(initId++);
        }

        employee.setDepartment(departmentDao.getDepartmentById(employee.getDepartment().getId()));

        employees.put(employee.getId(), employee);
    }

    // 查询全部员工信息
    public Collection<Employee> getAll(){
        return employees.values();
    }

    // 通过id查询员工
    public Employee getEmployeeById(Integer id) {
        return employees.get(id);
    }

    // 删除员工通过id
    public void delete(Integer id) {
        employees.remove(id);
    }

}
