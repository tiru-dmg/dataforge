import numpy as np
import matplotlib.pyplot as plt
import seaborn as sns

def compute_dissimilarity_matrix(data):
    num_samples = data.shape[0]
    dissimilarity_matrix = np.zeros((num_samples, num_samples))
    for i in range(num_samples):
        for j in range(num_samples):
            dissimilarity_matrix[i, j] = np.linalg.norm(data[i] - data[j])
    return dissimilarity_matrix

def generate_data(num_points, num_features):
    return np.random.rand(num_points, num_features)

num_points = 5
num_features = 3
data = generate_data(num_points, num_features)
dissimilarity_matrix = compute_dissimilarity_matrix(data)

print("Dissimilarity Matrix:")
print(dissimilarity_matrix)

plt.figure(figsize=(8, 6))
sns.heatmap(dissimilarity_matrix, annot=True, fmt=".2f", cmap='viridis', square=True)
plt.title('Dissimilarity Matrix Heatmap')
plt.xlabel('Sample Index')
plt.ylabel('Sample Index')
plt.show()
