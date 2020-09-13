package br.udesc.ppr55.sr.utils;

public class ArrayItem {

	public ArrayItem() {};
	
	/**
	 * 
	 * @param numbers
	 * @param index
	 * @return the largest number inside an int array
	 */
    public static int largestArrayItemAuxiliary(int [] numbers, int index)
    {           
        if (index == numbers.length-1)
        {    
            return numbers[index];
        } 
        else 
        { 
            int largest = largestArrayItemAuxiliary(numbers, index+1);
            if (largest > numbers[index]){    
                return largest;    
            }else{    
                return numbers[index];     
            }    
        }
    }
    
    /**
     * 
     * @param numbers
     * @return number of empty positions inside an array
     */
    public static int notEmptyArrayItem(int [] numbers) {
    	int array = 0;
    	for(int i=0; i<numbers.length; i++) {
			if(numbers[i] != 0) {
				array++;
			}
		}
    	return array;
    }
}
