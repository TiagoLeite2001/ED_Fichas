
///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package classes;
//
//import exceptions.ElementNotFoundException;
//import exceptions.EmptyCollectionException;
//import interfaces.GraphADT;
//
//
//import java.util.Iterator;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//
///**
// *
// * @author tiago
// */
///**
// * Graph represents an adjacency matrix implementation of a graph.
// *
// * @param <T>
// */
//public class GraphAdjArray<T> implements GraphADT<T> {
//
//    protected final int DEFAULT_CAPACITY = 10;
//    protected int numVertices; // number of vertices in the graph
//    protected int[][] adjList; // adjacency list
//    protected T[] vertices; // values of vertices
//
//    /**
//     * Creates an empty graph.
//     */
//    public GraphAdjArray() {
//        numVertices = 0;
//        this.adjList = new int[DEFAULT_CAPACITY][DEFAULT_CAPACITY];
//        this.vertices = (T[]) (new Object[DEFAULT_CAPACITY]);
//    }
//
//    /**
//     * Inserts an edge between two vertices of the graph.
//     *
//     * @param vertex1 the first vertex
//     * @param vertex2 the second vertex
//     */
//    @Override
//    public void addEdge(T vertex1, T vertex2) {
//        try {
//            addEdge(getIndex(vertex1), getIndex(vertex2));
//        } catch (ElementNotFoundException ex) {
//            System.out.println("Element does not exists");
//        }
//    }
//
//    private int getIndex(T vertex) throws ElementNotFoundException {
//        for (int i = 0; i < numVertices; i++) {
//            if (vertices[i].equals(vertex)) {
//                return i;
//            }
//        }
//        throw new ElementNotFoundException("Element Not Found");
//    }
//
//    /**
//     * Inserts an edge between two vertices of the graph.
//     *
//     * @param index1 the first index
//     * @param index2 the second index
//     */
//    public void addEdge(int index1, int index2) {
//        if (indexIsValid(index1) && indexIsValid(index2)) {
//            adjMatrix[index1][index2] = true;
//            adjMatrix[index2][index1] = true;
//        }
//    }
//
//    public boolean indexIsValid(int index) {
//        return (index < this.numVertices && index >= 0);
//    }
//
//    /**
//     * Adds a vertex to the graph, expanding the capacity of the graph if necessary.
//     * It also associates an object with the vertex.
//     *
//     * @param vertex the vertex to add to the graph
//     */
//    public void addVertex(T vertex) {
//        if (numVertices == vertices.length) {
//            expandCapacity();
//        }
//        vertices[numVertices] = vertex;
//        for (int i = 0; i <= numVertices; i++) {
//            adjMatrix[numVertices][i] = false;
//            adjMatrix[i][numVertices] = false;
//        }
//        numVertices++;
//    }
//
//    protected void expandCapacity() {
//        T[] newVertices = (T[]) (new Object[vertices.length*2]);
//        boolean newMatrixAdj[][] = new boolean[vertices.length * 2][vertices.length * 2];
//        
//        for(int i=0; i<numVertices; i++){
//            for(int j=0; j<numVertices; j++){
//                newMatrixAdj[i][j] = adjMatrix[i][j];
//            }
//        }
//        this.adjMatrix=newMatrixAdj;
//
//        for (int i = 0; i < numVertices; i++) {
//            newVertices[i] = vertices[i];
//        }
//        this.vertices = newVertices;
//    }
//
//    public boolean[][] getAdjMatrix() {
//        return adjMatrix;
//    }
//
//    public void setAdjMatrix(boolean[][] adjMatrix) {
//        this.adjMatrix = adjMatrix;
//    }
//
//    public T[] getVertices() {
//        return vertices;
//    }
//
//    public void setVertices(T[] vertices) {
//        this.vertices = vertices;
//    }
//
//    /**
//     * Returns an iterator that performs a depth first search traversal starting at
//     * the given index.
//     *
//     * @param startIndex the index to begin the search traversal from
//     * @return an iterator that performs a depth first traversal
//     */
//    public Iterator<T> iteratorDFS(int startIndex) throws EmptyCollectionException {
//        Integer x;
//        boolean found;
//        LinkedStack<Integer> traversalStack = new LinkedStack<>();
//        ArrayUnorderedList<T> resultList = new ArrayUnorderedList<>();
//        boolean[] visited = new boolean[numVertices];
//        if (!indexIsValid(startIndex)) {
//            return resultList.iterator();
//        }
//        for (int i = 0; i < numVertices; i++) {
//            visited[i] = false;
//        }
//
//        traversalStack.push(startIndex);
//        resultList.addToRear(vertices[startIndex]);
//        visited[startIndex] = true;
//        while (!traversalStack.isEmpty()) {
//            x = traversalStack.peek();
//            found = false;
//            /**
//             * Find a vertex adjacent to x that has not been visited and push it on the
//             * stack
//             */
//            for (int i = 0; (i < numVertices) && !found; i++) {
//                if (adjMatrix[x.intValue()][i] && !visited[i]) {
//                    traversalStack.push(i);
//                    resultList.addToRear(vertices[i]);
//                    visited[i] = true;
//                    found = true;
//                }
//            }
//            if (!found && !traversalStack.isEmpty()) {
//                traversalStack.pop();
//            }
//        }
//        return resultList.iterator();
//    }
//
//    /**
//     * Returns an iterator that performs a breadth first search traversal starting
//     * at the given index.
//     *
//     * @param startIndex the index to begin the search from
//     * @return an iterator that performs a breadth first traversal
//     */
//    public Iterator<T> iteratorBFS(int startIndex) throws EmptyCollectionException {
//        Integer x;
//        LinkedQueue<Integer> traversalQueue = new LinkedQueue<>();
//        ArrayUnorderedList<T> resultList = new ArrayUnorderedList<>();
//        if (!indexIsValid(startIndex)) {
//            return resultList.iterator();
//        }
//        boolean[] visited = new boolean[numVertices];
//        for (int i = 0; i < numVertices; i++) {
//            visited[i] = false;
//        }
//
//        traversalQueue.enqueue(startIndex);
//        visited[startIndex] = true;
//        while (!traversalQueue.isEmpty()) {
//            x = traversalQueue.dequeue();
//            resultList.addToRear(vertices[x.intValue()]);
//            /**
//             * Find all vertices adjacent to x that have not been visited and queue them up
//             */
//            for (int i = 0; i < numVertices; i++) {
//                if (adjMatrix[x.intValue()][i] && !visited[i]) {
//                    traversalQueue.enqueue(i);
//                    visited[i] = true;
//                }
//            }
//        }
//        return resultList.iterator();
//    }
//
//    @Override
//    public Iterator<T> iteratorShortestPath(T startVertex, T targetVertex) throws EmptyCollectionException {
//        throw new UnsupportedOperationException("Not supported yet."); // To change body of generated methods, choose
//                                                                       // Tools | Templates.
//    }
//
//    @Override
//    public void removeVertex(T vertex) {
//        try {
//            int index = getIndex(vertex);
//            for (int i = 0; i < this.numVertices; i++) {
//                this.adjMatrix[i][index] = false;
//                this.adjMatrix[index][i] = false;
//            }
//            removeVertice(index);
//        } catch (ElementNotFoundException ex) {
//        }
//    }
//
//    public void removeVertice(int index) {
//        for (int i = index; i < this.numVertices; i++) {
//            this.vertices[i] = this.vertices[i + 1];
//        }
//        this.numVertices--;
//    }
//
//    @Override
//    public void removeEdge(T vertex1, T vertex2) {
//        try {
//            int index1 = getIndex(vertex1);
//            int index2 = getIndex(vertex2);
//            this.adjMatrix[index1][index2] = false;
//            this.adjMatrix[index1][index2] = false;
//        } catch (ElementNotFoundException ex) {
//            System.out.println("Some vertex does not exist!!");
//        }
//    }
//
//    @Override
//    public boolean isEmpty() {
//        return this.numVertices == 0;
//    }
//
//    @Override
//    public boolean isConnected() {
//        int cont = 0;
//        for (int i = 0; i < numVertices; i++) {
//            for (int j = 0; j < numVertices; j++) {
//                if (!adjMatrix[i][j]) {
//                    if (cont == numVertices) {
//                        return false;
//                    }
//                    cont++;
//                }
//            }
//        }
//        return true;
//    }
//
//    @Override
//    public int size() {
//        return this.numVertices;
//    }
//
//    @Override
//    public Iterator<T> iteratorBFS(T startVertex) throws EmptyCollectionException {
//        int i;
//        try {
//            i = getIndex(startVertex);
//            return iteratorBFS(i);
//        } catch (ElementNotFoundException ex) {
//        }
//        return null;
//    }
//
//    @Override
//    public Iterator<T> iteratorDFS(T startVertex) throws EmptyCollectionException {
//        int i;
//        try {
//            i = getIndex(startVertex);
//            return iteratorDFS(i);
//        } catch (ElementNotFoundException ex) {
//            Logger.getLogger(Graph.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return null;
//    }
//}
//
//
//
