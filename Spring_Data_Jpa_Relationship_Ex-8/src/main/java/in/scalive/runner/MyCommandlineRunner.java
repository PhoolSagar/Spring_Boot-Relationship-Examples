package in.scalive.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import in.scalive.service.EmpDeptService;



@Component
public class MyCommandlineRunner implements CommandLineRunner {
	
	@Autowired
	private EmpDeptService serv;
	
	
	

	@Override
	public void run(String... args) throws Exception {
	
//		serv.createDept("IT");
//		serv.addEmpToDept(1, "Sagar");
//		serv.addEmpToDept(1, "Angad");
//		
//		serv.createDept("finance");
//		serv.addEmpToDept(2, "Manu");
//		serv.addEmpToDept(2, "Bittu");
//		
//		serv.showAllDept();
		
//		serv.deleteEmp(4);
		
//		serv.updateDept(2, "Finance");
//		serv.updateEmp(2, "Bittu");
		
//		serv.updateEmpDept(2, 2);
		
		serv.printNameToDetail("sagar");
		
	}
}
