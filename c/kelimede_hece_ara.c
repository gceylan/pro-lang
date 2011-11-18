#include <stdio.h>
#include <string.h>

int hece_ara(char* kelime, char* hece) {
	char* p1 = kelime;
	char* p2 = hece;
	int i = 0, j = 0;

	for(i=0;i < strlen(kelime); i++) {
		if(*(p1 + i) == *(p2 + j)) {
			for(j=0; j < strlen(hece); j++) {
				if(*(p1 + i + j) != *(p2 + j))
					return 0;
			}
		}
	}
	return 1;
}

int main(void) {
	char kelime[20];
	char hece[20];

	printf("kelime --> aranacak ifade:(ör: gceylan gc) ");
	scanf("%s%s", kelime, hece);

	if (hece_ara(kelime, hece))
		printf("True");
	else
		printf("False");

	printf("\n");
	return 0;
}
