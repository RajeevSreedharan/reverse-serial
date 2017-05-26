

import static org.junit.Assert.fail;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DefaultPackageSerializationTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		try {
			doSerialization();
		} catch (IOException e) {
			fail(e.getMessage());
		}
		
		try {
			doDeserialization();
		} catch (ClassNotFoundException e) {
			fail(e.getMessage());
		} catch (IOException e) {
			fail(e.getMessage());
		}
		
		try {
			doDeserialization2();
		} catch (ClassNotFoundException e) {
//			fail(e.getMessage());
		} catch (IOException e) {
			fail(e.getMessage());
		}
	}
	
	void doSerialization() throws IOException{
		DefaultPackageMyObject myObject = new DefaultPackageMyObject();
		File resourcesDirectory = new File("src/test/resources");
		FileOutputStream fileOut = new FileOutputStream(resourcesDirectory.getAbsolutePath()+"\\myobject_defaultpackage.ser");
		ObjectOutputStream out = new ObjectOutputStream(fileOut);
		out.writeObject(myObject);
		out.close();
		fileOut.close();
	}
	
	Object doDeserialization() throws IOException, ClassNotFoundException {
		Object object;
		File resourcesDirectory = new File("src/test/resources");
		FileInputStream fileIn = new FileInputStream(resourcesDirectory.getAbsolutePath()+"\\myobject.ser");
		ObjectInputStream in = new ObjectInputStream(fileIn);
		object = in.readObject();
		in.close();
		fileIn.close();
		return object;
	}
	
	@Test(expected=ClassNotFoundException.class)
	public void doDeserialization2() throws IOException, ClassNotFoundException {
		Object object;
		File resourcesDirectory = new File("src/test/resources");
		FileInputStream fileIn = new FileInputStream(resourcesDirectory.getAbsolutePath()+"\\myobject2.ser");
		ObjectInputStream in = new ObjectInputStream(fileIn);
		object = in.readObject();
		in.close();
		fileIn.close();
	}

}
