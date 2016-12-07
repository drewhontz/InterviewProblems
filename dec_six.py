import unittest
import Queue
import cProfile


def chapter_four_problem_seven(projects, dependencies):
    if not projects:
        return "Error"
    if check_for_circular_dependency(dependencies):
        return "No build case"
    build_order = []
    while len(projects) != len(build_order):
        for p in projects:
            if p not in build_order:
                if can_build(p, dependencies):
                    build(p, projects, dependencies, build_order)
    return build_order


class Node():

    def __init__(self, data, left, right):
        self.data = data
        self.left = left
        self.right = right


def chapter_four_problem_three(node):
    if node == None:
        return
    q = Queue.Queue()
    ret = []
    level = 0
    q.put(node)
    while not q.empty():

        cur = q.get()
        ret.append((cur.data, level))
        if cur.left:
            q.put(cur.left)
        if cur.right:
            q.put(cur.right)

    return ret


def inorder_traversal(node):
    ret = []

    if node.left:
        yield inorder_traversal(node.left)
    yield (node.data)
    if node.right:
        yield inorder_traversal(node.right)


def chapter_four_problem_nine():
    pass


def chapter_eleven_problem_three():
    pass


def check_for_circular_dependency(dependencies):
    for p in dependencies:
        if (p[1], p[0]) in dependencies:
            return True
        if (p[0], p[0]) in dependencies:
            return True
    return False


def can_build(project, dependencies):
    for p in dependencies:
        if p[0] == project:
            return False
    return True


def build(project, projects, dependencies, order):
    """Adds project to order, removes from to-be-built list, removes dependencies"""
    order.append(project)
    dependencies[:] = [x for x in dependencies if x[1] != project]
