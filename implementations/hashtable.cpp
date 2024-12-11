#include <bits/stdc++.h>
using namespace std;

class HashTable{
  private: 
  int numBuckets;
   vector<list<pair<int,int>>> table;
  
  public:
  HashTable(int numB){
    numBuckets = numB;
    table.resize(numB);
  }
  
   int hashFunction(int key){
    return key%numBuckets;
  }
  
   void insert(int key,int value){
    int index = hashFunction(key);
    for(auto &pair: table[index]){
      if(pair.first == key){
        pair.second = value;
      }
    }
    
    table[index].emplace_back(key,value);
  }
  
   int find(int key){
    int idx = hashFunction(key);
    auto &bucket = table[idx];
    
    for(auto it=bucket.begin();it!=bucket.end();it++){
      if(it->first==key){
          return it->second;
      }
    }
    
    return -1;
  }
  
  
   void remove(int key){
    auto idx = hashFunction(key);
    auto& bucket = table[idx];
    
    for(auto it=bucket.begin();it!=bucket.end();it++){
      
      if(it->first==key){
        bucket.erase(it);
        return;
      }
    }
    
  }
  
  void display(){
    
    for(int i=0;i<numBuckets;i++){
    auto& bucket  = table[i];
    cout << "Bucket "<<i+1 << " :";
    for(auto it=bucket.begin();it!=bucket.end();it++){
      cout << "[" << it->first << "," << it->second << "],"; 
    }
    cout << endl;
    }
  }
  
  
};



int main() 
{
   HashTable ht(7);
  
  ht.insert(1, 10);
    ht.insert(2, 20);
    ht.insert(8, 80);
    ht.insert(10, 100);
    ht.insert(15, 150);
    cout << "Hash table after insertion:\n";
    ht.display();

    // Search for a key
    int key = 8;
    int value = ht.find(key);
    if (value != -1) {
        cout << "Value for key " << key << ": " << value << endl;
    } else {
        cout << "Key " << key << " not found.\n";
    }

    // Remove a key
    ht.remove(8);
    cout << "Hash table after removing key 8:\n";
    ht.display();

    
    return 0;
}