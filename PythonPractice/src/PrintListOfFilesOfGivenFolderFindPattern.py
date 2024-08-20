import subprocess

class PrintListOfFilesOfGivenFolderFindPattern:

    def main(self):
        try:
            # Execute the grep command to search for the pattern "sum" recursively in the current directory
            process = subprocess.Popen(['grep', '-rnw', './', '-e', 'sum'], stdout=subprocess.PIPE, stderr=subprocess.PIPE)
            count = 0

            # Reading the output line by line
            with process.stdout:
                for line in iter(process.stdout.readline, b''):
                    # Decode the output from bytes to string
                    decoded_line = line.decode('utf-8').strip()
                    print(f"count{count}\tline\t{decoded_line}")
                    count += 1

            # Wait for the process to complete
            process.wait()
            print(f"exit: {process.returncode}")

        except subprocess.CalledProcessError as e:
            print(f"An error occurred: {e}")

        except Exception as e:
            print(f"An unexpected error occurred: {e}")

    def close(self):
        pass  # Method for compatibility with the original structure

if __name__ == "__main__":
    app = PrintListOfFilesOfGivenFolderFindPattern()
    app.main()
