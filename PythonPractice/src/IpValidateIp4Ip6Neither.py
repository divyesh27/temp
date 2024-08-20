from typing import List

def validate_ip(ip_list: List[str]) -> List[str]:
    result = []
    for ip in ip_list:
        if is_valid_ipv4(ip):
            result.append("IPV4")
        elif is_valid_ipv6(ip):
            result.append("IPV6")
        else:
            result.append("Neither")
    return result

def is_valid_ipv4(ip: str) -> bool:
    if len(ip) < 7 or ip[0] == '.' or ip[-1] == '.':
        return False
    tokens = ip.split('.')
    if len(tokens) != 4:
        return False
    return all(is_valid_ipv4_token(token) for token in tokens)

def is_valid_ipv4_token(token: str) -> bool:
    if token.startswith('0') and len(token) > 1:
        return False
    try:
        num = int(token)
        if num < 0 or num > 255:
            return False
        if num == 0 and token[0] != '0':
            return False
    except ValueError:
        return False
    return True

def is_valid_ipv6(ip: str) -> bool:
    if len(ip) < 15 or ip[0] == ':' or ip[-1] == ':':
        return False
    tokens = ip.split(':')
    if len(tokens) != 8:
        return False
    return all(is_valid_ipv6_token(token) for token in tokens)

def is_valid_ipv6_token(token: str) -> bool:
    if len(token) > 4 or len(token) == 0:
        return False
    return all(c.isdigit() or c.isalpha() for c in token)

if __name__ == "__main__":
    addr = [
        "172.16.254.1",
        "2001:0db8:85a3:0:0:8A2E:0370:7334",
        "101:0db8:defa:0:0:92cF:0370:7334",
        "256.256.256.256",
        "0.42.42.42",
        "254.254.254.254",
        "192.168.0.0",
        "10.255.255.255",
        "0.0.0.0",
        "0.0.0.01"
    ]

    results = validate_ip(addr)
    for result in results:
        print(result)
