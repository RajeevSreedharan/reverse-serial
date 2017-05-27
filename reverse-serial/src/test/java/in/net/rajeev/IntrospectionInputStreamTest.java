/**
 * 
 */
package in.net.rajeev;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Rajeev Sreedharan
 *
 */
public class IntrospectionInputStreamTest {

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testDefaultPackageNonClasspath() {
		try {
			File resourcesDirectory = new File("src/test/resources");
			FileInputStream fileIn = new FileInputStream(resourcesDirectory.getAbsolutePath()+"\\myobject_defaultpackage2.ser");
			IntrospectionInputStream in = new IntrospectionInputStream(fileIn);
			in.readObject();
			in.close();
			fileIn.close();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
		}
	}

	@Test
	public void testDefaultPackage() {
		try {
			// This will internally encounter a class-not-found since default
			// package object cannot be accessed from other packages as per JLS.
			// New dummy class will be generated and used for read.
			File resourcesDirectory = new File("src/test/resources");
			FileInputStream fileIn = new FileInputStream(resourcesDirectory.getAbsolutePath()+"\\myobject_defaultpackage.ser");
			IntrospectionInputStream in = new IntrospectionInputStream(fileIn);
			in.readObject();
			in.close();
			fileIn.close();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
		}
		
	}
	
	public void testNonClasspath(){
		try {
			File resourcesDirectory = new File("src/test/resources");
			FileInputStream fileIn = new FileInputStream(resourcesDirectory.getAbsolutePath()+"\\myobject2.ser");
			IntrospectionInputStream in = new IntrospectionInputStream(fileIn);
			in.readObject();
			in.close();
			fileIn.close();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
		}
	}
	
	@Test
	public void test() {
		try {
			File resourcesDirectory = new File("src/test/resources");
			FileInputStream fileIn = new FileInputStream(resourcesDirectory.getAbsolutePath()+"\\myobject.ser");
			IntrospectionInputStream in = new IntrospectionInputStream(fileIn);
			in.readObject();
			in.close();
			fileIn.close();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
		}
	}

}
