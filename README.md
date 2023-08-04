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

## Code Organization

The project is organized into packages:

- The `data` package contains classes for generating different types of datasets (`CircularDatasetGenerator`, `QuadrantDatasetGenerator`, `SpiralDatasetGenerator`, and `ClusterDatasetGenerator`) and the `DataProcessor` class that generates datasets based on the selected `DatasetGenerator`.

- The `modelling` package contains classes related to building neural networks (`NeuralNet` and `NeuralNetBuilder`) and model training services (`ModelTrainingServices`).

- The `Tests` package contains extensive unit tests to ensure the correctness and reliability of the dataset generation and neural network modules.

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
