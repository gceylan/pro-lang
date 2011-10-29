#include <stdio.h>

void kaydir_yaz(char*, int);
void kaydir_yaz(char* chpt, int len_dizi) {
	int i = 0, j = 0;

	for(i=0; j<len_dizi + 1; i++) {
		for(j = i; j<len_dizi; j++) {
			printf("%c", chpt[j]);
		}
		for(j = 0; j<i; j++) {
			printf("%c", chpt[j]);
		}
		printf("\n");
	}
}

int main(void) {
	char str[7] = {'g', 'c', 'e', 'y', 'l', 'a', 'n'};
	int i = 0, len_dizi = 7;

	kaydir_yaz(str, len_dizi);

	return 0;
}
