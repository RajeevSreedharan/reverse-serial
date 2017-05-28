package in.net.rajeev;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import in.net.rajeev.compile.DynamicCompiler;

public class DynamicCompilerTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		// Full name of the class that will be compiled.
        // If class should be in some package,
        // fullName should contain it too
        // (ex. "testpackage.DynaClass")
        String fullName = "in.net.rajeev.HelloWorld";

        // Here we get and specify the source code of the class to be compiled    
        StringWriter writer = new StringWriter();
		PrintWriter out = new PrintWriter(writer);
		out.println("package in.net.rajeev;");
		out.println("public class HelloWorld {");
		out.println("  public static void main(String args[]) {");
		out.println("    System.out.println(\"This is in another java file\");");
		out.println("  }");
		out.println("}");
		out.close();
		
        String src = writer.toString();
        
        DynamicCompiler uCompiler = new DynamicCompiler(fullName, src);
        uCompiler.compile();
        try {
			uCompiler.run();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
