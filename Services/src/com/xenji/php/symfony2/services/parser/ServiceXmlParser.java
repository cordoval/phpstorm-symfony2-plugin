package com.xenji.php.symfony2.services.parser;

import com.intellij.openapi.vfs.VirtualFile;
import com.xenji.php.symfony2.services.components.ServiceManager;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: Mario
 * Date: 03/06/12
 * Time: 08:53
 * To change this template use File | Settings | File Templates.
 */
public class ServiceXmlParser extends DefaultHandler {

    private ServiceManager manager;

    private VirtualFile file;

    private boolean inServices = false;

    private SAXParser parser;

    public ServiceXmlParser(VirtualFile file) throws SAXException, ParserConfigurationException {
        this.file = file;
        SAXParserFactory factory = SAXParserFactory.newInstance();
        parser = factory.newSAXParser();
    }

    public void parse() throws IOException, SAXException {
        parser.parse(file.getInputStream(), this);
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        super.startElement(uri, localName, qName, attributes);    //To change body of overridden methods use File | Settings | File Templates.
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        super.endElement(uri, localName, qName);    //To change body of overridden methods use File | Settings | File Templates.
    }

    @Override
    public void startDocument() throws SAXException {
        super.startDocument();    //To change body of overridden methods use File | Settings | File Templates.
    }

    @Override
    public void endDocument() throws SAXException {
        super.endDocument();    //To change body of overridden methods use File | Settings | File Templates.
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        super.characters(ch, start, length);    //To change body of overridden methods use File | Settings | File Templates.
    }
}
