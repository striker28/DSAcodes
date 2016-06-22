/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication9;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Ayush
 */
/*class Queue{
    Queue(int n){
        int data = n;
        
    }
}*/
public class BFS {
    static ArrayList<ArrayList<Integer>> al = new ArrayList<ArrayList<Integer>>();
    static Boolean[] visited;
    static int n=0;
    static int layer=0;
    static int m=0;
    static int timeLeft=1;     //timeLeft before moving onto next layer
    static ArrayList<Integer> queue = new ArrayList<>();
    public static void main(String args[]){
	 
        /*Taking Input and stuff */
          
        
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
        /* The real code begins here
            First call for DFS is from inside the visit function dfs(0)
         */
            queue.add(0);
            while(!queue.isEmpty()){
                bfs(queue.get(0));
                
                if(timeLeft==0){
                    layer++;
                    //System.out.println("layer: "+ layer);
                    timeLeft=queue.size();
                    
                }
                
            }
           // visit();
         }
	
	public static void bfs(int n){   
                                 
		visited[n]=true;
                System.out.println("Visiting node:  " + n+ " ---   timeLeft is:  "+ timeLeft);
                System.out.println("This Node is in layer:--- " + layer);
               // System.out.println("In Layer "+ layer);
            	for(Integer list:al.get(n)){
			if(!visited[list]){
                            queue.add(list);
                        }
		}
                
                queue.remove(0);
                timeLeft--;
                
	}

        public static void visit(){
		for(int i=0;i<n;i++){
			if(!visited[n]){
                          bfs(n);  
                        }
		}
		
	}
}
