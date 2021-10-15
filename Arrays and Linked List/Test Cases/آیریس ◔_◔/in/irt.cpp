#include <bits/stdc++.h>
using namespace std;
typedef long long ll;

// input generator (if u would like to see it)
int main(){
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	srand(time(0));
	int t;
	cin >> t;
	cout<<t<<endl;
	int mn = 2*100000;
	for(int i=0;i<t;i++){
		int n = (3+rand() % (mn));
		if(n==mn && i<t-1){
			n=n-(mn-t-1-i);
		}
		mn-=n;
	 	cout<<n<<endl;
	 	int sum=0;
	 	std::vector<int> v;
	 	for(int j=0;j<n+1;j++){
	 		int p = 1+rand()%100000;
	 		if(j<n)sum+=p;
	 		v.push_back(p);
	 	}
	 	v.push_back(sum);
	 	auto rng = std::default_random_engine {};
		std::shuffle(std::begin(v), std::end(v), rng);
		for(auto num:v){
			cout<<num<<' ';
		}
	 	cout<<endl;
	 }

}