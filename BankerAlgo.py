class BankerAlgorithm:
    def __init__(self, processes, available, max_resources, allocated):
        self.processes = processes
        self.available = available
        self.max_resources = max_resources
        self.alloc = alloc
        self.need = [[max_resources[i][j] - alloc[i][j] for j in range(len(max_resources[0]))] for i in range(len(processes))]
        self.safe_sequence = []

    def is_safe_state(self, work, finish):
        while len(self.safe_sequence) < len(self.processes):
            for i in range(len(self.processes)):
                if not finish[i]:
                    if all(need <= work[j] for j, need in enumerate(self.need[i])):
                        work = [work[j] + self.alloc[i][j] for j in range(len(work))]
                        self.safe_sequence.append(self.processes[i])
                        finish[i] = True
        return len(self.safe_sequence) == len(self.processes)

    def execute_algorithm(self):
        work = self.available[:]
        finish = [False] * len(self.processes)
        if self.is_safe_state(work, finish):
            print("System is in a safe state. Safe sequence:", self.safe_sequence)
        else:
            print("System is in an unsafe state")

processes = [0, 1, 2, 3, 4]
available = [3, 3, 2]
max_resources = [[7, 5, 3], [3, 2, 2], [9, 0, 2], [2, 2, 2], [4, 3, 3]]
alloc = [[0, 1, 0], [2, 0, 0], [3, 0, 2], [2, 1, 1], [0, 0, 2]]

banker = BankerAlgorithm(processes, available, max_resources, alloc)
banker.execute_algorithm()
