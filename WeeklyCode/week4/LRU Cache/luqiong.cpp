class LRUCache{
public:
    struct CacheNode{
        int key;
        int value;
        CacheNode(int k,int v):key(k),value(v){}
    };
private:
    int capacity;
    list<CacheNode> CacheList;
    unordered_map<int,list<CacheNode>::iterator> CacheMap;
public:
    LRUCache(int capacity) {
        this->capacity = capacity;
    }
    
    int get(int key) {
        if(CacheMap.find(key)==CacheMap.end())return -1;
        CacheList.splice(CacheList.begin(),CacheList,CacheMap[key]);
        CacheMap[key] = CacheList.begin();
        return CacheMap[key]->value;
    }
    
    void set(int key, int value) {
        if(CacheMap.find(key)==CacheMap.end()){
            if(CacheMap.size()==this->capacity){
                CacheMap.erase(CacheList.back().key);
                CacheList.pop_back();
            }
            CacheList.push_front(CacheNode(key,value));
            CacheMap[key] = CacheList.begin();
        }else{
            CacheList.splice(CacheList.begin(),CacheList,CacheMap[key]);
            CacheMap[key] = CacheList.begin();
            CacheMap[key]->value = value;
        }
    }
};