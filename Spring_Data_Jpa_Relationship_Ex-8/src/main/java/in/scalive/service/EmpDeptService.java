package in.scalive.service;

import java.security.spec.DSAGenParameterSpec;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.scalive.model.Dept;
import in.scalive.model.Emp;
import in.scalive.repository.DeptRepository;
import in.scalive.repository.EmpRepository;

@Service
public class EmpDeptService {
	private DeptRepository drepo;
	private EmpRepository erepo;

	@Autowired
	public EmpDeptService(DeptRepository drepo, EmpRepository erepo) {
		this.erepo = erepo;
		this.drepo = drepo;
	}

	// creating dept
	public void createDept(String name) {
		Dept dept = new Dept(name);
		drepo.save(dept);
		System.out.println("Dept created : " + dept.getName());
	}

	// creating Adding emp to dept
//	public void addEmpToDept(Integer deptId, String empName) {
//		Dept dept = drepo.findById(deptId).orElse(null);
//		if(dept != null) {
//			Emp emp = new Emp(empName);
//			dept.addEmp(emp);
//			drepo.save(dept);
//			
//			System.out.println("Emp added : "+ emp.getName());
//		}
//		else {
//			System.out.println("Dept not found!");
//		}
//	}

	public void addEmpToDept(Integer deptId, String empName) {
		Dept dept = drepo.findById(deptId).orElse(null);
		if (dept != null) {
			Emp emp = new Emp(empName);
			emp.setDept(dept);
			erepo.save(emp);

			System.out.println("Emp added : " + emp.getName());
		} else {
			System.out.println("Dept not found!");
		}
	}

	public void showAllDept() {
		List<Dept> deptList = drepo.findAll();
		for (Dept dept : deptList) {
			System.out.println("Dept : " + dept.getName());

			for (Emp emp : dept.getEmpList()) {
				System.out.println("Emp : " + emp);
			}
		}
	}

	public void deleteEmp(Integer empId) {
		Emp emp = erepo.findById(empId).orElse(null);
		if (emp == null) {
			System.out.println("Emp not found!");
		} else {
			Dept dept = emp.getDept();
			if (emp != null) {
				dept.removeEmp(emp);
				drepo.save(dept);
				System.out.println("Emp deleted");
			}
		}
	}

	public void updateEmp(Integer id, String newName) {
		Emp emp = erepo.findById(id).orElse(null);
		if (emp == null) {
			System.out.println("Emp not found!");
			return;
		} else {
			emp.setName(newName);
		    erepo.save(emp);
			System.out.println("Emp name changed");
		}
	}

	public void updateDept(Integer id, String newName) {
		Dept dept = drepo.findById(id).orElse(null);
		if (dept == null) {
			System.out.println("Dept not found!");
			return;
		} else {
			dept.setName(newName);
			drepo.save(dept);
			
			System.out.println("Dept name changed");
		}
	}

	public void updateEmpDept(Integer deptId, Integer empId) {
		Dept dept = drepo.findById(deptId).orElse(null);
		if (dept == null) {
			System.out.println("Dept not found!");
			return;
		} else {

			Emp emp = erepo.findById(empId).orElse(null);
			if (emp == null) {
				System.out.println("Emp not found!");
				return;
			} else {
				emp.setDept(dept);
				erepo.save(emp);
				System.out.println("Emp dept updated");
			}
		}
	}

	public void printNameToDetail(String name) {
		Emp emp = erepo.findByName(name);
		if(emp == null) {
			System.out.println("Name not found!");
		}else {
			Dept dept = emp.getDept();
			System.out.println("Dept name : "+ dept.getName());
			System.out.println("Emp : "+dept.getEmpList());
		}
	}


}
