# AI Playground

The AI Playground is a software program designed to help users visualize the decision boundary produced by a neural network using different datasets and configurations. It aims to provide an interactive and educational experience for understanding how neural networks work and how various factors impact their performance.

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

### Clean Architecture
WIP

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

### Code Organization

The AI Playground project follows structured code organization:

1. Project is divided into packages representing specific domains or layers like `interface_adapter`, `usecase`, `entity`, and `resources`.

2. Within each package, classes are organized based on their functionality and responsibilities.

3. The `test` package contains test classes for unit testing various components of the application.

By organizing the code in this manner, the AI Playground project becomes more maintainable and readable.

### User Stories

1. As a user, I want to see the decision boundary (represented graphically) update and the training loss after every epoch on the graph, superimposed over the input data points.

2. As a user, I want to see how modifying the input dataset (distribution of the data) and the noise of the data (how clustered the points are) affects the decision boundary.

3. As a teacher, I want to show students a highly accessible way of visualizing how changing the number of layers and how many nodes exist in each layer affects the decision boundary.

4. As a Deep Learning enthusiast, I want to see how different input features (the properties applied to the input data before it reaches the neural network) affect the decision boundary.

5. As a user, I want to be able to press a button to start/stop and reset the training of the model.

6. As a user, I want to see how the weights of each feature change (represented by the connection lines between nodes) with the number of epochs.

### Use of GitHub

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
