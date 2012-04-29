package haku.scratch.jaxb.model;

import java.io.InputStream;

import javax.xml.bind.JAXBException;

public class UserBuilder {
//	- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

	/**
	 * Must go via entry points.
	 */
	private UserBuilder () {}

//	- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
//	State.

	private String name;

//	- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
//	Entry points.

	public static UserBuilder create (String name) {
		UserBuilder builder = new UserBuilder();
		builder.name(name);
		return builder;
	}

	public static UserBuilder fromUser (User u) {
		return create(u.getName());
	}

	public static User fromXml (String s) throws JAXBException {
		return fromXml(Model.stringToInputStream(s));
	}

	public static User fromXml (InputStream is) throws JAXBException {
		return User.class.cast(Model.getUnmarshaller().unmarshal(is));
	}

//	- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
//	 Exit points.

	public User build () {
		User u = new User();
		u.setName(this.name);
		return u;
	}

//	- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
//	Setters.

	public void name (String n) {
		this.name = n;
	}

//	- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
}
