import requests

class HttpClientService:
    def send_get_request(self, url):
        response = requests.get(url)
        response.raise_for_status()  # Raise an HTTPError for bad responses
        return response.text

    def send_post_request(self, url, json_body):
        headers = {'Content-Type': 'application/json; utf-8', 'Accept': 'application/json'}
        response = requests.post(url, json=json_body, headers=headers)
        response.raise_for_status()  # Raise an HTTPError for bad responses
        return response.text

class ApiTest:
    def __init__(self, http_client_service):
        self.http_client_service = http_client_service
        self.url = "https://jsonplaceholder.typicode.com/posts"

    def run_tests(self):
        self.test_get_request_positive()
        self.test_get_request_negative()
        self.test_post_request_positive()
        self.test_post_request_negative()
        # Add more tests as needed

    def test_get_request_positive(self):
        url = self.url + "/1"
        response = self.http_client_service.send_get_request(url)
        assert "userId" in response, "Expected response body to contain 'userId'"
        print("GET Positive Case Passed")

    def test_get_request_negative(self):
        url = self.url + "/invalid"
        try:
            self.http_client_service.send_get_request(url)
            assert False, "Expected an exception for invalid URL"
        except requests.exceptions.RequestException:
            print("GET Negative Case Passed")

    def test_post_request_positive(self):
        url = self.url
        json_body = {"title": "foo", "body": "bar", "userId": 1}
        response = self.http_client_service.send_post_request(url, json_body)
        assert '"id"' in response, "Expected response body to contain 'id'"
        print("POST Positive Case Passed")

    def test_post_request_negative(self):
        url = self.url
        json_body = {"title": "", "body": "", "userId": -1}
        try:
            self.http_client_service.send_post_request(url, json_body)
            assert False, "Expected an exception for invalid POST data"
        except requests.exceptions.RequestException:
            print("POST Negative Case Passed")

if __name__ == "__main__":
    try:
        http_client_service = HttpClientService()
        api_test = ApiTest(http_client_service)
        api_test.run_tests()
    except Exception as e:
        print(e)
