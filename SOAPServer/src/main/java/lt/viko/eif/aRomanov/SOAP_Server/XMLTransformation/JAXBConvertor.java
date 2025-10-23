package lt.viko.eif.aRomanov.SOAP_Server.XMLTransformation;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.StringReader;
import java.io.StringWriter;
import static jakarta.xml.bind.Marshaller.JAXB_FORMATTED_OUTPUT;

@Service
public class JAXBConvertor {

    private static File file = new File("company.xml");

    public static String Marshal(Object object, boolean print)
    {
        try
        {
            StringWriter writer = new StringWriter();
            var context = JAXBContext.newInstance(object.getClass());
            var marshaller = context.createMarshaller();
            marshaller.setProperty(JAXB_FORMATTED_OUTPUT, print);
            marshaller.marshal(object, file);
            return file.toString();
        }
        catch (JAXBException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Object Unmarshal(Object object, String XMLFile)
    {
        try {
            var context = JAXBContext.newInstance(object.getClass());
            var unmarshaller = context.createUnmarshaller();
            return unmarshaller.unmarshal(new StringReader(XMLFile));
        } catch (JAXBException e) {
            e.printStackTrace();
            return null;
        }
    }
}
