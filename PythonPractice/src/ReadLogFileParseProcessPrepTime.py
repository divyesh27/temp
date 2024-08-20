import os
from collections import defaultdict
from typing import List, Dict

class LogFileData:
    def __init__(self):
        self.prep_times = []
        self.process_times = []

    def add_data(self, prep_time: int, process_time: int):
        self.prep_times.append(prep_time)
        self.process_times.append(process_time)

    def get_avg_prep_time(self) -> float:
        return sum(self.prep_times) / len(self.prep_times) if self.prep_times else 0.0

    def get_avg_process_time(self) -> float:
        return sum(self.process_times) / len(self.process_times) if self.process_times else 0.0

def parser(input_string: str) -> Dict[str, LogFileData]:
    if not input_string:
        raise ValueError("Input string is empty or None")

    customer_data = defaultdict(LogFileData)

    lines = input_string.strip().split('\n')
    for line in lines:
        parts = line.split(',')
        if len(parts) < 6:
            continue

        _, _, customer_id, _, prep_time, process_time = map(str.strip, parts)

        try:
            prep_time = int(prep_time)
            process_time = int(process_time)
        except ValueError:
            continue  # Skip lines with invalid integer values

        customer_data[customer_id].add_data(prep_time, process_time)

    return customer_data

def print_aggregate(customer_data: Dict[str, LogFileData]):
    for customer_id, data in customer_data.items():
        records_count = len(data.prep_times)
        avg_prep_time = data.get_avg_prep_time()
        avg_process_time = data.get_avg_process_time()

        print(f"{customer_id}: {records_count} records, {avg_prep_time:.1f} avg_time_prepared_ms, {avg_process_time:.1f} avg_time_processed_ms")

def main():
    input_string = ("12342334534, rid-1234-3434, cid-x123, 1245, 203, 530\n"
                    "12342334535, rid-1234-2345, cid-y34, 2345, 21, 45\n"
                    "12342334534, rid-1234-3434, cid-x123, 1245, 208, 630\n"
                    "12342334535, rid-1234-2345, cid-y34, 2345, 22, 65\n")

    customer_data = parser(input_string)
    print_aggregate(customer_data)

if __name__ == "__main__":
    main()
