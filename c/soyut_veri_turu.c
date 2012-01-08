#include <stdio.h>

#define MAX 100

int INDEX = 0;
int stack[MAX];

void push(int deger) {
	if (INDEX < MAX)
		stack[INDEX++] = deger;
	else
		printf("stack dolu!\n");
}

int pop(void) {
	if (INDEX != 0)
		return stack[INDEX--];
	else
		printf("stack bos!\n");
		return 0;
}

int size(void) {
	return INDEX;
}

void yazdir(void) {
	int x = 0;
	
	printf("\n");
	for(x = 0; x < INDEX; x++) {
		printf("%-4d", stack[x]);
	}
}

int main(void) {
	int i = 0;
	
	push(5);
	yazdir();
	
	push(7);
	yazdir();
	
	push(9);
	yazdir();
	
	push(123);
	yazdir();
	
	i = size();
	printf("\nsize : %d\n", i);
	
	pop();
	yazdir();
	
	return 0;
}
