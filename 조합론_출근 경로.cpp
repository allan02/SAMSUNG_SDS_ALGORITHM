#include <iostream>

using namespace std;
#define MOD 100000

int main(void) {

	int w, h; cin >> w >> h;
	int dp[101][101][2][2] = { 0, }; //3,4 번째 인덱스는 방향전환 가능 여부와 내 방향 0->북 1->동

	for (int i = 2; i <= h; i++)
		dp[i][1][0][0] = 1;

	for (int i = 2; i <= w; i++)
		dp[1][i][0][1] = 1;


	for (int i = 2; i <= h; i++)
		for (int j = 2; j <= w; j++) {
			dp[i][j][0][0] = (dp[i - 1][j][0][0] + dp[i - 1][j][1][0]) % MOD;
			dp[i][j][0][1] = (dp[i][j - 1][0][1] + dp[i][j - 1][1][1]) % MOD;
			dp[i][j][1][0] = (dp[i - 1][j][0][1]) % MOD;
			dp[i][j][1][1] = (dp[i][j - 1][0][0]) % MOD;
		}

	cout << (dp[h][w][0][0] + dp[h][w][0][1] + dp[h][w][1][0] + dp[h][w][1][1]) % MOD;
	return 0;
}