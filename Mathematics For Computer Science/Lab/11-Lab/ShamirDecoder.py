# Shamir Decoder
# Author: 65050437

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
for i in range(_NUMBER_SHARES):
    print(f"--- Enter share #{i + 1} ---")
    _SHARES.append((Validation("Enter x: ", 1, _NUMBER_SHARES),
                   Validation("Enter y: ", 1, _PRIME - 1)))


# Lagrange interpolation (Lagrange basis polynomial)
def _lagrange_interpolate(x, x_s, y_s, prime):
    k = len(x_s)
    assert k == len(set(x_s)), "points must be distinct"

    def _prod_except(i, x_s, x):
        p = 1
        for j in range(k):
            if i != j:
                p *= (x - x_s[j]) / (x_s[i] - x_s[j])
        return p
    f_x = 0
    for i in range(k):
        f_x += y_s[i] * _prod_except(i, x_s, x)
    return f_x % prime


# Reconstruct secret
def Reconstruct_secret(shares, prime=_PRIME):
    x_s, y_s = zip(*shares)
    return _lagrange_interpolate(0, x_s, y_s, prime)


# Print secret
_SECRET = Reconstruct_secret(_SHARES)
print(f"Secret: {_SECRET}")

# Calculate polynomial
_POLYNOMIAL = []
for i in range(_THRESHOLD):
    _POLYNOMIAL.append(_lagrange_interpolate(
        i + 1, _SHARES[0], _SHARES[1], _PRIME))

# Print polynomial
print(f"Polynomial: {_POLYNOMIAL}")
