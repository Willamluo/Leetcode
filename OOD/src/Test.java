import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

class Test implements Serializable{

	@SuppressWarnings("finally")
	public int methodToBeOverloaded(int p1) 
	{
		 try{
		        System.exit(0);
		    }finally{
		        return 43;
		    }
	}
	
	public char findFirstNonRepeated(String s)
	{
		HashMap<Character, Integer> hashmap = new HashMap<Character, Integer>();
		for(char c : s.toCharArray())
		{
			if(hashmap.containsKey(c))
				hashmap.put(c, hashmap.get(c) + 1);
			else
				hashmap.put(c, 1);
		}
		char firstNonRepeatedChar = ' ';
		for(char c : s.toCharArray())
		{
			if(hashmap.get(c) == 1)
			{
				firstNonRepeatedChar = c;
				break;
			}
		}
		return firstNonRepeatedChar;
		
	}
	
	public Method findInheritedMethod(Class classType, String theMethodName, Class[] methodParamTypes) {
		Method inheritedMethod = null;
		while (classType != null) {
			try {
				inheritedMethod = classType.getDeclaredMethod(theMethodName, methodParamTypes);
				
				break;
			}

			catch (NoSuchMethodException ex) {

				classType = classType.getSuperclass();

			}
		}
		return inheritedMethod;
	}
	
    public int findMedian(int[] nums, int start, int end)
    {
        int median = Integer.MAX_VALUE;
        for(int i = 0; i < 3; i++)
        {
            int max = Integer.MIN_VALUE;
            for(int j = start; j <= end; j++)
            {
                if(nums[j] > max && nums[j] < median)
                    max = nums[j];
            }
            median = max;
        }
        return median;
    }
    
    public void generateGrades()
    {
    	ArrayList<String> lines = readFile("grades.txt");
    	for(String line : lines)
    	{
    		String[] grades = line.split("\\s+");
    		//System.out.println(grades.length);
    		double[] g = convert(grades);
    		double grade = caculateGrade(g);
    		System.out.printf("%.2f\n",grade);
    		
    	}
    }
    public double[] convert(String[] grades)
    {
    	double[] g = new double[grades.length];
    	for(int j = 0; j < g.length; j++)
    	{
    		g[j] = Double.parseDouble(grades[j]);
    	}
    	return g;
    }
    public double caculateGrade(double[] grades)
    {
    	if(grades.length < 12)
    	{
    		double[] temp = new double[12];
    		for(int i = 0; i < 12; i++)
    		{
    			if(i < grades.length)
    				temp[i] = grades[i];
    			else
    				temp[i] = 0;
    		}
    		grades = temp;
    	}
    	Arrays.sort(grades);
    	double grade = 0;
    	for(int i = 2; i < grades.length; i++)
    	{
    		//System.out.print(grades[i] + "  ");
    		grade += grades[i] / 10 * 2;
    	}
//    	System.out.println();
    	return grade;
    }
    public ArrayList<String> readFile(String path)
    {
    	String line = null;
    	ArrayList<String> lines = new ArrayList<String>();
    	try {
			FileReader r = new FileReader(path);
			BufferedReader bufferedReader = 
		                new BufferedReader(r);
	        while((line = bufferedReader.readLine()) != null) {
	                //System.out.println(line);
	                lines.add(line);
	            }    

	            // Always close files.
	            bufferedReader.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return lines;
    	
    }
}


 
// class SubClass extends Test{
//	 @Override
//	  public int methodToBeOverloaded(int p1)
//	 {
//		 return 1;
//	 }
// }
 
 
