/**
 * @author Ming
 * @date 2023/6/18 8:16
 */
public class MergeSort {

    /**
     * @param arr array to be sorted
     * @param start start index of the left half
     * @param mid end index of the left half
     * @param end end index of the right half
     */
    public static void merge(int[] arr, int start, int mid, int end){
        int[] temp = new int[end - start + 1];
        int i = start;
        int j = mid+1;
        int k = 0;

        while(i <= mid && j <= end){
            if(arr[i] <= arr[j]){
                temp[k] = arr[i];
                k++;
                i++;
            }else{
                temp[k] = arr[j];
                k++;
                j++;
            }
        }

        while(i <= mid){
            temp[k] = arr[i];
            k++;
            i++;
        }

        while(j <= end){
            temp[k] = arr[j];
            k++;
            j++;
        }

        for(i = 0; i < k; i++){
            arr[start + i] = temp[i];
        }
    }

    /**
     * @param arr array to be sorted
     * @param start start index
     * @param end end index
     */
    public static void mergeUp2Down(int[] arr, int start, int end){
        if(arr == null || start >= end){
            return;
        }

        int mid = (end - start)/2 + start;
        mergeUp2Down(arr, start, mid);
        mergeUp2Down(arr, mid + 1, end);

        merge(arr, start, mid, end);
    }

    /**
     * @param arr array to be sorted
     */
    public static void mergeDown2Up(int[] arr){
        if(arr == null){
            return;
        }

        int len = arr.length;

        for(int n = 1; n < len; n *= 2){
            int i;
            for(i = 0; i + 2*n-1 < len; i += 2*n){
                merge(arr,i,i+n-1,i+2*n-1);
            }

            if(i+n-1< len -1){
                merge(arr,i,i+n-1, len -1);
            }
        }
    }

    public static void main(String[] args) {
        int[] arr1 = new int[]{28,11,78,45};
        mergeDown2Up(arr1);
        for(int i: arr1){
            System.out.println(i);
        }

    }
}
