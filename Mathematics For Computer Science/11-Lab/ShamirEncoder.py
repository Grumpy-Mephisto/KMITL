# Shamir Encoder
# Author: 65050437
# Before submit you delete this line 1, 2, 6, and 64-82

import os
import random
import functools


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


# Random integer
_RINT = functools.partial(random.SystemRandom().randint, 0)

# Input prime number
_PRIME = Validation("Enter a prime number: ", 1000, 2000)

# Input secret
_SECRET = Validation("Enter secret: ", 0, _PRIME - 1)

# Input number of shares
_NUMBER_SHARES = Validation("Enter number of shares: ", 1, 100)

# Input threshold (number of shares needed to reconstruct secret)
_THRESHOLD = Validation("Enter threshold: ", 1, _NUMBER_SHARES)


# Random polynomial
def _eval_at(poly, x, prime):
    accumulate = 0
    for i in reversed(poly):
        accumulate *= x
        accumulate += i
        accumulate %= prime
    return accumulate


# Generate a random sharing
def Make_random_shares(secret, min, number_shares, prime=_PRIME):
    if(min > number_shares):
        raise ValueError("Pool secret would be irrecoverable.")
    poly = [secret]+[_RINT(prime-1)for i in range(min-1)]
    shares = [(i, _eval_at(poly, i, prime)) for i in range(1, number_shares+1)]
    return shares, poly


_SHARES, _POLYNOMIAL = Make_random_shares(_SECRET, _THRESHOLD, _NUMBER_SHARES)

print("Shares:", _SHARES)
print("Polynomial:", _POLYNOMIAL)


#############################################################################
# You must be delete this
# Check folder exists
if not os.path.exists("Copy-here"):
    os.makedirs("Copy-here")

# Create ./Shamir-Secret-Sharing/EncoderOutput.txt file
with open("Copy-here/Encoder.txt", "w") as f:
    f.write('** Copy here, create and paste in the EncoderOutput.txt **\n')
    f.write("Input:\n")
    f.write(f"\tEnter a prime number: {_PRIME}\n")
    f.write(f"\tEnter secret: {_SECRET}\n")
    f.write(f"\tEnter number of shares: {_NUMBER_SHARES}\n")
    f.write(f"\tEnter threshold: {_THRESHOLD}\n")
    f.write("\nOutput:\n")
    f.write(f"\tShares: {_SHARES}\n")
    f.write(f"\tPolynomial: {_POLYNOMIAL}\n")
    f.write("\n---------------------------------------------------------------------------------\n")
    f.close()
