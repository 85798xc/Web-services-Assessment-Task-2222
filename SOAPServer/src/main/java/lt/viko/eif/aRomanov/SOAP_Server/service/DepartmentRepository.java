package lt.viko.eif.aRomanov.SOAP_Server.service;

import lt.viko.eif.aRomanov.SOAP_Server.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

}
