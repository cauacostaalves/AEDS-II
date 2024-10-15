#include <stdio.h>

int merge_and_count(int arr[], int temp[], int left, int mid, int right) {
    int i = left; 
    int j = mid;  
    int k = left; 
    int inv_count = 0; 

    while (i <= mid - 1 && j <= right) {
        if (arr[i] <= arr[j]) {
            temp[k++] = arr[i++];
        } else {
            temp[k++] = arr[j++];
            inv_count += (mid - i);
        }
    }

    while (i <= mid - 1) {
        temp[k++] = arr[i++];
    }

    while (j <= right) {
        temp[k++] = arr[j++];
    }

    for (i = left; i <= right; i++) {
        arr[i] = temp[i];
    }

    return inv_count;
}

int merge_sort_and_count(int arr[], int temp[], int left, int right) {
    int mid, inv_count = 0;
    if (right > left) {
        mid = (right + left) / 2;

        inv_count += merge_sort_and_count(arr, temp, left, mid);
        inv_count += merge_sort_and_count(arr, temp, mid + 1, right);
        inv_count += merge_and_count(arr, temp, left, mid + 1, right);
    }
    return inv_count;
}

int main() {
    int N;
    while (scanf("%d", &N) == 1) {
        int competidores[N], ordemchegada[N], temp[N];
        
        for (int i = 0; i < N; i++) {
            scanf("%d", &competidores[i]);
        }
    
        for (int i = 0; i < N; i++) {
            scanf("%d", &ordemchegada[i]);
        }

        int mapped[N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (ordemchegada[i] == competidores[j]) {
                    mapped[i] = j;
                    break;
                }
            }
        }

        int inversoes = merge_sort_and_count(mapped, temp, 0, N - 1);
        printf("%d\n", inversoes);
    }

    return 0;
}
