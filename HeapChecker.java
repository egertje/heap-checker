/**
 * 
 * @author Emma Gertje and Serena Raso
 * This class holds the addEltTester and remMinEltTester methods whcih check the addElt and remMinElt methods
 *
 */
public class HeapChecker {
	/**
	  * Adding an element to a heap to make it a binary tree
	  * 
	  * @param IHeap hOrig, int elt, IBinTree hAdded
	  * @return true if the element is added to the heap and if all of the elements from the original heap are still in the new binary tree
	  */
	boolean addEltTester(IHeap hOrig, int elt, IBinTree hAdded) {
		if(hAdded.isValidHeap() 
				&& hAdded.everythingThereAddElt(hOrig, elt, hAdded) && hAdded.sizeIsOneMore(hOrig, hAdded)) {
			return true;
		}
		else return false;
	}
	/**
	  * Removing an element from a heap to make it a binary tree
	  * 
	  * @param IHeap hOrig, IBinTree hRemoved
	  * @return true if the element is removed from the heap and if all of the elements from the original heap are still in the new binary tree
	  */
	 boolean remMinEltTester(IHeap hOrig, IBinTree hRemoved) {
		 if(hRemoved.isValidHeap()
				 && hOrig.everythingThereRemMinElt(hOrig, hRemoved) && hRemoved.sizeIsOneLess(hOrig, hRemoved)) {
			 return true;
		 }
		 else return false;
	 }
}
