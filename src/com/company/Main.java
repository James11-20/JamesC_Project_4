package com.company;


import java.util.*;

public class Main {
    public static void main(String[] args) {
        //TODO: The main method runs tests that report back whether each search found the target node or not.

        //TODO: Edit the value of targetData below to adjust what node is being searched for.
        //TODO: Changing it to something not A-I (like Z) will result in a full graph traversal.
        //TODO: Outside of doing that for testing purposes, do not modify the main method.
        String targetData = "C";
        Node E = buildGraph();

        System.out.println("BFS (Iterative)\n---------------");
        boolean bfsFound = bfs(E, targetData);

        E = buildGraph();
        System.out.println("\n\nDFS (Iterative)\n---------------");
        boolean dfsIterFound = dfsIterative(E, targetData);

        E = buildGraph();
        System.out.println("\n\nDFS (Recursive)\n---------------");
        boolean dfsRecurFound = dfsRecursive(E, targetData);

        String output = bfsFound ? "\nBFS found " + targetData + ".\n" : "\nBFS didn't find " + targetData + ".\n";
        output += dfsIterFound ? "DFS (iterative) found " + targetData + ".\n" : "DFS (iterative) didn't find " + targetData + ".\n";
        output += dfsRecurFound ? "DFS (recursive) found " + targetData + ".\n" : "DFS (recursive) didn't find " + targetData + ".\n";

        System.out.println("\n\nRESULTS\n-------" + output);
    }

    public static boolean bfs(Node start, String targetData) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(start);
        while (!queue.isEmpty()){
            Node currentNode = queue.remove();
            currentNode.visit();
            //start.visit();
            //queue.add(start);
            //System.out.println("On Node:"+ currentNode);
            //queue.remove(start);
            if(currentNode.data==targetData){
                System.out.println("Found Target!");
                return true;
            }
            else{
                //start.visit();
                for (Node temp : currentNode.neighbors){
                    if (!temp.visited && !queue.contains(temp)) {
                        queue.add(temp);
                    }
                }
            }
        }
        return false;
    }

    public static boolean dfsIterative(Node start, String targetData) {
        Stack<Node> stack = new Stack<>();
        stack.add(start);
        while (!stack.isEmpty()){
            Node currentNodeStack = stack.pop();
            currentNodeStack.visit();
            //start.visit();
            //queue.add(start);
            //System.out.println("On Node:"+ currentNode);
            //queue.remove(start);
            if(start.data.contains(targetData)||currentNodeStack.data.contains(targetData)){
                System.out.println("Found Target!");
                return true;
            }
            else{
                //start.visit();
                for (Node temp : currentNodeStack.neighbors){
                    if (!temp.visited && !stack.contains(temp) && !stack.contains(start)) {
                        stack.add(temp);
                        //  temp.visit();
                        //queue.remove(temp);
                    }
                }
            }
        }
        return false;
    }

    public static boolean dfsRecursive(Node current, String targetData) {
        if (current.data==targetData) {
            System.out.println("Target Found!");
            return true;
        } else {
            boolean found = false;
            current.visit();
            for (Node neighbor : current.neighbors) {
                if (neighbor.data == targetData){
                    found = true;
                }
                else
                    neighbor =current;
                    dfsRecursive(neighbor,targetData);
                    found=false;
                }
            }return false;
        }
    public static Node buildGraph() {
        //TODO: This method builds the graph shown in Graph Image.png in the project download. Do not modify.
        Node A = new Node("A");
        Node B = new Node("B");
        Node C = new Node("C");
        Node D = new Node("D");
        Node E = new Node("E");
        Node F = new Node("F");
        Node G = new Node("G");
        Node H = new Node("H");
        Node I = new Node("I");
        A.neighbors = new Node[]{E};
        B.neighbors = new Node[]{C, E, F, I};
        C.neighbors = new Node[]{B};
        D.neighbors = new Node[]{F};
        E.neighbors = new Node[]{A, B, G};
        F.neighbors = new Node[]{B, D, H};
        G.neighbors = new Node[]{E};
        H.neighbors = new Node[]{F, I};
        I.neighbors = new Node[]{B, H};
        return E;
    }
}