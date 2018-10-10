#include <vector>
#include <string>
#include <map>
#include <iostream>
#include <string.h>
#include <stdlib.h>
#include <stdio.h>
using namespace std;
void OrderPolynomial (char* InputString, char* OutputString)
{
    /*在这里实现功能*/
	string polyInput(InputString);
	string sign("+-");
	vector<string> deliVec;
	size_t signpos=0;
	//处理开头既是负号的情况
	if(polyInput[0]=='-'){
		//从位置1开始找
		signpos=polyInput.find_first_of(sign,1);
		if(signpos!=string::npos)
			deliVec.push_back(polyInput.substr(0,signpos));
		else 
		{
			//如果是仅有一个单项式
			strcpy(OutputString,polyInput.c_str());
			return;
		}
	}
	//根据正负号分割输入字符串
	while(signpos!=string::npos){
		size_t presingpos=signpos;
		signpos=polyInput.find_first_of(sign,presingpos+1);
		//s.substr(pos,n) 如果n>s.size(),则只复制到空字符
		deliVec.push_back(polyInput.substr(presingpos,signpos-presingpos));
	}

	map<int,vector<int> > deliMap;
	vector<string>::iterator iter=deliVec.begin();
	while(iter!=deliVec.end()){
		string temp=*iter; 
		size_t Xpos=temp.find('X');
		string param=temp.substr(0,Xpos);
		int intParam;
		sscanf(param.c_str(),"%d",&intParam);
		size_t powPos=temp.find('^');
		string pow=temp.substr(powPos+1);
		int powParam;
		sscanf(pow.c_str(),"%d",&powParam);
		if(deliMap.count(powParam)==0){
			vector<int> tempVec;
			tempVec.push_back(intParam);
			deliMap.insert(pair<int,vector<int> >(powParam,tempVec));
		}else{
			deliMap[powParam].push_back(intParam);
		}
		++iter;
	}
	//遍历map,int为键类型升序
	map<int,vector<int> >::const_iterator iterMap=deliMap.begin();
	string result;
	while(iterMap!=deliMap.end()){
		int paramResult=0;
		vector<int>::const_iterator iterVec=(iterMap->second).begin();
		//遍历相同键值的vector
		while(iterVec!=(iterMap->second).end()){
			paramResult+=*iterVec;
			++iterVec;
		}
		char charParam[50];
		char charPow[50];
		//处理正号
		if(paramResult>0)
			sprintf(charParam,"+%d",paramResult);
		else
			sprintf(charParam,"%d",paramResult);
		sprintf(charPow,"%d",iterMap->first);
		//在字符串头部插入
		if(paramResult!=0){
			result.insert(0,charParam+string("X^")+charPow);
		}
		++iterMap;
	}
	//处理开头是正号的情况
	if(result[0]=='+')
		strcpy(OutputString,result.c_str()+1);
	else
		strcpy(OutputString,result.c_str());
    return ;
}
