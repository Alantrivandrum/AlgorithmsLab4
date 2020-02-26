import static org.junit.Assert.assertEquals;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.junit.runners.MethodSorters;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.concurrent.TimeUnit;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

//-------------------------------------------------------------------------
/**
 *  Test class for SortComparison.java
 *
 *  @author	Alan Abraham
 *  @version HT 2020
 *  
 *  |----------------------+--------+-----------+----------------+-----------------+-------|
	| DataSets             | Insert | Selection | Merge-Recursive | MergeIterative | Quick |
	|----------------------+--------+-----------+----------------+-----------------+-------|
	| 10 random            | 0ms    | 0ms       | 0ms            | 0ms             | 0ms   |
	|----------------------+--------+-----------+----------------+-----------------+-------|
	| 100 random           | 0ms    | 0ms       | 0ms            | 0ms             | 0ms   |
	|----------------------+--------+-----------+----------------+-----------------+-------|
	| 1000 random          | 1ms    | 3.5ms     | 0ms            | 0ms             | 0ms   |
	|----------------------+--------+-----------+----------------+-----------------+-------|
	| 1000 few unique      | 1.5ms  | 2ms       | 0ms            | 0ms             | 0ms   |
	|----------------------+--------+-----------+----------------+-----------------+-------|
	| 1000 nearly ordered  | 1ms    | 2ms       | 0ms            | 0ms             | 0ms   |
	|----------------------+--------+-----------+----------------+-----------------+-------|
	| 1000 reverse order   | 8ms    | 2ms       | 0ms            | 0ms             | 1ms   |
	|----------------------+--------+-----------+----------------+-----------------+-------|
	| 1000 sorted          | 0ms    | 2ms       | 0ms            | 0ms             | 2ms   |
	|----------------------+--------+-----------+----------------+-----------------+-------|
	| 10000 random         | 11ms   | 16ms      | 2ms            | 1ms             | 2ms   |
	|	-------------------+--------+-----------+----------------+-----------------+-------|
	| 100000 random        | 931ms  | 1421ms    | 9ms            | 8ms             | 6ms   |
	|----------------------+--------+-----------+----------------+-----------------+-------|
	| 10000 few unique     | 11.5ms | 16ms      | 1ms            | 0ms             | 1.5ms |
	|----------------------+--------+-----------+----------------+-----------------+-------|
	| 10000 reverse order  | 17ms   | 21ms      | 3ms            | 0ms             | 18ms  |
	|----------------------+--------+-----------+----------------+-----------------+-------|
	| 10000 sorted         | 0ms    | 10ms      | 0ms            | 0ms             | 17ms  |
	|----------------------+--------+-----------+----------------+-----------------+-------|
	| 10000 nearly ordered | 3ms    | 11.5ms    | 0ms            | 0ms             | 1.5ms |
	|----------------------+--------+-----------+----------------+-----------------+-------|
 *  
 *  
 * (a) Which of the sorting algorithms does the order of input have an impact on? Why?
 * 
 * 		Insert sort - The more sorted the array, the less swaps will occur.
 * 		Quick sort - By choosing a partition index the algorithm sorts the array for elements to be on either side of the pivot, if the array is sorted already, 
 * 					 it will take a lot longer!
 * 
 * 
 * (b) Which algorithm has the biggest difference between the best and worst performance, based on the type of input, for the input of size 1000? Why?
 * 
 * 		Insert sort - Depends on if the array is sorted already, if it is, insertion sort is of O(n), otherwise it is O(n^2) 
 * 
 * (c) Which algorithm has the best/worst scalability, i.e., the difference in performance time based on the input size? Please consider only input files with random order for this answer.
 * 		
 * 		Best performance :    Merge Iterative
 * 		Worst performance:   Selection
 * 
 * (d) Did you observe any difference between iterative and recursive implementations of merge sort?
 * 
 * 		Yes - Merge Iterative seems to scale and perform much better than the recursive implementation.
 * 
 * (e) Which algorithm is the fastest for each of the 7 input files?
 * 		10 random:           Selection
 * 		100 random:          Merge Iterative
 * 		1000 random:         Merge Recursive
 * 		1000 few unique:     Merge Iterative
 * 		1000 nearly ordered: Merge Iterative
 * 		1000 reverse order:  Merge Iterative
 * 		1000 sorted:         Insert
 *
 *  
 *  
 *  
 *  
 *  
 *  
 *  
 *  
 *  
 *  
 *  
 *  
 *  
 *  
 *  
 *  
 */
@RunWith(JUnit4.class)
public class SortComparisonTest
{
	
	// For measuring running times
	double start;
	double end;
	double timeTaken;
	double coversionNumber = 1000000;
	static double array[] = new double[10];
	
    //~ Constructor ........................................................
    @Test
    public void testConstructor()
    {
        new SortComparison();
    }

    //~ Public Methods ........................................................

    // ----------------------------------------------------------
    /**
     * Check that the methods work for empty arrays
     * @throws FileNotFoundException 
     */
    @Test
    public void testEmpty() throws InterruptedException, FileNotFoundException
    {
    	double a[] = {};
    	
    	
    	start = System.nanoTime();
    	double sortedArray[] = SortComparison.insertionSort(a);
    	end = System.nanoTime();
    	timeTaken = (end - start) / coversionNumber;
    	assertEquals("[]", Arrays.toString(sortedArray));
    	
    	
    	start = System.nanoTime();
    	sortedArray = SortComparison.selectionSort(a);
    	end = System.nanoTime();
    	timeTaken = (end - start) / coversionNumber;
    	assertEquals("[]", Arrays.toString(sortedArray));
    	
    	
    	start = System.nanoTime();
    	sortedArray = SortComparison.quickSort(a);
    	end = System.nanoTime();
    	timeTaken = (end - start) / coversionNumber;
    	assertEquals("[]", Arrays.toString(sortedArray));
    	
    	
    	start = System.nanoTime();
    	sortedArray = SortComparison.mergeSortRecursive(a);
    	end = System.nanoTime();
    	timeTaken = (end- start) / coversionNumber;
    	assertEquals("[]", Arrays.toString(sortedArray));
    	
    	
    	start = System.nanoTime();
    	sortedArray = SortComparison.mergeSortIterative(a);
    	end = System.nanoTime();
    	timeTaken = (end - start) / coversionNumber;
    	assertEquals("[]", Arrays.toString(sortedArray));
    	
    	
    	
    	
    	
    }
    
    @Test
    public void testInsertionSort()
    {
    	double[] array  = {2377.88,2910.66,8458.14,1522.08,5855.37,1934.75,8106.23,1735.31,4849.83,1518.63} ;
    	start = System.nanoTime();
    	double sortedArray[] = SortComparison.insertionSort(array);
    	end = System.nanoTime();
    	timeTaken = (end - start) / coversionNumber;
    	
    	assertEquals("[1518.63, 1522.08, 1735.31, 1934.75, 2377.88, 2910.66, 4849.83, 5855.37, 8106.23, 8458.14]", Arrays.toString(sortedArray));
    	
    	
    }
    
    @Test
    public void testSelectionSort()
    {
    	double[] array  = {2377.88,2910.66,8458.14,1522.08,5855.37,1934.75,8106.23,1735.31,4849.83,1518.63} ;
    	start = System.nanoTime();
    	double sortedArray[] = SortComparison.selectionSort(array);
    	end = System.nanoTime();
    	timeTaken = (end - start) / coversionNumber;
    	
    	assertEquals("[1518.63, 1522.08, 1735.31, 1934.75, 2377.88, 2910.66, 4849.83, 5855.37, 8106.23, 8458.14]", Arrays.toString(sortedArray));
    	
    	
    }
    
    @Test
    public void testQuickSort()
    {
    	double[] array  = {2377.88,2910.66,8458.14,1522.08,5855.37,1934.75,8106.23,1735.31,4849.83,1518.63} ;
    	start = System.nanoTime();
    	double sortedArray[] = SortComparison.quickSort(array);
    	end = System.nanoTime();
    	timeTaken = (end - start) / coversionNumber;
    	
    	assertEquals("[1518.63, 1522.08, 1735.31, 1934.75, 2377.88, 2910.66, 4849.83, 5855.37, 8106.23, 8458.14]", Arrays.toString(sortedArray));
    	
    }
    
    @Test
    public void testMergeSortRec()
    {
    	double[] array  = {2377.88,2910.66,8458.14,1522.08,5855.37,1934.75,8106.23,1735.31,4849.83,1518.63} ;
    	start = System.nanoTime();
    	double sortedArray[] = SortComparison.mergeSortRecursive(array);
    	end = System.nanoTime();
    	timeTaken = (end - start) / coversionNumber;
    	
    	assertEquals("[1518.63, 1522.08, 1735.31, 1934.75, 2377.88, 2910.66, 4849.83, 5855.37, 8106.23, 8458.14]", Arrays.toString(sortedArray));
    	
    	
    }
    
    @Test
    public void testMergeSortItr()
    {
    	double[] array  = {2377.88,2910.66,8458.14,1522.08,5855.37,1934.75,8106.23,1735.31,4849.83,1518.63} ;
    	start = System.nanoTime();
    	double sortedArray[] = SortComparison.mergeSortIterative(array);
    	end = System.nanoTime();
    	timeTaken = (end - start) / coversionNumber;
    	
    	assertEquals("[1518.63, 1522.08, 1735.31, 1934.75, 2377.88, 2910.66, 4849.83, 5855.37, 8106.23, 8458.14]", Arrays.toString(sortedArray));
    	
    	
    }


    // TODO: add more tests here. Each line of code and ech decision in Collinear.java should
    // be executed at least once from at least one test.

    // ----------------------------------------------------------
    /**
     *  Main Method.
     *  Use this main method to create the experiments needed to answer the experimental performance questions of this assignment.
     *
     */
    public static void main(String[] args) throws Exception
    {
    	File file = new File("U:\\Algorithms and Datastructures Lab4\\Algorithms Lab4\\src\\InputFiles\\numbers10.txt");
    	Scanner sc = new Scanner(file);
	
    	int i=0;
    	while (sc.hasNextLine()) 
		array[i++] = Double.parseDouble(sc.nextLine());
	
    	sc.close();
    }

}
