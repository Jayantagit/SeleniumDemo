package Interview;

import java.util.Map;
import java.util.TreeMap;

public class TreeMapEx  {

	public static void main(String[] args) {
		
		Map<Integer,String> stu=new TreeMap();
		stu.put(3,"Jack");
		stu.put(6,"Kim");
		stu.put(3,"John");
		stu.put(7,"Amy");
		for(Integer key:stu.keySet())
		{
			System.out.println(stu.get(key));
		}
		

	}

}
