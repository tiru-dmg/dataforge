import matplotlib.pyplot as plt
import pandas as pd

data = {'Category': ['A', 'B', 'C', 'D'], 'Values': [20, 35, 30, 25]}
df = pd.DataFrame(data)
plt.bar(df['Category'], df['Values'])
plt.xlabel('Category')
plt.ylabel('Values')
plt.title('Bar Graph Example')
plt.show()
