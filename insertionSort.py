def insertionSort(list):
	for i in range(1, len(list)):
		cur = list[i]
		prev = i - 1

		while list[prev] > cur and prev >= 0:
			list[prev + 1] = list[prev]
			prev = prev - 1
		list[prev + 1] = cur

list = [14,17,13,15,19,10,3,16,9,12]
insertionSort(list)
print(list)