package json;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ParseMain {

	public static void main(String[] args) {
		//JavaScript Object Notation
		//�Ʒ��� ���ڿ��� ��������� �׳� ���ڿ��� ��, �� �ƹ��� �ǹ̰� ���� �������� ���̴�
		//������, ���Ŀ� JSON���� �νĽ��� ����غ���..
		//�� JSON Parsing ������ �ʿ��ϴ�..
		StringBuffer sb=new StringBuffer();
		sb.append("{");
		sb.append("\"name\" : \"�ƿ��� ������ũ �Ͽ콺\",");
		sb.append("\"loc\" : \"ȣ��\",");
		sb.append("\"menus\" : [");
		sb.append("{");
		sb.append("\"name\" :\"����� �Ľ�Ÿ\" ,\"price\":20000");
		sb.append("},");
		sb.append("{");
		sb.append("\"name\" :\"������\" ,\"price\":23000");
		sb.append("},");
		sb.append("{");
		sb.append("\"name\" :\"���� ġ�� �Ķ���\" ,\"price\":17000");
		sb.append("},");
		sb.append("]");	
		sb.append("}");	
		
	//	System.out.println(sb.toString());
		
		//���� ���ڿ��� �ڹپ� JSON���� ó���ϵ��� �ؼ��غ���!!
		//�� �۾��� ���ؼ��� JSON�� �����ϴ� ���α׷��� �ʿ��ϴ�!! 
		//javaSE���� JSON�ļ��� ���ԵǾ� ���� �ʱ� ������ �ܺ��� ���̺귯���� �̿��� ����!
		JSONParser parser=new JSONParser();
		try {
			//�Ľ��� ������� ��ȯ����!!
			//�Ľ��� ���ĺ��ʹ� ���� json���ڿ���
			//��ġ ��üó�� ����� �� �ִ�..
			JSONObject obj=(JSONObject)parser.parse(sb.toString());
			String name=(String)obj.get("name");
			System.out.println(name);
			System.out.println((String)obj.get("loc"));
			
			//json ǥ����� �迭�� ���, �� ��ȯ�Ǵ� ���� JSONArray�� ���� �� �ִ�
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

