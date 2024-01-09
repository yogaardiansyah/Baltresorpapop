import java.util.Scanner;

class ShortestPath {
    static int V;

    int minDistance(int dist[], boolean sptSet[]) {
        int min = Integer.MAX_VALUE, min_index = -1;

        for (int v = 0; v < V; v++)
            if (!sptSet[v] && dist[v] <= min) {
                min = dist[v];
                min_index = v;
            }

        return min_index;
    }

    void printSolution(int dist[], int parent[]) {
        System.out.println("Vertex \t\t Distance from Source \t Path");
        for (int i = 0; i < V; i++) {
            System.out.print(i + " \t\t " + dist[i] + "\t\t\t");
            printPath(parent, i);
            System.out.println();
        }
    }

    void printPath(int parent[], int j) {
        if (parent[j] == -1) {
            System.out.print(j);
            return;
        }
        printPath(parent, parent[j]);
        System.out.print(" -> " + j);
    }

    void dijkstra(int graph[][], int src) {
        int dist[] = new int[V];
        boolean sptSet[] = new boolean[V];
        int parent[] = new int[V];

        for (int i = 0; i < V; i++) {
            dist[i] = Integer.MAX_VALUE;
            sptSet[i] = false;
            parent[i] = -1;
        }

        dist[src] = 0;

        try {
            for (int count = 0; count < V - 1; count++) {
                int u = minDistance(dist, sptSet);
                sptSet[u] = true;

                for (int v = 0; v < V; v++)
                    if (!sptSet[v] && graph[u][v] != 0
                            && dist[u] != Integer.MAX_VALUE
                            && dist[u] + graph[u][v] < dist[v]) {
                        dist[v] = dist[u] + graph[u][v];
                        parent[v] = u;
                    }
            }

            printSolution(dist, parent);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: Array index out of bounds. Please check your input.");
        }
    }
}

class Node {
    int key, height;
    Node left, right;

    Node(int d) {
        key = d;
        height = 1;
    }
}

class AVLTree {
    Node root;

    int height(Node N) {
        if (N == null)
            return 0;

        return N.height;
    }

    int max(int a, int b) {
        return (a > b) ? a : b;
    }

    Node rightRotate(Node y) {
        Node x = y.left;
        Node T2 = x.right;

        x.right = y;
        y.left = T2;

        y.height = max(height(y.left), height(y.right)) + 1;
        x.height = max(height(x.left), height(x.right)) + 1;

        return x;
    }

    Node leftRotate(Node x) {
        Node y = x.right;
        Node T2 = y.left;

        y.left = x;
        x.right = T2;

        x.height = max(height(x.left), height(x.right)) + 1;
        y.height = max(height(y.left), height(y.right)) + 1;

        return y;
    }

    int getBalance(Node N) {
        if (N == null)
            return 0;

        return height(N.left) - height(N.right);
    }

    Node insert(Node node, int key) {
        if (node == null)
            return (new Node(key));

        if (key < node.key)
            node.left = insert(node.left, key);
        else if (key > node.key)
            node.right = insert(node.right, key);
        else
            return node;

        node.height = 1 + max(height(node.left), height(node.right));

        int balance = getBalance(node);

        if (balance > 1 && key < node.left.key)
            return rightRotate(node);

        if (balance < -1 && key > node.right.key)
            return leftRotate(node);

        if (balance > 1 && key > node.left.key) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        if (balance < -1 && key < node.right.key) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }

    void preOrder() {
        System.out.print("Preorder traversal: ");
        preOrder(root);
        System.out.println();
    }

    void inOrder() {
        System.out.print("Inorder traversal: ");
        inOrder(root);
        System.out.println();
    }

    void postOrder() {
        System.out.print("Postorder traversal: ");
        postOrder(root);
        System.out.println();
    }

    private void preOrder(Node node) {
        if (node != null) {
            System.out.print(node.key + " ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    private void inOrder(Node node) {
        if (node != null) {
            inOrder(node.left);
            System.out.print(node.key + " ");
            inOrder(node.right);
        }
    }

    private void postOrder(Node node) {
        if (node != null) {
            postOrder(node.left);
            postOrder(node.right);
            System.out.print(node.key + " ");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n================================");
            System.out.println("         Struktur Data");
            System.out.println("================================");
            System.out.println("Menu:");
            System.out.println("1. Dijkstra's Shortest Path Algorithm");
            System.out.println("2. AVL Tree Insertion");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    dijkstraMenu(scanner);
                    break;
                case 2:
                    avlTreeMenu(scanner);
                    break;
                case 3:
                    System.out.println("Exiting the program. Goodbye!");
                    System.out.println("Dibuat Oleh Yoga Ardiansyah 2IA25 51422643");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }

    private static void dijkstraMenu(Scanner scanner) {
        System.out.println("Dijkstra's Shortest Path Algorithm");

        System.out.print("Enter the number of vertices in the graph: ");
        int V = scanner.nextInt();

        int graph[][] = new int[V][V];

        System.out.println("Enter the adjacency matrix for the graph:");
        try {
            for (int i = 0; i < V; i++)
                for (int j = 0; j < V; j++)
                    graph[i][j] = scanner.nextInt();

            System.out.print("Enter the source vertex: ");
            int source = scanner.nextInt();

            ShortestPath shortestPath = new ShortestPath();
            shortestPath.dijkstra(graph, source);
        } catch (Exception e) {
            System.out.println("Error: Invalid input. Please check your input.");
        }
    }

    private static void avlTreeMenu(Scanner scanner) {
        System.out.println("AVL Tree Insertion");

        AVLTree avlTree = new AVLTree();

        System.out.println("Enter keys to insert into AVL Tree (enter -1 to stop):");

        int key;
        while ((key = scanner.nextInt()) != -1) {
            avlTree.root = avlTree.insert(avlTree.root, key);
        }

        System.out.println("Preorder traversal of constructed tree is : ");
        avlTree.preOrder();

        System.out.println("Inorder traversal of constructed tree is : ");
        avlTree.inOrder();

        System.out.println("Postorder traversal of constructed tree is : ");
        avlTree.postOrder();
    }
}
