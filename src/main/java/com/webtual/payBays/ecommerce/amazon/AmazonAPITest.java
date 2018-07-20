package com.webtual.payBays.ecommerce.amazon;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class AmazonAPITest {
	//https://stackoverflow.com/questions/8336427/amazon-product-advertising-api-through-java-soap
	private static final String SECRET_KEY = "AKIAI6CSYGWJMJNDXLTA";//"sikdar0shanta-21"//"<YOUR_SECRET_KEY>";
    private static final String AWS_KEY = "";//"AKIAI6CSYGWJMJNDXLTA";//"<YOUR_KEY>";

    public static void main(String[] args) throws Exception{
        SignedRequestsHelper helper = SignedRequestsHelper.getInstance("ecs.amazonaws.com", AWS_KEY, SECRET_KEY);

        Map<String, String> params = new HashMap<String, String>();
        params.put("Service", "AWSECommerceService");
        params.put("Version", "2009-03-31");
        params.put("Operation", "ItemLookup");
        params.put("ItemId", "1451648537");
        params.put("ResponseGroup", "Large");

        String url = helper.sign(params);
        try {
            Document response = getResponse(url);
            printResponse(response);
        } catch (Exception ex) {
            Logger.getLogger(AmazonAPITest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static Document getResponse(String url) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document doc = builder.parse(url);
        return doc;
    }

    private static void printResponse(Document doc) throws TransformerException, FileNotFoundException {
        Transformer trans = TransformerFactory.newInstance().newTransformer();
        Properties props = new Properties();
        props.put(OutputKeys.INDENT, "yes");
        trans.setOutputProperties(props);
        StreamResult res = new StreamResult(new StringWriter());
        DOMSource src = new DOMSource(doc);
        trans.transform(src, res);
        String toString = res.getWriter().toString();
        System.out.println(toString);
    }
	
}
