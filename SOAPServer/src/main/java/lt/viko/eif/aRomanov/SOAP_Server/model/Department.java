package lt.viko.eif.aRomanov.SOAP_Server.model;

import jakarta.persistence.*;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

import java.math.BigInteger;
import java.util.List;

@Entity
@Table(name="department")
@XmlType(propOrder = {"id", "departmentName", "employes"})
@XmlRootElement
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private BigInteger id;
    private String DepartmentName;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name="company",
            joinColumns = @JoinColumn(name="department_id"),
            inverseJoinColumns = @JoinColumn(name="employee_id")
    )
    private List<Employee> employes;

    public Department(BigInteger id, String departmentName, List<Employee> employes) {
        this.id = id;
        DepartmentName = departmentName;
        this.employes = employes;
    }

    public Department() { }

    public BigInteger getId() { return id; }
    public void setId(BigInteger id) { this.id = id; }

    public String getDepartmentName() { return DepartmentName; }
    public void setDepartmentName(String departmentName) { DepartmentName = departmentName; }

    public List<Employee> getEmployes() { return employes; }
    public void setEmployes(List<Employee> employes) { this.employes = employes; }

    @Override
    public String toString() {
        return "Department" +
                "\n\tid: " + id +
                "\n\tDepartment name: " + DepartmentName +
                "\n\tEmployee: " + employes;
    }
}
