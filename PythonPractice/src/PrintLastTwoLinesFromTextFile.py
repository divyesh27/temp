import os

def print_last_lines(filename, line_count):
    if not filename or line_count <= 0:
        raise ValueError("Invalid filename or line count.")

    if not os.path.exists(filename):
        raise FileNotFoundError(f"The file '{filename}' does not exist.")

    try:
        with open(filename, 'rb') as file:
            file.seek(0, os.SEEK_END)
            pointer = file.tell() - 1
            count = 0
            sb = []

            while pointer >= 0:
                file.seek(pointer)
                c = file.read(1).decode('utf-8')

                if c == '\n':
                    count += 1
                    if count == line_count + 1:
                        break

                sb.append(c)
                pointer -= 1

            print(''.join(sb[::-1]))

    except IOError as e:
        print(f"An I/O error occurred: {e}")

if __name__ == "__main__":
    print_last_lines("//Users/divyesh.shah/Documents/workspace/JavaPractice/input.txt", 2)
