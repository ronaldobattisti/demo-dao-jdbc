package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		
		System.out.println("=== TEST 1: seller findById ===");
		Department dep = departmentDao.findById(1);
		System.out.println(dep);
		
		System.out.println("=== TEST 2: seller findByDepartment ===");
		dep = departmentDao.findByName("Computers");
		System.out.println(dep);
		
		System.out.println("=== TEST 3: seller findAll===");
		List<Department> list = new ArrayList<>();
		list = departmentDao.findAll();
		System.out.println(list);
		
		System.out.println("=== TEST 4: seller insert===");
		dep = new Department(null, "Music");
		departmentDao.insert(dep);
		System.out.println("New department inserted! Id: " + dep.getId());
		
		System.out.println("=== TEST 5: seller update===");
		Department department = departmentDao.findById(6);
		department.setName("Clothes");
		departmentDao.update(department);
		System.out.println("Update done!");
		
		System.out.println("=== TEST 6: seller delete===");
		System.out.println("Enter id for the delete test: ");
		int i = sc.nextInt();
		departmentDao.deleteById(i);
		System.out.println("Delete finished!");
		
		sc.close();
	}

}
