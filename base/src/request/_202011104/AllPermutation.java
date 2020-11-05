package request._202011104;

/**
 * AllPermutation
 * 全排列
 * @author: cyx_jay
 * @date: 2020/11/4 15:04
 */
public class AllPermutation {


    public void allPermutation (int i){

        if (i < 1){
            return;
        }
        //flag数值 用来存储 哪几个数值还没有被放置道数组中
        boolean[] flags = new boolean[i];
        for (int i1 = 0; i1 < i; i1++) {
            flags[i1] = true;
        }
        allPermutation(i,0,new int[i],flags);


    }

    private void allPermutation(int i, int index, int[] arr, boolean[] flags) {
        int flagIndex = -1;
        if (index < i){

            for (int j = 0; j < flags.length; j++) {
                if (flags[j]){
                    arr[index] = j+1;
                    flagIndex = j;
                    flags[j] = false;
                    if (index == i-1){
                        System.out.print("找到了一组排列:");
                        for (int i1 : arr) {
                            System.out.print(i1);
                        }
                        System.out.println();
                    }else {
                        allPermutation(i,index+1,arr,flags);
                    }

                }

                if (flagIndex != -1){
                    flags[flagIndex] = true;
                }
            }

        }


    }
}
