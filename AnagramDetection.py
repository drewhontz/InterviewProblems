def question1(s, t):
    '''Returns boolean value if an anagram of t is/is not present in s'''
    # If string t is longer than s, return false.
    # If s or t have length 0, return false
    if len(t) > len(s) or len(s) == 0 or len(t) == 0:
        return False
    # Sort string t
    t = ''.join(sorted(t))
    # Iterate through the list of substrings of length t, sort them, and
    # compare to t
    count = 0
    for i in xrange(len(s) - len(t) + 1):
        if ''.join(sorted(s[i:i + len(t)])) == t:
            count += 1
    return count
