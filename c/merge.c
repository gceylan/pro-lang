// iki diziyi birlestirdik...

#include <stdio.h>

void birlestir(int* d1, int* d2, int lend1, int lend2) {
	int merge[lend1 + lend2];
	int i = 0;

	for (i=0; i < lend1 + lend2; i++) {
		if (i < lend1)
			merge[i] = d1[i];
		else
			merge[i] = d2[i - lend1];
	}

	for (i=0; i < lend1 + lend2; i++) {
		printf("%-5d", merge[i]);
	}
}

int main(void) {
	int x = 3, y = 5;
	int d1[] = {1, 3, 11};
	int d2[] = {2, 4, 6, 8, 12};

	birlestir(d1, d2, x, y);

	printf("\n");
	return 0;
}
