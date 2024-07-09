from copy import deepcopy
import random
from timeit import default_timer as timer
import argparse
from typing import List


def time(func):
    def wrapper(*args, **kwargs):
        start_time = timer()
        result = func(*args, **kwargs)
        end_time = timer()
        execution_time = end_time - start_time
        print(f"[INFO] {func.__name__} Running Time: {execution_time:.3f} seconds")
        return result

    return wrapper


@time
def bubble_sort(arr):
    array = deepcopy(arr)
    for i in range(len(array)):
        for j in range(0, len(array) - i - 1):
            if array[j] > array[j + 1]:
                array[j], array[j + 1] = array[j + 1], array[j]

    return array


@time
def selection_sort(arr):
    array = deepcopy(arr)
    for i in range(len(array) - 1):
        min_index = i
        for j in range(i + 1, len(array)):
            if array[min_index] > array[j]:
                min_index = j
        array[min_index], array[i] = array[i], array[min_index]
    return array


@time
def insertion_sort(arr):
    array = deepcopy(arr)
    for i in range(len(array) - 1):
        for j in range(i + 1, 0, -1):
            if array[j - 1] > array[j]:
                array[j - 1], array[j] = array[j], array[j - 1]
            else:
                break
    return array


@time
def shell_sort_stupid(arr):
    array = deepcopy(arr)
    gap = int(len(array) / 2)

    # 针对每个不为0的gap，分组排序
    while gap > 0:
        for start in range(0, gap):
            for i in range(start, len(array) - gap, gap):
                for j in range(i + gap, start, -gap):
                    if array[j - gap] > array[j]:
                        array[j - gap], array[j] = array[j], array[j - gap]
                    else:
                        break
        gap = int(gap / 2)
    return array


@time
def shell_sort_clever(arr):
    array = deepcopy(arr)
    gap = int(len(array) / 2)

    while gap > 0:
        for i in range(0, len(array) - gap):
            for j in range(i + gap, 0, -gap):
                if array[j - gap] > array[j]:
                    array[j - gap], array[j] = array[j], array[j - gap]
                else:
                    break
        gap = int(gap / 2)
    return array


@time
def merge_sort(arr):
    def sort(
        array: List,
        low: int,
        high: int,
    ):
        if low > high:
            return
        mid = low + (high - low) // 2
        if not low == mid:
            sort(array, low, mid)
        if not mid + 1 == high:
            sort(array, mid + 1, high)

        merge(array, low, mid, high)

    def merge(array: List, low: int, mid: int, high: int):
        array1_low, array1_high = low, mid
        array2_low, array2_high = mid + 1, high

        p1 = array1_low
        p2 = array2_low
        p3 = low

        while True:
            if p1 > array1_high:
                assist[p3 : high + 1] = array[p2 : array2_high + 1]
                break
            if p2 > array2_high:
                assist[p3 : high + 1] = array[p1 : array1_high + 1]
                break

            if array[p2] < array[p1]:
                assist[p3] = array[p2]
                p2 += 1
            else:
                assist[p3] = array[p1]
                p1 += 1
            p3 += 1

        array[low : high + 1] = assist[low : high + 1]

    array = deepcopy(arr)
    assist = [0] * len(array)

    sort(array, 0, len(array) - 1)

    return array


@time
def quick_sort(arr):
    def sort(array, low: int, high: int):
        if low >= high:
            return
        partitionIndex = partition(array, low=low, high=high)
        sort(array, low, partitionIndex - 1)
        sort(array, partitionIndex + 1, high)

    def partition(array, low: int, high: int):
        pivot = array[low]
        left = low + 1
        right = high

        while True:
            if array[left] <= pivot:
                if left == high:
                    break
                left += 1
                continue

            if array[right] > pivot:
                if right == low:
                    break
                right -= 1
                continue

            if right < left:
                break

            array[left], array[right] = array[right], array[left]

        array[low], array[right] = array[right], array[low]
        return right

    array = deepcopy(arr)

    sort(array, 0, len(array) - 1)

    return array


if __name__ == "__main__":
    parser = argparse.ArgumentParser(description="Sort")
    parser.add_argument(
        "-t",
        "--timeit",
        action="store_true",
        required=False,
        default=False,
        help="是否用大样本计时",
    )
    args = parser.parse_args()

    if not args.timeit:
        arr = [8, 6, 6, 5, 4, 3, 2, 1, 0, 6]
    else:
        arr = [random.randint(0, 10000) for _ in range(0, 10000)]

    arr0 = sorted(arr)
    arr1 = bubble_sort(arr)
    arr2 = selection_sort(arr)
    arr3 = insertion_sort(arr)
    arr4 = shell_sort_stupid(arr)
    arr5 = shell_sort_clever(arr)
    arr6 = merge_sort(arr)
    arr7 = quick_sort(arr)

    if args.timeit:
        print(f"冒泡排序: {arr1 == arr0}")
        print(f"选择排序: {arr2 == arr0}")
        print(f"插入排序: {arr3 == arr0}")
        print(f"希尔排序(stupid): {arr4 == arr0}")
        print(f"希尔排序(clever): {arr5 == arr0}")
        print(f"归并排序: {arr6 == arr0}")
        print(f"快速排序: {arr7 == arr0}")
    else:
        print(f"原始序列: {arr}")
        print(f"官方排序: {arr0}")
        print(f"冒泡排序: {arr1}")
        print(f"选择排序: {arr2}")
        print(f"插入排序: {arr3}")
        print(f"希尔排序(stupid): {arr4}")
        print(f"希尔排序(clever): {arr5}")
        print(f"归并排序: {arr6}")
        print(f"快速排序: {arr7}")
