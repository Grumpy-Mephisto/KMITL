# Importing the libraries
import pandas as pd
import matplotlib.pyplot as plt
import numpy as np
import scipy.stats as stats

α = 0.05


def ReadData(dataset):
    dataset = pd.read_csv(dataset)
    return dataset


class Male:
    def __init__(self, dataset):
        self.dataset = dataset.loc[dataset['sex'] == 'Male']

    def Mean_bp(self):
        return self.dataset[['bp_before', 'bp_after']].mean()

    def T_test(self):
        return stats.ttest_rel(self.dataset['bp_before'], self.dataset['bp_after'])

    def Conclusion_Hypothesis(self):
        reject = ['Reject Null Hypothesis ❌',
                  'The drug is effective for male patient 😁']
        accept = ['Accept Null Hypothesis ✅',
                  'The drug is not effective for male patient ☹️']
        if self.T_test()[1] < α:
            return reject
        else:
            return accept


class Female:
    def __init__(self, dataset):
        self.dataset = dataset.loc[dataset['sex'] == 'Female']

    def Mean_bp(self):
        return self.dataset[['bp_before', 'bp_after']].mean()

    def T_test(self):
        return stats.ttest_rel(self.dataset['bp_before'], self.dataset['bp_after'])

    def Conclusion_Hypothesis(self):
        reject = ['Reject Null Hypothesis ❌',
                  'The drug is effective for female patient 😁']
        accept = ['Accept Null Hypothesis ✅',
                  'The drug is not effective for female patient ☹️']
        if self.T_test()[1] < α:
            return reject
        else:
            return accept


if __name__ == '__main__':
    df = ReadData('BloodPressure.csv')
    male_data = Male(dataset=df)
    female_data = Female(dataset=df)

    result = input(
        "You want to see the result \n1. Male\n2. Female\nYour Choice: ")

    print("\033[H\033[J")

    if result == 'Male' or result == 'male' or result == 'M' or result == 'm' or result == '1':
        print("RESULT FOR MALE PATIENT 🚹")
        male_bp = male_data.Mean_bp()
        male_t_test = male_data.T_test()
        male_conc = male_data.Conclusion_Hypothesis()
        print(
            f'Mean BP Before = {male_bp[0].round(2)} and After Treatment = {male_bp[1].round(2)}')
        print(
            f'T-stat = {male_t_test[0].round(4)}\nP-value = {male_t_test[1].round(4)}')
        print(f'Hypothesis: {male_conc[0]}')
        print(f'Conclusion: {male_conc[1]}')
    elif result == 'Female' or result == 'female' or result == 'F' or result == 'f' or result == '2':
        print("RESULT FOR FEMALE PATIENT 🚺")
        female_bp = female_data.Mean_bp()
        female_t_test = female_data.T_test()
        female_conc = female_data.Conclusion_Hypothesis()
        print(
            f'Mean BP Before = {female_bp[0].round(2)} and After Treatment = {female_bp[1].round(2)}')
        print(
            f'T-stat = {female_t_test[0].round(4)}\nP-value = {female_t_test[1].round(4)}')
        print(f'Hypothesis: {female_conc[0]}')
        print(f'Conclusion: {female_conc[1]}')
