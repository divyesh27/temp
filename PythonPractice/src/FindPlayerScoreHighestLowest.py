class Players:
    def __init__(self, name: str, score: int):
        if not name or score is None:
            raise ValueError("Invalid input: Name and score must be provided")
        self.name = name
        self.minscore = score
        self.maxscore = score

    def get_name(self) -> str:
        return self.name

    def get_minscore(self) -> int:
        return self.minscore

    def set_minscore(self, minscore: int):
        self.minscore = minscore

    def get_maxscore(self) -> int:
        return self.maxscore

    def set_maxscore(self, maxscore: int):
        self.maxscore = maxscore

    def set_score(self, name: str, score: int):
        if not name or score is None:
            raise ValueError("Invalid input: Name and score must be provided")
        self.name = name
        if score < self.get_minscore():
            self.set_minscore(score)
        if score > self.get_maxscore():
            self.set_maxscore(score)

def main():
    hm = {}
    pl = Players("Divyesh", 5)

    if "Divyesh" not in hm:
        hm["Divyesh"] = pl

    print(hm["Divyesh"].get_maxscore())  # Get max score of player "Divyesh"
    print(hm["Divyesh"].get_minscore())  # Get min score of player "Divyesh"

if __name__ == "__main__":
    main()
