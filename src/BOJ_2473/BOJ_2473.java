package BOJ_2473;

import java.util.*;
import java.io.*;
public class BOJ_2473 {
    static int N,arr[];
    static int result[] = new int[3];
    static Long max;
    static boolean flag = false;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //System.out.println(Integer.MAX_VALUE);
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine()); arr = new int[N]; max = 3_000_000_001L;
        for(int i=0 ; i<N ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr); Arrays.fill(result,-1);

        for(int i=0 ; i<N-2 ; i++){
            Search(i);
            if(flag){
                break;
            }
        }
        Arrays.sort(result);
        for(int i=0 ; i<3; i++){
            System.out.print(result[i]+" ");
        }

    }
    public static void Search(int index){
        int left = index+1; int right = N-1;
        while(left < right) {
            long sum =(long) arr[index]+arr[left]+arr[right];
            long abs = Math.abs(sum);
            if(abs<max){
                max = abs;
                //System.out.println(abs);
                result[0] = arr[index]; result[1] = arr[left] ; result[2] = arr[right];
            }
            if(sum>0){
                right = right-1 ;
            }
            else if(sum == 0){
                flag = true;
                break;
            }
            else{
                left = left+1;
            }
        }
    }
}
