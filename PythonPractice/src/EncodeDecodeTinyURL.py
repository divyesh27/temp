import random
import re
from typing import Optional, Dict

class EncodeDecodeTinyURL:
    _hm: Dict[str, str] = {}
    _return_url: str = "http://tinyURL.com/"

    @staticmethod
    def tiny_url_encode_decode(input_string: str) -> None:
        if not isinstance(input_string, str) or not input_string or not EncodeDecodeTinyURL._valid_url(input_string):
            raise ValueError("Pass valid input")

        key = EncodeDecodeTinyURL._get_random_value()
        short_url = EncodeDecodeTinyURL._encode_url(input_string, key)
        print(short_url)
        print(EncodeDecodeTinyURL._decode_url(short_url))

    @staticmethod
    def _encode_url(long_url: str, key: str) -> str:
        while key in EncodeDecodeTinyURL._hm:
            key = EncodeDecodeTinyURL._get_random_value()
        EncodeDecodeTinyURL._hm[key] = long_url
        return EncodeDecodeTinyURL._return_url + key

    @staticmethod
    def _decode_url(short_url: str) -> Optional[str]:
        key = short_url.replace(EncodeDecodeTinyURL._return_url, "")
        return EncodeDecodeTinyURL._hm.get(key)

    @staticmethod
    def _get_random_value() -> str:
        alphabet = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"
        return ''.join(random.choice(alphabet) for _ in range(10))

    @staticmethod
    def _valid_url(input_string: str) -> bool:
        if not isinstance(input_string, str):
            return False

        regex = r"^(https://|http://|www\.)[-a-zA-Z0-9+/%?_|:.]*[-a-zA-Z0-9](\.[a-z]{2,3})$"
        pattern = re.compile(regex)
        return bool(pattern.match(input_string))

# Example usage
try:
    EncodeDecodeTinyURL.tiny_url_encode_decode("https://www.helix.com")
    EncodeDecodeTinyURL.tiny_url_encode_decode("https://www.abcdefghijladfafacsdcas.com")
    EncodeDecodeTinyURL.tiny_url_encode_decode("www.timeofindiaahmedabadtobombay.com")
    EncodeDecodeTinyURL.tiny_url_encode_decode("www.vyavsaividhyapratishthanrajkotaliasvvp.com")
    EncodeDecodeTinyURL.tiny_url_encode_decode("https://leetcode.com/problems/design-tinyurl")
    EncodeDecodeTinyURL.tiny_url_encode_decode("www.om")
except Exception as e:
    print(f"An error occurred: {e}")
