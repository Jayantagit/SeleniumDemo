package Demo.Demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SampleTest2 {

	public static void main(String[] args) {
	
		List<String> l1=new ArrayList<String>();
		l1.add("Java");
		l1.add("Python");
		l1.add("Ruby");
		
		l1.parallelStream().forEachOrdered(s->System.out.println(s));
		System.out.println("=====================");
		l1.forEach(s->System.out.println(s));
		System.out.println("=====================");
		for(String e:l1)
		{
			System.out.println(e);
		}
		System.out.println("=====================");
		
		for(int i=0;i<l1.size();i++)
		{
			System.out.println(l1.get(i));
		}
		
		List<String> allList=Arrays.asList("Java","Python","C++");
		System.out.println(allList);
		
		Set<String> hs=new HashSet<String>();
		
		

	}

}
