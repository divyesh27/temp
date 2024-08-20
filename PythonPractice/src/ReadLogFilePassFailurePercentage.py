import os

def print_pass_logging_information(input_file_name_with_path):
    if not input_file_name_with_path or not os.path.isfile(input_file_name_with_path):
        raise ValueError("Pass a valid file path")

    total_counter = 0
    total_pass = 0
    pass_result = []
    fail_result = []

    try:
        with open(input_file_name_with_path, 'r') as file:
            for line in file:
                wordsplit = line.strip().split("::")
                if len(wordsplit) < 4:
                    continue

                date_time, jobname, status, *message = wordsplit
                message = message[0] if message else ""

                if status == "PASS":
                    if message:
                        pass_result.append(f"{date_time},{jobname},{message}")
                    else:
                        pass_result.append(f"{date_time},{jobname}")
                    total_pass += 1
                else:
                    if message:
                        fail_result.append(f"{date_time},{jobname},{message}")
                    else:
                        fail_result.append(f"{date_time},{jobname}")
                total_counter += 1

        pass_result.sort(key=lambda x: x.split(',')[0])
        fail_result.sort(key=lambda x: x.split(',')[0])

        if total_counter > 0:
            print(f"PASS {total_pass / total_counter * 100:.2f}%")
            for result in pass_result:
                print(result)

            print(f"FAIL {(total_counter - total_pass) / total_counter * 100:.2f}%")
            for result in fail_result:
                print(result)
        else:
            print("No entries to process")

    except FileNotFoundError:
        print("File not found")
    except IOError:
        print("Error reading file")
    except Exception as e:
        print(f"An error occurred: {e}")

def main():
    # Example usage
    input_file_name_with_path = "//Users/divyesh.shah/Documents/workspace/JavaPractice/inputFileName.txt"
    print_pass_logging_information(input_file_name_with_path)

if __name__ == "__main__":
    main()
