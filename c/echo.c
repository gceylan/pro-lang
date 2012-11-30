#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define SEPARATOR ' '
#define NEWLINE '\n'

/*
 * $ echo -n gceylan
 * gceylan$
 *
 */

enum boolean {TRUE, FALSE} boole;

int main(int argc, char *argv[]) {
	boole = FALSE;
	int i = 1;

	if ((argc > 1) && (strcmp(argv[i], "-n") == 0)) {
		boole = TRUE;
		i++;
	}

	for(i; i < argc; i++) {
		printf("%s", argv[i]);
		if (i + 1 < argc)
			putchar(SEPARATOR);
	}

	if (boole)
		putchar(NEWLINE);

	exit(EXIT_SUCCESS);
}
