//A
//AB
//ABC
//ABCD
//ABCDE  seklinde cikti üretecek program

#include <stdio.h>

int main(void) {
	char c = 'A';
	int i = 0, j = 0;

	for(i=0; i <= 10; i++) {
		for(j=0; j <= i; j++) {
			printf("%c", c + j);
		}
		printf("\n");
	}

	return 0;
}
