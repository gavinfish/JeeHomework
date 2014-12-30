package cn.edu.nju.sj12.helpers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import cn.edu.nju.sj12.exceptions.FileNotOpenException;

public class XmlHelpr{
	private Document doc;
	private Element root;
	private String filename;
	
	public XmlHelpr(String filename){
		this.filename = filename;
	}

	public boolean createXml(String fileName) {
		// TODO Auto-generated method stub
		return true;
	}


	public Node getNode(String express) throws FileNotOpenException {
		// TODO Auto-generated method stub
		String absoluteFileName=Thread.currentThread().getContextClassLoader().getResource("").toString();  
        absoluteFileName=absoluteFileName.replace('/', '\\'); // 将/换成\  
        absoluteFileName=absoluteFileName.replace("file:", ""); //去掉file:  
        absoluteFileName=absoluteFileName.replace("classes\\", ""); //去掉class\  
        absoluteFileName=absoluteFileName.substring(1); //去掉第一个\,如 \D:\JavaWeb...  
        absoluteFileName+=filename+".xml"; 
        File file = new File(absoluteFileName);
		DocumentBuilderFactory factory = DocumentBuilderFactory
                .newInstance();
        try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			doc = builder.parse(file);
			root = doc.getDocumentElement();
        }catch(Exception e){
        	
        }
		Node result=null;
        XPathFactory xpathFactory=XPathFactory.newInstance();
        XPath xpath=xpathFactory.newXPath();
        try {
            result=(Node) xpath.evaluate(express, root, XPathConstants.NODE);
        } catch (XPathExpressionException e) {
            e.printStackTrace();
        }
        
        return result;
	}

	public NodeList getNodes(String express) {
		// TODO Auto-generated method stub
		NodeList result=null;
        XPathFactory xpathFactory=XPathFactory.newInstance();
        XPath xpath=xpathFactory.newXPath();
        try {
            result=(NodeList) xpath.evaluate(express, root, XPathConstants.NODESET);
        } catch (XPathExpressionException e) {
            e.printStackTrace();
        }
        
        return result;
	}

	public void saveXml(Document doc,String fileName) {
		// TODO Auto-generated method stub
		TransformerFactory transFactory=TransformerFactory.newInstance();
        try {
            Transformer transformer = transFactory.newTransformer();
            transformer.setOutputProperty("indent", "yes");

            DOMSource source=new DOMSource();
            source.setNode(doc);
            StreamResult result=new StreamResult();
            result.setOutputStream(new FileOutputStream(fileName));
            
            transformer.transform(source, result);
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }   
	}
}
