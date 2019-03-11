#include<stdio.h>
#include<stdlib.h>
#include<string.h>

int bin2Dec(int b){
	char s[100];
	int re = 0,i,n;
	itoa(b, s, 10);
	n = strlen(s) - 1;
	for(i=n;i>=0;i--){
		re += s[i] - 48<<n-i;
	}
	return re;

}

int main(){

	printf("%d\n", bin2Dec(1101));



}
