struct Page{
    int key;
    int value;
    Page(int k,int v):key(k),value(v){}
};
class LRUCache{
public:
    LRUCache(int capacity) {
        this->capacity=capacity;
    }
    
    int get(int key) {
        if(index_map.find(key)!=index_map.end()){               //如果该页面存在       
            pages.splice(pages.begin(),pages,index_map[key]);   //将该页面置为最近被访问的，即将其调整到表头；
            return pages.begin()->value;                        //返回该页面的value
        }
        return -1;
    }
    
    void set(int key, int value) {
        if(index_map.find(key)!=index_map.end()){               //如果该页面存在
            index_map[key]->value=value;                        //将该页面的内容重新设置
            pages.splice(pages.begin(),pages,index_map[key]);   //将该页面置为最近被访问的，即将其调整到表头；
        }else{                                                  //如果该页面不存在，则需要创建新页面
            if(pages.size()==capacity){                         //如果此时已经达到容量上限，则将最后被访问的页面删除，
                 index_map.erase(pages.back().key);             //删除第一步：将最后被访问的页面从页面索引中删除
                 pages.pop_back();                              //删除第二步：将该页面从页面列表中删除
            }
            pages.push_front(Page(key,value));                  //新建页面，并将其置为最近被访问的，即将其插入到表头；
            index_map[key]=pages.begin();                       //为该页面创建索引
        }
    }
private:
    int capacity;
    list<Page> pages;                                           //用于维护页面调用的先后关系
    unordered_map<int,list<Page>::iterator> index_map;          //用于维护页面索引
};