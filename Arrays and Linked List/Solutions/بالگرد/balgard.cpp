//by Mitra Omrani
#include<bits/stdc++.h>
using namespace std;
using ll=long long;
class node{
    friend class linklist;
    node(string nme,node * nx,node * prv){
        name=nme;
        next=nx;
        prev=prv;
    }
    string name;
    node * next;
    node * prev;
};
class linklist{
    int size;
    node * head;
    node * tail;

public:
    linklist(){
        size=0;
        head=0;
        tail=0;
    }
    ~linklist(){
          while(head){
            node *tmp= head->next;
            delete head;
            head=tmp;
        }
        size=0;
        head=nullptr;
        tail=nullptr;
    }
    void insert(string name,int pos){
        if(size==0)
        {
            node * tmp=new node(name,nullptr,nullptr);
            head=tmp;
            tmp->next=nullptr;
            tail=head;
            size++;
            return;
        }
        if(pos==0){
             node * tmp=new node(name,head,nullptr);
             head->prev=tmp;
             head=tmp;
             size++;
             return;
        }
        else{
            ll i=0;
            node * tmp=head;
            while(i+1!=pos){
                i++;
                tmp=tmp->next;
            }
            node *x=new node(name,tmp->next,tmp);
            if(tmp->next!=nullptr) tmp->next->prev=x;
            tmp->next=x;
            tail=x;
            size++;
        }
    }
    void depart(string nme){
        if(head==nullptr) return;
        size--;
        node * tmp=head;
        if(tmp->name==nme){
            head=head->next;
           if(head!=nullptr) head->prev=nullptr;
            delete tmp;
            return;
        }
        while (tmp->next!=nullptr)
        {
           if(tmp->next->name==nme){
               node * tt=tmp->next;
              if(tmp->next->next!=nullptr) tmp->next->next->prev=tmp;
               tmp->next=tmp->next->next;
               delete tt;
               return;
           }
           tmp=tmp->next;
        }  
    }
    void relocate(string nme,int mv){
        node * tmp=head;
        ll i=0;
        while(tmp){
            if(tmp->name==nme)
                break;
            tmp=tmp->next;
            i++;
        }
        depart(nme);
        insert(nme,i+mv);
    }  
    void reverse(ll i,ll j){
        node * tmp=head;
        ll k=1;
        while(k!=i){
            k++;
            tmp=tmp->next;
        }
        node * tt=tmp;
        while(k!=j){
            k++;
            tmp=tmp->next;
        }
        while( tmp!=tt && tt->next!=tmp )
        {
            string data=tt->name;
            tt->name=tmp->name;
            tmp->name=data;
            tt=tt->next;
            tmp=tmp->prev;
        }
        if(tt->next==tmp){
           string data=tt->name;
            tt->name=tmp->name;
            tmp->name=data;
        }
    }
    void print(){
        if(head==nullptr) {cout<<"The airport is empty"<<endl; return;}
        node * tmp=head;
        while (tmp)
        {
           cout<<tmp->name<<' ';
           tmp=tmp->next;
        }
        cout<<"\n";
    }
};
int main(){
    ll n,s,x,i,j;
    linklist helikopt;
    cin>>n>>s;
    string name="",command="";
    for(ll i=0;i<n;i++){
        cin>>name;
        helikopt.insert(name,i);
    }
    while(s--){
        cin>>command;
        if(command=="insert"){
            cin>>name>>x;
            helikopt.insert(name,x);
        }
        else if(command=="relocate"){
            cin>>name>>x;
            helikopt.relocate(name,x);
        }
        else if(command=="depart"){
            cin>>name;
            helikopt.depart(name);
        }
        else if(command=="reverse"){
            cin>>i>>j;
            if(i>j) x=i,i=j,j=x;
            helikopt.reverse(i,j);
        }
    }
      helikopt.print();
    return 0;
}
