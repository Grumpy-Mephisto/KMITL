import os
import sys
import subprocess
import StatsTestDrugPatients


# Install the package
def install(name):
    try:
        subprocess.check_call([sys.executable, "-m", "pip", "install", name])
        if os.name == 'nt':
            os.system('cls')
        else:
            os.system('clear')
    except:
        print("Error installing package")


install('stats-drug-test-patients')

dataset = StatsTestDrugPatients.ReadData('BloodPressure.csv')

# Male
male_data = StatsTestDrugPatients.Male(dataset=dataset)
male_bp = StatsTestDrugPatients.Male.Mean_bp(male_data)
male_t_test = StatsTestDrugPatients.Male.T_test(male_data)
male_conc = StatsTestDrugPatients.Male.Conclusion_Hypothesis(male_data)

# Female
female_data = StatsTestDrugPatients.Female(dataset=dataset)
female_bp = StatsTestDrugPatients.Female.Mean_bp(female_data)
female_t_test = StatsTestDrugPatients.Female.T_test(female_data)
female_conc = StatsTestDrugPatients.Female.Conclusion_Hypothesis(female_data)

choice = input("""You want to see the result Male or Female
1. Male
2. Female
Your Choice: """)

print("\033[H\033[J")

if choice == 1 or choice == '1' or choice == 'Male' or choice == 'M':
    print(f"""MALE RESULT 🚹
    Mean Blood Pressure Before = {male_bp[0].round(2)}
    Mean Blood After Drug = {male_bp[1].round(2)}
    T-Stat = {male_t_test[0].round(4)}
    P-Value = {male_t_test[1].round(4)}
    Hypothesis Conclusion: {male_conc[0]}
    Conclusion: {male_conc[1]}""")
elif choice == 2 or choice == '2' or choice == 'Female' or choice == "F":
    print(f"""\nFEMALE RESULT 🚺
    Mean Blood Pressure Before = {female_bp[0].round(2)}
    Mean Blood After Drug = {female_bp[1].round(2)}
    T-Stat = {female_t_test[0].round(4)}
    P-Value = {female_t_test[1].round(4)}
    Hypothesis Conclusion: {female_conc[0]}
    Conclusion: {female_conc[1]}""")
