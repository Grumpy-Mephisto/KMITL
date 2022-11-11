import pandas as pd
from sklearn.linear_model import LinearRegression
from sklearn.metrics import mean_squared_error, mean_absolute_error, r2_score
import time
import os


def ReadData(dataset):
    df = pd.read_csv(dataset)
    return df


def DataTransform(df):
    X = df[['Age', 'Weight_pounds']]
    y = df['Blood_pressure']
    return X, y


def LinearRegressionModel(X, y):
    model = LinearRegression()
    model.fit(X.values, y)
    return model


def ViewCoefficient(model):
    print("===== View Coefficient =====")
    print(f"Intercept: {model.intercept_}")
    print(f"Coefficient: {model.coef_}")


def Equation(model):
    print("===== Equation =====")
    print(
        f"Blood_pressure = {round(model.intercept_, 3)} + {round(model.coef_[0], 3)} * Age + {round(model.coef_[1], 3)} * Weight_pounds")


def Predict(model, Age, Weight_pounds):
    print("===== Predict =====")
    try:
        Blood_pressure = model.predict([[Age, Weight_pounds]])
        print(f"Blood_pressure: {round(Blood_pressure[0], 2)}")
    except Exception as e:
        print("Error: ", e)


def ModelEvaluation(model, X, y):
    y_pred = model.predict(X)
    print("===== Model Evaluation =====")
    y_test = pd.DataFrame({'Actual': y, 'Predicted': y_pred})
    print(y_test)
    print(f'R2: {round(r2_score(y, y_pred), 4)}')
    print(f'MAE: {round(mean_absolute_error(y, y_pred), 4)}')
    print(f'MSE: {round(mean_squared_error(y, y_pred), 4)}')


def Menu():
    print("===== Menu =====")
    print(" 1. View Coefficient")
    print(" 2. Equation")
    print(" 3. Predict")
    print(" 4. Model Evaluation")
    print(" 5. Exit")
    print("===============")
    choice = input("Enter your choice: ")
    return choice


def LoadAnimation():
    ClearScreen()
    bar = [
        " [=     ]",
        " [ =    ]",
        " [  =   ]",
        " [   =  ]",
        " [    = ]",
        " [     =]",
        " [    = ]",
        " [   =  ]",
        " [  =   ]",
        " [ =    ]",
    ]
    for i in range(5):
        for j in range(10):
            print(bar[j], end="\r")
            if i == 4 and j == 9:
                print("Exiting program...")
                time.sleep(1)
            time.sleep(0.1)
        ClearScreen()


def ClearScreen():
    os.system('cls' if os.name == 'nt' else 'clear')


def BackToMenu():
    choice = input("\nDo you want to go back to menu? (y/n): ")
    if choice == 'y' or choice == 'Y':
        main()
    elif choice == 'n' or choice == 'N':
        LoadAnimation()
        exit()
    else:
        print("Invalid choice")
        time.sleep(0.5)


def main():
    df = ReadData('BloodPressure.csv')
    X, y = DataTransform(df)
    model = LinearRegressionModel(X, y)
    while True:
        ClearScreen()
        choice = Menu()
        if choice == '1':
            ClearScreen()
            ViewCoefficient(model)
            BackToMenu()
        elif choice == '2':
            ClearScreen()
            Equation(model)
            BackToMenu()
        elif choice == '3':
            ClearScreen()
            Age = float(input("Enter Age: "))
            Weight_pounds = float(input("Enter Weight_pounds: "))
            Predict(model, Age, Weight_pounds)
            BackToMenu()
        elif choice == '4':
            ClearScreen()
            ModelEvaluation(model, X, y)
            BackToMenu()
        elif choice == '5':
            LoadAnimation()
            exit()
        else:
            print("Invalid choice")
            time.sleep(0.5)


if __name__ == '__main__':
    main()
