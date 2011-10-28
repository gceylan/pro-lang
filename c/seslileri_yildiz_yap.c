// girilen kelimedeki sesli harfleri '*' yapar...

#include <stdio.h>
#include <string.h>

int main(void) {
	int i;
	char kelime[20];
	char* sesliler = "aeiouAEIOU";

	printf("bir kelime girin: ");
	scanf("%s", kelime);

	for (i=0; i < strlen(kelime); i++) {
		if (strchr(sesliler, kelime[i]))
			putchar('*');
		else
			putchar(kelime[i]);
	}
	printf("\n");
	return 0;
}
