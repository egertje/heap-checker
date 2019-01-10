/**
 * @author Emma Gertje and Serena Raso
 * This class holds all the test cases for the addElt() and remMinElt() methods
 */
import static org.junit.Assert.*;

import org.junit.Test;

public class Examples {
	
	HeapChecker HC = new HeapChecker();
	
	//Instantiate original heap for tests 1 and 2 of addElt and remMinElt, where it is a valid heap
	MtHeap mtheap = new MtHeap();
	DataHeap A = new DataHeap(9, mtheap, mtheap);
	DataHeap B = new DataHeap(12, mtheap, mtheap);
	DataHeap C = new DataHeap(7, A, B);
	DataHeap D = new DataHeap(24, mtheap, mtheap);
	DataHeap E = new DataHeap(10, mtheap, D);
	DataHeap node1 = new DataHeap(2, C, E);
	
	//Instantiate new heap for test 1 of addElt, where it is a valid heap and a correct answer
	DataHeap F = new DataHeap(5, E, mtheap);
	DataHeap node2 = new DataHeap(2, C, F);
	
	//Instantiate new heap for test 1 for remMinElt, where it is a valid heap and a correct answer
	DataHeap FFF = new DataHeap(24, mtheap, mtheap);
	DataHeap GGG = new DataHeap(10, FFF, mtheap);
	DataHeap HHH = new DataHeap(12, mtheap, mtheap);
	DataHeap JJJ = new DataHeap(9, mtheap, HHH);
	DataHeap root1 = new DataHeap(7, JJJ, GGG);
	
	//Instantiate new heap for test 2 of addElt, where it is not a valid heap
	DataHeap G = new DataHeap(20, E, mtheap);
	DataHeap node3 = new DataHeap(2, C, G);
	
	//Instantiate new heap for test 2 for remMinElt, where it is not a valid heap because the elements
	//were merged incorrectly so an element that is bigger than its left or right heaps is the root
	DataHeap FFFF = new DataHeap(24, mtheap, mtheap);
	DataHeap GGGG = new DataHeap(10, FFFF, mtheap);
	DataHeap HHHH = new DataHeap(9, mtheap, mtheap);
	DataHeap JJJJ = new DataHeap(12, HHHH, mtheap);
	DataHeap root2 = new DataHeap(7, JJJJ, GGGG);
	
	//Instantiate original heap for test 3 of addElt and remMinElt, which is a valid heap
	DataHeap AA = new DataHeap(8, mtheap, mtheap);
	DataHeap BB = new DataHeap(14, mtheap, mtheap);
	DataHeap CC = new DataHeap(5, AA,  BB);
	DataHeap DD = new DataHeap(40, mtheap, mtheap);
	DataHeap EE = new DataHeap(15, mtheap, mtheap);
	DataHeap FF = new DataHeap(10, DD, EE);
	DataHeap node4 = new DataHeap(4, CC, FF);
	
	//Instantiate new heap for test 3 for addElt, which is a valid heap but not a correct answer
	//because the wrong element was added to the BT
	DataHeap GG = new DataHeap(9, FF, mtheap);
	DataHeap node5 = new DataHeap(4, CC, GG);
	
	//Instantiate new heap for test 3 for remMinElt, which is a valid heap but not a correct answer
	//because the wrong element was removed
	DataHeap C2 = new DataHeap(8, BB, mtheap);
	DataHeap root3 = new DataHeap(4, FF, C2);
	
	//Instantiate new heap for test 4 for addElt, which is a valid heap and the correct answer 
	DataHeap node6 = new DataHeap(10, mtheap, mtheap);
	
	//Instantiate original heap for test 5 for addElt, which is a valid heap 
	DataHeap H = new DataHeap(25, mtheap, mtheap);
	DataHeap I = new DataHeap(28, mtheap, mtheap);
	DataHeap J = new DataHeap(18, H, I);
	DataHeap K = new DataHeap(40, mtheap, mtheap);
	DataHeap L = new DataHeap(32, mtheap, mtheap);
	DataHeap M = new DataHeap(20, K, L);
	DataHeap N = new DataHeap(12, M, J);
	
	//Instantiate the new heap for test 5 for addElt, which is a valid heap but not the correct answer 
	//because it is only the left subheap
	DataHeap O = new DataHeap(12, M, mtheap);
	DataHeap P = new DataHeap(7, O, mtheap);
	
	//Instantiate the new heap for test 6 for remMinElt, which is a valid heap but not the correct answer
	//because it is only the left subheap
	DataHeap root4 = new DataHeap(20, K, L);
	
	
	//test for addEltTester method where the original and new heaps are valid heaps and the correct answer is given
	@Test
	public void testAddElt1(){
		 
	    assertTrue(HC.addEltTester(node1, 5, node2));
	}
	 
	//test for addEltTester method where the original is a valid heap but the new heap created is not valid because
	//the element added was added was bigger than the node it was added on top of, making it an invalid heap
	@Test
	public void testAddElt2() {
		
		assertFalse(HC.addEltTester(node1, 20, node3));
	}
	
	//test for addEltTester method where the original and new heaps are valid but the new heap is not
	//a correct answer because the wrong element was added
	@Test
	public void testAddElt3() {
		
		assertFalse(HC.addEltTester(node4, 7, node5));
	}
	
	//test for addEltTester method where the original is an empty heap and the new heap is a valid heap and correct answer
	@Test
	public void testAddElt4() {
		
		assertTrue(HC.addEltTester(mtheap, 10, node6));
	}
	
	//test for addEltTester method where the original is a valid heap and the new heap is a valid heap but not the
	//correct answer because it is only a subheap of the original so some of the original elements are missing in the
	//new heap
	@Test
	public void testAddElt5() {
		
		assertFalse(HC.addEltTester(N, 7, P));
	}
	
	//test for remMinElt method where the original is a valid heap and the new heap is a valid heap and a correct answer
	@Test
	public void testRemMinElt1() {
		
		assertTrue(HC.remMinEltTester(node1, root1));
	}
	
	//test for remMinElt method where the original is a valid heap but the new heap is not a valid heap
	//because a bigger element is on top of a smaller element
	@Test
	public void testRemMinElt2() {
		
		assertFalse(HC.remMinEltTester(node1, root2));
	}
	
	//test for remMinElt method where the original and new heaps are valid but the new heap is not
		//a correct answer because the wrong element was removed
	@Test
	public void testRemMinElt3() {
		
		assertFalse(HC.remMinEltTester(node4, root3));
	}
	
	//test for remMinElt method where the original is an empty heap and the new heap is a valid heap and correct answer
	@Test
	public void testRemMinElt4() {
		
		assertTrue(HC.remMinEltTester(mtheap, mtheap));
	}
	
	//test for remMinElt method where the original is a valid heap and the new heap is a valid heap but not the
		//correct answer because it is only a subheap of the original so some of the original elements are missing in the
		//new heap
	@Test
	public void testRemMinElt5() {
		
		assertFalse(HC.remMinEltTester(N, root4));
	}
}