package lt.viko.eif.aRomanov.WS_Client.WSDLFiles;

import jakarta.annotation.PostConstruct;
import lt.viko.eif.aRomanov.WS_Client.model.Employee;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.util.HashMap;
import java.util.Map;

@Component
public class EmployeeRepository {
    private static final Map<String, Employee> employes = new HashMap<>();

    @PostConstruct
    public void intData() {
        Employee john = new Employee();
        john.setFirstName("John");
        john.setLastName("Hock");
        john.setAge(45);
        john.setPosition("Senjor Developer");

        employes.put(john.getFirstName(), john);
    }

    public Employee findEmployee(String name) {
        Assert.notNull(name, "The employes name must not be null");
        return employes.get(name);
    }
}
