#include <stdio.h>
#define MAX 100		/* define bir önişlemcidir. Derleme başlamadan hemen önce MAX ifadelerini 100 ifadesiyle değiştirir */

char *stack[MAX];	/* argv gibi bir dizi */
int INDEX = 0;

void push(char *str) {
	if (INDEX + 1 > MAX)
	{
		printf("stack dolu!\n");
		return;
	}
	stack[INDEX++] = str;
	printf("push -> %d -> %s\n", INDEX - 1, stack[INDEX - 1]);
}

char * pop()
{
	if(INDEX - 1 < 0) {
		printf("stack boş!\n");
		return NULL;
	}
	INDEX--;
	printf("pop  -> %d -> %s\n", INDEX, stack[INDEX]);
	return stack[INDEX];
}

void print(void)
{
	int i = 0;

	for(i; i < INDEX; i++) {
		printf("%d -> %s\n", i, stack[i]);
	}
}

int size(void)
{
	printf("size -> %d\n", INDEX);
	return INDEX;
}

int main(void)
{
	push("Deneme");
	push("Deneme 123");
	push("Hello WORLD!");

	print();
	size();

	pop();

	print();
	size();

	pop();
	pop();
	pop();
	pop();

	size();

	push("gceylan");

	return 0;
}
