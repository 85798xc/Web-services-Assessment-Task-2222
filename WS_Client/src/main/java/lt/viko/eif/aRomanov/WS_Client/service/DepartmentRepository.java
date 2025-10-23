package lt.viko.eif.aRomanov.WS_Client.service;

import lt.viko.eif.aRomanov.WS_Client.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

}
