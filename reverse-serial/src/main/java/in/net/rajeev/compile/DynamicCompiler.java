package in.net.rajeev.compile;

import java.util.ArrayList;
import java.util.List;

import javax.tools.JavaCompiler;
import javax.tools.JavaFileManager;
import javax.tools.JavaFileObject;
import javax.tools.ToolProvider;

/*
 * Compiler source credits : http://javapracs.blogspot.in/2011/06/dynamic-in-memory-compilation-using.html
 * 
 * */

public class DynamicCompiler {
    private JavaFileManager fileManager ;
    private String fullName;
    private String sourceCode;
    
    /**
     * @param fullName_
       Full name of the class that will be compiled. 
       If class should be in some package,
       fullName should contain it too
       (ex. "testpackage.DynaClass")
     * @param SrcCode_
       Here we specify the source code of the class to be compiled

     */
    
    public DynamicCompiler(String fullName_, String SrcCode_){
        fullName = fullName_;
        sourceCode=SrcCode_;
        fileManager = initFileManager();
    }
    
    public JavaFileManager initFileManager(){
        if(fileManager!=null)
            return fileManager;
        else {
            JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
             fileManager = new
                ClassFileManager(compiler
                    .getStandardFileManager(null, null, null));
             return fileManager;
        }
            
    }
    
    public void compile(){
           // We get an instance of JavaCompiler. Then
        // we create a file manager
        // (our custom implementation of it)
          JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
          

            // Dynamic compiling requires specifying
            // a list of "files" to compile. In our case
            // this is a list containing one "file" which is in our case
            // our own implementation (see details below)
            List<JavaFileObject> jfiles = new ArrayList<JavaFileObject>();
            jfiles.add(new CharSequenceJavaFileObject(fullName, sourceCode));

            // We specify a task to the compiler. Compiler should use our file
            // manager and our list of "files".
            // Then we run the compilation with call()
            compiler.getTask(null, fileManager, null, null,
                null, jfiles).call();

    }
    
    public void run() throws InstantiationException, 
                IllegalAccessException, ClassNotFoundException{
          // Creating an instance of our compiled class and
        // running its toString() method
        Object instance = fileManager.getClassLoader(null)
            .loadClass(fullName).newInstance();
        System.out.println(instance);
    }
}
