#include <stdio.h>

int main(void) {
	char cumle[28] = "Turkiye Buyuk Millet Meclisi";
	int i;

	for (i=0; cumle[i] != '\0'; i++) {
		if (i == 0)
			printf("%c", cumle[i]);
		if (cumle[i - 1] == ' ')
			printf("%c", cumle[i]);
	}
	printf("\n");
	return 0;
}
