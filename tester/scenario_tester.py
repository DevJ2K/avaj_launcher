from pathlib import Path
import os
from subprocess import run, PIPE

os.chdir(Path(__file__).parent.parent)
def test_invalid_scenario():
    invalid_files = list(Path("files/invalid").glob("*"))
    for file in invalid_files:
        scenario = file.name
        result = run(
            ["make", "run", f"SCENARIO={scenario}"],
            stdout=PIPE,
            stderr=PIPE,
            text=True
        )
        assert "Parsing Error" in result.stdout, f"Expected parsing error for '{scenario}', but got output: {result.stdout}"

if __name__ == "__main__":
    test_invalid_scenario()
    print("Test completed.")