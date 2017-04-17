package json;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ParseMain {

	public static void main(String[] args) {
		//JavaScript Object Notation
		//아래의 문자열은 현재까지는 그냥 문자열일 뿐, 즉 아무런 의미가 없는 데이터일 뿐이다
		//하지만, 추후에 JSON으로 인식시켜 사용해보자..
		//즉 JSON Parsing 과정이 필요하다..
		StringBuffer sb=new StringBuffer();
		sb.append("{");
		sb.append("\"name\" : \"아웃백 스테이크 하우스\",");
		sb.append("\"loc\" : \"호주\",");
		sb.append("\"menus\" : [");
		sb.append("{");
		sb.append("\"name\" :\"투움바 파스타\" ,\"price\":20000");
		sb.append("},");
		sb.append("{");
		sb.append("\"name\" :\"립아이\" ,\"price\":23000");
		sb.append("},");
		sb.append("{");
		sb.append("\"name\" :\"오지 치즈 후라이\" ,\"price\":17000");
		sb.append("},");
		sb.append("]");	
		sb.append("}");	
		
	//	System.out.println(sb.toString());
		
		//위의 문자열을 자바언어가 JSON으로 처리하도록 해석해보자!!
		//이 작업을 위해서는 JSON을 이해하는 프로그램이 필요하다!! 
		//javaSE에는 JSON파서가 포함되어 있지 않기 때문에 외부의 라이브러리를 이용해 본다!
		JSONParser parser=new JSONParser();
		try {
			//파싱한 결과물을 반환받자!!
			//파싱한 이후부터는 위의 json문자열을
			//마치 객체처럼 사용할 수 있다..
			JSONObject obj=(JSONObject)parser.parse(sb.toString());
			String name=(String)obj.get("name");
			System.out.println(name);
			System.out.println((String)obj.get("loc"));
			
			//json 표기법이 배열일 경우, 그 반환되는 값을 JSONArray로 받을 수 있다
			JSONArray array=(JSONArray)obj.get("menus");
		
			for(int i=0; i<array.size(); i++){
				JSONObject json=(JSONObject)array.get(i);
				System.out.println(json.get("name")+","+json.get("price"));
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		
		}
	}

