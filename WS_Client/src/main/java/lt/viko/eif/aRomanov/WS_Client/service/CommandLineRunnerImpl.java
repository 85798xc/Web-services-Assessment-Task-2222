package lt.viko.eif.aRomanov.WS_Client.service;

import lt.viko.eif.aRomanov.WS_Client.DataExtractionFromDB;
import lt.viko.eif.aRomanov.WS_Client.XMLTransformation.HTMLConvertor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {

    @Autowired
    private DataExtractionFromDB DataExtract;

    @Autowired
    private HTMLConvertor htmlConvertor = new HTMLConvertor();

    @Override
    public void run(String... args) throws Exception {
        DataExtract.Show_data();
        htmlConvertor.CreateHTML();
    }
}
