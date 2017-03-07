package org.cx.util.json;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.core.JsonFactory.Feature;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.node.ArrayNode;


public class JacksonUtil {

	public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		
//		//配置为true表示mapper接受只有一个元素的数组的反序列化
//		mapper.configure(Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
//		 
//		//配置为false表示mapper在遇到mapper对象中存在json对象中没有的数据变量时不报错，可以进行反序列化
//		mapper.configure(Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
//		 
//		//新版的jackson设置mapper的方法，功能同上
//		mapper.getDeserializationConfig().without(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES);
//		 
//		//定义针对日期类型的反序列化时的数据格式
//		mapper.getDeserializationConfig().setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
//		mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));

		//格式化输出   尽量使用这种方式  之前的mapper.getSerializationConfig().setXxx方法现在很多都已经被标注为@Deprecated了
//		mapper.configure(SerializationConfig.Feature.INDENT_OUTPUT,Boolean.TRUE);
//		mapper.configure(SerializationFeature.INDENT_OUTPUT, Boolean.TRUE);
		
		School school = new School();
		school.setId(123);
		school.setSchoolName("school name...");
		List<Student> stuList = new ArrayList<Student>();
		
		Student stu = new Student();
		stu.setId(1);
		stu.setAge(18);
		stu.setName("asdasd");
		stu.setCreateTime(new Date());
		stuList.add(stu);
		school.setStuList(stuList);
		
		System.out.println(mapper.writeValueAsString(school));
		
		
		String jsonStr = "{\"id\":123,\"schoolName\":\"school name...\",\"stuList\":[{\"id\":1,\"age\":18,\"name\":\"asdasd\",\"address\":null,\"createTime\":1488877882639}]}";
		School scho = mapper.readValue(jsonStr, School.class);
		System.out.println(scho.toString());
		
		JsonNode jn = mapper.readTree(jsonStr);
		System.out.println(jn.get("schoolName"));
		ArrayNode array = (ArrayNode) jn.get("stuList");
		for (JsonNode node : array) {
			System.out.println(node.get("createTime"));
		}
		
	}

}
