#include <stdio.h>
#include <string.h>

int palindrom(char* dizi) {
	char *b = dizi;			      //dizinin basini goster (*b)
	char *s = dizi + strlen(dizi) - 1;    //dizinin sonunu goster (*s)
	int i = 0;

	while ((b + i) <= s) {                //döngü kırılırsa palindrom degil
		if (*(b + i) != *(s - i))
			return 0;
		i++;
	}
	return 1;
}

int main(void) {
	char dizi[100];

	printf("palindrom testi: ");
	gets(dizi);

	if (palindrom(dizi))
		printf("palindrom");
	else
		printf("palindrom değil");

	printf("\n");
	return 0;
}
