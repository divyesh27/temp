class Players:
    def __init__(self, name: str, score: int):
        if not name or score is None:
            raise ValueError("Invalid input: Name and score must be provided")
        self.name = name
        self.score = score
        self.minscore = score
        self.maxscore = score

    def get_name(self) -> str:
        return self.name

    def get_score(self) -> int:
        return self.score

    def set_score(self, name: str, score: int):
        if not name or score is None:
            raise ValueError("Invalid input: Name and score must be provided")
        self.name = name
        self.score = score
        self.set_score_value(score)

    def set_name(self, name: str):
        if not name:
            raise ValueError("Invalid input: Name must be provided")
        self.name = name

    def get_minscore(self) -> int:
        return self.minscore

    def set_minscore(self, minscore: int):
        self.minscore = minscore

    def get_maxscore(self) -> int:
        return self.maxscore

    def set_maxscore(self, maxscore: int):
        self.maxscore = maxscore

    def set_score_value(self, score: int):
        if score < self.get_minscore():
            self.set_minscore(score)
        if score > self.get_maxscore():
            self.set_maxscore(score)

    def print_high_to_low(self):
        pass

    def print_low_to_high(self):
        pass


def main():
    hm = {}
    pl = Players("Divyesh", 5)
    p2 = Players("Jinal", 15)

    if "Divyesh" not in hm:
        hm["Divyesh"] = pl
    if "Jinal" not in hm:
        hm["Jinal"] = p2

    print(hm["Divyesh"].get_score())
    print(hm["Divyesh"].get_maxscore())
    print(hm["Divyesh"].get_minscore())
    print(hm["Jinal"].get_score())
    print(hm["Jinal"].get_maxscore())
    print(hm["Jinal"].get_minscore())


if __name__ == "__main__":
    main()
