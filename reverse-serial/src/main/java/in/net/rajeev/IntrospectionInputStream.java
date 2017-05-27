package in.net.rajeev;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;

/**
 * @author Rajeev Sreedharan
 *
 */
public class IntrospectionInputStream extends ObjectInputStream {

	protected IntrospectionInputStream() throws IOException, SecurityException {
		super();
	}

	public IntrospectionInputStream(InputStream in) throws IOException {
		super(in);
	}

	@Override
	protected Class<?> resolveClass(ObjectStreamClass osc) throws ClassNotFoundException, IOException {
		Class<?> cl = null;
		try {
			cl = super.resolveClass(osc);
		} catch (ClassNotFoundException e) {
		}
		return cl;
	}
}
