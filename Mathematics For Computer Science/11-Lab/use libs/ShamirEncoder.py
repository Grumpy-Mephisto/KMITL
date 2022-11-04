import ShamirEncode
import subprocess
import sys
import os


# Install the package
def install(name):
    try:
        subprocess.check_call([sys.executable, "-m", "pip", "install", name])
        os.system('cls')
    except:
        print("Error installing package")


install('ShamirEncoder')


# Input Prime, Secret, Number of Shares, Threshold
prime = input("Enter Prime: ")
secret = input("Enter Secret: ")
number_shares = input("Enter Number of Shares: ")
threshold = input("Enter Threshold: ")

result = ShamirEncode.ShamirEncoder(int(prime), int(secret), int(
    number_shares), int(threshold)).encode()

for i in result:
    if i == 0:
        print(f"Shares: {i}")
    else:
        print(f"Polynomial: {i}")
