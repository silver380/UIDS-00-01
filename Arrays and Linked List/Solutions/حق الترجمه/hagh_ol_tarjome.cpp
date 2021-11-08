#include <bits/stdc++.h>
#include <string>
using namespace std;

int main()
{
    int n;
    cin>>n;
    while(n>0)
    {
        int k;
        cin>>k;
        int * price = new int [k];
        char * charec = new char [k];
        for(int i=0 ; i<k ; i++)
            cin>>charec[i]>>price[i];
        int nos;
        cin>>nos;
        float sum = 0;
        while (nos>=0)
        {
            string a;
            getline(cin,a);
            for(int i=0; i<a.size(); i++)
            {
                for(int j =0 ; j<k ; j++)
                {
                    if(a[i] == charec[j])
                    {
                        sum += price[j];
                        break;
                    }
                }
            }
            nos--;
        }
//        cout<<sum/100<<"$"<<endl;
        cout<<fixed<<setprecision(2)<<sum/100<<"$"<<endl;
        n--;
    }

}

