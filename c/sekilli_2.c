//s
//sa
//sam
//sams
//samsu
//samsun
//samsu
//sams
//sam
//sa
//s	seklinde cikti üreten program

#include <stdio.h>
#include <string.h>

int main(void) {
	char c[20];
	int i = 0, j = 0;

	printf("bir kelime giriniz: ");
	scanf("%s", c);

	for(i=0; i < strlen(c)-1; i++) {
		for(j=0; j <= i; j++) {
			printf("%c", c[j]);
		}
		printf("\n");
	}

	for(i; i >= 0; i--) {
		for(j=0; j <= i; j++) {
			printf("%c", c[j]);
		}
		printf("\n");
	}

	return 0;
}
