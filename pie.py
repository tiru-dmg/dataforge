import matplotlib.pyplot as plt

plt.pie([35, 25, 25, 15], labels=['Apples', 'Bananas', 'Cherries', 'Dates'], autopct='%1.1f%%')
plt.title('Fruit Distribution')
plt.show()
