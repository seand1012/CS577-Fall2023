import java.util.*;

public class Bipartite {
    
    public Bipartite(){

    }
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int instances = scan.nextInt();

        for(int i = 0; i < instances; i++){
            int m = scan.nextInt(); // number of nodes in set A
            int n = scan.nextInt(); // number of nodes in set B
            int numEdges = scan.nextInt(); // number of edges in graph
            ArrayList<Integer> setA = new ArrayList<>();
            ArrayList<Integer> setB = new ArrayList<>();
            NetworkFlow g = new NetworkFlow(numEdges);

            for(int j = 0; j < numEdges; j++){
                setA.add(scan.nextInt());
                setB.add(scan.nextInt());
            }

            for(int j = 0; j < setA.size(); j++){
                g.addEdge(numEdges, j);
            }
            addSuperSource(g, setA);
            addSuperSink(g, setB);
            int maxFlow = g.maxFlow(1, n);
            
            StringBuilder sb = new StringBuilder();
            for(int[] s1 : g.getCapMatrix()){
                sb.append(Arrays.toString(s1)).append('\n');
            }
            String s = sb.toString();
           // System.out.println(s);
            // if m == n && maxFlow == m
                // return Y
            if(m == n && maxFlow == m){
                System.out.println(maxFlow + " Y");
            }
            else{
                System.out.println(maxFlow + " N");
            }
        }

        scan.close();
    }
    

    public static void addSuperSource(NetworkFlow g, ArrayList<Integer> setA){
        for(int i = 1; i < setA.size(); i++){
            g.addEdge(0, i);
        }
    }
    public static void addSuperSink(NetworkFlow g, ArrayList<Integer> setB){
        for(int i = 1; i < setB.size(); i++){
            g.addEdge(i, setB.size()+1);
        }
    }
}
