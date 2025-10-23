package lt.viko.eif.aRomanov.SOAP_Server.model;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementWrapper;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.List;

@XmlRootElement
public class Company {

    private List<Department> departments;

    @XmlElementWrapper(name = "Departments")
    @XmlElement(name = "department")
    public List<Department> getDepartments() { return departments; }
    public void setDepartments(List<Department> departments) { this.departments = departments; }
}
