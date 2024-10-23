import matplotlib.pyplot as plt
import numpy as np

np.random.seed(10)
data = np.random.normal(100, 20, 200)
fig = plt.figure(figsize=(10, 7))
plt.boxplot(data)
plt.title('Boxplot of Random Data')
plt.ylabel('Values')
plt.show()
