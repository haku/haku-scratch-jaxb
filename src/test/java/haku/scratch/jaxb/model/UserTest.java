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
		User u = UserBuilder.fromXml("<user name=\"bob\" />");
		assertEquals("bob", u.getName());
	}

	@Test
	public void itCopiesItem () {
		User u0 = UserBuilder.create("bob").build();
		User u1 = UserBuilder.fromUser(u0).build();
		assertEquals("bob", u1.getName());
	}

//	- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

	private static void assertXmlEquals (Marshalable m, String xml) throws SAXException, IOException, JAXBException {
		StringWriter s = new StringWriter();
		m.toXml(s);
		XMLAssert.assertXMLEqual(xml, s.toString());
	}

}
