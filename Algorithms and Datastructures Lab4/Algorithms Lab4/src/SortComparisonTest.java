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
