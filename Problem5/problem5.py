# This problem was asked by Jane Street.

# cons(a, b) constructs a pair, and car(pair) and cdr(pair)
# returns the first and last element of that pair.
# For example, car(cons(3, 4)) returns 3, and cdr(cons(3, 4)) returns 4.

def cons(a, b):
    def pair(f):
        return f(a, b)
    return pair

def car(pair): return pair(lambda a, b: a)

def cdr(pair): return pair(lambda a, b: b)

pair = cons(2 , 5)
print pair
print car(pair)
print cdr(pair)

