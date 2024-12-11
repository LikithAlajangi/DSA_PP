#include <bits/stdc++.h>
using namespace std;

class directedGraph{
  unordered_map<int,list<int>> adj;
  
  public:
  
  unordered_map<int,list<int>> getadj(){
    return adj;
  }
  void addEdge(int v,int w){
    adj[v].push_back(w);
  }
  
  void printGraph(){
    for(auto &node : adj){
      cout << node.first << "->";
      for(auto neighbour: node.second){
      cout << neighbour << " ";
    }
     cout << endl;
    }
  }
  
   void updateEdge(int u,int oldV,int newV){
         auto it = find(adj[u].begin(),adj[u].end(),oldV);
         
         if(it!= adj[u].end()){
           *it = newV;
         }
  }
  
   void removeEdge(int u,int v){
    adj[u].remove(v);
  }
  
  void graphDFS(int startVertex,vector<int> &ans,vector<bool> &vis){
    vis[startVertex] = 1;
    
    ans.push_back(startVertex);
    
    for(auto x: adj[startVertex]){
      if(!vis[x]){
        graphDFS(x,ans,vis);
      }
    }
    
  }
vector<int> graphBFS(int sval){
  queue<int> q;
  q.push(sval);
  int n = adj.size();
  vector<int> ans;
  vector<bool> visited(n,0);
  while(!q.empty()){
    int v = q.front();
    visited[v] = 1;
    ans.push_back(v);
    q.pop();
    
    for(int x: adj[v]){
      if(!visited[x]){
        q.push(x);
        visited[x]=1;
      }
    }
    
  }
  return ans;
}

int size(){
  return adj.size();
}
  
};


int main() 
{
   
   directedGraph g;
   g.addEdge(1,2);
   g.addEdge(1,3);
   g.addEdge(2,3);
   g.addEdge(3,1);
   g.addEdge(3,2);
   g.addEdge(3,4);
   
   g.printGraph();
   g.updateEdge(1,3,4);
   cout << endl;
   g.printGraph();
   
   g.removeEdge(3,4);
    cout << endl;
   g.printGraph();
   
  vector<int> ans = g.graphBFS(1);
  cout << "BFS:";
  for(auto x:ans){
    cout << x << " ";
  }
cout<<endl;
  
  vector<bool> visited(g.size(),0);
  vector<int> ans1; 
  g.graphDFS(1,ans1,visited);
    cout << "DFS:";
  for(auto x: ans1){
    cout<< x << " ";
  }
    return 0;
}