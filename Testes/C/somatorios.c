#include <stdio.h>

int main(){
    int n =10;
    int acc=0;
    for (int i=n-1;i>0;i/=2){ // lg(n)
            acc++;
    }
    printf ("%d\n",acc);
    acc=0;
    for (int i=1;i<=n;i++){
        acc++;
    }
    printf("%d\n",(n*(n-1))/2);
    
    acc =0;
    for(int i =0;i<n;i++){
        acc += i;
    }
    printf ("\n%d\n",acc);
    return 0;
}