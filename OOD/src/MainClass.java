import java.util.List;
import java.util.*;
import java.util.Stack;
import graphs.*;
import dynamicprogramming.*;
import backtrack.*;

public class MainClass {

	/**
	 * @param args
	 * @throws NoSuchFieldException 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Test test = new Test();
		//System.out.println(test.findFirstNonRepeated("repeat"));
//		SubClass subClass = new SubClass();
//		System.out.print(subClass.methodToBeOverloaded(2));
		Class[] types = new Class[1];
		//types[0] = (new Object()).getClass();
		Class<?>[] typeClass = test.findInheritedMethod("".getClass(), "toString", new Class[0]).getParameterTypes();
		//System.out.println(test.findInheritedMethod("".getClass(), "toString", new Class[0]).getName());
		for(Class<?> type : typeClass)
		{
			System.out.println(type.getName());
		}
		int[] nums = new int[]{9, 4, 1, 6,3};
		double[] grades = new double[]{9.75,10,	8.2,10,	8,	10,	10,	10,	9.5, 10};
		double gg = 0d;
		for(double g : grades)
		{
			gg += g * 0.2;
		}
		//System.out.println(gg);
		//System.out.println(test.findMedian(nums, 0, nums.length - 1));
		//test.generateGrades();
		//System.out.println(Math.ceil(6.1));
		FindKthLargest f = new FindKthLargest();
		int[] array = new int[]{3,1,2,4};
		int[] a = new int[0];
		//int n =   4294967295;
		System.out.println( "11111111111111111111111111111111".length());
		//System.out.println(array[f.findMedian(array, 0, array.length - 1)]);
		//System.out.println(f.findKthLargest(array, 1));
		//System.out.println(f.partition(array, 0, array.length - 1, 0));
		int n = 1;
		n <<= 1;
//		System.out.println(n);
//		System.out.println(Integer.toBinaryString(5));
//		System.out.println(Integer.toBinaryString(5 >> 32));
		List<String> list = (new FindRepeatedDnaSequences()).findRepeatedDnaSequences("AAAAAAAAAAAA");
		for(int i = 0; i < list.size(); i++)
		{
			System.out.println(list.get(i));
		}
		Integer i = new Integer(1);
		Integer j = new Integer(1);
//		System.out.println(i.equals(j));
//		Stack<Integer> stack = new Stack<Integer>();
//		char c = ' ';
//		System.out.println(c);
		WordDictionary dict = new WordDictionary();
		dict.addWord("at");
		dict.addWord("and");
		dict.addWord("an");
		dict.addWord("add");
		//System.out.println(dict.search("."));
		Cache<Integer, Integer> cache = new Cache<Integer, Integer>(4);
		cache.put(1, 1);
		cache.put(2, 2);
		cache.put(3, 3);
		cache.put(4, 4);
		cache.remove(1);
		cache.put(1, 1);
		cache.put(5, 5);
//		System.out.println(cache.get(2));
//		System.out.println(Math.ceil(1 /2.0));
		//LinkedListOperation lo = new LinkedListOperation();
		//System.out.println("List: ");
		//lo.createLinkedList();
		
		//Graph Operation test
        Graph gDfs = GraphImplementation.createNewGraph();
        GraphImplementation s = new GraphImplementation();

        System.out.println("--------------DFS---------------");
        //s.dfs(gDfs.getNode()[0]);
        System.out.println();
        System.out.println();
        Graph gBfs = GraphImplementation.createNewGraph();
        System.out.println("---------------DFS Iteration---------------");
        //s.dfsIteration(gBfs.getNode()[0]);
        System.out.println();
		//System.out.println(new UniquePath().uniquePaths(2, 3));
		
		//System.out.println(new RegularExpression().isMatch("a", "a*"));
		//System.out.println();
		//System.out.println(new ScambledString().isScramble("abcdefghijklmn", "efghijklmncadb"));
		//System.out.println(new DistinctSubsequences().numDistinct("bddaddcaeef", "bddabdcae"));
		//System.out.println("aabdbaabeeadcbbdedacbbeecbabebaeeecaeabaedadcbdbcdaabebdadbbaeabdadeaabbabbecebbebcaddaacccebeaeedababedeacdeaaaeeaecbe".length());
		int[] prices = new int[]{2,1,2,0,1};
		//System.out.println(new NQueens().solveNQueens(9).size());
		System.out.println("----- Word Ladder-------");
		Set<String> set = new HashSet<String>();
		set.add("hot");
		set.add("dot");
		set.add("lot");
		set.add("log");
		set.add("dog");
		//set.add("cog");
		System.out.println(new WordLadder().ladderLength("hit", "cog", set));
	}

}
