package Exempelkoder;

import java.util.*;

/**
 * Oriktad graf
 */
public class ListGraphExample {

    private final Map<CityExample, Set<EdgeExample>> nodes = new HashMap<>();

    public void add(CityExample city) {
        nodes.putIfAbsent(city, new HashSet<>());
    }

    public void connect(CityExample a, CityExample b, String name, double weight) {
        add(a);
        add(b);

        Set<EdgeExample> aEdges = nodes.get(a);
        Set<EdgeExample> bEdges = nodes.get(b);

        aEdges.add(new EdgeExample(b, name, weight));
        bEdges.add(new EdgeExample(a, name, weight));

    }

    public boolean pathExists(CityExample a, CityExample b) {
        Set<CityExample> visited = new HashSet<>();
        depthFirstVisitAll(a, visited);
        return visited.contains(b);
    }

    public List<EdgeExample> getAnyPath(CityExample from, CityExample to) {
        Map<CityExample, CityExample> connection = new HashMap<>();
        depthFirstConnection(from, null, connection);
        if (!connection.containsKey(to)) {
            return Collections.emptyList();
        }
        return gatherPath(from, to, connection);
    }

    public List<EdgeExample> getShortestPath(CityExample from, CityExample to) {
        Map<CityExample, CityExample> connections = new HashMap<>();
        connections.put(from, null);

        LinkedList<CityExample> queue = new LinkedList<>();
        queue.add(from);
        while (!queue.isEmpty()) {
            CityExample city = queue.pollFirst();
            for (EdgeExample edge : nodes.get(city)) {
                CityExample destination = edge.getDestination();
                if (!connections.containsKey(destination)) {
                    connections.put(destination, city);
                    queue.add(destination);
                }
            }
        }

        if (!connections.containsKey(to)) {
            throw new IllegalStateException("no connection");
        }

        return gatherPath(from, to, connections);

    }

    private List<EdgeExample> gatherPath(CityExample from, CityExample to, Map<CityExample, CityExample> connection) {
        LinkedList<EdgeExample> path = new LinkedList<>();
        CityExample current = to;
        while (!current.equals(from)) {
            CityExample next = connection.get(current);
            EdgeExample edge = getEdgeBetween(next, current);
            path.addFirst(edge);
            current = next;
        }
        return Collections.unmodifiableList(path);
    }

    private EdgeExample getEdgeBetween(CityExample next, CityExample current) {
        for (EdgeExample edge : nodes.get(next)) {
            if (edge.getDestination().equals(current)) {
                return edge;
            }
        }

        return null;
    }

    private void depthFirstConnection(CityExample to, CityExample from, Map<CityExample, CityExample> connection) {
        connection.put(to, from);
        for (EdgeExample edge : nodes.get(to)) {
            if (!connection.containsKey(edge.getDestination())) {
                depthFirstConnection(edge.getDestination(), to, connection);
            }
        }

    }

    private void depthFirstVisitAll(CityExample current, Set<CityExample> visited) {
        visited.add(current);
        for (EdgeExample edge : nodes.get(current)) {
            if (!visited.contains(edge.getDestination())) {
                depthFirstVisitAll(edge.getDestination(), visited);
            }
        }
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (CityExample city : nodes.keySet()) {
            sb.append(city).append(": ").append(nodes.get(city)).append("\n");
        }
        return sb.toString();
    }


}
