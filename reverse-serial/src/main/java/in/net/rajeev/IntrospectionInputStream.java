/*
 * Copyright 2017 Rajeev Sreedharan
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package in.net.rajeev;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;

import in.net.rajeev.codegenerator.StreamClassGenerator;

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
			// Class not found, continue with dummy class generation
			StreamClassGenerator classGenerator = new StreamClassGenerator();
			classGenerator.compileClass(classGenerator.generateClass(osc));
		}
		return cl;
	}
}
