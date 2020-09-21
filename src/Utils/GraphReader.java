package Utils;

import Graph.Graph;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class GraphReader {
    public GraphReader() {
    }

    public static Graph<String, Integer> readEdgeList(String path) {
        Graph graph = new Graph();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(path));
            Throwable var3 = null;

            try {
                String line;
                try {
                    while((line = reader.readLine()) != null) {
                        String[] vertices = line.split(" ");
                        graph.addEdge(vertices[0], vertices[1], 1);
                    }
                } catch (Throwable var14) {
                    var3 = var14;
                    throw var14;
                }
            } finally {
                if (reader != null) {
                    if (var3 != null) {
                        try {
                            reader.close();
                        } catch (Throwable var13) {
                            var3.addSuppressed(var13);
                        }
                    } else {
                        reader.close();
                    }
                }

            }
        } catch (IOException var16) {
            var16.printStackTrace();
        }

        return graph;
    }
}
