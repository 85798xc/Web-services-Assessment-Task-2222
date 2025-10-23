package lt.viko.eif.aRomanov.WS_Client;

import lt.viko.eif.aRomanov.WS_Client.XMLTransformation.JAXBConvertor;
import lt.viko.eif.aRomanov.WS_Client.XMLTransformation.PDFConvertor;
import lt.viko.eif.aRomanov.WS_Client.model.Company;
import lt.viko.eif.aRomanov.WS_Client.model.Department;
import lt.viko.eif.aRomanov.WS_Client.service.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 *  Description
 */
@Component
public class DataExtractionFromDB {

    @Autowired
    private DepartmentRepository departmentRepository;
    @Autowired
    private JAXBConvertor convertToXML;
    @Autowired
    private PDFConvertor pdfConvertor;

    private static List<Department> departmentsList;
    private static Company company;

    /**
     * Method responsible for showing on console data and XML File
     */
    public void Show_data(){
        departmentsList = departmentRepository.findAll();
        company = new Company();
        company.setDepartments(departmentsList);
        for(Department department: departmentsList){
            System.out.println(department);
        }
        System.out.println("\n" + convertToXML.Marshal(company, true));
        pdfConvertor.GetPDFFile();
    }
}
