package lt.viko.eif.aRomanov.SOAP_Server.XMLTransformation;

import org.apache.fop.apps.*;
import org.springframework.stereotype.Service;

import javax.xml.transform.Result;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.sax.SAXResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

@Service
public class PDFConvertor {

    private static File XSLTfile = new File("XSL-FO.xsl");

    public static void GetPDFFile()
    {
        try {
            ConverToPDF();
        }
        catch (IOException| TransformerException| FOPException e)
        {
            e.printStackTrace();
        }
    }

    private static void ConverToPDF() throws IOException, TransformerException, FOPException {

        StreamSource xmlSource = new StreamSource(new File("company.xml"));
        FopFactory fopFactory = FopFactory.newInstance(new File(".").toURI());
        FOUserAgent foUserAgent = fopFactory.newFOUserAgent();
        OutputStream out;
        out = new java.io.FileOutputStream("UAB_COMPANY.pdf");

        try {
            Fop fop = fopFactory.newFop(MimeConstants.MIME_PDF, foUserAgent, out);

            TransformerFactory factory = TransformerFactory.newInstance();
            Transformer transformer = factory.newTransformer(new StreamSource(XSLTfile));
            Result res = new SAXResult(fop.getDefaultHandler());
            transformer.transform(xmlSource, res);
        }
        finally {
            out.close();
        }
    }
}
