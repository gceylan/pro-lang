// stringde hece arama

#include <stdio.h>
#include <string.h>

int hece_ara(char* kelime, char* hece) {
	char* p1 = kelime;       //kelimeyi goster
	char* p2 = hece;         //heceyi goster
	int i = 0, j = 0;

	for(i=0;i < strlen(kelime); i++) {
		if(*(p1 + i) == *(p2 + j)) {                    //kelime stringinin i. elemanı hece stringinin 0. elemanına eşit mi?
			for(j=0; j < strlen(hece); j++) {           //ilk harfler uyustuguna gore diger harflere bakalım...
				if(*(p1 + i + j) != *(p2 + j))          //eger bir uyusmayan varsa dogru degildir.
					return 0;
			}
		}
	}
	if (j == 0)       //eger j degiskeni 0 ise kelime stringinin icinde aradıgım hecenin bas harfi yoktur. ornek: gceylan xc
		return 0;
	return 1;
}

int main(void) {
	char kelime[20];
	char hece[20];

	printf("kelime --> aranacak ifade:(ör: gceylan gc) ");
	scanf("%s%s", kelime, hece);

	if (hece_ara(kelime, hece) == 1)
		printf("True");
	else
		printf("False");

	printf("\n");
	return 0;
}
