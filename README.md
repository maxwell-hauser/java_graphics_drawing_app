# Graphics Drawing App

A simple Java AWT/Swing app to input and visualize 2D/3D geometric shapes and compute their properties.

## Requirements
- JDK 21 (Temurin recommended)
- Maven 3.9+

## Run (without Maven)
```powershell
# From this folder
javac *.java
java graphics_drawing_app
```

## Build and run (Maven)
```powershell
# From this folder
mvn -DskipTests package
java -jar target/graphics-drawing-app-1.0.0.jar
```

## Notes
- Uses AWT `Frame` and Swing dialogs (`JOptionPane`).
- Shape calculations handle floating-point math where needed (e.g., diamond perimeter/area).
- Line endings normalized via `.gitattributes` to avoid CRLF/LF warnings on Windows.
