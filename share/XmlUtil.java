package com.su.tools.xml;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;

public class XmlUtil {
	public static void main(String[] args) {
		XStream xStream = new XStream(new StaxDriver());
		xStream.alias("person", Person.class);

		String xml = xStream.toXML(new Person("husu"));
		System.out.println(xml);

		Person p = (Person) xStream.fromXML(xml);
		System.out.println(p.getName());


	}
}
