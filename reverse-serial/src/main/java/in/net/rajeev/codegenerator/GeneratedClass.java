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

package in.net.rajeev.codegenerator;

import java.util.ArrayList;

/**
 * @author Rajeev Sreedharan
 *
 */
public class GeneratedClass {

	String packageName;
	String className;
	ArrayList<GeneratedField> fields;
	

	public String getPackageName() {
		return packageName;
	}
	
	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}
	
	public String getClassName() {
		return className;
	}
	
	public void setClassName(String className) {
		this.className = className;
	}
	
	public ArrayList<GeneratedField> getFields() {
		return fields;
	}
	
	public void addField(GeneratedField generatedField) {
		fields.add(generatedField);
	}
	
	public void addField(String fieldType, String fieldName) {
		if(fields == null)
			fields = new ArrayList<GeneratedField>();
		fields.add(new GeneratedField(fieldType, fieldName));
	}
	
	public String toString(){
		StringBuilder sb = new StringBuilder();
		if(packageName != null && !packageName.equals(""))
			sb.append("package " + packageName + ";\n");
		sb.append("public class "+ className + " {\n");
		for(GeneratedField field : fields)
			sb.append("\t" + field.fieldType + " " + field.fieldName + ";\n");
		sb.append("}\n");
		return sb.toString();
	}
	
}
