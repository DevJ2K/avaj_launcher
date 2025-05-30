from pathlib import Path
import os
from subprocess import run, PIPE

os.chdir(Path(__file__).parent.parent)
def test_invalid_scenario():
    invalid_files = list(Path("files/invalid").glob("*"))
    for file in invalid_files:
        scenario = file.name
        result = run(
            ["make", "run", f"SCENARIO={file}", f"TERMINAL_OUT=true"],
            stdout=PIPE,
            stderr=PIPE,
            text=True
        )
        # print(f"Testing scenario: {scenario}")
        # print(f"Output: {result.stdout}")
        assert "Parsing Error" in result.stdout, f"Expected parsing error for '{scenario}', but got output: {result.stdout}"

def test_valid_scenario():
    valid_files = list(Path("files/valid").glob("*"))
    for file in valid_files:
        scenario = file.name
        result = run(
            ["make", "run", f"SCENARIO={file}", f"TERMINAL_OUT=true"],
            stdout=PIPE,
            stderr=PIPE,
            text=True
        )
        assert "Parsing Error" not in result.stdout, f"Expected no parsing error for '{scenario}', but got output: {result.stdout}"

if __name__ == "__main__":
    test_invalid_scenario()
    test_valid_scenario()
    print("Test completed.")