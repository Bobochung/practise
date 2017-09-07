package Sort;

import java.util.HashSet;

public class HashSetTest2 {
	private static String randomString(int length) {
        String pool = "";
        for (short i = '0'; i <= '9'; i++) {
            pool += (char) i;
        }
        for (short i = 'a'; i <= 'z'; i++) {
            pool += (char) i;
        }
        for (short i = 'A'; i <= 'Z'; i++) {
            pool += (char) i;
        }
        char cs[] = new char[length];
        for (int i = 0; i < cs.length; i++) {
            int index = (int) (Math.random() * pool.length());
            cs[i] = pool.charAt(index);
        }
        String result = new String(cs);
        return result;
    }
	public static void main(String[] args) {
		// TODO 自动生成的方法存�?
		String[] str=new String[100]; 
		// 初始�?
        for (int i = 0; i < str.length; i++) {
            str[i] = randomString(2);
        }
        for (int i = 0; i < str.length; i++) {
            System.out.print(str[i] + " ");
            if (19 == i % 20)
                System.out.println();
        }
        
        HashSet<String> hSet=new HashSet<>();
        HashSet<String> result=new HashSet<>();
        for(int i = 0; i < str.length; i++){
            int originHashSetSize = hSet.size();
            hSet.add(str[i]);
//            利用HashSet不能插入相同值的特�?�，如果插入的�?�出现过，则长度未改变，此时将这个插入的值加�?
//            新的结果集中�?
            if(hSet.size() == originHashSetSize){
                result.add(str[i]);
            }
        }
        System.out.printf("重复的有%d�?%n", result.size());
        for(String each: result){
            System.out.print(each.toString() + " ");
        }

	}

}
