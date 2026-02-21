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


	public void getAllDept() {
		List<Dept> deptList = repo.findAll();
		for(Dept dept : deptList) {
			System.out.println("Department Name : "+dept.getName());
			System.out.println(dept.getEmpList());
			System.out.println();
		}
	}
	
	
	
	
}

