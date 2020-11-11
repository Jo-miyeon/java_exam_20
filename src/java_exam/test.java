package java_exam;

import java.io.FileOutputStream;
import java.io.OutputStream;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

public class test {
	public static void main(String[] args) {
		//json읽기
		String jsonStr = "[0,{\"1\":{\"2\":{\"3\":{\"4\":[5,{\"6\":7}]}}}}]";
		
		JSONArray array = (JSONArray) JSONValue.parse(jsonStr);//배열
		System.out.println(array.get(1));
		
		JSONObject obj2 = (JSONObject)array.get(1); //맵이랑 똑같은 기능수행
	    System.out.println("Field \"1\"");
	    System.out.println(obj2.get("1"));    
		
	    JSONObject obj = new JSONObject();
	    String jsonText;
	    //맵저장과동일
	    obj.put("id", new Integer(1));
	    obj.put("title", "제목");
	    obj.put("body", "내용");
	    obj.put("nickname", "홍길동");
	    jsonText = obj.toString();

	    System.out.println("Encode a JSON Object - to String");
	    System.out.print(jsonText);

		JSONObject jobj = (JSONObject)JSONValue.parse(jsonText);
		long s1 = (long)jobj.get("id");
		String s2 = (String)jobj.get("title");
		String s3 = (String)jobj.get("body");
		String s4 = (String)jobj.get("nickname");
		
		
//		//json쓰기
//		JSONArray list = new JSONArray();
//	    String jsonText;
//
//	    list.add("foo");
//	    list.add(new Integer(100));
//	    list.add(new Double(1000.21));
//	    list.add(new Boolean(true));
//	    list.add(null);
//	    jsonText = list.toString();
//
//	    System.out.println("Encode a JSON Array - to String");
//	    System.out.print(jsonText);
//		JSONArray array = (JSONArray)JSONValue.parse(jsonText);	
//		String s1 = (String)array.get(0);
//		long s2 = (long)array.get(1); //json에서는 숫자를 long으로 받는다
//		double s3 = (double)array.get(2);
//		boolean s4 = (boolean)array.get(3);
//		
//		
		
		try {
			OutputStream output = new FileOutputStream("C:/test/test.txt");
			String str = "오늘 날씨는 아주 좋습니다.";
			byte[] by = str.getBytes();
			output.write(by);

		} catch (Exception e) {
			e.getStackTrace();
		}
	}
}
