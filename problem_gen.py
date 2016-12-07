from random import randint


def generate_problem_list():
    chap = {1: 9, 2: 8, 3: 6, 4: 12, 5: 8, 6: 10, 7: 12, 8: 14, 9: 8,
            10: 11, 11: 6, 13: 8, 14: 7, 15: 7, 16: 26, 17: 26}
    l = []
    for k, v in chap.iteritems():
        for p in range(1, v + 1):
            l.append((k, p))
    return l


def select_x_problems(x=5, set=generate_problem_list()):
    size = len(set)
    p = []
    for n in xrange(x):
        p.append(set[randint(0, size)])
    return p

print select_x_problems()
