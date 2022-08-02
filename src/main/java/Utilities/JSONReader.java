package Utilities;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JSONReader {
	
	public String  readData(String value) throws IOException, ParseException
	{
		JSONParser jsonparser = new JSONParser();
		FileReader reader = new FileReader("C:\\Users\\Sukannya Ghosh\\eclipse-workspace\\project1\\src\\main\\java\\Utilities\\testData.json");
		String creds;
		Object obj = jsonparser.parse(reader);
		
		JSONObject jsonobject =(JSONObject)obj;		
		
		if(value.contentEquals("email"))
		{
			creds = (String)jsonobject.get("email");			
		}
		else
		{
			creds=(String)jsonobject.get("password");
		}
		return creds;
			
	}

}
