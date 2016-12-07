from dec_six import *
import unittest


class TestSolutions(unittest.TestCase):

    def test_chapter_four_problem_seven(self):
        p = []
        d = [('a', 'b'), ('a', 'c'), ('a', 'd'), ('b', 'a')]
        self.assertEquals(chapter_four_problem_seven(p, d), "Error")

        p = ['a', 'b', 'c', 'd']
        d = [('a', 'b'), ('a', 'c'), ('a', 'd'), ('b', 'a')]
        self.assertEquals(chapter_four_problem_seven(p, d), "No build case")

        p = ['a', 'b', 'c', 'd']
        d = [('a', 'b'), ('a', 'c'), ('a', 'd')]
        self.assertEquals(chapter_four_problem_seven(p, d),
                          ['b', 'c', 'd', 'a'])

        p = ['a', 'b', 'c', 'd', 'e', 'f']
        d = [('a', 'c'), ('b', 'c'), ('d', 'f'), ('e', 'f')]
        self.assertEquals(chapter_four_problem_seven(p, d),
                          ['c', 'f', 'a', 'b', 'd', 'e'])

    # def test_chapter_four_problem_three(self):
    #     one = Node(1, None, None)
    #     four = Node(4, None, None)
    #     seven = Node(7, None, None)
    #     ten = Node(10, None, None)
    #     twenty = Node(20, None, None)
    #     twentytwo = Node(22, None, None)
    #     three = Node(3, one, four)
    #     nine = Node(9, seven, ten)
    #     thirteen = Node(13, None, None)
    #     twentyone = Node(21, twenty, twentytwo)
    #     six = Node(6, three, nine)
    #     eighteen = Node(18, thirteen, twentyone)
    #     twelve = Node(12, six, eighteen)
    #
    #     self.assertEquals(chapter_four_problem_three(twelve), [
    #                       [12], [6, 18], [3, 9, 13, 21], [1, 4, 7, 10, 20, 22]])

    def test_inorder_traversal(self):
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
        self.assertEquals(list(inorder_traversal(twelve)), [
                          1, 3, 4, 6, 7, 9, 10, 12, 13, 18, 20, 21, 22])

if __name__ == '__main__':
    unittest.main()
