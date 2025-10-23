package lt.viko.eif.aRomanov.WS_Client.WSDLFiles;

import lt.viko.eif.aRomanov.WS_Client.model.GetEmployeeRequest;
import lt.viko.eif.aRomanov.WS_Client.model.GetEmployeeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class EmployeeEndpoint {

    private EmployeeRepository employeeRepository;

    private static final String NAMESPACE_URI = "http://spring.io/guides/gs-producing-web-service";

    @Autowired
    public EmployeeEndpoint(EmployeeRepository employeeRepository) { this.employeeRepository = employeeRepository; }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getEmployeeRequest")
    @ResponsePayload
    public GetEmployeeResponse getEmployee(@RequestPayload GetEmployeeRequest request) {
        GetEmployeeResponse response = new GetEmployeeResponse();
        response.setEmployee(employeeRepository.findEmployee(request.getName()));

        return response;
    }
}
