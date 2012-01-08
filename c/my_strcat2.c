#include <stdio.h>
#include <string.h>

char *my_strcat(char *s1, char *s2) {
	char *p = s1;
	
	for ( ; *s2 != '\0'; p++) {
		if (*p == '\0') {
			*p = *s2++;
		}
	}
	//*s2 = '\0';
	
	return s1; 	// &s1[0] aynisi...
}

int main(void) {
	char s1[20] = "merhaba ";
	char s2[8] = "gceylan";
	char *p;
	
	p = my_strcat(s1, s2);
	
	printf("%s\n", p);
	
	
	return 0;
}
