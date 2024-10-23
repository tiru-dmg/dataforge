import numpy as np
import pandas as pd
from scipy.stats import chi2_contingency

data = np.array([[10, 20, 30],
                 [6, 12, 18],
                 [5, 10, 15]])

df = pd.DataFrame(data, columns=['Category 1', 'Category 2', 'Category 3'], index=['Group 1', 'Group 2', 'Group 3'])
print("Contingency Table:")
print(df)

chi2_stat, p_value, dof, expected = chi2_contingency(data)

print("\nChi-Square Statistic:", chi2_stat)
print("P-Value:", p_value)
print("Degrees of Freedom:", dof)
print("Expected Frequencies:")
print(expected)

alpha = 0.05
if p_value < alpha:
    print("\nReject the null hypothesis: There is a significant association between the variables.")
else:
    print("\nFail to reject the null hypothesis: There is no significant association between the variables.")
