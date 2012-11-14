#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define SEPARATOR ' '
#define NEWLINE '\n'

/*
 * $ echo -n gceylan
 * gceylan$
 *
 * todo, j yi enum(true, false) yap
 */

int main(int argc, char *argv[]) {
	int i = 1, j = 0;

	if ((argc > 1) && (strcmp(argv[i], "-n") == 0)) {
		j = 1;
		i++;
	}

	for(i; i < argc; i++) {
		printf("%s", argv[i]);
		if (i + 1 < argc)
			putchar(SEPARATOR);
	}

	if (j == 0)
		putchar(NEWLINE);

	exit(EXIT_SUCCESS);
}
