#include<stdio.h>

int main(){

	int n = 8;

}


void dec2Bin(){
	if(n/2)
		dec2Bin(n/2)
	putchar('0'+n%2);
}
