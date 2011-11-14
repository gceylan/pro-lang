#include <stdio.h>

int main(void) {
	int sayilar[10] = {1, 2, -1, -5, 3, 87, 39, 21, 45, -99};
	int i = 0, j = 0, k = 0;

	for (i=0; i < 10; i++) {
		for(j=0; j < 10; j++) {
			if (sayilar[j] > sayilar[j + 1]) {
				k = sayilar[j];
				sayilar[j] = sayilar[j + 1];
				sayilar[j + 1] = k;
			}
		}
	}

	for(i=0; i < 10; i++) {
		printf("%d ", sayilar[i]);
	}

	return 0;
}
