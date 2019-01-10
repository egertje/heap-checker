/**
 * 
 * @author Emma Gertje and Serena Raso
 * This interface holds all the methods for binary trees and heaps that are used for empty and nonempty binary trees and heaps
 *
 */
public interface IBinTree {
 // determines whether element is in the tree
 boolean hasElt(int e);
 // returns number of nodes in the tree; counts duplicate elements as separate items
 int size();
 // returns depth of longest branch in the tree
 int height();
 //checks to see if the binary tree is a valid heap
 boolean isValidHeap();
 //Helper function for isValidHeap that checks to see if the given data value is 
 	//greater than the root, making it a valid heap
 boolean biggerThanRoot(int root);
 //Helper function for everythingThere that counts the amount of times an element shows up in the binary tree
 int countOccurances(int value);
 
 //For the addEltTester:
 
 //Function that makes sure everything in the original heap is in the new heap, except for the value added
 //which is one more than in the original
 boolean everythingThereAddElt(IHeap originalHeap, int valueAdded, IBinTree newTree);
 //Function that makes sure the size of the new heap is one more than the size of the old one
 boolean sizeIsOneMore(IBinTree originalHeap, IBinTree newTree);


//For the remMinEltTester:

//Function that makes sure everything in the original heap is in the new heap, except for the value taken away
//which is one less than in the original
boolean everythingThereRemMinElt(IHeap originalHeap, IBinTree newTree);
//Helper function for everytingThereRemMinElt
boolean everythingThereHelper(IHeap originalHeap, int valueRemoved, IBinTree newTree);
//Function that makes sure the size of the new heap is one less than the size of the old one
boolean sizeIsOneLess(IBinTree originalHeap, IBinTree newTree);

}



