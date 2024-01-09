# Baltresorpapop
Balanced Tree and Shortest Path Problem created using Java

Balanced Tree Implement  AVL Tree 
Shortest Path problem implement Dijkstra’s Algorithm (Single-Source Shortest Paths)

# Example Input
## AVL

Sample Input
```
10
20
30
40
50
25
-1
```

The Output will be
```
Preorder traversal of constructed tree is : 
Preorder traversal: 30 20 10 25 40 50 
Inorder traversal of constructed tree is : 
Inorder traversal: 10 20 25 30 40 50 
Postorder traversal of constructed tree is : 
Postorder traversal: 10 25 20 50 40 30
```

Visualization 
```
             30 
            /  \ 
          20   40 
         /  \     \ 
        10  25    50 
```
## Dijkstra Single Source Spp
Sample Input
```
0 4 0 0 0 0 0 8 0
4 0 8 0 0 0 0 11 0
0 8 0 7 0 4 0 0 2
0 0 7 0 9 14 0 0 0
0 0 0 9 0 10 0 0 0
0 0 4 14 10 0 2 0 0
0 0 0 0 0 2 0 1 6
8 11 0 0 0 0 1 0 7
0 0 2 0 0 0 6 7 0

// Sample Input on Code
Enter the number of vertices in the graph: 9
Enter the adjacency matrix for the graph:
Enter row 1 (separate values with spaces): 0 4 0 0 0 0 0 8 0   
Enter row 2 (separate values with spaces): 4 0 8 0 0 0 0 11 0
Enter row 3 (separate values with spaces): 0 8 0 7 0 4 0 0 2
Enter row 4 (separate values with spaces): 0 0 7 0 9 14 0 0 0
Enter row 5 (separate values with spaces): 0 0 0 9 0 10 0 0 0
Enter row 6 (separate values with spaces): 0 0 4 14 10 0 2 0 0
Enter row 7 (separate values with spaces): 0 0 0 0 0 2 0 1 6
Enter row 8 (separate values with spaces): 8 11 0 0 0 0 1 0 7
Enter row 9 (separate values with spaces): 0 0 2 0 0 0 6 7 0
Enter the source vertex: 0
```

The Output Will Be
```
Vertex           Distance from Source    Path
0                0                      0
1                4                      0 -> 1
2                12                     0 -> 1 -> 2
3                19                     0 -> 1 -> 2 -> 3       
4                21                     0 -> 7 -> 6 -> 5 -> 4  
5                11                     0 -> 7 -> 6 -> 5       
6                9                      0 -> 7 -> 6
7                8                      0 -> 7
8                14                     0 -> 1 -> 2 -> 8       

```

Visualization
![sample_graph](https://media-geeksforgeeks-org.translate.goog/wp-content/uploads/20231121131245/1-(2).jpg?_x_tr_sl=en&_x_tr_tl=id&_x_tr_hl=id&_x_tr_pto=tc)
