#include <stdio.h>
#include <string.h>

int main(void) {
	char* sifre = "xxbxbbcccddaaabvncs";
	int i = 0, s = 0;

	for(i=0; i<strlen(sifre); i++) {
		if (sifre[i] == sifre[i-1])
			s++;
		else
			s = 0;
		if (s==2)
			printf("%c", sifre[i]);
	}

	printf("\n");
	return 0;
}
