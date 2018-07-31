from threading import Thread
from threading import Timer

#This problem was asked by Apple.
#Implement a job scheduler which takes in a function f and an integer n, and calls f after n milliseconds.
def cons(a, b):
    def pair(f):
        return f(a, b)
    return pair

def car(pair):
    def inner_pair():
        print pair(lambda a, b: a)
    return inner_pair    

def print_something():
    print "mates"

def shedule(f, ms):
    ms /= 1000
    def delayed_execution(f, ms):        
        Timer(ms, f).start()
        
    job = Thread(target=delayed_execution, args=(f, ms))
    job.start()

shedule(car(cons(1,2)), 1000)
shedule(print_something, 1)   
