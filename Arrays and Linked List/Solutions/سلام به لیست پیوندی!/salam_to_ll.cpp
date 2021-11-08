//by Mitra Omrani
#include<bits/stdc++.h>
using namespace std;
class node{
    friend class linklist;
    int data;
    node * next;
    node(int d,node *nx){
        data=d;
        next=nx;
    }
};
class linklist{
    int size;
    node * head; 
    node * tail;
    public:
    linklist(){
        head=nullptr;
        tail=nullptr;
        size=0;
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
    void push_front(int d){
        if(!head){
            node * tmp=new node(d,nullptr);
            head=tmp;
            tail=head;
            size++;
            return;
        }
        node * tmp=new node(d,nullptr);
        tmp->next=head;
        head=tmp;
        size++;
    }
    void pop_front(){
        if(head==nullptr) return; 
        if(head==tail){
            delete head;
            head=nullptr;
            tail=nullptr;
            size=0;
            return;
        }
        node * tmp=head;
        head=head->next;
        size--;
        delete tmp;
    }
    void print(){
        node * tmp=head;
        if(head==nullptr){
            cout<<"list is empty"<<endl;
            return;
        }
        while(tmp){
            cout<<tmp->data<<' ';
            tmp=tmp->next;
        }
        cout<<"\n";
    }
    void sort(){
        int * arr=new int[size];
        node * tmp=head;
        for(int i=0;i<size;i++) arr[i]=tmp->data,tmp=tmp->next;
        std::sort(arr,arr+size);
        tmp=head;
        for(int i=0;i<size;i++) tmp->data=arr[i],tmp=tmp->next;
    }
};
int main(){
    int x;
    linklist ll1;
    string command="";
   do{
       cin>>command;
       if(command=="pop"){
           ll1.pop_front();
       }
       else if(command=="push"){
           cin>>x;
           ll1.push_front(x);
       }
       else if(command=="sort"){
           ll1.sort();
       }
       else if(command=="print"){
           ll1.print();
       }
   }while(command!="finish");
    return 0;
}