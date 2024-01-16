#!/usr/bin/env bash

# This script is used to run the OpenGL project
echo "==================== Running OpenGL project... ===================="

echo "Compiling..."
g++ main.cpp Libs/Mesh.cpp Libs/Shader.cpp Libs/Window.cpp -lglfw -lGLEW -lGL -o OpenGLFirstProject.out

echo "Running..."
./OpenGLFirstProject.out