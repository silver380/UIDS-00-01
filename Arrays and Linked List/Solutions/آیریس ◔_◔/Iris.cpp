//by Mahroo Noohi
#include <iostream>
#include <algorithm>

using namespace std;

void show(long long * x, int size)
{
	sort(x, x + size);
	for (int i = 0; i < size; i++) {
		cout << x[i] << " ";
	}
}
int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	int t;
	cin >> t;
	while (t--) {
		int n;
		cin >> n;
		long long * arr = new long long [n + 2];
		long long  sum = 0;
		for (int i = 0; i < n + 2; i++) {
			cin >> arr[i];
			sum += arr[i];
		}
		sort(arr, arr + (n + 2));
		if (sum - (arr[n + 1] + arr[n]) == arr[n])
			show(arr, n);
		else {
			int i;
			for (i = 0; i < n + 1; i++) {
				if (sum - (arr[n + 1] + arr[i]) == arr[n + 1]) {
					swap(arr[i], arr[n]);
					show(arr, n);
					break;
				}
			}
			if (i == n + 1)
				cout << -1;
		}
		cout << endl;
		delete[]arr;
	}
}
