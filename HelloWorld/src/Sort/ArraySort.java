package Sort;

import java.util.Arrays;

public class ArraySort {
	
//	�� ��ָ����Χ��(0����number)����Ϊlength���������
	
public int[] randomInt(int number,int length){
	int[] arr=new int[length];
	for(int i=0;i<length;i++){
		arr[i]=(int) (Math.random()*number);
	}
	return arr;
	
}

//	ð������(���������)
public int[] bubbSort(int[] arr){
		
	for(int i=0;i<arr.length-1;i++){    
			for(int j=0;j<arr.length-1-i;j++){ 
//��Ϊÿ�αȽ϶�������Ԫ������ȥ ��һ����ѭ������Ҫ�������� ��Ϊ���Ԫ���Ѿ������� ����ÿһ����ѭ���ȽϺ���ѭ�����൱������һ��Ԫ��  ��������Ϊarr.length-1-i

		  if(arr[j]>arr[j+1]){
//������ʱ��������
			  int temp=arr[j];
			  arr[j]=arr[j+1];
			  arr[j+1]=temp;
		  		}
			}
		  }
		return arr;		
	}
//	��������(С����ǰ����)
	public int[] insertSort(int[] arr){
		for(int i = 1;i < arr.length; i++)    //   ��ѭ����ǰ��һ��Ԫ�������Ƚϣ����Ծ�ֻ��length-1��Ԫ����Ҫ��������±��1��ʼ
        {
           for(int j = i - 1; j >= 0;j--){  //   ���ѭ��������Ҫ�����Ԫ����ǰ���Ѿ��ź����Ԫ�ؽ��бȽ�
                         if(arr[ j ] > arr[ j + 1]){    //  �ж����� 
                                       
                                   int temp = arr[ j ];
                                   arr[ j ] = arr[ j + 1];
                                   arr[ j + 1] = temp;
                                        }
                     }
        }
		
		return arr;
		
	}
	
//	ѡ������
//	ÿ�α����ҵ�δ�ҹ�������Ԫ���е����ֵ������������λ�á���һ�α����ҵ������ֵ������һ���ҵ������ֵ��ǰ�档
	public int[] choiceSort(int[] arr){
		int index;
        for (int i = 1; i < arr.length; i++) {
            index=0;//ÿһ�α�����Ҫ���������±꣬�ӵ�һ������ʼ����
            for (int j = 1; j <= arr.length - i; j++) {
                if (arr[j] > arr[index]) {
                    index = j;// �������ֵ,��ȡ���ֵ�������±�
                }
            }
            // ������λ��array.length-i��index(���ֵ)������
            int temp = arr[arr.length - i];
            arr[arr.length - i] = arr[index];
            arr[index] = temp;
        }
		return arr;
		
	}

	
//	�鲢����
	public void merge(int[] array,int start,int mid,int end){
		int temp[] = new int[end-start+1];//��ʱ����  
	      
	    int firstArrIndex = start;//��һ���������е��±�  
	    int secondArrIndex = mid+1;//�ڶ����������е��±�  
	    int tempArrIndex = 0;//��ʱ���������±�  
	      
	    //1.ɨ���һ���������к͵ڶ�����������  
	    while(firstArrIndex <=mid && secondArrIndex<=end){  
	        //1.1 ����һ������С�ڵڶ������� δ������׸�Ԫ��ʱ  
	        if(array[firstArrIndex] <=array[secondArrIndex]){  
	            temp[tempArrIndex] = array[firstArrIndex];  
	            firstArrIndex++;  
	        }else{//1.2 ���ڶ�������С�ڵ�һ������ δ������׸�Ԫ��ʱ  
	            temp[tempArrIndex] = array[secondArrIndex];  
	            secondArrIndex++;  
	        }  
	          
	        tempArrIndex++;  
	    }  
	      
	    //2.����һ��û�и�����ȫʱ����ʣ�������ȫ�����Ƶ���ʱ����  
	    while(firstArrIndex<=mid){  
	        temp[tempArrIndex] = array[firstArrIndex];  
	        firstArrIndex++;  
	        tempArrIndex++;  
	    }  
	            
	    //3.���ڶ���û�и�����ȫʱ����ʣ�������ȫ�����Ƶ���ʱ����  
	    while(secondArrIndex<=end){  
	        temp[tempArrIndex] = array[secondArrIndex];  
	        secondArrIndex++;  
	        tempArrIndex++;  
	    }  	      
	    //4.����ʱ���鸴�Ƶ�ԭʼ����  
	    for(tempArrIndex=0,firstArrIndex=start;firstArrIndex<=end;tempArrIndex++,firstArrIndex++){  
	        array[firstArrIndex] = temp[tempArrIndex];  
	    }  	
	}
	public void mergeSort(int[] arr){
		for (int gap = 1; gap < arr.length; gap = 2 * gap) {  
	        int i=0;  
	        //�鲢gap���ȵ���������������  
	        for(i=0; i+2*gap-1< arr.length; i = i + 2*gap) {  
	            merge(arr, i, i+gap-1, i+2*gap-1);  
	        }  
	          
	        // ���²��������ϲ��������顣��֤��һ������gap���ڡ�  
	        if(i + gap - 1 < arr.length){  
	            merge(arr, i, i + gap - 1, arr.length - 1);  
	        }  
	    }  
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArraySort as=new ArraySort();
		int[] newArr=as.randomInt(100, 5);
		System.out.println("ԭ����˳��"+Arrays.toString(newArr));
		//System.out.println("ð�����������˳��"+Arrays.toString(as.bubbSort(newArr)));
		//System.out.println("�������������˳��"+Arrays.toString(as.insertSort(newArr)));
		//System.out.println("ѡ��������˳��"+Arrays.toString(as.choiceSort(newArr)));
		as.mergeSort(newArr);
		System.out.println("�鲢������˳��"+Arrays.toString(newArr));
		

	}

}
