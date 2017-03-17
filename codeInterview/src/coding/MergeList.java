package coding;

import java.util.ArrayList;
import java.util.List;

public class MergeList {

	public static void main(String[] args) {
		
		List<String> l1 =new ArrayList<String>();
		l1.add("Hello");
		
		List<String> l2 =new ArrayList<String>();
		l2.add("World");
		
		List<String> mergeList = MergeList.merge(l1, l2);
		System.out.println(mergeList.toString());

	}

	public static List<String> merge(List<String> list1, List<String> list2) {
		
		List<String> mergeList = new ArrayList<String>(); 
		
		list1.forEach((i) ->{
			mergeList.add(i);
		});
		
		list2.forEach((i) ->{
			mergeList.add(i);
		});
		
		return mergeList;
		
	}
	
	
	
	public double add(double d1, double d2) {
		return d1+d2;
	}
	
}
