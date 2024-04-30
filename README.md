# Manjul Balayar and Devin Alamsya

# MVC Calculator Application

This document provides detailed instructions on how to deploy and use the MVC-based calculator application. The application is structured using the Model-View-Controller (MVC) architecture to separate the logic, user interface, and control flow.

## Prerequisites

Before you start, ensure you have the following installed:
- **Java Development Kit (JDK)** 1.8 or later
- An **Integrated Development Environment (IDE)** like IntelliJ IDEA, Eclipse, or VSCode

## Deployment

To deploy the calculator application, follow these steps:

1. **Clone the Repository**
   - Use Git to clone the source repository from GitHub. Open your terminal and run the following command:
   git clone https://github.com/ManjulBalayar/Lab7.git
   cd Lab7

2. **Open the Project**
- Open your IDE and import the project. Most IDEs have an option to open or import projects from the file system.

3. **Build the Project**
- Use your IDE’s build functionality to compile the project. This is often found under the "Build" menu.

4. **Run the Application**
- Navigate to the `CalculatorMain` class, right-click on it, and select "Run" from the context menu. Alternatively, use the IDE's run configuration settings to start the application.

## Usage Instructions

Once the application is running, you can use the calculator to perform basic arithmetic operations and memory functions.

### Performing Calculations

- **Basic Operations**: Use the numeric buttons (0-9) to enter numbers, and the operation buttons (+, -, *, /) to perform calculations.
- **Calculate**: Press the "=" button to display the result of the calculation.
- **Clear**: Press the "AC" button to clear the current input and start a new calculation.

### Using Memory Functions

- **Memory Add (M+)**: Adds the current display value to the memory.
- **Memory Subtract (M-)**: Subtracts the current display value from the memory.
- **Memory Recall (MR)**: Displays the current value stored in memory.
- **Memory Clear (MC)**: Clears the stored memory value.

### Advanced Operations

- **Square (x^2)**: Calculates the square of the current number.
- **Square Root (Sqrt)**: Calculates the square root of the current number.

## Contributing

Contributions to enhance the calculator are welcome. Please follow these steps:

1. Fork the repository.
2. Create a new branch (`git checkout -b feature-branch`).
3. Make your changes and commit them (`git commit -am 'Add some feature'`).
4. Push to the branch (`git push origin feature-branch`).
5. Create a new Pull Request.

## License

This project is licensed under the MIT License - see the LICENSE.md file for details.
