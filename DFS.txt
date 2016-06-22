/*

	SAMPLE INPUT
10 9
0 1
0 2
1 5
1 6
2 3
2 4
6 7
6 8
8 9


*/
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class Solution {
    static ArrayList<ArrayList<Integer>> al = new ArrayList<ArrayList<Integer>>();
    static Boolean[] visited;
    static int flag=0;
    static int n=0;
    static int m=0;
    public static void main(String args[]){
	 Scanner in = new Scanner(System.in);
         n = in.nextInt();
         m = in.nextInt();
         visited = new Boolean[n];
         for(int j=0;j<n;j++){
            visited[j]=false;
         }
         int a;
         int b;
        
         for(int i=0;i<n;i++){
             al.add(new ArrayList<Integer>());
         }
         for(int i=0;i<m;i++){
        	 a= in.nextInt();
        	 
             b= in.nextInt();
             al.get(a).add(b);
             al.get(b).add(a);
         }
        
        visit();
         
	}
	
	public static void dfs(int n)
	{   
		visited[n]=true;
                System.out.println("Visiting node:  " + n);
            	for(Integer list:al.get(n))
		{
			if(al.get(n)!=null)
			{	
				if(!visited[list]){
					dfs(list);
				}
			}
		}
	
	
	}
	public static void visit()
	{
		for(int i=0;i<n;i++)
		{
			if(!visited[n]){
                          dfs(n);  
                        }
		}
		
	}
		
}
