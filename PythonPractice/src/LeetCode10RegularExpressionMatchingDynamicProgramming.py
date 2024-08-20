from typing import Optional

def is_match(s: Optional[str], p: Optional[str]) -> bool:
    if s is None or p is None:
        return False

    m = len(s)
    n = len(p)
    dp = [[False] * (n + 1) for _ in range(m + 1)]
    dp[0][0] = True

    # Handle patterns like a*, a*b*, a*b*c* at the start
    for i in range(1, n + 1):
        if p[i - 1] == '*':
            dp[0][i] = dp[0][i - 2]

    for i in range(1, m + 1):
        for j in range(1, n + 1):
            sc = s[i - 1]
            pc = p[j - 1]
            if pc == '.' or pc == sc:
                dp[i][j] = dp[i - 1][j - 1]
            elif pc == '*':
                ppc = p[j - 2]
                if ppc == '.' or ppc == sc:
                    dp[i][j] = dp[i][j - 2] or dp[i - 1][j]
                else:
                    dp[i][j] = dp[i][j - 2]

    return dp[m][n]

# Example usage
if __name__ == "__main__":
    print(is_match("aa", "a"))   # Output: False
    print(is_match("aa", "a*"))  # Output: True
    print(is_match("aa", ".*"))  # Output: True
