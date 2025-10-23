package lt.viko.eif.aRomanov.SOAP_Server.model;

import jakarta.persistence.*;
import jakarta.xml.bind.annotation.XmlType;

import java.math.BigInteger;

@Entity
@Table(name="employee")
@XmlType(propOrder = {"id", "firstName", "lastName", "age", "position"})
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private BigInteger id;
    private String FirstName;
    private String LastName;
    private int Age;
    private String position;

    public Employee(BigInteger id, String firstName, String lastName, int Age, String position) {
        this.id = id;
        FirstName = firstName;
        LastName = lastName;
        this.Age = Age;
        this.position = position;
    }

    public Employee() { }

    public BigInteger getId() { return id; }
    public void setId(BigInteger id) { this.id = id; }

    public String getFirstName() { return FirstName; }
    public void setFirstName(String firstName) { FirstName = firstName; }

    public String getPosition() { return position; }
    public void setPosition(String position) { this.position = position; }

    public int getAge() { return Age; }
    public void setAge(int Age) { this.Age = Age; }

    public String getLastName() { return LastName; }
    public void setLastName(String lastName) { LastName = lastName; }

    @Override
    public String toString(){
        return "Employee" +
                "\n\t\tid: " + id +
                "\n\t\tFirst name: " +FirstName +
                "\n\t\tLast name: " + LastName +
                "\n\t\tage: " + Age +
                "\n\t\tposition: " + position;
    }
}
