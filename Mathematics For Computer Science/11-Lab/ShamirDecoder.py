# Shamir Decoder
# Author: 65050437

# Before submit you delete this line 1, 2, 5
import os


def Validation(message, min, max):
    while True:
        try:
            _INPUT = int(input(message))
            if _INPUT < min or _INPUT > max:
                raise ValueError
            break
        except ValueError:
            print("Invalid input. Please try again.")
            _INPUT = message
    return _INPUT


# Input prime number
_PRIME = Validation("Enter a prime number: ", 1000, 2000)

# Input number of shares
_NUMBER_SHARES = Validation("Enter number of shares: ", 1, 100)

# Input threshold (number of shares needed to reconstruct secret)
_THRESHOLD = Validation("Enter threshold: ", 1, _NUMBER_SHARES)

# Input shares
_SHARES = []
print("\nFormat shares: (x, y)")
for i in range(_NUMBER_SHARES):
    _SHARE = input(f"Enter share #{i+1}: ")
    _SHARE = _SHARE.split(",")
    _SHARE = [int(i) for i in _SHARE]
    _SHARES.append(_SHARE)


def Extended_GCD(a, b):
    x = 0
    last_x = 1
    y = 1
    last_y = 0
    while b != 0:
        quot = a // b
        a, b = b, a % b
        x, last_x = last_x - quot * x, x
        y, last_y = last_y - quot * y, y
    return last_x, last_y


def DivMod(num, den, p):
    inv, _ = Extended_GCD(den, p)
    return num * inv


# Lagrange interpolation (Lagrange basis polynomial)
def Lagrange_interpolate(x, x_s, y_s, p):
    k = len(x_s)
    assert k == len(set(x_s))

    def PI(vals):
        accumulate = 1
        for v in vals:
            accumulate *= v
        return accumulate
    nums = []
    dens = []
    for i in range(k):
        others = list(x_s)
        cur = others.pop(i)
        nums.append(PI(x-o for o in others))
        dens.append(PI(cur-o for o in others))
    den = PI(dens)
    num = sum([DivMod(nums[i] * den * y_s[i] % p, dens[i], p)
              for i in range(k)])
    return (DivMod(num, den, p)+p) % p


# Reconstruct secret
def Reconstruct_secret(shares, prime=_PRIME):
    x_s, y_s = zip(*shares)
    return Lagrange_interpolate(0, x_s, y_s, prime)


# Print secret
_SECRET = Reconstruct_secret(_SHARES)
print(f"\nSecret: {_SECRET}")


#############################################################################
# You must be delete this
# Check folder exists
if not os.path.exists("Copy-here"):
    os.makedirs("Copy-here")

# Create ./Shamir-Secret-Sharing/EncoderOutput.txt file
with open("Copy-here/Decoder.txt", "w") as f:
    f.write("** Copy here, create and paste in the DecoderOutput.txt *\n")
    f.write("\nInput:\n")
    f.write(f"\tEnter a prime number: {_PRIME}\n")
    f.write(f"\tEnter number of shares: {_NUMBER_SHARES}\n")
    f.write(f"\n\tFormat shares: (x, y)\n")
    f.write(f"\tEnter threshold: {_THRESHOLD}\n")
    for i in range(_NUMBER_SHARES):
        f.write(f"\tEnter share #{i+1}: {_SHARES[i][0]}, {_SHARES[i][1]}\n")
    f.write("\nOutput:\n")
    f.write(f"\tEnter secret: {_SECRET}\n")
    f.write("\n---------------------------------------------------------------------------------\n")
    f.close()
