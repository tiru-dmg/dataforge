import matplotlib.pyplot as plt

# Reduced dataset
x = [1, 3, 5, 10, 15, 18, 20, 25, 30, 35, 
     40, 45, 50, 55, 60, 65, 70, 75, 80, 90]

plt.hist(x, bins=10)
plt.show()
