import ShamirDecode
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


install('ShamirDecoder')


# Input Prime, Number of Shares, Shares
prime = int(input("Enter Prime: "))
number_shares = int(input("Enter Number of Shares: "))
shares = []
print("\nFormat shares: (x, y)")
for i in range(number_shares):
    share = input(f"Enter share #{i+1}: ")
    share = share.split(",")
    share = [int(i) for i in share]
    shares.append(share)

result = ShamirDecode.ShamirDecoder(shares, prime).decode()

print(f"Secret: {result}")
