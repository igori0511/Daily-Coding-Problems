#This problem was asked by Twitter.

#You run an e-commerce website and want to record the last N order ids in a log.
#Implement a data structure to accomplish this, with the following API:

#record(order_id): adds the order_id to the log
#get_last(i): gets the ith last element from the log.

#i is guaranteed to be smaller than or equal to N.
#You should be as efficient with time and space as possible.

# CircularBuffer
class LogStore(object):
    def __init__(self, n):
        self.n = n
        self._log = []
        self._current_last = 0

    def record(self, order_id):
        if len(self._log) == self.n:
            self._log[self._current_last] = order_id
        else:
            self._log.append(order_id)
        self._current_last = (self._current_last + 1) % self.n

    def get_last(self, i):
        return self._log[self._current_last - i]

log_store = LogStore(3)
log_store.record(15)
log_store.record(16)
log_store.record(4)
i = 3
print log_store.get_last(i)
