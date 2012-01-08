#include <stdio.h>
#include <string.h>
#include <stdlib.h>

char *my_strncat(char s1[], char s2[], int n) {
	int i = 0;
	char *p, *g;
	g = malloc(sizeof(char) * (strlen(s1) + n + 1));
	p = g;
	
	for( ; *s1; s1++) {
		*p++ = *s1;
	}
	
	for(i=0; i < n; i++) {
		*p++ = *s2++;
	}
	
	*p = '\0';
	
	return g;
}

int main(void) {
	char d1[9] = "gceylan-";
	char d2[8] = "merhaba";
	char *p;
	
	p = my_strncat(d1, d2, 10);
	printf("%s\n", p);
	
	p = my_strncat(d1, d2, 5);
	printf("%s\n", p);
	
	return 0;
}
