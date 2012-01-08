// s1 stringi s2 stringinden once geliyorsa negatif, sonra geliyorsa pozitif dönderiri.
// tüm karakterler aynı ise 0 dönderir.

#include <stdio.h>

int my_strcmp(char *s1, char *s2) {
	for ( ; *s1 || *s2; s1++, s2++) {
		if (*s1 > *s2) {
			return 1;
		}
		else if (*s1 < *s2) {
			return -1;
		}
	}
	return 0;
}

int main(void) {
	char s1[] = "merhaba";
	char s2[] = "merhaba";
	
	printf("%d\n", my_strcmp(s1, s2));
	
	return 0;
}
