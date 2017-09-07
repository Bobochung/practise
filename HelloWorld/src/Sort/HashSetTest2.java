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
		// TODO è‡ªåŠ¨ç”Ÿæˆçš„æ–¹æ³•å­˜æ ?
		String[] str=new String[100]; 
		// åˆå§‹åŒ?
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
//            利用HashSet不能添加相同值的特性，如果之前插入过相同的值，则无法插入，长度不会改变。并将此事插入的值添加到结果集中去
            if(hSet.size() == originHashSetSize){
                result.add(str[i]);
            }
        }
        System.out.printf("é‡å¤çš„æœ‰%dä¸?%n", result.size());
        for(String each: result){
            System.out.print(each.toString() + " ");
        }

	}

}
