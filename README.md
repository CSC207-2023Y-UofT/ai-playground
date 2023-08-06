# AI Playground

The AI Playground is an interactive software program designed to help users explore and visualize the decision boundary produced by a neural network using various datasets and configurations. It offers an educational and hands-on experience, allowing users to understand how neural networks function and how different factors impact their performance.

Users can select from a range of datasets, adjust the training-to-testing data ratio, introduce noise, customize batch size and learning rate, and experiment with different activation functions and regularization options. The program's intuitive interface provides start, stop, and resume buttons, enabling users to observe the decision boundary graphed onto the dataset after each training epoch.

The AI Playground serves as a valuable tool for students, researchers, and machine learning enthusiasts to gain practical insights into the world of artificial intelligence.

## Usage

To use the AI Playground, follow these steps:

1. Clone the repository to your local machine.
2. Open the project in an IDE or editor that supports Java 11.
3. Run `src/main/java/com/playground/playground/MainLauncher.java`.

## Software Specification

The AI Playground offers the following features for users to interact with:

### 1. Choose Dataset

Users can select from various randomly generated datasets, such as Circular, Cluster, Quadrant, and Spiral datasets. Each dataset represents different clustering patterns that can be used to observe the decision boundary produced by the neural network.

### 2. Set Training-to-Testing Ratio

The user can control the ratio of training to testing data. This feature helps users understand the trade-off between the amount of training data and testing data and the concept of overfitting.

### 3. Add Noise

Users can introduce noise to the dataset by choosing a noise level between 0 and 50. This feature allows users to see how noise affects the decision boundary and the robustness of the neural network.

### 4. Set Batch Size

The batch size can be adjusted, allowing users to explore the impact of batch size on the number of samples propagated through the network during training. This provides insights into the trade-offs between batch size and the number of iterations.

### 5. Set Learning Rate

The learning rate can be customized, offering various choices for users. Adjusting the learning rate helps users observe how it affects the training process and convergence speed.

### 6. Choose Activation Function

Users can choose the activation function for the neural network. Different activation functions have distinct effects on the network's performance and learning behavior.

### 7. Enable Regularization

Regularization can be turned on or off. Users can observe how regularization affects the model's performance and prevents overfitting.

### 8. Set Regularization Rate

If regularization is enabled, users can set the rate for regularization. This parameter controls the strength of the regularization effect on the neural network.

### 9. Choose Features

The AI Playground offers a selection of features or properties to be used as the first layer of the neural network. Users can experiment with different features to observe their impact on the model's performance.

### 10. Set Number of Layers and Nodes

Users can specify the number of layers and the number of nodes in each layer. This feature allows users to design custom neural network architectures and understand how the network's structure affects its capabilities.

### 11. Start, Stop, and Resume Training

The software provides buttons to start, stop, and resume the training process. This allows users to control the training procedure and observe the decision boundary at different stages of training.

### 12. Visualize Decision Boundary

After each training epoch, the decision boundary is graphed onto the dataset. Users can see the evolving decision boundary and understand how the neural network learns to classify data points.

### 13. Training Metrics

The AI Playground displays various training metrics, including Epoch number, Testing loss, and Training loss. These metrics provide users with insights into the neural network's performance during training.

By offering these interactive features and visualizations, the AI Playground aims to make neural networks more accessible and understandable for users. Users can experiment with different configurations and datasets to gain a deeper understanding of how neural networks work and how to optimize their performance for specific tasks. The software provides a valuable educational tool for students, researchers, and enthusiasts interested in machine learning and neural networks.

## Clean Architecture

The AI Playground project follows Clean Architecture principles:

### interface_adapter layer
- Contains classes interacting with the external world.
- Includes UI components like `FeatureController`.
- Provides an interface for data generators like `DataProcessor`.

### usecase layer
- Holds business logic and use cases.
- Includes classes like `ModelTrainingServices` for training the neural network.

### entity layer
- Contains domain model and business entities.
- Includes classes like `NeuralNet` representing the neural network model.

### resources layer
- Contains configuration files and resources.
- For example, external configuration files would be placed here.

### frameworks layer

## SOLID Principles

The AI Playground project adheres to SOLID principles:

### Single Responsibility Principle (SRP)
- Each class has a single responsibility.
- `FeatureApplier` applies specific features to the dataset.
- `DataGeneratorFactory` creates different dataset generators.

### Open/Closed Principle (OCP)
- Designed to be easily extensible.
- New feature appliers or dataset generators can be added by implementing interfaces.

### Liskov Substitution Principle (LSP)
- Subclasses can be used interchangeably with their parent classes.
- All dataset generators implement the `DatasetGenerator` interface.

### Interface Segregation Principle (ISP)
- Small, focused interfaces are created.
- `DatasetGenerator` and `FeatureApplier` interfaces define only relevant methods.

### Dependency Inversion Principle (DIP)
- Dependency Injection is used, relying on abstractions rather than concrete implementations.
- `DataProcessor` depends on the `DatasetGenerator` interface.

### Design Patterns

- **Singleton Pattern:** The Singleton pattern is employed to ensure that the dataset generators (`CircularDatasetGenerator`, `QuadrantDatasetGenerator`, `SpiralDatasetGenerator`, and `ClusterDatasetGenerator`) have a single global instance across the application. This guarantees that all dataset generation requests go through the same generator instances, promoting consistency and avoiding unnecessary instantiation.

- **Composite Pattern:** The Composite pattern is employed in the `TransformDatasets` class to transform the dataset from an ArrayList of ArrayLists to an ArrayList of Lists with weights. This transformation allows for more efficient data representation, where each point includes coordinates and associated weights. The Composite pattern enables the processing of complex nested data structures with a unified interface.

- **Factory Pattern:**
  - `DataGeneratorFactory`: This factory encapsulates the creation of different dataset generators (`CircularDatasetGenerator`, `ClusterDatasetGenerator`, `QuadrantDatasetGenerator`, and `SpiralDatasetGenerator`). It allows clients to obtain instances of dataset generators without knowing their concrete classes.
  - `FeatureApplierFactory`: This factory encapsulates the creation of different feature appliers (`SquareFeatureApplier`, `SinFeatureApplier`, and `MultiplyFeatureApplier`). It allows clients to obtain instances of feature appliers without knowing their concrete classes.

- **Strategy Pattern:**
  - `FeatureController`: The Strategy pattern is used in `FeatureController` to apply different features to the dataset. The `FeatureApplier` interface defines the strategy, and concrete implementations like `SquareFeatureApplier`, `SinFeatureApplier`, and `MultiplyFeatureApplier` provide different algorithms for applying features.
  - `DataProcessor`: The Strategy pattern is used in `DataProcessor` to generate different datasets based on user input. The `DatasetGenerator` interface defines the strategy, and concrete implementations like `CircularDatasetGenerator`, `ClusterDatasetGenerator`, `QuadrantDatasetGenerator`, and `SpiralDatasetGenerator` provide different algorithms for generating datasets.

- **Builder Pattern:**
  - `NeuralNetBuilder`: The Builder pattern is used in `NeuralNetBuilder` to construct `NeuralNet` objects step by step. It provides a clear and readable way to configure various parameters of the neural network before building the final object.

- **Iterator Pattern:**
  - `DataSetIterator`: The Iterator pattern is used in the `modelling` package to provide a way to traverse dataset elements without exposing the underlying representation. This abstraction allows iterating through the dataset efficiently regardless of its internal structure. For example, the `INDArrayDataSetIterator` implements the iterator interface to traverse through the dataset's INDArray elements.

## Code Organization

The AI Playground project follows structured code organization:

1. Project is divided into packages representing specific domains or layers like `interface_adapter`, `usecase`, `entity`, and `resources`.

2. Within each package, classes are organized based on their functionality and responsibilities.

3. The `test` package contains test classes for unit testing various components of the application.

By organizing the code in this manner, the AI Playground project becomes more maintainable and readable.

## User Stories

1. As a user, I want to see the decision boundary (represented graphically) update and the training loss after every epoch on the graph, superimposed over the input data points.

2. As a user, I want to see how modifying the input dataset (distribution of the data) and the noise of the data (how clustered the points are) affects the decision boundary.

3. As a teacher, I want to show students a highly accessible way of visualizing how changing the number of layers and how many nodes exist in each layer affects the decision boundary.

4. As a Deep Learning enthusiast, I want to see how different input features (the properties applied to the input data before it reaches the neural network) affect the decision boundary.

5. As a user, I want to be able to press a button to start/stop and reset the training of the model.

6. As a user, I want to see how the weights of each feature change (represented by the connection lines between nodes) with the number of epochs.

## Use of GitHub

The AI Playground project demonstrates effective use of GitHub's features and best practices to foster collaboration, version control, and code management. Here are some key aspects of how GitHub was utilized in this project:

1. **Version Control with Git:** The project is hosted on GitHub, utilizing Git for version control. All changes and updates to the codebase are tracked, allowing for easy collaboration among team members and maintaining a history of code changes.

2. **Pull Requests (PRs):** The team followed a collaborative workflow using pull requests. Whenever a new feature or enhancement was developed, a new branch was created from the `main` branch. After implementing the changes, a pull request was opened to merge the feature branch into the `main` branch. This allowed for code review, discussions, and quality assurance before merging.

3. **Code Reviews:** Every pull request was subjected to code reviews by team members. This process ensured that the code met the project's standards, adhered to best practices, and was free of any potential issues. Code reviews also provided an opportunity for knowledge sharing and learning among team members.

4. **Issue Tracking:** GitHub's issue tracking system was extensively used to manage tasks, enhancements, and bug reports. Whenever a new feature or bug fix was required, an issue was created, assigned to team members, and labeled appropriately. This allowed for better organization and transparency in the development process.

5. **Project Boards:** GitHub project boards were used to manage the development process. Tasks and issues were categorized into different columns, such as "To Do," "In Progress," and "Done." This provided a visual representation of the project's progress and helped the team stay focused on critical tasks.

6. **Code Organization and Collaboration:** The codebase was well-organized into different packages and modules. Team members collaborated on specific features and modules while minimizing conflicts and ensuring smooth integration.

7. **Documentation and Comments:** The team placed significant emphasis on documentation and comments within the codebase. This made the code more understandable and maintainable for all team members and future contributors.

8. **Code Quality and Linting:** GitHub's integration with code quality tools and linters helped maintain consistent code standards and identify potential issues early in the development process.

Overall, the use of GitHub played a crucial role in facilitating collaboration, code management, and efficient development workflows throughout the AI Playground project. It allowed the team to work cohesively, implement new features, and address issues effectively, resulting in a successful and well-structured project.

## License

```
Copyright 2023 Shivesh Prakash, Rishit Dagli, Robert Ford, Rohan Patra, Alvina Yang and Amr Alomari

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
