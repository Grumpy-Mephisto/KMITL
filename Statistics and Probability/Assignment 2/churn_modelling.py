# Import libraries
import pandas as pd
import matplotlib.pyplot as plt
import seaborn as sns

# Read the CSV File
df = pd.read_csv('./Churn_Modelling.csv')

# Box Plot
sns.set_style('darkgrid')
plt.figure(figsize=(12, 8))
box_plot = sns.boxplot(x='Geography', y='Balance',
                       hue='Exited', palette="Set1", data=df)

# Describe the plot
box_plot.set_title('Box Plot of Balance by Geography and Exited')
box_plot.set_xlabel('Geography')
box_plot.set_ylabel('Balance')

# Show the plot
plt.show()

# Download the box plot
box_plot.figure.savefig("box_plot.png")

# Analyze the plot and write your findings below
# The plot shows that the median balance of customers who exited the bank is higher than the median balance of customers who did not exit the bank. The median balance of customers who exited the bank is higher in France than in Germany and Spain. The median balance of customers who did not exit the bank is higher in Germany than in France and Spain.
