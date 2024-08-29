#include <stdio.h>
int array [4];
void swap(int a, int b) {
    int temp = array[a];
    array[a] = array[b];
    array[b] = temp;
 }
int main(){
    int n =4;
    int acc=0;
    // for (int i=n-1;i>0;i/=2){ // lg(n)
    //         acc++;
    // }
    // printf ("%d\n",acc);
    // acc=0;
    // for (int i=1;i<=n;i++){
    //     acc++;
    // }
    // printf("%d\n",(n*(n-1))/2);
    
    // acc =0;
    // for(int i =0;i<n;i++){
    //     acc += i;
    // }
    // printf ("\n%d\n",acc);
//     int a =0;
//    for (int i = n; i > 0; i /= 2){
//     -
//     }
//     for i=n-1 i >1 i /=2
//  printf("%d", a);
int for1=0, for2=0;
 for (int i = 0; i < (n - 1); i++) {
 int menor = i; 
 for1++ ;
         for (int j = (i + 1); j < n; j++){
            for2++;
            if (array[menor] > array[j]){acc++;
               menor = j; 
  }
 }
 swap(menor, i); 
 }
 printf("%d",acc);
 printf("\n1 :%d  \n 2:%d",for1 , for2);
  int mov = 0;
 for (int i = 0; i < (n - 1); i++) {
 int menor = i; 
         for (int j = (i + 1); j < n; j++){
            if (array[menor] > array[j]){
               menor = j;
 }
 }
 swap(menor, i);
 mov += 3;
 }
 printf("Teoria: " , (3*n - 3));
 printf("Prática: " , mov);
    return 0;
}