/* Implement a method for a tree called 'get random node' that has equal
   probability of selecting a node from a tree. Explain how insert, find,
   and delete are implemented as well. */


/*
   Clarify - Will the getRandomNode function return the value or the node?
   Inputs - Assuming this is a method for a tree class
   Test Cases - see other tree declarations
   Brainstorm - If you flatten the tree and select a random element in the
    list, then runtime suffers.
    - If you select a random number of moves to make and continually move
    throughout the tree then you can way 'over move' or 'under move' i.e.
    100 moves for a tree with 3 nodes or 10 moves for a tree with 10,000
   Runtime Analysis
    - If we flatten the tree to an array and select a random element, we
    are at O(n) time and O(n) space. This is working but not ideal
    - Another approach is to traverse the tree with 'equal prob'. which
    would require we know the size of the tree, and the size of each
    left/right subtree. I.e. You start at the root. 1/N
    (where N is number of nodes) probability you select the root. 1/l
    (number of nodes in left subtree) says you traverse left & 1/r says
    you traverse right. But what happens if you reach the end of the tree
    without selecting a node yet?
 */
