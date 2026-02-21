package in.scalive.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import in.scalive.model.Dept;
import in.scalive.model.Emp;


public interface EmpRepository extends JpaRepository<Emp, Integer>{

	Emp findByName(String name);
}
