#include "string.h"
#include "stdio.h"
#include "stdlib.h"
#define MAX_PATH 256
 
int store[1024] = {0};
int num = 0;
void getStringBeforeString(char *out,char *in,char *subFlag)
{
 char *t = strstr(in,subFlag);
 if(t!=NULL)
 {
  memcpy(out,in,t-in);
 }
 else
 {
  memset(out,0,1);
 }
 
}
 
char *getUnit(char *out,char *in,int *pn)
{
 char *position = NULL;
 char tmp1[1024] = {0};
 char tmp2[1024] = {0};
 getStringBeforeString(tmp1,in,"+");
 getStringBeforeString(tmp2,in,"-");
 if (strlen(tmp1)==0 && strlen(tmp2)==0)
 {
  memset(out,0,1);
  return in;
 }
 if (strlen(tmp1)<strlen(tmp2))
 {
  if (strlen(tmp1)!=0)
  {
   memcpy(out,tmp1,strlen(tmp1)+1);
   *pn = 1;//正数
   position = in+(strstr(in,"+")-in)+1;
  }
  else
  {
   memcpy(out,tmp2,strlen(tmp2)+1);
   *pn = 0;//负数
   position = in+(strstr(in,"-")-in)+1;
  }
 }
 else
 {
  if(strlen(tmp2)!=0)
  {
   memcpy(out,tmp2,strlen(tmp2)+1);
   *pn = 0;//负数
   position = in+(strstr(in,"-")-in)+1;
  }
  else
  {
   memcpy(out,tmp1,strlen(tmp1)+1);
   *pn = 1;//正数
   position = in+(strstr(in,"+")-in)+1;
  }
 }
 return position;
}
//准备工作：存入数据，处理数据（矩阵运算：行的元素和列的元素对应积的和），输出
int main()
{
 //输入：
 // "-7X^4+5X^6-3X^3+3X^3+1X^0" 
  //输出：
  //"5X^6-7X^4+1X^0"
 char buffer[1024] = {0};
 char out[1024] = {0};
 gets(buffer);
 int pn = 1,pn_next = 1;//记录正负，1为正数
 char *position = buffer;
 //单独处理第一个
 if (*position=='-')
 {
  pn_next = 0;
  pn = pn_next;
  position = position+1;
 }
 while(true)
 {
  memset(out,0,1024);
  position = getUnit(out,position,&pn_next);
  if (strlen(out)==0)
  {
   //处理最后一组
   char *a = strtok(position,"X^");
   char *b = strtok(NULL,"X^");
   if (pn==1)
   {
    store[atoi(b)] += atoi(a);
   }
   else
   {
    store[atoi(b)] -= atoi(a);
   }
   break;
  }
  char *a = strtok(out,"X^");
  char *b = strtok(NULL,"X^");
  if (pn==1)
  {
   store[atoi(b)] += atoi(a);
  }
  else
  {
   store[atoi(b)] -= atoi(a);
  }
  pn = pn_next;
 }
 int headFlag = 0;
 for (int i=1023;i>=0;i--)
 {
  int t = store[i];
  if (t!=0)
  {
   if (t>0)
   {
    if (headFlag==1)
    {
     printf("+");
    }
   }
   printf("%dX^%d",t,i);
   headFlag = 1;
  }
  
 }
 //store[num++] = atoi(out);
 return 0;
}
