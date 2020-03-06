package job.written.examination.sort;

import com.alibaba.fastjson.JSON;

import java.util.Arrays;
import java.util.List;

public class QuickSort {
    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        Integer[] unSortArray = {2, 1, 3};
        List unSortList = Arrays.asList(unSortArray);
        System.out.println(JSON.toJSONString(unSortArray));
        quickSort.quickSort2(unSortList, 0, unSortList.size()-1);
        System.out.println(JSON.toJSONString(unSortArray));
    }

    public <T extends Comparable<T>> void quickSort(List<T> list, Integer left, Integer right) {
        if(right - left < 1) {
            return ;
        }

        T compareValue = list.get(right);
        Integer i = left;
        Integer j = right - 1;

        while (i < j) {

            while (i < j && (list.get(i).compareTo(compareValue) < 0)) {
                i++;
            }

            while (i < j && (list.get(j).compareTo(compareValue) >= 0)) {
                j--;
            }

            if(i != j) {
                T temp = list.get(i);
                list.set(i, list.get(j));
                list.set(j, temp);
            }
        }

        //交换比较值和j
        if( i == j && list.get(i).compareTo(compareValue) > 0) {
            list.set(right, list.get(i));
            list.set(i, compareValue);
            quickSort(list, left, i-1);
            quickSort(list, i + 1, right);
        } else {
            quickSort(list, left, i);
            quickSort(list, i + 1, right);
        }
    }

    public  <T extends Comparable<T>> void quickSort2(List<T> list, Integer start, Integer end) {
        if(start > end) {
            //如果只有一个元素，就不用再排下去了
            return;
        } else {
            //如果不止一个元素，继续划分两边递归排序下去
            Integer partition = devide(list, start, end);
            quickSort2(list, start, partition-1);
            quickSort2(list, partition + 1, end);
        }
    }

    public <T extends Comparable<T>> int devide(List<T> list, Integer start, Integer end) {
        //每次都以最右边的元素作为基准值
        T base = list.get(end);

        //start一旦等于end，就说明左右两个指针合并到了同一位置，可以结束此轮循环。
        while (start < end) {
            while (start < end && list.get(start).compareTo(base) <=0) {
                //从左边开始遍历，如果比基准值小，就继续向右走
                start++;
            }

            //上面的while循环结束时，就说明当前的a[start]的值比基准值大，应与基准值进行交换
            if(start < end) {
                swap(list, start, end);
                //交换后，此时的那个被调换的值也同时调到了正确的位置(基准值右边)，因此右边也要同时向前移动一位
                end--;
            }

            while (start < end && list.get(end).compareTo(base) > 0) {
                //从右边开始遍历，如果比基准值大，就继续向左走
                end--;
            }

            //上面的while循环结束时，就说明当前的a[end]的值比基准值小，应与基准值进行交换
            if(start < end) {
                swap(list, start, end);
                //交换后，此时的那个被调换的值也同时调到了正确的位置(基准值左边)，因此左边也要同时向后移动一位
                start++;
            }
         }

        //这里返回start或者end皆可，此时的start和end都为基准值所在的位置
        return end;
    }

    public <T> void swap(List<T> list, Integer left, Integer right) {
        T temp = list.get(right);
        list.set(right, list.get(left));
        list.set(left, temp);
    }
}
