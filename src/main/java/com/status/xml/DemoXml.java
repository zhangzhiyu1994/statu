package com.status.xml;

import cn.hutool.core.util.XmlUtil;
import org.w3c.dom.Document;

/**
 * @author 张志宇
 * @version V1.0
 * @Package com.status.xml
 * @date 2021/3/1 16:28
 */
public class DemoXml {
    public static String createdXml(){
        Document document = XmlUtil.parseXml ("F:\\a.xml");
        String s1 = XmlUtil.toStr(document);
        System.out.println(s1);
        return s1;
    }
}
