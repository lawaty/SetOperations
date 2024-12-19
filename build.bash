echo "Compiling Java files..."
find . -name "*.java" -exec javac {} +

echo "Building jar..."
jar cvfe ./SetOperations.jar SetOperations.part2 $(find . -name '*.class')

echo "Here is the jar content"
jar tf ./SetOperations.jar