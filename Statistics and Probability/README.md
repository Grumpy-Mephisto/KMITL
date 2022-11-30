# Conclusion

Short cuts

[1]: [Naive Bayes Classifier](#naive-bayes-classifier)

[2]: [Descriptive Statistics](#descriptive-statistics)

[3]: [Monte Carlo Simulation](#monte-carlo-simulation)

[4]: [Hypothesis Testing](#hypothesis-testing)

[5]: [Linear Regression](#linear-regression)

## Naive Bayes Classifier

- Upload and Read the data

  ```python
   from google.colab import files
   uploaded = files.upload()
  ```

  ```python
     import numpy as np
     import pandas as pd
     df = pd.read_csv('data.csv')
  ```

- Separate data between dependent and independent variables

  ```python
   X = df.drop(['target'], axis=1) # independent variables
   y = df['target'] # dependent variable
  ```

- Label Encoding

  ```python
   from sklearn.preprocessing import LabelEncoder
   def label_encoding(data, columns):
     for i in columns:
         lb = LabelEncoder().fit_transform(data[i])
         data[i + "_"] = lb
  ```

  ```python
   label_encoding(X, ['Outlook', 'Temperature', 'Humidity', 'Wind']) # label encoding
  ```

  ```python
  y_le = Encoder() # Label Encoder for dependent variable
  y1 = y_le.fit_transform(y) # label encoding for dependent variable
  ```

  ```python
  X1 = X[['Outlook_', 'Temperature_', 'Humidity_', 'Wind_']] # independent variables
  ```

- Model Construction

  ```python
   from sklearn.naive_bayes import CategoricalNB # Naive Bayes Classifier
   model = CategoricalNB() # model construction
   model.fit(X1, y1) # model training
  ```

  ```python
  print(model.feature_log_prob_) # log probability of each feature
  print(model.category_count_) # number of samples encountered for each (class, feature) during fitting
  ```

- Model Prediction

  ```python
  new_input = [[0, 1, 1, 1], [1, 0, 0, 2]] # new input
  y_prob_pred = model.predict_proba(new_input) # probability prediction
  ```

  ```python
  y_new_predict = model.predict(new_input) # prediction
  n = 1
  for i in y_new_predict:
      print("No", n, ":", y_le.classes([i])) # print the prediction
      n += 1
  ```

## Descriptive Statistics

- Upload and Read the data

  ```python
  from google.colab import files
  uploaded = files.upload()
  ```

  ```python
  import numpy as np
  import pandas as pd
  df = pd.read_csv('data.csv')
  ```

- Churn Modeling Dataset

  ```python
  df.dtypes # data types
  ```

- Numeric Data

  ```python
  df.describe() # descriptive statistics
  ```

- Mode

  ```python
  df.mode() # mode of each column
  ```

  ```python
  df.mode(numeric_only=True) # mode of numeric columns
  ```

- Variance/Coefficient of Variation

  ```python
  df.var() # variance of each column
  df.var()['Age'] # variance of Age column
  ```

  ```python
  from scipy.stats import variation # coefficient of variation
  variation(df['Age']) # coefficient of variation of Age column
  ```

- Categorical Data

  ```python
  df.describe(exclude=['float', 'int64']) # descriptive statistics of categorical data
  ```

  ```python
  df.describe(include=['object']) # descriptive statistics of categorical data
  ```

- Convert Data Type

  ```python
  df.RowNumber=df.RowNumber.astype('category')
  df.CustomerId=df.CustomerId.astype('category')
  df.HasCrCard=df.HasCrCard.astype('category')
  df.IsActiveMember=df.IsActiveMember.astype('category')
  df.Exited=df.Exited.astype('category')
  df.NumOfProducts=df.NumOfProducts.astype('category')
  ```

  ```python
  df.Geography = df.Geography.astype('category')
  df.Surname = df.Surname.astype('category')
  df.Gender = df.Gender.astype('category')
  ```

### Data Visualization

- Bar Chart

  ```python
  import matplotlib.pyplot as plt
  import seaborn as sns
  sns.set_style('darkgrid')
  colors = ['#00A5E0', '#DD403A']
  fig = plt.figure(figsize = (5, 5))
  sns.countplot(x = 'Exited', data = df, palette = colors)

  for index, value in enumerate(df['Exited'].value_counts()):
    # If you want to show the percentage of each bar, use the following code
    label = '{}%'.format(round( (value/df['Exited'].shape[0])*100, 2))
    # And if you want to show the number of each bar, use the following code
    label = '{}'.format(value)
    plt.annotate(label, xy = (index -0.25, value -800), color = 'w',fontweight='bold',size=17)

  plt.title('Number of Retained and Churned Customers')
  plt.xticks([0, 1], ['Remained', 'Churned'])
  plt.xlabel('Status')
  plt.ylabel('Count')
  ```

  If you want to show multiple charts

  ```python
   fig, axarr = plt.subplots(2, 2, figsize=(20, 12))
   sns.countplot(x='Geography', hue = 'Exited',data = df, ax=axarr[0][0])
   sns.countplot(x='Gender', hue = 'Exited',data = df, ax=axarr[0][1])
   sns.countplot(x='HasCrCard', hue = 'Exited',data = df, ax=axarr[1][0])
   sns.countplot(x='IsActiveMember', hue = 'Exited',data = df, ax=axarr[1][1])
  ```

  - Majority of the data is from persons from France. Germany has the highest proportion of churned customers
  - The proportion of female customers churning is also greater than that of male customers

  ![Example of Bar Chart](inkdrop://file:mz5TBvOSV)

  - No different proportion of customers churning between HasCrCard and not have
  - The inactive members have a greater churn

  ![Example of Bar Chart](inkdrop://file:frJdOPzkC)

- Box Plot

  - Data is represented with a box
  - The ends of the box are at the first and third quartiles, i.e. the height of the box is `IQR` => `Q3 - Q1`
  - The median is marked by a line within the box
  - Whiskers: two lines outside the box extended to Minimum and Maximum
  - Outliers: points beyond a specified outlier threshold, plotted individually

  ```python
  sns.boxplot(y = "Age", data = df)
  ```

  ```python
  fig = pltfigure(figsize = (10, 5))
  sns.boxplot(x = 'Exited', y = 'Age', data = df, hue = 'Exited', palette = colors)
  ```

  - There is no significant difference in the credit score distribution between retained and churned customers
  - The older customers are churning at more than the younger customers
  - The customers on either extreme end (spent little time with the bank or a lot of time with the bank) are more likely to churn compared to those that are of average tenure

  ![Example of Box Plot](inkdrop://file:tSA6XCwYc)

  - The bank is losing customers with significant bank balances
  - The salary has no significant effect on the likelihood to churn

  ![Example of Box Plot](inkdrop://file:AYBYaDSt7)

- Histogram

  ```python
  fig = plt.figure(figsize = (10, 5))
  sns.histplot(x = 'Age', data = df, hue = 'Exited', palette = colors)
  ```

  use function `multiple` to show multiple charts

  ```python
  sns.histplot(x = 'Age', data = df, hue = 'Exited', palette = colors, multiple = 'stack') # stack the bars on top of each other
  sns.histplot(x = 'Age', data = df, hue = 'Exited', palette = colors, multiple = 'dodge') # place the bars side by side
  sns.histplot(x = 'Age', data = df, hue = 'Exited', palette = colors, multiple = 'layer') # place the bars in the same position
  ```

  - Most of our customers are between the age of 28 to 40
  - Credit Score seems like left skewed

  ![Example of Histogram](inkdrop://file:djQ-poYAn)

  - Balance of the customers are seemed to be symmetrically distributed
  - There is not much variation in Estimated salary

  ![Example of Histogram](inkdrop://file:a-ElK0TUc)

## Monte Carlo Simulation

### Estimating the values of Pi

- Monte Carlo simulations use **random sampling** to obtain **numerical** results
- A dart thrower who always manages to hit the board and is equality likely to hit any area of the board
- The probability that the dart will hit p(hit) is

```mathematic
p(hit) = # of darts in the circle / # of darts thrown
       = area of the circle / area of the square
       = pi * r^2 / (2r)^2 = pi / 4
```

The algorithm

1. Set the radius, sampling size to N (#iteration of random points)
2. circle_points=0
3. For i=1 to N
   - random x and y as a point p=(x,y)
   - If point p is inside the circle increment circle_points
4. End for
5. Calculate Pi = 4\*(circle_points/N)
6. Return Pi

- Import libraries and set the initial values

  ```python
  import random
  import math
  import pandas as pd
  import seaborn as sns
  import matplotlib.pyplot as plt
  ```

  ```python
  r = 1.0 # radius
  N = 100000 # number of iterations
  d = {"Trials": [], "Pi": []} # dictionary to store the results
  ```

- Monte Carlo Simulation

  ```python
  for T in range(1,N):
    circle_p=0
    for i in range(T):
      x = random.uniform(-1.0, 1.0)
      y = random.uniform(-1.0, 1.0)

      x2 = x ** 2
      y2 = y ** 2

      if math.sqrt(x2 + y2) <= r:
        circle_p+=1

    d["Trials"].append(T)
    d["Pi"].append((circle_p/T)*4)
  ```

- Visualize Pi values calculated by Monte Carlo

  ```python
  df = pd.DataFrame(data=d)
  plt.figure(figsize = (10,7))
  plot = sns.scatterplot(x="Trials", y="Pi", s=30, marker="o", data=df)
  plot.set(title='Monte Carlo Simulation to Estimate Value of Pi', xlabel="Number of Trials", ylabel="Value of Pi")
  plt.axhline(y=3.14, color='r', linestyle='-')
  plt.show()
  ```

- Histogram of Pi values

  ```python
  import seaborn as sns
  sns.set_style('darkgrid')
  fig = plt.figure(figsize = (10,6))
  sns.histplot(df, x="Pi",color='orange');
  ```

  If you want to see the mean

  ```python
  df['Pi'].mean()
  ```

#### Predicting sales commission budget

- Random Percent to Plan (normal distribution)

  ```python
  import pandas as pd
  import numpy as np
  import seaborn as sns
  sns.set_style('whitegrid')
  ```

  ```python
  avg = 1
  std_dev = .1
  num_reps = 500
  pct_to_target = np.random.normal(avg, std_dev, num_reps).round(2)
  ```

- Random Sales Target (weighted uniform distribution)

  ```python
  sales_target_values = [75_000, 100_000, 200_000, 300_000, 400_000, 500_000]
  sales_target_prob = [.3, .3, .2, .1, .05, .05]
  sales_target = np.random.choice(sales_target_values, num_reps, p=sales_target_prob)
  ```

- Create DataFrame

  ```python
  df = pd.DataFrame(index=range(num_reps), data={'Pct_To_Target': pct_to_target, 'Sales_Target': sales_target})
  ```

- Compute Actual Sales

  ```python
  df['Sales'] = df['Pct_To_Target'] * df['Sales_Target']
  ```

- Visualize the Distribution of Percent to Plan (Pct_To_Target)

  ```python
  df['Pct_To_Target'].plot(kind='hist', title='Percent to Target Distribution')
  ```

- Visualize the Distribution of Sales Target

  ```python
  sns.countplot(x = 'Sales_Target', data = df, palette = 'Set2')
  ```

- Calculate Commission Rate

  ```python
  # Rate following the proportion of sales target
  def calc_commission_rate(x):
    if x <= .90:
      return .02
    if x <= .99:
      return .03
    else:
      return .04
  ```

  ```python
  df['Commission_Rate'] = df['Pct_To_Target'].apply(calc_commission_rate)
  ```

- Calculate Commission Amount

  ```python
  df['Commission_Amount'] = df['Commission_Rate'] * df['Sales']
  ```

- Simulation with 1000 iterations

  ```python
  num_simulations = 1000
  all_stats = []
  # Loop through many simulations
  for i in range(num_simulations):
      # Choose random inputs for the sales targets and percent to target
      sales_target = np.random.choice(sales_target_values, num_reps, p=sales_target_prob)
      pct_to_target = np.random.normal(avg, std_dev, num_reps).round(2)
      # Build the dataframe based on the inputs and number of reps
      df = pd.DataFrame(index=range(num_reps), data={'Pct_To_Target': pct_to_target,
      'Sales_Target': sales_target})

      # Back into the sales number using the percent to target rate
      df['Sales'] = df['Pct_To_Target'] * df['Sales_Target']
      # Determine the commissions rate and calculate it
      df['Commission_Rate'] = df['Pct_To_Target'].apply(calc_commission_rate)
      df['Commission_Amount'] = df['Commission_Rate'] * df['Sales']
      # We want to track sales,commission amounts and sales targets over all the simulations
      all_stats.append([df['Sales'].sum().round(0), df['Commission_Amount'].sum().round(0), df['Sales_Target'].sum().round(0)])
  ```

- Create DataFrame of Actual Sales, Commission Amount, and Sales Target from 1,000 iterations

  ```python
  results_df = pd.DataFrame.from_records(all_stats, columns=['Sales', 'Commission_Amount', 'Sales_Target'])
  ```

- View descriptive statistics of Actual Sales, Commission Amount, and Sales Target

  ```python
  results_df.describe().style.format('{:,.2f}')
  ```

- Display in tabular format

  ```python
  from tabulate import tabulate
  print((tabulate(results_df.describe(),headers='keys',floatfmt=",.2f",tablefmt='psql')))
  ```

  ```python
  print((tabulate(results_df.describe(),headers='keys',floatfmt=",.2f",tablefmt='grid'))) # tablefmt='grid' is displayed in grid format
  ```

  ```python
  print((tabulate(results_df.describe(),headers='keys',floatfmt=",.2f",tablefmt='fancy_grid'))) # tablefmt='fancy_grid' is displayed in fancy grid format
  ```

- Visualize the distribution of Total Commission Amount (1,000 iterations)

  ```python
  results_df['Commission_Amount'].plot(kind='hist', title="Total Commission Amount")
  ```

## Hypothesis Testing

### Z Test

- Test for p1 - p2
- In a test, a new deodorant was preferred by 320 of 400 people asked in North & 300 of 425 people asked in South
- Is there a difference between two groups at α = 5% ?
  - H0: p1 - p2 = 0
  - H1: p1 - p2 ≠ 0
  - two-tailed test with α = 0.05

```python
from statsmodels.stats.proportion import proportions_ztest
import numpy as np
```

- Set alpha, sample size

  ```python
  significance = 0.05 #alpha value
  successes = np.array([320, 300])
  samples = np.array([400, 425])
  ```

- Compute z-statistics and p-value

  ```python
  z_stat, p_value = proportions_ztest(count=successes,nobs=samples,alternative='two-sided')
  ```

- Show the outputs: z-statistics, p-value, and conclusion

  ```python
  print('z_stat: %0.5f, p_value: %0.5f' % (stat, p_value))
  if p_value < significance:
    print ("Reject the null hypothesis")
  else:
    print ("Accept the null hypothesis")

  # Result
  # z_stat: 3.12644, p_value: 0.00177
  # Reject the null hypothesis
  ```

### Chi-Square Test

```python
import pandas as pd
from scipy.stats import chi2_contingency
```

```python
df = pd.DataFrame(index = ["Married", "Single"], data = {'Male': [25, 35], 'Female': [15, 25]})
```

```python
chi2, p, dof, expected = chi2_contingency(df,correction=False)
print(f"chi2 statistic: {chi2:.5g}")
print(f"p-value: {p:.5g}")
print(f"degrees of freedom: {dof}")
print("expected frequencies:")
print(expected)
```

## Linear Regression

### Simple Linear Regression

- Find linear regression of the following data (n = 5)

  - x = [50, 51, 52, 53, 54]
  - y = [20, 40, 50, 70, 80]

  ```python
  import pandas as pd
  import numpy as np
  from sklearn.linear_model import LinearRegression
  ```

  ```python
  x = np.array([50, 51, 52, 53, 54]).reshape((-1, 1))
  y = np.array([20, 40, 50, 70, 80]).reshape((-1, 1))
  ```

  ```python
  model = LinearRegression() # create a model
  model.fit(x, y) # fit the model
  ```

  ```python
  print(f"intercept: {model.intercept_}")
  print(f"slope: {model.coef_}")
  ```

  ```python
  # Predict new input x
  y_pred = model.predict([51.5])
  ```

- Model Evaluation

  - Coefficient of Determination (R-squared)

    - R-squared is a statistical measure that represents the proportion of the variance for a dependent variable that's explained by an independent variable or variables in a regression model.

    ```python
    model.score(x, y)
    ```

  - Mean Absolute Error (MAE)
  - Mean Squared Error (MSE)

    ```python
    from sklearn.metrics import mean_squared_error, mean_absolute_error
    y_predict1=model.predict(x_TV)
    print('MAE =', mean_absolute_error(y,y_predict1))
    print('MSE =', mean_squared_error(y,y_predict1))
    ```
