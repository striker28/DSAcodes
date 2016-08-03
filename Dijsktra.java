package algos;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Scanner;

/*
 * Input Sample
5 6
0 1 4
0 2 4
0 3 5
1 2 2
2 4 1
3 4 1

5 6
0 1 1
0 2 4
0 3 5
1 2 2
2 4 1
3 4 1
 */
class Dijkstra {
	
	private ArrayList<ArrayList<Pair>> al = new ArrayList<>();
	private PriorityQueue<Pair> queue = new PriorityQueue<>();
	private Boolean[] visited;
	private int[] dist;
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		Dijkstra dObject = new Dijkstra();
		
		dObject.initialize(n,m);
		dObject.doDijkstra();
		dObject.printResult();
		sc.close();
	}
	
	private void printResult() {
//		System.out.println("printing ans-----");
		for(int d : dist){
			System.out.println(d);
		}
		
	}

	private void initialize(int n, int m) {
		for(int i=0;i<n;i++){
			al.add(new ArrayList<Pair>());
		}
	
		
		for(int i=0;i<m;i++){
			int a = sc.nextInt();
			int b = sc.nextInt();
			int w = sc.nextInt();
			
			al.get(a).add(new Pair(b,w));
			al.get(b).add(new Pair(a,w));
			
		}
	
		visited = new Boolean[n];
		for(int i=0;i<n;i++){
			visited[i]=false;
		}
		
		dist = new int[n];
		for(int i=0;i<n;i++){
			dist[i]=Integer.MAX_VALUE;
		}
		
		dist[0]=0;
		queue.add(new Pair(0,0));
		
	}

	private void doDijkstra(){
		while(!queue.isEmpty()){
			Pair current = queue.poll();
			Iterator<Pair> itr = al.get(current.getV()).iterator();
		
			while(itr.hasNext()){
				Pair a = itr.next();
				int x = dist[current.getV()] + a.getW();
				if(x<dist[a.getV()]){
					dist[a.getV()]=x;
					queue.add(new Pair(a.getV(),x));
				}
			}
		}
	}
}

class Pair implements Comparable{
	
	private int v;
	private int w;
	
	public Pair(int v, int w){
		this.v=v;
		this.w=w;
	}
	public int getV() {
		return v;
	}

	public void setV(int v) {
		this.v = v;
	}

	public int getW() {
		return w;
	}

	public void setW(int w) {
		this.w = w;
	}
	@Override
	public int compareTo(Object o) {
		Pair p = (Pair)o;
		return this.w - p.getW();
	}

}

