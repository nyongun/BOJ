package BOJ_13904;

import java.util.*;
import java.io.*;
public class BOJ_13904 {
    static int N;
    static PriorityQueue<Work> queue;
    static PriorityQueue<Integer> scores;
    public static class Work implements Comparable <Work>{
        int date,score;
        Work(int date,int score){
            this.date = date; this.score = score;
        }
        @Override
        public int compareTo(Work a){
            if(this.date != a.date){
//                return this.date-a.date;
                return a.date - this.date ;
            }
            else{
//                return this.score-a.score;
                return a.score - this.score;
            }
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); queue = new PriorityQueue(); int max_date = -1; scores = new PriorityQueue<>(Comparator.reverseOrder()); int result = 0;
        for(int i=0 ; i<N ; i++){
            st = new StringTokenizer(br.readLine());
            int now_d = Integer.parseInt(st.nextToken()); int now_s = Integer.parseInt(st.nextToken());
            if(now_d>max_date){
                max_date = now_d ;
            }
            queue.add(new Work(now_d,now_s));
        }
//        while(!queue.isEmpty()){
//            Work now = queue.poll();
//            System.out.println("result: "+now.date+" "+now.score);
//
//        }
        while(max_date>0){
//            Work now = queue.poll();
//            System.out.println("result: "+now.date+" "+now.score);
            while(!queue.isEmpty() && queue.peek().date>=max_date){
                scores.add(queue.poll().score);
            }
            if(!scores.isEmpty()){
                result += scores.poll();
            }
            //System.out.println(result);
            max_date--;
        }
        System.out.println(result);
    }
}
