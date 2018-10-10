#include <iostream>
#include <map>
#include <string>
#include <stack>
using namespace std;

// 整型转换为字符串
string Int2Str(int num){
    string str = "";
    if(num == 0){
        str = "0";
        return str;
    }//if
    while(num){
        str.insert(str.begin(),num % 10 + '0');
        num /= 10;
    }//while
    return str;
}

void OrderPolynomial (char* InputString, char* OutputString){
    if(InputString==NULL){
        return;
    }//if
    // key 为 系数 
    map<int,int> Map;
    int size = strlen(InputString);
    char* str = InputString;

    int index = 0;
    while(index < size){
        bool positive = true;
        // 正负号
        if(str[index] == '+' ){
            ++index;
        }//if
        else if(str[index] == '-'){
            positive = false;
            ++index;
        }//else
        // 系数
        int num = 0;
        while(str[index] >= '0' && str[index] <= '9'){
            num =num * 10+ str[index] - '0';
            ++index;
        }//while
        if(!positive){
            num = -num;
        }//if

        //跳过X^
        index += 2;

        // 指数
        int number = 0; 
        while(str[index] >= '0' && str[index] <= '9'){
            number = number * 10+ str[index] - '0';
            ++index;
        }//while

        // 相同指数
        map<int,int>::iterator ite = Map.find(number);
        if(ite != Map.end()){
            ite->second += num;
        }//if
        // 没有相同指数
        else{
            Map.insert(pair<int,int>(number,num));
        }//else
    }//while
    map<int,int>::reverse_iterator ite = Map.rbegin();
    index = 0;
    bool isFirst = true;
    while(ite != Map.rend()){
        // 等于 0
        if(ite->second == 0){
            ++ite;
            continue;
        }//if
        // 大于 0 
        int num = ite->second;
        if(ite->second > 0){
            if(!isFirst){
                OutputString[index++] = '+';
            }//if
        }//if
        // 小于 0
        else if(ite->second < 0){
            OutputString[index++] = '-';
            num = -num;
        }//else
        isFirst = false;
        // 系数
        string tmp = Int2Str(num);
        for(int i = 0;i < tmp.size();++i){
            OutputString[index++] = tmp[i];
        }//for
        OutputString[index++] ='X';
        OutputString[index++] ='^';
        // 指数
        tmp = Int2Str(ite->first);
        for(int i = 0;i < tmp.size();++i){
            OutputString[index++] = tmp[i];
        }//for
        ++ite;
    }//while
    OutputString[index]='\0';
    //cout<<OutputString<<endl;
    return;
}