package in.scalive.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import in.scalive.model.Dept;
import in.scalive.model.Emp;
import in.scalive.service.DeptService;
import jdk.javadoc.doclet.Reporter;

@Component
public class MyCommandlineRunner implements CommandLineRunner {
	
	@Autowired
	private DeptService serv;
	
	

	@Override
	public void run(String... args) throws Exception {
	
		List<String> empnameList = List.of("Sagar","Manu");
		Dept dept = serv.createDeptWithEmp("IT", empnameList);
		System.out.println("Departed created : "+dept.getName());
		
		empnameList = List.of("Riya","Bittu");
		Dept dept2 = serv.createDeptWithEmp("Prodution", empnameList);
		System.out.println("Departed created : "+dept2.getName());
		
		
		

	Dept dept1 =	serv.updateDept(2, "Finance");
	
	if(dept1 != null) {
		System.out.println("Dept updated");
	}else {
		System.out.println("Dept not updated!");
	}
	
	serv.addEmpToDept(1, "Abhishek");
		
	 List<Dept> dept3 =	serv.getAllDeptWithEmp();
	 for( Dept d : dept3) {
		 System.out.println("Dept : "+d); 
	 }
	 
	 serv.removeEmpFromDept(1, 5);
		
	 serv.deleteDept(2);
		
	}
}
