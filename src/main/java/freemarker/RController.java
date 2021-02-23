package freemarker;

import java.util.Base64;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(path = "/")
public class RController  {
    private static final Logger LOGGER = LoggerFactory.getLogger(RController.class);

    @Autowired
    private Freemarker service;
    @Autowired
    private Encryption encryption;

    public RController(Freemarker service2, Encryption encryption2) {
        service = service2;
        encryption = encryption2;
    }
    
    /**
     * Given cols columns and input choose the correct ftl file
     * and Columns?.java produce a table 1-5 columns in a PDF.
     * CSV indicates EXCEL format CSV input this is used in the 
     * table headingsCSV and fileCSV and should have the same cols
     * 
     * @param cols
     * @param input
     * @return
     */
    @PostMapping(path="TabularToPDF/columns/{cols}", produces="application/json", consumes="application/json")
    public ResponseEntity<ReturnBean> postFile(@PathVariable("cols") Integer cols, @RequestBody InputBean input) {
        String result=null;
        try {
            result = service.convert(input.getTitle(),
                    input.getDatetime(),
                    input.getPrintedby(),
                    input.getHeadingsCSV(),
                    input.getFileCSV(),
                    cols);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        ReturnBean rb = new ReturnBean();
        rb.setFileB64(result);
        Base64.Decoder b64d = Base64.getDecoder();
        rb.setSha1(encryption.sha1(b64d.decode(result)));
        return new ResponseEntity<ReturnBean>(rb, HttpStatus.OK);
    }
    /**
     * Given the input which takes inputFTL and replacementStringsCSV
     * pass to freemarker then pass to the PDF generator returning
     * Base64 file and sha1.
     * CSV indicates EXCEL format CSV input this is used in the 
     * replacementStringsCSV and should have columns = 2
     * 
     * @param input
     * @return
     */
    @PostMapping(path="GeneralToPDF", produces="application/json", consumes="application/json")
    public ResponseEntity<ReturnBean> postFile(@RequestBody InputBeanGeneral input) {
        String result=null;
        try {
            result = service.convert(input.getInputFTL(),
                    input.getReplacementStringsCSV());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        ReturnBean rb = new ReturnBean();
        rb.setFileB64(result);
        Base64.Decoder b64d = Base64.getDecoder();
        rb.setSha1(encryption.sha1(b64d.decode(result)));
        return new ResponseEntity<ReturnBean>(rb, HttpStatus.OK);
    }
    /**
     * Saves the template to file
     * @param input
     * @return
     */
    @PostMapping(path="Init", produces="application/json", consumes="application/json")
    public ResponseEntity<Boolean> initFile(@RequestBody InputBeanInit input) {
        Boolean result=null;
        try {
            result = service.init(input.getInputFTL(),
                    input.getFilename());
        } catch (Exception e) {
            result = false;
            throw new RuntimeException(e);
        }
        return new ResponseEntity<Boolean>(result, HttpStatus.OK);
    }
    /**
     * Converts an array of Partha1InputBean to PDF via columnsPartha1Template.ftl
     * @param input
     * @return
     */
    @PostMapping(path="Partha1ToPDF", produces="application/json", consumes="application/json")
    public ResponseEntity<ReturnBean> partha1File(@RequestBody Partha1InputBean[] input) {
        String result=null;
        try {
            result = service.convert2(input);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        ReturnBean rb = new ReturnBean();
        rb.setFileB64(result);
        Base64.Decoder b64d = Base64.getDecoder();
        rb.setSha1(encryption.sha1(b64d.decode(result)));
        return new ResponseEntity<ReturnBean>(rb, HttpStatus.OK);
    }
    /**
     * Converts a HTML string to PDF
     * @param input
     * @return
     */
    @PostMapping(path="ToPDF", produces="application/json", consumes="application/json")
    public ResponseEntity<ReturnBean> toPDF(@RequestBody InputHTMLString input) {
        String result=null;
        try {
            result = service.convert2(input);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        ReturnBean rb = new ReturnBean();
        rb.setFileB64(result);
        Base64.Decoder b64d = Base64.getDecoder();
        rb.setSha1(encryption.sha1(b64d.decode(result)));
        return new ResponseEntity<ReturnBean>(rb, HttpStatus.OK);
    }
    /**
     * Compares the given sha1 with one generated from the file.
     * @param input
     * @return
     */
    @PostMapping(path="isTamperedWith", produces="application/json", consumes="application/json")
    public ResponseEntity<Boolean> isTamperedWith(@RequestBody TamperedBean input) {
        Base64.Decoder b64d = Base64.getDecoder();
        return new ResponseEntity<Boolean>(!input.getSha1().equals(
                encryption.sha1(
                        b64d.decode(input.getFileB64()))), HttpStatus.OK);
    }


}