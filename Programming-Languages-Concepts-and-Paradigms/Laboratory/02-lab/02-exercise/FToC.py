def main():
    f = float(input("Enter temperature in Fahrenheit: "))
    c = (f - 32) * 5.0/9.0
    print(f"{f} Fahrenheit = {c} Celsius")

main()