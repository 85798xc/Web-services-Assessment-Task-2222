package lt.viko.eif.aRomanov.WS_Client.model;

import jakarta.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {"Employee"})
@XmlRootElement(name="getEmployeeResponse")
public class GetEmployeeResponse {

    @XmlElement(required = true)
    private Employee employee;

    public Employee getEmployee() { return employee; }
    public void setEmployee(Employee employee) { this.employee = employee; }
}
