import numpy as np
import matplotlib.pyplot as plt

def generate_data(num_points, centers, spread):
    data = []
    for center in centers:
        points = np.random.randn(num_points, 2) * spread + center
        data.append(points)
    return np.vstack(data)

def k_means(data, k, max_iterations=100):
    random_indices = np.random.choice(data.shape[0], k, replace=False)
    centroids = data[random_indices]
    for _ in range(max_iterations):
        distances = np.linalg.norm(data[:, np.newaxis] - centroids, axis=2)
        labels = np.argmin(distances, axis=1)
        new_centroids = np.array([data[labels == i].mean(axis=0) for i in range(k)])
        if np.all(centroids == new_centroids):
            break
        centroids = new_centroids
    return centroids, labels

def plot_clusters(data, centroids, labels):
    plt.scatter(data[:, 0], data[:, 1], c=labels, cmap='viridis', marker='o', edgecolor='k')
    plt.scatter(centroids[:, 0], centroids[:, 1], c='red', marker='X', s=200, label='Centroids')
    plt.title('K-means Clustering')
    plt.xlabel('Feature 1')
    plt.ylabel('Feature 2')
    plt.legend()
    plt.grid(True)
    plt.show()

if __name__ == "__main__":
    num_points_per_cluster = 50
    centers = [(2, 2), (8, 8), (5, 1)]
    spread = 0.5
    k = len(centers)

    data = generate_data(num_points_per_cluster, centers, spread)
    centroids, labels = k_means(data, k)
    plot_clusters(data, centroids, labels)
