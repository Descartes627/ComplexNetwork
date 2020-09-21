package Graph;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * 无向图，使用邻接链表实现
 *
 * @param <V> type of vertex labels in this graph, must be immutable
 * @param <E> type of edge distance in this graph
 */
public class Graph<V, E> {
    private Map<V, Vertex<V, E>> vertices;
    private int vertexCount = 0;
    private int edgeCount = 0;

    public Graph() {
        this.vertices = new HashMap<>();
    }

    /**
     * 向图中添加顶点
     *
     * @param v 顶点对象
     */
    public void addVertex(Vertex<V, E> v) {
        this.vertices.put(v.getLabel(), v);
        this.vertexCount++;
    }

    /**
     * 向图中添加边
     *
     * @param from     起始顶点标签
     * @param to       终止顶点标签
     * @param distance 距离
     */
    public void addEdge(V from, V to, E distance) {
        if (!vertices.containsKey(from)) {
            Vertex v = new Vertex<V, E>(from);
            this.vertices.put(from, v);
        }
        if (!vertices.containsKey(to)) {
            Vertex v = new Vertex<V, E>(to);
            this.vertices.put(to, v);
        }
        this.vertices.get(from).addEdge(to, distance);
        this.vertices.get(to).addEdge(from, distance);
        this.edgeCount++;
    }

    /**
     * 返回图数据
     *
     * @return 顶点对象Map的深拷贝
     */
    public Map<V, Vertex<V, E>> getVertices() {
        return new HashMap<>(this.vertices);
    }

    /**
     * 获取图中所有顶点的标签
     *
     * @return 顶点标签集合
     */
    public Set<V> getVertexLabels() {
        return this.vertices.keySet();
    }

    /**
     * 获取图的顶点数
     *
     * @return 顶点数
     */
    public int getVertexCount() {
        return this.vertexCount;
    }

    /**
     * 获取图的边数
     *
     * @return 边数
     */
    public int getEdgeCount() {
        return this.edgeCount;
    }

    /**
     * 计算图的Coreness
     *
     * @return coreness
     */
    public int getCoreness() {
        Map<V, Vertex<V, E>> vertices = this.getVertices();
        int coreness = 0;
        while (vertices.size() != 0) {
            boolean deleteVertex = false;
            Iterator<Map.Entry<V, Vertex<V, E>>> iterator = vertices.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<V, Vertex<V, E>> entry = iterator.next();
                V label = entry.getKey();
                if (vertices.get(label).getEdgeCount() < coreness) {
                    for (V neighbour : vertices.get(label).getNeighbourLabels()) {
                        vertices.get(neighbour).removeEdge(label);
                    }
                    iterator.remove();
                    if (!deleteVertex) {
                        deleteVertex = true;
                    }
                }
            }
            if (!deleteVertex) {
                coreness += 1;
            }
        }
        return coreness;
    }
}
