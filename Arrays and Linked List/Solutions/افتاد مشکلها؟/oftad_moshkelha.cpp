#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
ll maxIndexDiff(ll *arr, ll n)
{
	ll maxDiff;
	ll i, j;

	ll* LMin = new ll[(sizeof(ll) * n)];
	ll* RMax = new ll[(sizeof(ll) * n)];
	LMin[0] = arr[0];
	for (i = 1; i < n; ++i)
		LMin[i] = min(arr[i], LMin[i - 1]);
	RMax[n - 1] = arr[n - 1];
	for (j = n - 2; j >= 0; --j)
		RMax[j] = max(arr[j], RMax[j + 1]);

	i = 0, j = 0, maxDiff = -1;
	while (j < n && i < n) {
		if (LMin[i] <= RMax[j]) {
			maxDiff = max(maxDiff, j - i);
			j = j + 1;
		}
		else
			i = i + 1;
	}

	return maxDiff;
}

int main()
{
	ios_base::sync_with_stdio(false);
    cin.tie(NULL);
	ll n;
	cin >> n;
	ll *arr = new ll [n];
	for(ll i=0;i<n;i++)
		cin >> arr[i];
	ll maxDiff = maxIndexDiff(arr, n);
	if(maxDiff==0){
		cout<<"YOU DIED"<<endl;
	}
	else
		cout<<maxDiff<<endl;
	return 0;
}


