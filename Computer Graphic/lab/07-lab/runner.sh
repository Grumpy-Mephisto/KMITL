#!/usr/bin/env bash

# Default executable name
DEFAULT_EXEC_NAME="OpenGLFirstProject.out"

# Function to check dependencies
check_dependencies() {
    local dependencies=("g++")
    for dep in "${dependencies[@]}"; do
        if ! command -v "$dep" &> /dev/null; then
            echo "Error: Dependency $dep not found."
            exit 1
        fi
    done
}

# Function to compile the project
compile_project() {
    echo "Compiling..."
    if g++ main.cpp Libs/Mesh.cpp Libs/Shader.cpp Libs/Window.cpp -lglfw -lGLEW -lGL -o "$1"; then
        echo "Compilation successful."
    else
        echo "Error: Compilation failed."
        exit 1
    fi
}

# Function to run the project
run_project() {
    echo "Running..."
    if ./"$1"; then
        echo "Execution successful."
    else
        echo "Error: Execution failed."
        exit 1
    fi
}

# Function to clean up
clean_up() {
    echo "Cleaning..."
    rm -rf "$1"
    echo "Cleaned."
}

# Main script starts here
echo "==================== Running OpenGL project... ===================="

# Clean up any previous builds
clean_up "$DEFAULT_EXEC_NAME"

# Check for dependencies
check_dependencies

# Get or set the executable name
EXECUTABLE_NAME="${1:-$DEFAULT_EXEC_NAME}"

# Compile and run by default, or based on passed arguments
case "$2" in
    compile-only)
        compile_project "$EXECUTABLE_NAME"
        ;;
    run-only)
        run_project "$EXECUTABLE_NAME"
        ;;
    *)
        compile_project "$EXECUTABLE_NAME"
        run_project "$EXECUTABLE_NAME"
        clean_up "$EXECUTABLE_NAME"
        ;;
esac

echo "==================== Finished ===================="
