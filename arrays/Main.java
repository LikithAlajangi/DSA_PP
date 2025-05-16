/* Given a 2D matrix matrix, handle multiple queries of the following type: Calculate the sum of the elements of matrix inside the rectangle defined by its upper left corner (x1, y1) and lower right corner (x2, y2) for every query.

Input Format

First line contains n and m (dimensions of matrix). Next n lines contains m elements for the matrix. Third line contains q denoting number of queries. Next q lines contains x1,y1,x2,y2 where (x1,y1) is the upper left corner of defined matrix and (x2,y2) lower right corner.

Output Format

Print q lines each denoting sum of the defined rectangle.

Example 1;

Input

3 3
1 2 3
4 5 6
7 8 9
2
0 0 1 1
1 0 2 2

Output
12
39

Explanation For first query elements we got are 1+2+4+5 = 12 For second query elements are 4+5+6+7+8+9=39
Constraints
1 <= m*n <= 10^6
-1000 <= matrix[i][j] <= 1000
0 <= x1 <= x2 < n
0 <= y1 <= y2 < m
Number of queries will not exceed 10^5. */
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
