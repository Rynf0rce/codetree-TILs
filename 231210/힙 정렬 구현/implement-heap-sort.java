import java.util.*;

public class Main {
    public static final int INPUT_RANGE = 100000;
    public static int[] arr = new int[INPUT_RANGE];
    public static void heapify(int range, int idx){
      int parent = idx;
      int leftChild = idx*2 + 1; // left child node
      int rightChild = idx*2 + 2; // right child node

      // if(range == 3){
      //   System.out.println("chack : " + parent + " " + leftChild + " " + right);
      // }

      if(range >= leftChild && arr[parent] < arr[leftChild]){
        parent = leftChild;
      }

      if(range >= rightChild && arr[parent] < arr[rightChild]){
        parent = rightChild;
      }

      if(parent != idx){
        int temp = arr[idx];
        arr[idx] = arr[parent];
        arr[parent] = temp;
        heapify(range, parent);
      }
    }

    public static void heapSort(int range){
      // max heap을 만들어주기 위해서.
      for(int i = range / 2 ; i >= 0 ; i--){
        heapify(range, i);
      }

      for(int i = range ; i > 0 ; i--){
        int temp = arr[i];
        arr[i] = arr[0];
        arr[0] = temp;
        heapify(i - 1, 0); // 현재 바꾸어준 부분을 제외한 범위를 제시 그래서 i - 1로 정의 (이전에는 range - 1 로 정의)
      }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 0 ; i < n ; i++){
            arr[i] = sc.nextInt();
        }

        heapSort(n - 1);

        for(int i = 0 ; i < n ; i++){
            System.out.print(arr[i] + " ");
        }
    }
}

/*
function heapify(arr[], n, i)
  set largest = i                     // 최대 노드가 i번이라고 가정합니다.
  set l = i * 2                       // 왼쪽 자식 노드 번호입니다.
  set r = i * 2 + 1                   // 오른쪽 자식 노드 번호입니다.

  if l <= n && arr[l] > arr[largest]  // 왼쪽 자식이 크다면, 최대 번호를 수정합니다.
    largest = l

  if r <= n && arr[r] > arr[largest] // 오른쪽 자식이 크다면, 최대 번호를 수정합니다.
    largest = r

  if largest != i                   // 최대 노드가 자식 노드라면
    swap(arr[i], arr[largest])      // 해당 자식과 현재 노드를 교환해준 뒤
    heapify(arr, n, largest)        // 내려간 위치에서 다시 heapify를 진행합니다.


function heap_sort(arr[], n)
  // 1. max-heap을 만들어 줍니다.
  for i = n / 2 ... i >= 1         // n / 2번째 원소부터 1번째 원소까지 돌며
    heapify(arr, n, i)             // heapify 과정을 진행하여 max-heap을 만들어줍니다.

  // 2. 정렬을 진행합니다.
  for i = n ... i > 1              // n을 하나씩 줄여나가며
    swap(arr[1], arr[i])           // 현재 최댓값과 가장 끝에 있는 노드를 교환해주고
    heapify(arr, i - 1, 1)         // 1번 노드를 기준으로 heapify를 진행하여
                                   // max-heap 상태를 계속 유지해줍니다. 

*/