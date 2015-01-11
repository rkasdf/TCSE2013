__author__ = 'inferno'
class LRUCache:
    def __init__(self, capacity):
        self.capacity = capacity
        self.seq = 0
        self.cached = {}
        self.lru = {}

    def get(self, key):
        if key in self.cached:
            self.lru[key] = self.seq
            self.seq += 1
            return self.cached[key]
        return -1

    def set(self, key, value):
        if len(self.cached) >= self.capacity and key not in self.cached:
            old_key = min(self.lru.keys(), key=lambda k:self.lru[k])
            self.cached.pop(old_key)
            self.lru.pop(old_key)
        self.cached[key] = value
        self.lru[key] = self.seq
        self.seq += 1