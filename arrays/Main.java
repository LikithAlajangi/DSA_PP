/* package codechef; // don't place package name! */
import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class Main
{
    public static void main (String[] args) throws java.lang.Exception
    {
        // your code goes here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       
        String[] dim = br.readLine().split(" ");
        int n = Integer.parseInt(dim[0]);
        int m = Integer.parseInt(dim[1]);
         int[][] arr = new int[n][m];
        for(int i=0;i<n;i++){
            String[] row = br.readLine().split(" ");
            for(int j=0;j<m;j++){
                arr[i][j] = Integer.parseInt(row[j]);
            }
        }
        int q = Integer.parseInt(br.readLine());
        int[][] query = new int[q][4];
        for(int i=0;i<q;i++){
            String[] data = br.readLine().split(" ");
            for(int j=0;j<4;j++){
                query[i][j] = Integer.parseInt(data[j]);
            }
        }
        
        int[][] prefix = new int[n][m];
      // prefix[0][0] = arr[0][0];
        for(int i=0;i<n;i++){
            prefix[i][0] = arr[i][0];
            for(int j=1;j<m;j++){
                prefix[i][j] = arr[i][j] + prefix[i][j-1];
            }
        }
        
        
        
        for(int i=0;i<m;i++){
            prefix[0][i] = prefix[0][i];
            for(int j=1;j<n;j++){
                prefix[j][i] = prefix[j][i] + prefix[j-1][i];
            }
        }
        
        
        int[] ans = new int[q];
        for(int i=0;i<q;i++){
            int x2 = query[i][2];
            int y2 = query[i][3];
            int x1 = query[i][0];
            int y1 = query[i][1];
            int temp = prefix[x2][y2];
            if(x1>0){
                temp -= prefix[x1-1][y2];
            }
            
            if(y1>0){
                temp -= prefix[x2][y1-1];
            }
            if(x1>0 && y1>0){
                temp += prefix[x1-1][y1-1];
            }
            
            ans[i] = temp;
        }
        
        for(int i=0;i<q;i++){
            System.out.println(ans[i]);
        }
    }
}