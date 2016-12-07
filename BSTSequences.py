"""Given a bst w/ distinct elements, print all possible arrays that could have led to this tree.
   Ex: Input: root - 2 left - 1 right -3
       Output: {2,1,3}{2,3,1}

    CURRENT OUTPUT REACHES MAX RECURSION DEPTH LIMIT"""


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


def generate_sequences(node):
    res = []
    if not node:
        res.append([])
        return res

    prefix = []
    prefix.append(node.data)

    left_seq = generate_sequences(node.left)
    right_seq = generate_sequences(node.right)

    for l in left_seq:
        for r in right_seq:
            weaved = []
            weave(left_seq, right_seq, weaved, prefix)
            for w in weaved:
                res.append(w)
    return res


def weave(first, second, res, prefix):
    if len(first) == 0 or len(second) == 0:
        r = prefix[:]
        for f in first:
            res.append(f)
        for s in second:
            res.append(s)
        res.append(res)
        return

    head_first = first.pop(0)
    prefix.append(head_first)
    weave(first, second, res, prefix)
    prefix.pop()
    first.insert(0, head_first)

    head_second = second.pop(0)
    prefix.append(head_second)
    weave(first, second, res, prefix)
    prefix.pop()
    second.insert(0, head_second)

print generate_sequences(twelve)
