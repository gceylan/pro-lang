// dec2bin converter

#include <stdio.h>

int main(void) {
	int dec = 563;
	int binary[100];
	int i = 0, k = 0, j = 0;

	printf("dec: %d\nbinary: ", dec);

	for (i=0; dec > 0; i++) {
		k = dec % 2;
		binary[i] = k;
		dec /= 2;
		//printf("%d\n", dec);
	}

	for(j=0; j < i; j++){
		printf("%d", binary[i - j - 1]);
	}
	printf("\n");
	return 0;
}
