package BOJ_30804;

import java.io.*;
import java.util.*;

public class BOJ_30804 {
    static int result,N;
    static Queue<Integer> fruit;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); fruit = new LinkedList<>(); result = -1;
        st = new StringTokenizer(br.readLine());
        for(int i=0 ; i<N ; i++){
            fruit.add(Integer.parseInt(st.nextToken()));
        }
        UsingDeque();
        System.out.println(result);
    }
    public static void UsingDeque() {
       Deque<Integer> d = new LinkedList<>();
       int count[] = new int[10];
       boolean use[] = new boolean[10];
       while(!fruit.isEmpty()){
           d.addLast(fruit.poll());
           count[d.peekLast()]++;
           use[d.peekLast()] = true;
           if (check(use)){
               result = Math.max(result,d.size());
           }
           else{
               int num = 0;
               while(true) {
                   num = d.pollFirst();
                   count[num]--;
                   if(count[num] == 0){
                       use[num] = false;
                       break;
                   }
               }
           }
       }
    }
    public static boolean check(boolean[] input) {
        int count = 0 ;
        for(int i=1 ; i<=9 ; i++){
            if(input[i]){
                count++;
            }
            if(count>2){
                break;
            }
        }
        return count>2 ? false : true;
    }
}
