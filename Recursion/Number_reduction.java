import java.util.*;
import java.lang.*;
import java.io.*;
//recursion - O(2^n) but use array to decrease redundant calls memoizasation 
class Codechef
{
   public static Map<Integer,Integer> mp = new HashMap<>();
    
    public static int helper(int x){
      if(mp.containsKey(x)){
        return mp.get(x);
      }
        if(x<=3 && x%2!=0){
          mp.put(x,x);
            return x;
        }
        int a = Integer.MAX_VALUE;
        int b =  Integer.MAX_VALUE;
        if(x>3){
            a = helper(x-3);
        }
        if(x%2==0){
            b = helper(x/2);
        }
        int res = Math.min(a,b);
        mp.put(x,res);
        return res;
    }
    
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t>0){
		    int x = sc.nextInt();
		    int ans = helper(x);
		    System.out.println(ans);
		    t--;
		}

	}
}
