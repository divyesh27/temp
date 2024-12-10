from collections import defaultdict
import re

def generate_report(filename):
    # Regex pattern to extract timestamp (up to minute) and status code
    pattern = re.compile(r"\d{4}:\d{2}:\d{2} (\d{2}:\d{2}):\d{2} .*? (\d{3}) .*")

    # Variables to keep track of the current minute and status counts
    current_minute = None
    status_counts = defaultdict(int)

    # Read the log file line by line
    with open(filename, 'r') as file:
        for line in file:
            match = pattern.match(line)
            if match:
                minute = match.group(1)  # Extract HH:MM
                status_code = match.group(2)  # Extract status code

                # If we're still processing the same minute, accumulate counts
                if current_minute == minute:
                    status_counts[status_code] += 1
                else:
                    # If the minute changes, print the report for the previous minute
                    if current_minute is not None:
                        print_minute_report(current_minute, status_counts)

                    # Reset for the new minute
                    current_minute = minute
                    status_counts.clear()
                    status_counts[status_code] = 1

        # Print the last minute's data after reading the entire file
        if current_minute is not None:
            print_minute_report(current_minute, status_counts)

def print_minute_report(minute, status_counts):
    """Print the report for a given minute."""
    for status_code, count in status_counts.items():
        print(f"{minute} {status_code} {count}")

# Example usage
generate_report('logfile.txt')
