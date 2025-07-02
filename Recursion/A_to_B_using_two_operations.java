import java.util.*;
//by recusion we will get binary tree,since we have 2 operations but we dont to repeat same calls and avoid exponential complexity
 //Done using BFS with map and queue 
//map is used to store parent node 
//and queue is for exploting all nodes in a breadth wise fashion
//op1 : x-> x*2
//op2 : x-> 10*x+1
//ex: a:2,b=41 ==> YES 2->4->41 
public class Main {
    public static void main(String[] args) {
     Scanner sc = new Scanner(System.in);
     int a = sc.nextInt();
     int b = sc.nextInt();
     Boolean flg = false;
     Map<Integer,Integer> mp = new HashMap<>();//to store parent of every vlaue
     Queue<Integer> q = new LinkedList<>();
     q.add(a);
     mp.put(a,-1);//no parent for a, so -1
     while(!q.isEmpty()){
       int curr = q.poll();//we got b,we break
       if(curr==b){
         flg = true;
         break;
       }
       
       long op1 = (long)2*curr;//operation 1, we push into queue and add it parent as curr
       if(op1<=b && !mp.containsKey((int)op1)){
         mp.put((int)op1,curr);
         q.add((int)op1);
       }
       long op2 = (long)10*curr+1;//operation 2,  we push into queue and add it parent as curr
        if(op2<=b && !mp.containsKey((int)op2)){
         mp.put((int)op2,curr);
         q.add((int)op2);
       }
     }
     if(flg){
       List<Integer> path = new ArrayList<>();
       for(int v = b;v!=-1;){
         path.add(v);
         v = mp.get(v);//iterator changing here
       }
       
       Collections.reverse(path);
       System.out.println("YES");
       System.out.println(path.size());
       for(int p : path){
         System.out.print(p+ " ");
       }
     }
     else{
       System.out.println("NO");
     }
  }
}
