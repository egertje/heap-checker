/**
 * 
 * @author Emma Gertje and Serena Raso
 * This class holds the constructor and methods for empty binary trees
 *
 */
public class MtBT implements IBinTree {
 MtBT(){}

 // returns false since empty tree has no elements
 public boolean hasElt(int e) {
  return false;
 }

 // returns 0 since empty tree has no elements
 public int size() {
  return 0;
 }

 // returns 0 since empty tree has no branches
 public int height() {
  return 0;
 }
 
 /**
  * Checks if valid heap
  * 
  * 
  * @return true because empty 
  */
 public boolean isValidHeap() {
	 return true;
 }
 /**
  * returns true since any value is bigger than an empty tree by default
  * 
  * @param integer root 
  * @return true 
  */
 
 public boolean biggerThanRoot(int root) {
	 return true;
 }
 /**
  * returns 0 since the tree is empty so there are no values
  * 
  * @param integer value
  * @return 0
  */

 public int countOccurances(int value) {
	 return 0;
 }
 /**
  * returns true since everything will be there since it was am empty list to begin with
  * 
  * @param IHeap originalHeap, int valueAdded, IBinTree newTree
  * @return true 
  */

public boolean everythingThereAddElt(IHeap originalHeap, int valueAdded, IBinTree newTree) {
	return true;
}
/**
 * returns true since something added to an empty list will be one
 * 
 * @param IBinTree originalHeap, IBinTree newTree
 * @return true 
 */

public boolean sizeIsOneMore(IBinTree originalHeap, IBinTree newTree) {
	return true;
}
/**
 * returns true since everything will be there since it was an empty list to begin with
 * 
 * @param IHeap originalHeap, IBinTree newTree
 * @return true
 */

public boolean everythingThereRemMinElt(IHeap originalHeap, IBinTree newTree) {
	return true;
}
/**
 * returns true since everything will be accounted for
 * 
 * @param IHeap originalHeap, int valueRemoved, IBinTree newTree
 * @return true
 */

public boolean everythingThereHelper(IHeap originalHeap, int valueRemoved, IBinTree newTree) {
	return true;
}
/**
 * return false since one can't take anything out of an empty list
 * 
 * @param IBinTree originalHeap, IBinTree newTree)
 * @return true
 */

public boolean sizeIsOneLess(IBinTree originalHeap, IBinTree newTree) {
	return true;
}

}
