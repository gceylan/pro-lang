#include <stdio.h>
#include <stdlib.h>
#include <string.h>

char *join(char *s, char k) {
	char *p, *g;
	int i = 0;
	p = (char *)malloc(strlen(s) * 2);
	g = p;
	
	for(i=0; *s; i++) {
		if (i % 2 == 0) {
			*g++ = *s++;
		} else {
			*g++ = k;
		}
	}
	*g = '\0';
	
	return p;
}

char *split(char *s, char k) {
	char dizi[strlen(s) / 2 + 2];
	char *p = dizi;
	char *g = p;
	
	for(; *s; s++) {
		if (*s != k)
			*p++ = *s;
	}
	
	*p = '\0';
	
	return g;
}

int main(void) {
	char dizi[24] = "ONDOKUZMAYISUNIVERSITESI";
	char krktr = '-';
	char *p, *g;
	
	printf("string : %s\n", dizi);
	
	p = join(dizi, krktr);
	
	printf("join   : %s\n", p);
	
	g = split(p, krktr);
	
	printf("split  : %s\n", g);
	
	return 0;
}
