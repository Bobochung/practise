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
//插入排序，往前面的有序数组中插入新数据
public int[] insertSort(int[] arr){
	for (int i = 1; i < arr.length; i++)    //从第2个数据开始插入  
      {  
        int j = i - 1;  
        int temp = arr[i];    //记录要插入的数据  
        while (j >= 0 && arr[j] > temp)    //从后向前，找到比其小的数的位置  
        {  
            arr[j+1] = arr[j];    //向后挪动  
            j--;  
        }  
  
        if (j != i - 1)    //存在比其小的数  
            arr[j+1] = temp;  
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
		public static void mergeSort(int[] arr,int left,int right){
		int middle=(left+right)/2;
		if(left<right){
//			让左边继续拆
			mergeSort(arr, left, middle);
//			让右边继续拆
			mergeSort(arr, middle+1, right);
//			合并两个有序数组为一个数组
			merge(arr, left,middle, right);
		}
	}
	
	public static void merge(int[] arr,int left,int middle,int right){
//		定义临时数组
		int[] temp=new int[right-left+1];
		int low1=left;
		int low2=middle+1;
		int index=0;
		 while (low1 <= middle && low2 <= right) {
	            if (arr[low1] <= arr[low2]) {
	                temp[index] = arr[low1++];
	                index++;
	            } else {
	                temp[index] = arr[low2++];
	                index++;
	            }
	        }
	        // 把左边剩余的装进新数组
	        while (low1 <= middle) {
	            temp[index] = arr[low1++];
	            index++;
	        }
	        // 把右边剩余的装进新数组
	        while (low2 <= right) {
	            temp[index] = arr[low2++];
	            index++;
	        }
	        //把新数组里面的有序元素数，装进原数组
	        for (int i = 0; i < temp.length; i++) {
	            arr[i + left] = temp[i];
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
		as.mergeSort(newArr, 0, arr.length-1);
		System.out.println("归并排序后的顺序："+Arrays.toString(newArr));
		

	}

}
