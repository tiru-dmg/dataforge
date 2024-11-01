#include<stdio.h>
 int main()
 {
 int windowsize,sent=0,ack,i;
 printf("enter window size \n");
 scanf("%d",&windowsize);
 while(1)
 {
 for(i=0;i<windowsize;i++)
 {
 printf("frame %dhas been transmitted.\n",sent);
 sent++;
 if(sent==windowsize)
 break;
 }
 printf("\n please enter the last acknowledgement received.\n");
 scanf("%d",&ack);
 if(ack==windowsize)
 break;
 else
 sent=ack;
 }
 return 0;
 }
