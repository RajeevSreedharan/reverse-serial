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

import java.io.ObjectStreamClass;
import java.io.ObjectStreamField;

/**
 * @author Rajeev Sreedharan
 *
 */
public class StreamClassGenerator {
	
	public GeneratedClass generateClass(ObjectStreamClass osc){
		GeneratedClass generatedClass = new GeneratedClass();
		if(osc.getName().lastIndexOf(".") > 0)
			generatedClass.setPackageName(osc.getName().substring(0, osc.getName().lastIndexOf(".")));
		generatedClass.setClassName(osc.getName().substring(osc.getName().lastIndexOf(".")+1));
		
		for (ObjectStreamField osf : osc.getFields()) {
			GeneratedField field = getField(osf);
			generatedClass.addField(field);
		}
		
		System.out.println(generatedClass.toString());
		return generatedClass;
	}

	private GeneratedField getField(ObjectStreamField osf) {
		String fieldType = null;
		String fieldName = osf.getName();
		if (osf.isPrimitive()) {
			fieldType = getTypeString(osf.getTypeCode(), null);
		} else {
			switch (osf.getTypeCode()) {
			case 'L':
				fieldType =  getTypeClass(osf.getTypeString());
				break;
			case '[':
				fieldType =  getTypeArray(osf.getTypeString())+"[]";
				break;
			}
		}
		return new GeneratedField(fieldType, fieldName);
	}

	private String getTypeString(char typeCode, String typeString) {
		switch (typeCode) {
		case 'B':
			return "byte";
		case 'C':
			return "char";
		case 'D':
			return "double";
		case 'F':
			return "float";
		case 'I':
			return "int";
		case 'J':
			return "long";
		case 'L':
			return getTypeClass(typeString);
		case 'S':
			return "short";
		case 'Z':
			return "boolean";
		default:
			return null;
		}
	}
	
	private String getTypeClass(String typeString){
		if(typeString.startsWith("L")){
			typeString = typeString.substring(1, typeString.length()-1);
			typeString = typeString.replace('/', '.');
		}
		return typeString;
	}
	
	private String getTypeArray(String typeString){
		return getTypeString(typeString.charAt(1), typeString.substring(1));
	}

	public void compileClass(GeneratedClass generatedClass) {
		
	}
}
