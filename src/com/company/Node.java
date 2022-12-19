package com.company;
    public class Node {
        //TODO: This class definition is being given in completed format to allow the focus
        // to be on BFS/DFS for this project, as I've already tested you a few times on making classes.
        String data;
        boolean visited;
        Node[] neighbors;

        public Node (String data){
            this.data = data;
        }

        public void visit() {
            System.out.print(data + ", ");
            visited = true;
        }
    }
