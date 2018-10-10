
#include <string.h>
#include <stdio.h>

void method (int* a, char* OutputString,int n)
{
	int i=1;
	int j;
	char b[10];
	int num=0;
	if(a[0]==0)
		i=2;
	else
	{
		if(a[0]<0)
		{
			OutputString[0]='-';
			a[0]=-1*a[0];
			++num;
		}
		sprintf(b,"%d",a[0]);
		for(j=0;b[j]!='\0';++j)
		{
			OutputString[num]=b[j];
			++num;
		}
		OutputString[num]='X';
		++num;
		OutputString[num]='^';
		++num;
	}
	while((i<=n))
	{
		if((a[i]==0)&&(i%2==0))
		{
			i=i+2;
			continue;
		}
		if((i+1)<=n)
			if((a[i+1]==-1)&&((i+1)%2==1))
				break;
		if(i%2==1)
		{
			sprintf(b,"%d",a[i]);
			for(j=0;b[j]!='\0';++j)
			{
				OutputString[num]=b[j];
				++num;
			}
		}
		if(i%2==0)
		{
			if(a[i]<0)
			{
				OutputString[num]='-';
				a[i]=-1*a[i];
				++num;
			}
			else
			{
				OutputString[num]='+';
				++num;
			}
			sprintf(b,"%d",a[i]);
			for(j=0;b[j]!='\0';++j)
			{
				OutputString[num]=b[j];
				++num;
			}
			OutputString[num]='X';
			++num;
			OutputString[num]='^';
			++num;
		}
		++i;
	}
	OutputString[num]='\0';
}
void OrderPolynomial (char* InputString, char* OutputString)
{
    /*在这里实现功能*/
    int a[40];
	int i,j,b,flag;
	int num=0;
	for(i=0;i<40;++i)
	{
		a[i]=0;
	}
    if(InputString[0]=='-')
		flag=-1;
	else
	{
		a[0]=InputString[0]-'0';
		flag=1;
	}
	for(i=1;InputString[i]!='\0';++i)
	{
        if((InputString[i]>='0')&&(InputString[i]<='9'))
		{
			a[num]=10*a[num]+InputString[i]-'0';
		}
		if(InputString[i]=='X')
		{
			a[num]=a[num]*flag;
			++num;
		}
		if(InputString[i]=='-')
		{
			flag=-1;
			++num;
		}
		if(InputString[i]=='+')
		{
			flag=1;
			++num;
		}
	}
 
	for(i=1;i<=num;i=i+2)
	{
		for(j=i+2;j<=num;j=j+2)
		{
			if(a[i]==a[j])
			{
				a[i-1]=a[i-1]+a[j-1];
				a[j]=-1;
			}
		}
	}
    for(i=1;i<=num;i=i+2)
	{
		for(j=i+2;j<=num;j=j+2)
		{
			if(a[i]<a[j])
			{
				b=a[i];a[i]=a[j];a[j]=b;
				b=a[i-1];a[i-1]=a[j-1];a[j-1]=b;
			}
		}
	}
	method(a,OutputString,num);
    return;
}

int main(){
	
	char in[40];
	char out[40];
	scanf("%s", in);

	OrderPolynomial (in, out);

	printf("%s\n", out);

	return 0;
}
