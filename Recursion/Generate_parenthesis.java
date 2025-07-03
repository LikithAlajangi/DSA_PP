//Key Take Aways 
//1.In balanced string ,for every closing bracket ')', there should be counter '('  i.e.
//count of '(' greater than count of ')' at any prefix of String


class Solution {
    List<String> ans;

    public void generateParenthesis(int n,int s,int e,int i,char[] str){
        if(i==2*n){
            ans.add(new String(str));
            return;
        }
        if(s==e){
          str[i]='(';
          generateParenthesis(n,s+1,e,i+1,str);
        }
        else if(s>e){
            if(s==n){
                str[i] = ')';
                generateParenthesis(n,s,e+1,i+1,str);
            }
            else{
                str[i]='(';
                generateParenthesis(n,s+1,e,i+1,str);
                str[i]=')';
                generateParenthesis(n,s,e+1,i+1,str);
            }
        }
return;
    }


    public List<String> generateParenthesis(int n) {
        char[] s = new char[2*n];
        ans = new ArrayList<>();
        generateParenthesis(n,0,0,0,s);
        return ans;
    }
}