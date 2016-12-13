
def TowersOfHanoi(n, s, d, v):
    if n >= 1:
        TowersOfHanoi(n - 1, s, v, d)
        move(s, d)
        TowersOfHanoi(n - 1, v, d, s)


def move(s, d):
    print "Moving {} to {}".format(s.pop(0), d)


s = [x for x in range(1, 9)]
print s
d = []
v = []
TowersOfHanoi(5, s, d, v)
