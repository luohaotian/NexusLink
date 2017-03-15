package cqupt.nmid.weixin.util;

import com.thoughtworks.xstream.XStream;
import cqupt.nmid.weixin.model.TextMessage;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import sun.plugin.dom.core.Document;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 罗浩 on 2017/3/15.
 */
public class MessageUtil {
    public static Map<String,String> xmlToMap(HttpServletRequest request) throws IOException,DocumentException {
        Map<String ,String> map = new HashMap<>();
        SAXReader reader = new SAXReader();

        InputStream ins = request.getInputStream();
        Document doc = null;
        try{
            doc = (Document) reader.read(ins);
        }catch(DocumentException e) {
            e.printStackTrace();
        }finally {
            ins.close();
        }
        Element root = null;
        if (doc != null) {
            root = (Element) doc.getDocumentElement();
        }
        List<Element> list = root.elements();
        for (Element e: list) {
            map.put(e.getName(),e.getText());
        }
            ins.close();
        return map;

    }

    public static  String textMessageToXml(TextMessage tx){
        XStream xstream = new XStream();
        xstream.alias("xml", tx.getClass());
        return xstream.toXML(tx);


    }
}
