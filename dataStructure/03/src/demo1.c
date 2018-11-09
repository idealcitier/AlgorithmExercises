#include<stdio.h>
#include<stddef.h>

int find(char* a, int n, char key);
int main(){
	char a[] = {4,2,3,5,9,6};

	int i = find(a, 6, 7);
	printf("at %d\n", i);

	return 0;


}

int find(char* a, int n, char key){
	
	if(a == 0 || n <= 0){
		return -1;
	}

	int i = 0;
	while(i<n){
		if(a[i] == key){
			return i;
		}

		++i;
	}
	return -1;

}
