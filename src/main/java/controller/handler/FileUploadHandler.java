package controller.handler;

import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.pdf.PDFParser;
import org.apache.tika.sax.BodyContentHandler;
import org.xml.sax.SAXException;
import ratpack.form.Form;
import ratpack.form.UploadedFile;
import ratpack.handling.Context;
import ratpack.handling.Handler;

import java.io.IOException;
import java.util.List;

public class FileUploadHandler implements Handler {

    @Override
    public void handle(Context ctx) throws Exception {
        ctx.parse(Form.class).then(form -> {
            UploadedFile file = form.file("image");
            test(file);
            System.out.println("\n\nHello \n" + file.getFileName());
            String param = form.get("param");
            List<String> multi = form.getAll("multi");
            ctx.next();
        });
    }

    public void test(UploadedFile file) throws IOException, TikaException, SAXException {
        BodyContentHandler handler = new BodyContentHandler();
        Metadata metadata = new Metadata();
        ParseContext pcontext = new ParseContext();

        //parsing the document using PDF parser
        PDFParser pdfparser = new PDFParser();
        pdfparser.parse(file.getInputStream(), handler, metadata, pcontext);

        //getting the content of the document
        System.out.println("Contents of the PDF :" + handler.toString());

        //getting metadata of the document
        System.out.println("Metadata of the PDF:");
        String[] metadataNames = metadata.names();

        for (String name : metadataNames) {
            System.out.println(name + " : " + metadata.get(name));
        }
    }
}
