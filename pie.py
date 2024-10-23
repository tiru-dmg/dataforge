import matplotlib.pyplot as plt

labels = ['Apples', 'Bananas', 'Cherries', 'Dates']
sizes = [35, 25, 25, 15]
plt.pie(sizes, labels=labels, autopct='%1.1f%%')
plt.title('Fruit Distribution')
plt.show()
