// -------------------------------------------------------------------------

/**
 *  This class contains static methods that implementing sorting of an array of numbers
 *  using different sort algorithms.
 *
 *  @author
 *  @version HT 2020
 */

 class SortComparison {

    /**
     * Sorts an array of doubles using InsertionSort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     * @param a: An unsorted array of doubles.
     * @return array sorted in ascending order.
     *
     */
    static double [] insertionSort (double a[])
    {
    	for(int i=0; i<a.length; i++)
    	{
    		double temp;
    		int j = i;
    		while(j>0 && a[j-1]>a[j])
    		{
    			temp = a[j-1];
    			a[j-1] = a[j];
    			a[j] = temp;
    			j--;
    		}
    	}
		return a;

        
    }//end insertionsort
	
	    /**
     * Sorts an array of doubles using Selection Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     * @param a: An unsorted array of doubles.
     * @return array sorted in ascending order
     *
     */
    static double [] selectionSort (double a[]){
    	
    	for(int i=0; i<a.length; i++)
    	{
    		int min = i;
    		for(int j = i+1; j<a.length; j++)
    		{
    			if(a[min] > a[j])
    			{
    				min = j;
    			}
    		}
    		if(min != i)
    		{
    			double temp = a[i];
    			a[i] = a[min];
    			a[min] = temp;
    					
    		}
    	}
		return a;

         

    }//end selectionsort

    /**
     * Sorts an array of doubles using Quick Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     * @param a: An unsorted array of doubles.
     * @return array sorted in ascending order
     *
     */
    static double [] quickSort (double a[])
    {
    	quickSort(a,0,a.length-1);
		return a;
	
		 //todo: implement the sort

    }//end quicksort
    
    static void quickSort(double a[], int low, int high)
    {
    	if (low < high) {
			int pivot = partition(a, low, high);

			quickSort(a, low, pivot - 1);
			quickSort(a, pivot + 1, high);
		}
    }
    
    static int partition(double a[], int low, int high)
    {
    	double pivotValue = a[high];
    	int small = low -1;
    	for(int j = 0; j< high; j++)
    	{
    		if(a[j] <= pivotValue)
    		{
    			small++;
    		}
    		double temp = a[small];
    		a[small] = a[j];
    		a[j] = temp; 
    	}
    	double temp = a[small + 1];
		a[small + 1] = a[high];
		a[high] = temp;
    	
    	return small + 1;
    }

    /**
     * Sorts an array of doubles using Merge Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     * @param a: An unsorted array of doubles.
     * @return array sorted in ascending order
     *
     */
    /**
     * Sorts an array of doubles using iterative implementation of Merge Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     *
     * @param a: An unsorted array of doubles.
     * @return after the method returns, the array must be in ascending sorted order.
     */

    static double[] mergeSortIterative (double a[]) 
    {
    	double[] temp = new double[a.length];
    	for(int i =1; i<a.length;i=2*i)
    	{
    		for(int lo=0; lo<a.length-1;lo+=2*i)
    		{
    			merge(a,temp,lo,lo+i-1,a.length);
    		}
    	}
		return a;
    }
    
    static void merge(double a[], double temp[], int lo, int mid, int hi) {
		for (int k = lo; k <= hi; k++) {
			temp[k] = a[k];
		}
		int i = lo;
		int j = mid + 1;
		for (int k = lo; k <= hi; k++) {
			if (i > mid)
				a[k] = temp[j++];
			else if (j > hi)
				a[k] = temp[i++];
			else if (temp[j] < temp[i])
				a[k] = temp[j++];
			else
				a[k] = temp[i++];
		}
	}
    
    
    
    /**
     * Sorts an array of doubles using recursive implementation of Merge Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     *
     * @param a: An unsorted array of doubles.
     * @return after the method returns, the array must be in ascending sorted order.
     */
    static double[] mergeSortRecursive (double a[]) {
		return a;
    	

    	//todo: implement the sort
	
   }//end mergeSortRecursive
    	
    


   


    public static void main(String[] args) {

        //todo: do experiments as per assignment instructions
    }

 }//end class
