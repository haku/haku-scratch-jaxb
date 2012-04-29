package haku.scratch.jaxb.model;

import java.io.Writer;

import javax.xml.bind.JAXBException;

public interface Marshalable {

	public void toXml (Writer writer) throws JAXBException;

}
