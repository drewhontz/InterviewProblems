# There will always be roughly 50-50.
# There is an assumption that there will be more boys because you will try
# until there is a girl but a girl is equally as likely on the first try
from __future__ import division
from random import randint


def createFamily():
    family = []
    child = randint(0, 1)
    while (child != 1):
        family.append(child)
        child = randint(0, 1)
    family.append(child)
    return family


def runSim(number_of_families):
    new_pop = []
    while (len(new_pop) < number_of_families):
        new_pop.append(createFamily())
    return new_pop


def countPop(population):
    boyCount = 0
    girlCount = 0
    for family in population:
        for child in family:
            if child == 0:
                boyCount += 1
            else:
                girlCount += 1
    total_pop = boyCount + girlCount
    per_girl = girlCount / total_pop
    return per_girl
    # return {"Boy Percent": boyCount / total_pop * 100, "Girl Percent":
    # girlCount / total_pop * 100}


def analyze(number_of_families, number_of_sims):
    sims = [countPop(runSim(number_of_families))
            for x in xrange(number_of_sims)]
    return (sum(sims) / len(sims))


print analyze(1000, 100)
