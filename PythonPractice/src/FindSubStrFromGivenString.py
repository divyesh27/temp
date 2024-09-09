#  Find the Index of the First Occurrence in a String

class FindSubStrFromGivenString:
    def strStr(self, haystack: str, needle: str) -> int:
        if haystack is None or needle is None:
            raise ValueError ("Pass valid input")

        return haystack.find(needle)


if __name__ == "__main__":
    fs = FindSubStrFromGivenString()
    print(fs.strStr("sadbutsad", "sad"))
    print(fs.strStr("leetcode", "leeto"))
    print(fs.strStr("sadbutsad", "but"))
