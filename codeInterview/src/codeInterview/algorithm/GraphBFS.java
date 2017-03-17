package codeInterview.algorithm;

import java.util.*;

public class GraphBFS {
	// Breadth First Search (BFS)
		//
		// This is a very different approach for traversing the graph nodes. The aim
		// of BFS algorithm is to traverse the graph as close as possible to the
		// root node. Queue is used in the implementation of the breadth first
		// search. Let’s see how BFS traversal works with respect to the following
		// graph:
		//
		//
		// If we do the breadth first traversal of the above graph and print the
		// visited node as the output, it will print the following output. “A B C D
		// E F”. The BFS visits the nodes level by level, so it will start with
		// level 0 which is the root node, and then it moves to the next levels
		// which are B, C and D, then the last levels which are E and F.
		//
		// Algorithmic Steps
		//
		// Step 1: Push the root node in the Queue.
		// Step 2: Loop until the queue is empty.
		// Step 3: Remove the node from the Queue.
		// Step 4: If the removed node has unvisited child nodes, mark them as
		// visited and insert the unvisited children in the queue.
		// Based upon the above steps, the following Java code shows the
		// implementation of the BFS algorithm:
	
	public static void main(String[] args) {
		
		// Testing
		
		// Nodes: 0 1 2 3 4 5 6 7 8
		// Matrix below represents node connections
		// for example: row1col2=1 and row2col2=1 means node0 connects to node1,
		//  node0->node1,node0->node3, node0->node8
		//  node1->node0. node1->node7
		//  node2->node3, node2->node5,node2->node7
		//  node3->node0, node3->node2, node3_.node4
		//  node4->node3, node4->node8
		//  node5->node2, node5->node6
		//  node6->node5
		//  node7->node1, node7->node2
		//  node8->node0, node8->node4
		//
		//  Result: 0 1	3 8		7		2		4		5		6

		// ===================================================
		int[][] conn = { 	{ 0, 1, 0, 1, 0, 0, 0, 0, 1 }, // 0
							{ 1, 0, 0, 0, 0, 0, 0, 1, 0 }, // 1
							{ 0, 0, 0, 1, 0, 1, 0, 1, 0 }, // 2
							{ 1, 0, 1, 0, 1, 0, 0, 0, 0 }, // 3
							{ 0, 0, 0, 1, 0, 0, 0, 0, 1 }, // 4
							{ 0, 0, 1, 0, 0, 0, 1, 0, 0 }, // 5
							{ 0, 0, 0, 0, 0, 1, 0, 0, 0 }, // 6
							{ 0, 1, 1, 0, 0, 0, 0, 0, 0 }, // 7
							{ 1, 0, 0, 0, 1, 0, 0, 0, 0 } };// 8

		GraphBFS G = new GraphBFS(conn);

		G.bfs();

	}
	
	
	/*
	 * --------- Data structure used to represent a graph --------------------------
	 */
	int[][] adjMatrix;
	int rootNode = 0;
	int NNodes;

	boolean[] visited;

	/*
	 * ------------------------------- Construct a graph of N nodes
	 * -------------------------------
	 */
	GraphBFS(int N) {
		NNodes = N;
		adjMatrix = new int[N][N];
		visited = new boolean[N];
	}

	
	GraphBFS(int[][] mat) {

		NNodes = mat.length;

		adjMatrix = new int[NNodes][NNodes];
		visited = new boolean[NNodes];

		for (int i = 0; i < NNodes; i++)
			for (int j = 0; j < NNodes; j++)
				adjMatrix[i][j] = mat[i][j];
	}

	public void bfs() {
		// BFS uses Queue data structure
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(rootNode);
		visited[rootNode] = true;
		printNode(rootNode);

		while (!q.isEmpty()) {
			int n, child;

			n = (q.peek()).intValue();

			child = getUnvisitedChildNode(n);

			if (child != -1) {
				visited[child] = true;

				printNode(child);

				q.add(child);
			} else {
				q.remove();
			}
		}

		clearVisited(); // Clear visited property of nodes
	}

	int getUnvisitedChildNode(int n) {
		for (int j = 0; j < NNodes; j++) {
			if (adjMatrix[n][j] > 0) {
				if (!visited[j])
					return (j);
			}
		}

		return (-1);
	}

	void clearVisited() {
		for (int i = 0; i < visited.length; i++)
			visited[i] = false;
	}

	void printNode(int n) {
		System.out.println(n);
	}
}
