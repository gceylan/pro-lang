// strchr islevi karakterin string icinde ilk bulundugu yerin adresini
// gönderir. Karakter string icinde mevcut degilse NULL dondurur.

#include <stdio.h>

char *my_strchr(char *p, char karakter) {
	
	for(; ; p++) {
		if (*p == karakter)
			return p;
	}
	
	return NULL;
}

int main(void) {
	char x[] = "Ondukuz Mayis Universitesi";
	char karakter = 'M';
	char *p;
	
	p = my_strchr(x, karakter);
	
	if (p != NULL)
		printf("%s\n", p);
	
	return 0;
}
