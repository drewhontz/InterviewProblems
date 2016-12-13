import traceback


def PowerSet(set):
    all_subsets = []
    if (len(set) == 0):
        all_subsets.append([])
        return all_subsets
    item = set[0]
    rest = set[1:]
    for s in PowerSet(rest):
        print (PowerSet(rest))
        temp = []
        temp.append(item)
        temp.extend(s)
        all_subsets.append(temp)
        all_subsets.append(s)
    return all_subsets


print(PowerSet(['a', 'b', 'c', 'd', 'e']))
