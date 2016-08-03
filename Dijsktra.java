import java.io.*;
import java.util.*;
class Pair implements Comparable{
    private int w;  // distance
    private int v;  // vertex 1
    public Pair(int w, int v) {
        this.w = w;
        this.v = v;
    }
    public int compareTo(Object o){
        return this.w - ((Pair)o).w;
    }
    public int getw() {
        return w;
    }
    public void setw(int w) {
        this.w = w;
    }
    public int getv() {
        return v;
    }
    public void setv(int v) {
        this.v = v;
    }
}


public class Dijsktra{
    private int V;   // No. of vertices
    private LinkedList<Pair> adj[]; // Adjacency List Represntation
    Dijsktra(int v) {
        V = v;
        adj = new LinkedList[V];
        for(int i=0; i<v; ++i)
            adj[i] = new LinkedList<Pair>();
    }
    void addEdge(int v,int w, int z) {
        adj[v].add(new Pair(z,w));
        adj[w].add(new Pair(z,v));
    }
    public static void main(String args[])
    {
        int from,to,weight;
        int start,end;
        Scanner in = new Scanner(System.in);
        int n=in.nextInt();
        int m=in.nextInt();
        Dijsktra g1 = new Dikjstra(n);
        int dist[] = new int[n];
        for(int i=0;i<m;i++){
            from=in.nextInt();
            to=in.nextInt();
            weight=in.nextInt(); 
            g1.addEdge(from,to,weight);
        }
        start = in.nextInt();
       // end = in.nextInt();
        for (int i=0;i<n;i++){
            dist[i] = Integer.MAX_VALUE;
        }
        PriorityQueue<Pair> pq=new PriorityQueue(); 
        pq.add(new Pair(0,start));
        dist[start] = 0; // Distance From Start To Itself Is 0

        while (!pq.isEmpty()){
        	Pair current = pq.poll();
                System.out.println("Going to vertex: "+ current.getv());
        	Iterator<Pair> itr = g1.adj[current.getv()].iterator();
        	while (itr.hasNext()){
        		Pair a = itr.next();
        		int x = dist[current.getv()] + a.getw();
        		if (x < dist[a.getv()]) {
        			dist[a.getv()] = x;
        			pq.add(new Pair(x,a.getv()));
                                System.out.println("Updating: "+ " vertex: "+ a.getv() + " distance: "+ x +"  ");
                        }
        	}
        }
        for (int i=0;i<n;i++){	System.out.println("Distance To "+ i +" is "+dist[i]);}
    }
}


