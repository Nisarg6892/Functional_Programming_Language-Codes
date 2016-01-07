#include <stdio.h>

int i;
int j;
int k;

int thunk1();
int thunk2();
int thunk3();

int thunk1(){
    return i * sigma(&j,0,4,thunk2);
}

int thunk2(){
	return (i+j) * sigma(&k,0,4,thunk3);
}

int thunk3(){
    return (j*k-i);
}

int sigma(int *k, int low, int high, int expr()) {
  	
  	int sum = 0;
  	
  	for (*k=low; *k<=high; (*k)++) {
       sum = sum + expr();
	}
	return sum; 
}

int main(void) {

	printf("%d\n",sigma(&i,0,4,thunk1));
	return 0;
	
}