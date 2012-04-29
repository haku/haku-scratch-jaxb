package haku.scratch.jaxb.model;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.io.StringWriter;

import javax.xml.bind.JAXBException;

import org.custommonkey.xmlunit.XMLAssert;
import org.junit.Test;
import org.xml.sax.SAXException;

public class UserTest {

	@Test
	public void itMarshalsUserToXml () throws Exception {
		User u = UserBuilder.create("bob").build();
		assertXmlEquals(u, "<user name=\"bob\" />");
	}

	@Test
	public void itUnmarshalsUserFromXml () throws Exception {
		User u = UserBuilder.fromXml("<user name=\"bob\" />").build();
		assertEquals("bob", u.getName());
	}

//	- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

	private static void assertXmlEquals (Marshalable m, String xml) throws SAXException, IOException, JAXBException {
		StringWriter s = new StringWriter();
		m.toXml(s);
		XMLAssert.assertXMLEqual(xml, s.toString());
	}

}
