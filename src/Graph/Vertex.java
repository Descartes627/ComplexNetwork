package Graph;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Vertex<V, E> {
    private V label;
    private Map<V, E> edges;

    public Vertex(V label) {
        this.label = label;
        this.edges = new HashMap<>();
    }

    /**
     * 添加顶点的边
     *
     * @param label    邻接顶点的标签
     * @param distance 距离
     */
    public void addEdge(V label, E distance) {
        edges.put(label, distance);
    }

    /**
     * 删除顶点的一条边
     *
     * @param label 邻接顶点的标签
     */
    public void removeEdge(V label) {
        edges.remove(label);
    }

    /**
     * 获取顶点的标签
     *
     * @return 标签
     */
    public V getLabel() {
        return label;
    }

    /**
     * 获取顶点的边数据
     *
     * @return 邻接矩阵Map
     */
    public Map<V, E> getEdges() {
        return edges;
    }

    /**
     * 获取顶点的边数
     *
     * @return 边数
     */
    public int getEdgeCount() {
        return this.edges.size();
    }

    /**
     * 获取顶点所有邻接顶点的标签
     *
     * @return 邻接顶点标签集合
     */
    public Set<V> getNeighbourLabels() {
        return this.edges.keySet();
    }
}
