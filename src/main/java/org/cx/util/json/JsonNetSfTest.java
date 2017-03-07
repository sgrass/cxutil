package org.cx.util.json;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonValueProcessor;
import net.sf.json.util.JSONUtils;

public class JsonNetSfTest {

	public static void main(String[] args) {
		
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
		
		//转换date为long
		JsonConfig config = new JsonConfig();
		config.registerJsonValueProcessor(Date.class, new JsonValueProcessor() {
			
			public Object processObjectValue(String key, Object value, JsonConfig jsonConfig) {
				Date d = (Date) value;
				return d.getTime();
			}
			
			public Object processArrayValue(Object value, JsonConfig jsonConfig) {
				Date d = (Date) value;
				return d.getTime();
			}
		});
		
		JSONObject jsonObject = JSONObject.fromObject(school,config);
		System.out.println(jsonObject.toString());
		
		//========tobean
		//转换long型为date
		JSONUtils.getMorpherRegistry().registerMorpher(new TimestampToDateMorpher(),true);
		
		String jsonStr = "{\"id\":123,\"schoolName\":\"school name...\",\"stuList\":[{\"address\":[],\"age\":18,\"createTime\":1488878473176,\"id\":1,\"name\":\"asdasd\"}]}";
		JSONObject jsonObj = JSONObject.fromObject(jsonStr);
		
		Map<String, Class<Student>> map = new HashMap<String, Class<Student>>();
		map.put("stuList", Student.class);
		
		School sch = (School) JSONObject.toBean(jsonObj, School.class, map);
		System.out.println(sch.toString());
		
		JSONObject obj = JSONObject.fromObject(jsonStr);
		System.out.println(obj.get("name"));
	}

}
