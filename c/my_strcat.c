#include <stdio.h>
#include <string.h>

char *my_strcat(char *s1, char *s2) {
	char *p = s1;
	int boy = strlen(s2);
	
	for (i = 0; j < boy; i++) {
		if (s1[i] == '\0') {
			s1[i] = s2[j++];
		}
	}
	
	return s1; 	// &s1[0] aynisi...
}

int main(void) {
	char s1[20] = "merhaba ";
	char s2[6] = "dunya";
	char *p;
	
	p = my_strcat(s1, s2);
	
	printf("%s\n", p);
	
	return 0;
}
