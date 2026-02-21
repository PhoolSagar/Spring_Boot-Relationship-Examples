package in.scalive.service;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.scalive.model.Dept;
import in.scalive.model.Emp;
import in.scalive.repository.DeptRepository;

@Service
public class DeptService {
	private DeptRepository repo;

	@Autowired
	public DeptService(DeptRepository repo) {
		this.repo = repo;
	}

	public Dept createDeptWithEmp(String deptName, List<String> empNameList) {
		Dept dept = new Dept(deptName);
		for(String e : empNameList) {
			Emp emp = new Emp(e);
			dept.addEmp(emp);
		}
		return repo.save(dept);
	}
	
	public List<Dept> getAllDeptWithEmp(){
		return repo.findAll();
	}
	
	public Dept updateDept(Integer deptId, String  newDept) {
		Optional<Dept> result = repo.findById(deptId);
		if(!result.isPresent()) {
			return null;
		}else {
			Dept dept = result.get();
			dept.setName(newDept);
			return repo.save(dept);
		}
	}
	
	public void addEmpToDept(Integer id, String empName) {
		Optional<Dept> result = repo.findById(id);
		if(!result.isPresent()) {
			System.out.println("Department not found!");
			return;
		}else {
			Dept dept = result.get();
			Emp emp = new Emp(empName);
			dept.addEmp(emp);
			repo.save(dept);
			return;
		}
	}
	
	public void removeEmpFromDept(Integer deptId, Integer empId) {
		Optional<Dept> result = repo.findById(deptId);
		if(!result.isPresent()) {
			System.out.println("Department not found!");
			return;
		}else {
			Dept dept = result.get();
			List<Emp> empList = dept.getEmpList();
			for(Emp emp : empList) {
				if(emp.getId() == empId) {
					dept.removeEmp(emp);
					repo.save(dept);
					System.out.println("Employee removed!");
					return;
				}
				
			}
			System.out.println("Emp not found!");
		}
	}
	
	public void deleteDept(Integer deptId) {
		repo.deleteById(deptId);
	}
}

