#  Find the Index of the First Occurrence in a String

class FindSubStrFromGivenString:
    def strStr(haystack: str, needle: str) -> int:
        if haystack is None or needle is None:
            raise ValueError ("Pass valid input")
        # if len(needle) > len(haystack):
        #     raise ValueError("Pass valid input")

        return haystack.find(needle)


if __name__ == "__main__":
    print(FindSubStrFromGivenString.strStr("sadbutsad", "sad"))
    print(FindSubStrFromGivenString.strStr("leetcode", "leeto"))
    print(FindSubStrFromGivenString.strStr("sadbutsad", "but"))
