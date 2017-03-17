package codeInterview.algorithm;

import java.util.*;

public class GraphDFS {
//	Depth First Search (DFS) 
//
//	The aim of DFS algorithm is to traverse the graph in such a way that it tries to go far from the root node. Stack is used in the implementation of the depth first search. Let’s see how depth first search works with respect to the following graph:   
//
//
//	As stated before, in DFS, nodes are visited by going through the depth of the tree from the starting node. If we do the depth first traversal of the above graph and print the visited node, it will be “A B E F C D”. DFS visits the root node and then its children nodes until it reaches the end node, i.e. E and F nodes, then moves up to the parent nodes. 
//
//	Algorithmic Steps   
//
//	Step 1: Push the root node in the Stack.  
//	Step 2: Loop until stack is empty. 
//	Step 3: Peek the node of the stack.  
//	Step 4: If the node has unvisited child nodes, get the unvisited child node, mark it as traversed and push it on stack.   
//	Step 5: If the node does not have any unvisited child nodes, pop the node from the stack.
//	Based upon the above steps, the following Java code shows the implementation of the DFS algorithm: 

	public static void main(String[] args) {
		
		// Testing
		
		// 0 1 2 3 4 5 6 7 8
		// ===================================================
		int[][] conn = { { 0, 1, 0, 1, 0, 0, 0, 0, 1 }, // 0
				{ 1, 0, 0, 0, 0, 0, 0, 1, 0 }, // 1
				{ 0, 0, 0, 1, 0, 1, 0, 1, 0 }, // 2
				{ 1, 0, 1, 0, 1, 0, 0, 0, 0 }, // 3
				{ 0, 0, 0, 1, 0, 0, 0, 0, 1 }, // 4
				{ 0, 0, 1, 0, 0, 0, 1, 0, 0 }, // 5
				{ 0, 0, 0, 0, 0, 1, 0, 0, 0 }, // 6
				{ 0, 1, 1, 0, 0, 0, 0, 0, 0 }, // 7
				{ 1, 0, 0, 0, 1, 0, 0, 0, 0 } };// 8

		GraphDFS G = new GraphDFS(conn);

		G.clearVisited();
		G.dfs();

	}
	
	/*
	 * ------------------------------------------ Data structure used to
	 * represent a graph ------------------------------------------
	 */
	int[][] adjMatrix;
	int rootNode = 0;
	int NNodes;

	boolean[] visited;

	/*
	 * ------------------------------- Construct a graph of N nodes
	 * -------------------------------
	 */
	GraphDFS(int N) {
		NNodes = N;
		adjMatrix = new int[N][N];
		visited = new boolean[N];
	}

	GraphDFS(int[][] mat) {
		int i, j;

		NNodes = mat.length;

		adjMatrix = new int[NNodes][NNodes];
		visited = new boolean[NNodes];

		for (i = 0; i < NNodes; i++)
			for (j = 0; j < NNodes; j++)
				adjMatrix[i][j] = mat[i][j];
	}

	public void dfs() {
		// DFS uses Stack data structure

		Stack<Integer> s = new Stack<Integer>();

		s.push(rootNode);
		visited[rootNode] = true;

		printNode(rootNode);

		while (!s.isEmpty()) {
			int n, child;

			n = (s.peek()).intValue();

			child = getUnvisitedChildNode(n);

			if (child != -1) {
				visited[child] = true;

				printNode(child);

				s.push(child);
			} else {
				s.pop();
			}
		}

		clearVisited(); // Clear visited property of nodes
	}

	int getUnvisitedChildNode(int n) {
		int j;

		for (j = 0; j < NNodes; j++) {
			if (adjMatrix[n][j] > 0) {
				if (!visited[j])
					return (j);
			}
		}

		return (-1);
	}

	void clearVisited() {
		int i;

		for (i = 0; i < visited.length; i++)
			visited[i] = false;
	}

	void printNode(int n) {
		System.out.println(n);
	}
}
