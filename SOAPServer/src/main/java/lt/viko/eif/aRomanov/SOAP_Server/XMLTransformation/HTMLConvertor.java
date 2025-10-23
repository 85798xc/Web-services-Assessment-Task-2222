package lt.viko.eif.aRomanov.SOAP_Server.XMLTransformation;

import org.hibernate.Transaction;
import org.hibernate.TransactionException;
import org.springframework.stereotype.Service;

import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.io.IOException;

/**
 *  The class is responsible for converting XML to HTML using an XSL stylesheet.
 */
@Service
public class HTMLConvertor {
    File xmlFile = new File("Company.xml");
    File xslFile = new File("XSL-HTML.xsl");

    /**
     * Converts an XML file to an HTML file using a specified XSL stylesheet.
     * <p>
     * This method performs the transformation using {@code TransformerFactory} and {@code Source}
     * to define the XSL stylesheet to be applied. It then sets the XML input file (e.g., {@code company.xml})
     * and specifies the name of the output HTML file. Finally, the transformation is executed
     * and the resulting HTML file is created.
     * </p>
     *
     * @throws TransformerException if an error occurs during the transformation process
     * @throws IOException if an I/O error occurs while reading or writing files
     */
    public void CreateHTML() throws TransformerException, IOException {
        try{
            TransformerFactory factory = TransformerFactory.newInstance();
            Source xslt = new StreamSource(xslFile);
            Transformer transformer = factory.newTransformer(xslt);

            Source xmlSource = new StreamSource(xmlFile);
            StreamResult result = new StreamResult(new File("UAB_COMPANY.html"));

            transformer.transform(xmlSource, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
