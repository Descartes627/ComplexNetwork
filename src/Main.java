import Graph.Graph;
import Utils.GraphReader;

public class Main {

    public static void main(String[] args) {
        Graph<String, Integer> graph = GraphReader.readEdgeList("res/BA.txt");
        System.out.println(graph.getCoreness());
    }
}
