/*
 * tester.cpp
 */
#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
bool ok = true;
ll solve(std::vector<ll> num, ll n){
		ll sum=0,mx=INT_MIN;
		sort(num.begin(),num.end());
		for(ll i=0;i<n;i++){
			sum+=num[i];
		}
		if(sum==num[n]){
			return 1;
		}
		sum+=num[n];
		mx = num[n+1];
		ll f=1;
		sum = sum-mx;
		for(ll i=0;i<n+1;i++){
			if(num[i]==sum&&f==1){
				f=0;
				continue;
			}
		}
		if(f){
			return -1;
		}
		return 1;
}
int main(int argc, char const *argv[])
{
	ifstream test_in(argv[1]);    /* This stream reads from test's input file   */
	ifstream test_out(argv[2]);   /* This stream reads from test's output file  */
	ifstream user_out(argv[3]);   /* This stream reads from user's output file  */
 	ll t;
 	test_in >> t;
 
 	for(ll q=0;q<t;q++){
 		ok = true;
 		ll n;
 		test_in>>n;
 		vector<ll> num(n+2);
 		multiset<ll> num2;
		for(ll i=0;i<n+2;i++){
			test_in>>num[i];
			num2.insert(num[i]);
		}
		ll sum=0;
		ll un;ll i=0;
		while((i<n)&&(user_out>>un)){
			if(un ==-1 && i==0){
				break;
			}
			i++;
			sum+=un;
			if(num2.count(un)==0){
				ok = false;
				return 1;
			}
			num2.erase(num2.find(un));
		}
		ll mn = solve(num,n);
		if(un ==-1 && i==0){
			if(mn ==-1)continue;
			else{
				return 1;
			}
		}
		if(i==n && ok && (num2.find(sum)!=num2.end())){
			continue;
		}
		return 1;
	}
	return 0;
}
