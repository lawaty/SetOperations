echo "Compiling Java files..."
find . -name "*.java" -exec javac {} +

echo "Building jar..."
jar cvfe ./BitNumOperations.jar BitNumOperations.part1 $(find . -name '*.class')

echo "Here is the jar content"
jar tf ./BitNumOperations.jar