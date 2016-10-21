package graphs;

import java.util.*;

/**
 * TODO : Implicit representation => Less space
 */

public class BFS {
    protected enum Color {
        WHITE,
        GRAY,
        BLACK
    }

    private Queue<BFSVertex> vertexQueue;
    private BFSVertex vertexSource;
    private BFSVertex[] list;

    public BFS(Integer numberOfNodes) {
        // We don't use the 0 position
        list = new BFSVertex[numberOfNodes + 1];
        vertexQueue =  new LinkedList<>();

        for (int graphVertex = 1; graphVertex <= numberOfNodes; graphVertex++) {
            list[graphVertex] = new BFSVertex(Color.WHITE, Double.POSITIVE_INFINITY, null, new LinkedList<>());
        }
    }

    public void addEdge(Integer u, Integer v) {
        list[u].getNeighbors().add(list[v]);
        list[v].getNeighbors().add(list[u]);
    }

    /**
     * Put all vertices to WHITE
     */
    public void calibrate() {
        for (int graphVertex = 1; graphVertex < list.length; graphVertex++) {
            list[graphVertex].setColor(Color.WHITE);
        }
    }

    public void calculateDistance(Integer source) {
        this.vertexSource = list[source];

        calibrate();

        vertexSource.setColor(Color.GRAY);
        vertexSource.setDistanceFromSource(0d);
        vertexSource.setPredecessor(null);
        vertexQueue.add(vertexSource);

        while (!vertexQueue.isEmpty()) {
            BFSVertex currentVertex = vertexQueue.poll();
            for (BFSVertex neighbour: currentVertex.getNeighbors()
                 ) {
                if (neighbour.getColor().equals(Color.WHITE)) {
                    neighbour.setColor(Color.GRAY);
                    neighbour.setDistanceFromSource(currentVertex.getDistanceFromSource() + 1);
                    neighbour.setPredecessor(currentVertex);
                    vertexQueue.add(neighbour);
                }
            }
            currentVertex.setColor(Color.BLACK);
        }

        printDistances();
    }

    private void printDistances() {
        Double value;
        boolean firstnospace = true;
        for (int i = 1; i < list.length; i++) {
            if (list[i].equals(vertexSource)) {
                continue;
            } else if (list[i].getDistanceFromSource().equals(Double.POSITIVE_INFINITY)) {
                value = -1d;
            } else {
                value = list[i].getDistanceFromSource();
            }

            if (firstnospace) {
                firstnospace = !firstnospace;
            } else {
                System.out.print(" ");
            }

            System.out.print((int) value.doubleValue());
        }
        System.out.println();
    }

    private static class BFSVertex {

        private BFS.Color color;
        private Double distanceFromSource;
        private BFSVertex predecessor;
        private LinkedList<BFSVertex> neighbors;

        public BFSVertex(BFS.Color color, Double distanceFromSource, BFSVertex predecessor, LinkedList<BFSVertex> neighbors) {
            this.color = color;
            this.distanceFromSource = distanceFromSource;
            this.predecessor = predecessor;
            this.neighbors = neighbors;
        }

        public LinkedList<BFSVertex> getNeighbors() {
            return neighbors;
        }

        public void setNeighbors(LinkedList<BFSVertex> neighbors) {
            this.neighbors = neighbors;
        }

        public BFS.Color getColor() {
            return color;
        }

        public void setColor(BFS.Color color) {
            this.color = color;
        }

        public Double getDistanceFromSource() {
            return distanceFromSource;
        }

        public void setDistanceFromSource(Double distanceFromSource) {
            this.distanceFromSource = distanceFromSource;
        }

        public BFSVertex getPredecessor() {
            return predecessor;
        }

        public void setPredecessor(BFSVertex predecessor) {
            this.predecessor = predecessor;
        }
    }
}
