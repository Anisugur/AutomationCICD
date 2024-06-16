package anirudh.data;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DataReader {

	public List<HashMap<String, String>> getJsonDataToMap() throws IOException {
		
		String jsocontent= FileUtils.readFileToString(new File("C:\\Users\\Ani\\eclipse-workspace\\SeleniumFrameworkDesign\\src\\test\\java\\anirudh\\data\\Purchaseorder.json"),StandardCharsets.UTF_8);
		
		ObjectMapper Mapper = new ObjectMapper();
		List<HashMap <String,String>> data = Mapper.readValue(jsocontent,new TypeReference<List<HashMap<String,String>>>(){});
		return data;
	}
}
