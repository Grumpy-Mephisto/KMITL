import numpy as np
import pandas as pd
from sklearn.preprocessing import LabelEncoder
from sklearn.naive_bayes import CategoricalNB


class TextColor:
    GREEN = '\033[92m'
    RED = '\033[91m'
    END = '\033[0m'


def ReadCSV(filename):
    df = pd.read_csv(filename)
    return df


def LabelEncode(data, columns):
    for i in columns:
        lb = LabelEncoder().fit_transform(data[i])
        data[i + '_'] = lb


def TrainModel(X, y):
    model = CategoricalNB()
    model.fit(X, y)
    return model


def Predict(model, new_input):
    y_prob_predict = model.predict_proba(new_input)
    y_new_predict = model.predict(new_input)
    return y_prob_predict, y_new_predict


def TranslateLabel(y_le, y_new_predict, y_prob_predict):
    n = 1
    for i in y_new_predict:
        if y_le.classes_[i] == 'yes':
            print(
                f'No {n} => {TextColor.GREEN}{y_le.classes_[i]}{TextColor.END}')
            print(
                f'Predict Probability: {TextColor.GREEN}{y_prob_predict[n-1][i]}{TextColor.END}, {TextColor.RED}{y_prob_predict[n-1][1-i]}{TextColor.END}')
        else:
            print(
                f'No {n} => {TextColor.RED}{y_le.classes_[i]}{TextColor.END}')
            print(
                f'Predict Probability: {TextColor.GREEN}{y_prob_predict[n-1][1-i]}{TextColor.END}, {TextColor.RED}{y_prob_predict[n-1][i]}{TextColor.END}')
        n = n + 1


def main():
    df = ReadCSV('./playtennis.csv')
    X = df.drop(['play'], axis=1)
    y = df.play
    f_columns = ['outlook', 'temp', 'humidity', 'windy']
    LabelEncode(X, f_columns)
    y_le = LabelEncoder()
    y1 = y_le.fit_transform(y)
    X1 = X[['outlook_', 'temp_', 'humidity_', 'windy_']]
    model = TrainModel(X1, y1)
    print(f'Model: {model}')
    new_input = [[2, 0, 1, 1], [1, 2, 1, 0]]
    y_prob_predict, y_new_predict = Predict(model, new_input)
    TranslateLabel(y_le, y_new_predict, y_prob_predict)


if __name__ == '__main__':
    main()
