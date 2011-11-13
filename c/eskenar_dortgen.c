/* '*'ler yardimiyla eskenar dortgen cizer */

#include<stdio.h>
int main( void ) {
	int i, j;

	for(i = 1; i <= 5; i++) {
		for(j = 1; j <= 9; j++)
			if((j <= (9 - (2*i - 1))/2) || (j > (i + 4)))
				printf(" ");
			else
				printf("*");

		printf("\n");
	}
	for(i = 4; i >= 1; i--){
		for(j = 1; j <= 9; j++)
			if((j <= (9 - (2*i - 1))/2) || (j > (i + 4)))
				printf(" ");
			else
				printf("*");

		printf("\n");
	}
	return 0;
}
