package org.wso2.datamapper.engine.sample;

import java.io.File;
import java.io.IOException;

import javax.script.ScriptException;

import org.wso2.datamapper.engine.core.DataMapper;

public class MapperMain {

	public static void main(String[] args) {
		
		DataMapper mapper = new DataMapper();
		try {
			mapper.doMap(new File("./resources/MappingConfig4.js"),new File("./resources/input4.xml"),new File("./resources/inputSchema4.avsc"),new File("./resources/outputSchema4.avsc"));

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ScriptException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
