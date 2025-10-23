package lt.viko.eif.aRomanov.WS_Client.model;

import jakarta.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {"Name"})
@XmlRootElement(name="getEmployeeRequest")
public class GetEmployeeRequest {

    @XmlElement(required = true)
    private String name;

    //@XmlElement(required = true)
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
}
