import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'isBalanced' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */
	
	////REquired function to complete

    public static String isBalanced(String s1) {
    // Write your code here
    char[] s = s1.toCharArray();
       Stack<Character> stk = new Stack<>();
       for(int i=0;i<s.length;i++){
       
        if(s[i]=='{' || s[i]=='('|| s[i]=='['){
        stk.push(s[i]);
        }
        else{
        if(s[i]=='}'){
            if( !stk.empty()&& stk.peek()=='{' ){
            stk.pop();
            }
            else{  return "NO";}
        
        }
        
        else if(s[i]==']'){
            if( !stk.empty()&& stk.peek()=='[' ){
              
            stk.pop();
            }
            else{  return "NO";}
        }
        
        else if(s[i]==')'){
            if(!stk.empty()&& stk.peek()=='('){
            stk.pop();
            }
            else{  return "NO";}
        
        }
        }
       }
      return stk.isEmpty()?"YES":"NO";

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        for (int tItr = 0; tItr < t; tItr++) {
            String s = bufferedReader.readLine();

            String result = Result.isBalanced(s);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedReader.close();
        bufferedWriter.close();
    }
}
