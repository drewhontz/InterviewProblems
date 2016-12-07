def bubbleSort(list):
	end = len(list)
	for i in range(0, end):
		for i in range(1, end - i):
			#rabbit and tortoise are 2 pointers that will be compared
			#rabbit will always be the pointer closer to end
			rabbit = i
			tortoise = i - 1
			if list[rabbit] < list[tortoise]:
				swap(list, rabbit, tortoise)

def swap(l, a, b):
	temp = l[a]
	l[a] = l[b]
	l[b] = temp

l = [4,14,82,67,81,94,7,2]
bubbleSort(l)
print(l)