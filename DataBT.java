/**
 * 
 * @author Emma Gertje and Serena Raso
 * this class holds all the methods and constructor for a nonempty binary tree
 *
 */
public class DataBT implements IBinTree {
 int data;
 IBinTree left;
 IBinTree right;

 DataBT(int data, IBinTree left, IBinTree right) {
  this.data = data;
  this.left = left;
  this.right = right;
 }
 
 // an alternate constructor for when both subtrees are empty
 DataBT(int data) {
   this.data = data;
   this.left = new MtBT();
   this.right = new MtBT();
 }

 // determines whether this node or node in subtree has given element
 public boolean hasElt(int e) {
  return this.data == e || this.left.hasElt(e) || this.right.hasElt(e) ;
 }

 // adds 1 to the number of nodes in the left and right subtrees
 public int size() {
  return 1 + this.left.size() + this.right.size();
 }

 // adds 1 to the height of the taller subtree
 public int height() {
  return 1 + Math.max(this.left.height(), this.right.height());
 }
 /**
	 * determines if the binary tree is a valid heap or not
	 * 
	 * 
	 * @return true if all parts of the tree are a valid heap
	 */
 
 public boolean isValidHeap() {
	 int root = this.data;
	        //this is checking to see if the left and right subtrees are bigger than the root, 
	        //making it a valid heap
	 return (this.left.biggerThanRoot(root) && this.right.biggerThanRoot(root) 
			 //this is checking to see if the left and right subtrees are valid heaps, making the function recursive
			 && this.right.isValidHeap() && this.left.isValidHeap());
 }
 /**
	 * Helper function for isValidHeap, checks if the left and right subtrees are bigger than the root
	 * 
	 * @param an integer root
	 * @return true if the left and right subtrees are bigger than the root
	 */
 
 public boolean biggerThanRoot(int root) {
	 return (this.data >= root && this.left.biggerThanRoot(root) && this.right.biggerThanRoot(root));
 }
 /**
	 * Helper function for everythingThere counts the occurences of each element in the binary tree
	 * 
	 * @param integer value that is being counted to see how many times it occurs
	 * @return number of each element
	 */
 
 public int countOccurances(int value) {
	 if(this.data == value) {
		 return 1 + this.left.countOccurances(value) + this.right.countOccurances(value);
	 }
	 else {
		 return this.left.countOccurances(value) + this.right.countOccurances(value);
	 }
 }
 /**
	 * Function that determines if everything in the original heap is in the new heap plus the new element we added
	 * 
	 * @param IHeap originalHeap, int valueAdded which is the value added to the tree, IBinTree newTree
	 * @return true if all the elements from the original heap are in the new heap
	 */
 
public boolean everythingThereAddElt(IHeap originalHeap, int valueAdded, IBinTree newTree) {
	int originalCount = originalHeap.countOccurances(this.data);
	int newBTCount = newTree.countOccurances(this.data);
	
	//this checks to see if the value added to the heap is in the new heap
	//and if it is in there one more time than in the original heap
	//if it is not in there one more time than the original it returns false
	if(this.data == valueAdded && ((originalCount + 1) != newBTCount)) {
		return false;
	}
	
	//this checks to see if all other values that are not the value added to the heap 
	//are in the new heap the same amount of times as the original
	//if this is not true it returns false
	if(this.data != valueAdded && originalCount != newBTCount) {
		return false;
	}
	
	//this recurses through the function and does this on the left and right subtrees 
	return this.left.everythingThereAddElt(originalHeap, valueAdded, newTree)
			&& this.right.everythingThereAddElt(originalHeap, valueAdded, newTree);
}
/**
 * Function that determines if the size of the new binary tree is one more than the size of the original
 * 
 * @param IBinTree originalHeap, IBinTree newTree
 * @return true if the new heap is bigger than the old one 
 */

public boolean sizeIsOneMore(IBinTree originalHeap, IBinTree newTree) {
	if (originalHeap.size() + 1 == newTree.size()) {
		return true;
	}
	else {
		return false;
	}
}
/**
 * Function that determines if everything in the original heap is in the new BT except for the element removed
 * 
 * @param IHeap originalHeap, IBinTree newTree
 * @return true if every element in the original heap is in the new Binary Tree
 */

public boolean everythingThereRemMinElt(IHeap originalHeap, IBinTree newTree) {
	int minElt = this.data;
	return everythingThereHelper(originalHeap, minElt, newTree);
}
/**
 * Helper function for everythingThereRemMinElt which recurses through the function
 * 
 * @param IHeap originalHeap, int valueRemoved, IBinTree newTree
 * @return true if every element in the left and right subtrees of the original heap is in the new binary tree in addition to the added element
 */

public boolean everythingThereHelper(IHeap originalHeap, int valueRemoved, IBinTree newTree) {
	int originalCount = originalHeap.countOccurances(this.data);
	int newBTCount = newTree.countOccurances(this.data);
	//returns false if the value removed is not in the new BT one less time than the original
		if(this.data == valueRemoved && ((originalCount - 1) != newBTCount)) {
			return false;
		}
		
		//this checks to see if all other values that are not the value added to the heap 
		//are in the new heap the same amount of times as the original
		//if this is not true it returns false
		if(this.data != valueRemoved && originalCount != newBTCount) {
			return false;
		}
		
		//this recurses through the function and does this on the left and right subtrees 
		return this.left.everythingThereHelper(originalHeap, valueRemoved, newTree)
				&& this.right.everythingThereHelper(originalHeap, valueRemoved, newTree);
}
/**
 * Function that determines if the size of the new BT is one less than the size of the original
 * 
 * @param IBinTree originalHeap, IBinTree newTree
 * @return true if the new tree is one element less than the original tree
 */

public boolean sizeIsOneLess(IBinTree originalHeap, IBinTree newTree) {
	if (originalHeap.size() - 1 == newTree.size()) {
		return true;
	}
	else {
		return false;
	}
}
 
}


