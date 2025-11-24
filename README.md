# Graphics Drawing App

![Java](https://img.shields.io/badge/Java-21-ED8B00?style=flat&logo=openjdk&logoColor=white)
![Maven](https://img.shields.io/badge/Maven-3.9+-C71A36?style=flat&logo=apache-maven)
![License](https://img.shields.io/badge/License-MIT-blue?style=flat)
![Status](https://img.shields.io/badge/Status-Active-success?style=flat)

A Java AWT/Swing desktop application for visualizing and calculating properties of 2D and 3D geometric shapes with an intuitive graphical interface.

## ✨ Features

- **Visual Shape Rendering**: Draw shapes on canvas
- **2D Shapes**: Line, Triangle, Rectangle, Diamond
- **3D Shapes**: Cube, Cylinder, Cone, Sphere, Triangular Prism
- **Property Calculations**: Area, volume, surface area, perimeter
- **Interactive Input**: Dialog-based coordinate and dimension entry
- **Floating-Point Precision**: Accurate calculations for complex shapes
- **Cross-Platform**: Runs on Windows, macOS, and Linux

## 🚀 Quick Start

### Using Maven (Recommended)

```powershell
# Build the project
mvn clean package

# Run the application
java -jar target/graphics-drawing-app-1.0.1.jar
```

### Without Maven

```powershell
# Compile all files
javac *.java

# Run
java GraphicsDrawingApp
```

## 📖 Usage

1. Launch the application
2. Select a shape from the menu
3. Enter required coordinates or dimensions
4. View the shape drawn on canvas
5. See calculated properties in dialogs

## 📐 Supported Shapes

### 2D Shapes
- **Line**: Length from two endpoints
- **Triangle**: Area and perimeter from vertices
- **Rectangle**: Area and perimeter from corners
- **Diamond**: Area and perimeter from diagonals

### 3D Shapes
- **Cube**: Surface area and volume
- **Cylinder**: Surface area and volume
- **Cone**: Surface area and volume
- **Sphere**: Surface area and volume
- **Triangular Prism**: Surface area and volume

## 📋 Requirements

- **JDK 21** (Temurin recommended)
- **Maven 3.9+**

## 🏗️ Building from Source

```powershell
# Clone the repository
git clone https://github.com/maxwell-hauser/java_graphics_drawing_app.git
cd java_graphics_drawing_app

# Build with Maven
mvn clean install

# Run tests
mvn test
```

## 📄 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## 👤 Author

**Maxwell Hauser**

## 🤝 Contributing

Contributions, issues, and feature requests are welcome! Feel free to check the [issues page](https://github.com/maxwell-hauser/java_graphics_drawing_app/issues).
