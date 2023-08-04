# AI Playground

This program can help users visualize the decision boundary produced by a neural network given a collection of data points. The data points will be clustered in various patterns to explore the impacts of changing elements of the neural network, such as the number of layers, the number of neurons, the neural network features (transformations made on the input data points), and how noise in the dataset affects the neural network.

## Usage

1. Clone the repository to your local machine.
2. Open the project in an IDE or editor that supports Java 11.
3. Run `src/main/java/com/playground/playground/MainLauncher.java`.

## Software Specification

The user is presented with an interactive UI where they can choose various aspects of a handcrafted Neural Network:

1. Dataset: Randomly generated datasets on-click, possibilities include Circular, Cluster, Quadrant, and Spiral datasets.
2. Ratio of Training to Testing Data: Helps the user understand the balance between the amount of training and data, useful to understand concepts such as overfitting.
3. Noise: Choosing a value between 0 and 50 adds 0 to 500 random points onto the dataset.
4. Batch Size: Allows choosing the number of samples to be propagated through the network, useful in understanding the trade-off between batch size and the number of iterations.
5. Learning Rate: Provides various choices for the learning rate.
6. Activation Function: Choose the activation function for the neural network.
7. Regularization: Choose whether to apply regularization to the neural network.
8. Regularization Rate: Choose the rate for regularization if applied.
9. Features: Choose from a range of features or properties to be used as the first layer of the neural network.
10. Number of Nodes and Layers: Choose the number of layers and the number of nodes in each layer.

The user is also presented with start, stop, and resume buttons to facilitate their use of the program. The output decision boundary is graphed onto the dataset after each Epoch. The user can see various training metrics such as Epoch number and Training loss to gauge a deeper understanding of the neural network.

## Clean Architecture

### SOLID Principles

- **Single Responsibility Principle (SRP):** The `DataProcessor` class adheres to the SRP by taking the responsibility of dataset generation away from the `FeatureController`. This separation of concerns makes the codebase cleaner and more focused on specific tasks, enhancing code readability and maintainability.

- **Open/Closed Principle (OCP):** The implementation of the Strategy pattern allows for the extension of dataset generation capabilities without modifying existing code. By introducing new classes that implement the `DatasetGenerator` interface, we can easily introduce additional dataset generation algorithms, ensuring the codebase remains open for extension but closed for modification.

- **Liskov Substitution Principle (LSP):** The `DatasetGenerator` interface acts as a contract, ensuring that all concrete generator classes (e.g., `CircularDatasetGenerator`, `QuadrantDatasetGenerator`, etc.) can be used interchangeably in the `DataProcessor`. This promotes robustness and makes it easier to add new generators in the future.

- **Interface Segregation Principle (ISP):** The `DatasetGenerator` interface is designed to have minimal and specific methods required for generating datasets. This ensures that the implementing classes do not have to implement unnecessary methods, promoting a more focused and concise design.

- **Dependency Inversion Principle (DIP):** The use of the `DatasetGenerator` interface in the `DataProcessor` class demonstrates adherence to DIP. Instead of depending on concrete classes directly, the `DataProcessor` relies on abstractions, which decouples the high-level module from low-level details, leading to a more flexible and maintainable architecture.

### Design Patterns

- **Singleton Pattern:** The Singleton pattern is employed to ensure that the dataset generators (`CircularDatasetGenerator`, `QuadrantDatasetGenerator`, `SpiralDatasetGenerator`, and `ClusterDatasetGenerator`) have a single global instance across the application. This guarantees that all dataset generation requests go through the same generator instances, promoting consistency and avoiding unnecessary instantiation.

- **Strategy Pattern:** The Strategy pattern is used to enable dynamic switching between different dataset generation algorithms. The `DatasetGenerator` interface defines the contract for dataset generation algorithms, and individual generator classes implement this interface. The `DataProcessor` class acts as the client and accepts a dataset generator as a constructor parameter, allowing it to work with any class that implements the `DatasetGenerator` interface.

- **Composite Pattern:** The Composite pattern is employed in the `TransformDatasets` class to transform the dataset from an ArrayList of ArrayLists to an ArrayList of Lists with weights. This transformation allows for more efficient data representation, where each point includes coordinates and associated weights. The Composite pattern enables the processing of complex nested data structures with a unified interface.

## Code Organization

The project is organized into packages:

- The `data` package contains classes for generating different types of datasets (`CircularDatasetGenerator`, `QuadrantDatasetGenerator`, `SpiralDatasetGenerator`, and `ClusterDatasetGenerator`) and the `DataProcessor` class that generates datasets based on the selected `DatasetGenerator`.

- The `modelling` package contains classes related to building neural networks (`NeuralNet`
