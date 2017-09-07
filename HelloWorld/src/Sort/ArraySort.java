package Sort;

import java.util.Arrays;

public class ArraySort {
	
//	生 成指定范围内(0——number)长度为length的随机数组
	
public int[] randomInt(int number,int length){
	int[] arr=new int[length];
	for(int i=0;i<length;i++){
		arr[i]=(int) (Math.random()*number);
	}
	return arr;
	
}

//	冒泡排序(大的往后移)
public int[] bubbSort(int[] arr){
		
	for(int i=0;i<arr.length-1;i++){    
			for(int j=0;j<arr.length-1-i;j++){ 
//因为每次比较都把最大的元素挑出去 下一次外循环后不需要跟他比了 因为这个元素已经是最大的 所以每一次外循环比较后，内循环都相当于少了一个元素  所以条件为arr.length-1-i

		  if(arr[j]>arr[j+1]){
//设置临时交换的数
			  int temp=arr[j];
			  arr[j]=arr[j+1];
			  arr[j+1]=temp;
		  		}
			}
		  }
		return arr;		
	}
//	插入排序(小的往前插入)
	public int[] insertSort(int[] arr){
		for(int i = 1;i < arr.length; i++)    //   外循环，前面一个元素用来比较，所以就只有length-1个元素需要排序，因此下标从1开始
        {
           for(int j = i - 1; j >= 0;j--){  //   这个循环的是需要插入的元素与前面已经排好序的元素进行比较
                         if(arr[ j ] > arr[ j + 1]){    //  判断条件 
                                       
                                   int temp = arr[ j ];
                                   arr[ j ] = arr[ j + 1];
                                   arr[ j + 1] = temp;
                                        }
                     }
        }
		
		return arr;
		
	}
	
//	选择排序
//	每次遍历找到未找过的数组元素中的最大值，并放在最后的位置。下一次遍历找到的最大值放在上一次找到的最大值的前面。
	public int[] choiceSort(int[] arr){
		int index;
        for (int i = 1; i < arr.length; i++) {
            index=0;//每一次便利需要重置数组下标，从第一个数开始遍历
            for (int j = 1; j <= arr.length - i; j++) {
                if (arr[j] > arr[index]) {
                    index = j;// 查找最大值,获取最大值的数组下标
                }
            }
            // 交换在位置array.length-i和index(最大值)两个数
            int temp = arr[arr.length - i];
            arr[arr.length - i] = arr[index];
            arr[index] = temp;
        }
		return arr;
		
	}

	
//	归并排序
	public void merge(int[] array,int start,int mid,int end){
		int temp[] = new int[end-start+1];//临时数组  
	      
	    int firstArrIndex = start;//第一段数组序列的下标  
	    int secondArrIndex = mid+1;//第二段数组序列的下标  
	    int tempArrIndex = 0;//临时存放数组的下标  
	      
	    //1.扫描第一个数组序列和第二个数组序列  
	    while(firstArrIndex <=mid && secondArrIndex<=end){  
	        //1.1 当第一段数组小于第二段数组 未排序的首个元素时  
	        if(array[firstArrIndex] <=array[secondArrIndex]){  
	            temp[tempArrIndex] = array[firstArrIndex];  
	            firstArrIndex++;  
	        }else{//1.2 当第二段数组小于第一段数组 未排序的首个元素时  
	            temp[tempArrIndex] = array[secondArrIndex];  
	            secondArrIndex++;  
	        }  
	          
	        tempArrIndex++;  
	    }  
	      
	    //2.当第一段没有复制完全时，将剩余的数组全部复制到临时数组  
	    while(firstArrIndex<=mid){  
	        temp[tempArrIndex] = array[firstArrIndex];  
	        firstArrIndex++;  
	        tempArrIndex++;  
	    }  
	            
	    //3.当第二段没有复制完全时，讲剩余的数组全部复制到临时数组  
	    while(secondArrIndex<=end){  
	        temp[tempArrIndex] = array[secondArrIndex];  
	        secondArrIndex++;  
	        tempArrIndex++;  
	    }  	      
	    //4.将临时数组复制到原始数组  
	    for(tempArrIndex=0,firstArrIndex=start;firstArrIndex<=end;tempArrIndex++,firstArrIndex++){  
	        array[firstArrIndex] = temp[tempArrIndex];  
	    }  	
	}
	public void mergeSort(int[] arr){
		for (int gap = 1; gap < arr.length; gap = 2 * gap) {  
	        int i=0;  
	        //归并gap长度的两个相邻子数组  
	        for(i=0; i+2*gap-1< arr.length; i = i + 2*gap) {  
	            merge(arr, i, i+gap-1, i+2*gap-1);  
	        }  
	          
	        // 余下不足两个合并的子数组。保证第一个数组gap存在。  
	        if(i + gap - 1 < arr.length){  
	            merge(arr, i, i + gap - 1, arr.length - 1);  
	        }  
	    }  
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArraySort as=new ArraySort();
		int[] newArr=as.randomInt(100, 5);
		System.out.println("原数组顺序："+Arrays.toString(newArr));
		//System.out.println("冒泡排序后数组顺序："+Arrays.toString(as.bubbSort(newArr)));
		//System.out.println("插入排序后数组顺序："+Arrays.toString(as.insertSort(newArr)));
		//System.out.println("选择排序后的顺序："+Arrays.toString(as.choiceSort(newArr)));
		as.mergeSort(newArr);
		System.out.println("归并排序后的顺序："+Arrays.toString(newArr));
		

	}

}
