#include <stdio.h>
#include <string.h>

int main(){
	char string[20];
	char sesliler[8] = "aeioAEIO";
	int i = 0, s = 0;

	printf("Kelimeyi giriniz: ");
	scanf("%s", string);

	for (i=0; i<strlen(string); i++) {
		if (strchr(sesliler, string[i]))
			s++;
	}

	printf("%s kelimesindeki sesli herf sayisi: %d\n", string, s);
	return 0;
}
