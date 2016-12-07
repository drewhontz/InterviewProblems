def chapter_four_problem_three(node, level):
    if not node:
        return
    if node.left:
        for value in chapter_four_problem_three(node.left, level + 1):
            yield value
    yield node.data, level
    if node.right:
        for value in chapter_four_problem_three(node.right, level + 1):
            yield value


class Node:

    def __init__(self, data, first, second):
        self.data = data
        self.left = first
        self.right = second

one = Node(1, None, None)
four = Node(4, None, None)
seven = Node(7, None, None)
ten = Node(10, None, None)
twenty = Node(20, None, None)
twentytwo = Node(22, None, None)
three = Node(3, one, four)
nine = Node(9, seven, ten)
thirteen = Node(13, None, None)
twentyone = Node(21, twenty, twentytwo)
six = Node(6, three, nine)
eighteen = Node(18, thirteen, twentyone)
twelve = Node(12, six, eighteen)


def convert_from_flat(list_out):
    list_out.sort(key=lambda tup: tup[1])
    ret = [[]]
    marker = list_out[0][1]
    for item in list_out:
        if item[1] == marker:
            ret[marker].append(item[0])
        else:
            marker = item[1]
            ret.append([])
            ret[marker].append(item[0])
    return ret


print convert_from_flat(list(chapter_four_problem_three(twelve, 0)))
