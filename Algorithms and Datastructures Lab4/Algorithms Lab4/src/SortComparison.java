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
    
    static double[] quickSort(double arr[], int low, int high)
    {
    	  if (low < high) 
          { 
              /* pi is partitioning index, arr[pi] is  
                now at right place */
              int pi = partition(arr, low, high); 
    
              // Recursively sort elements before 
              // partition and after partition 
              arr = quickSort(arr, low, pi-1); 
              arr = quickSort(arr, pi, high); 
          } 
    	  return arr;
    }
    
    private static int partition(double arr[], int low, int high) 
    { 
        double pivot = arr[high];  
        int i = (low-1); // index of smaller element 
        for (int j=low; j<high; j++) 
        { 
            // If current element is smaller than the pivot 
            if (arr[j] < pivot) 
            { 
                i++; 
  
                // swap arr[i] and arr[j] 
                double temp = arr[i]; 
                arr[i] = arr[j]; 
                arr[j] = temp; 
            } 
        } 
  
        // swap arr[i+1] and arr[high] (or pivot) 
        double temp = arr[i+1]; 
        arr[i+1] = arr[high]; 
        arr[high] = temp; 
  
        return i+1; 
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
    		for(int low=0; low<a.length-1;low+=2*i)
    		{
    			merge(a,temp,low,low+i-1,Math.min(low + 2*i -1,a.length-1));
    		}
    	}
		return a;
    }
    
    static void merge(double a[], double temp[], int low, int mid, int high) {
		for (int k = low; k <= high; k++) {
			temp[k] = a[k];
		}
		int i = low;
		int j = mid + 1;
		for (int k = low; k <= high; k++) {
			if (i > mid)
				a[k] = temp[j++];
			else if (j > high)
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
    static double[] mergeSortRecursive (double a[]) 
    {
    	
    	double temp[] = new double[a.length];
		mergeSortRecursive(a, temp, 0, a.length - 1);
		return a;
    	

    	//todo: implement the sort
	
    }//end mergeSortRecursive
    
    static void mergeSortRecursive(double a[], double temp[],int low,int high)
    {
    	if (high <= low) {
			return;
		}
		int mid = low + (high - low) / 2;
		mergeSortRecursive(a, temp, low, mid);
		mergeSortRecursive(a, temp, mid + 1, high);
		merge(a, temp, low, mid, high);
    	
    	
    }
    	
    


   


    public static void main(String[] args) {

        //todo: do experiments as per assignment instructions
    }

 }//end class
