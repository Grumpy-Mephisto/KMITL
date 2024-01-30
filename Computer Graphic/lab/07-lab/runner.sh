#!/usr/bin/env bash

EXECUTABLE_NAME="OpenGLFirstProject.out"

echo "==================== Running OpenGL project... ===================="

echo "Compiling..."
if g++ main.cpp Libs/Mesh.cpp Libs/Shader.cpp Libs/Window.cpp -lglfw -lGLEW -lGL -o "$EXECUTABLE_NAME"; then
	echo "Compilation successful."

	echo "Running..."
	if ./"$EXECUTABLE_NAME"; then
		echo "Execution successful."
	else
		echo "Error: Execution failed."
	fi

	echo "Cleaning..."
	rm -rf "$EXECUTABLE_NAME"
else
	echo "Error: Compilation failed."
fi

echo "==================== Finished ===================="
