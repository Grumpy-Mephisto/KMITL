#undef GLFW_DLL
#include <iostream>
#include <stdio.h>
#include <string.h>
#include <string>

#include <GL/glew.h>
#include <GLFW/glfw3.h>

#include <cmath>
#include <vector>

#include "Mesh.h"
#include "Shader.h"
#include "Window.h"

const GLint WIDTH = 800, HEIGHT = 600;

Window mainWindow;
std::vector<Mesh *> meshList;
std::vector<Shader> shaderList;

// Vertex Shader
static const char *vShader = "Shaders/shader.vert";

// Fragment Shader
static const char *fShader = "Shaders/shader.frag";

void CreateTriangleFunction() {
  GLfloat vertices[] = {-1.0f, -1.0f, 0.0f, 1.0f, -1.0f,
                        0.0f,  0.0f,  1.0f, 0.0f};

  unsigned int indices[] = {
      0,
      1,
      2,
  };

  Mesh *obj1 = new Mesh();
  obj1->CreateMesh(vertices, indices, 9, 9);
  meshList.push_back(obj1);
}

void CreateShadersFunction() {
  Shader *shader1 = new Shader();
  shader1->CreateFromFiles(vShader, fShader);
  shaderList.push_back(*shader1);
}

// Split the main function into smaller functions
void InitializeWindow() {
  mainWindow = Window(WIDTH, HEIGHT, 3, 3);
  mainWindow.initialise();
}

void RenderLoop() {
  while (!mainWindow.getShouldClose()) {
    glfwPollEvents();
    glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
    glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
    shaderList[0].UseShader();
    meshList[0]->RenderMesh();
    glUseProgram(0);
    mainWindow.swapBuffers();
  }
}

int main() {
  mainWindow = Window(WIDTH, HEIGHT, 3, 3);
  mainWindow.initialise();

  CreateTriangleFunction();
  CreateShadersFunction();

  // for secret room 3 enter - https://forms.gle/U9VE4pkYAPNvUW1H9

  // Loop until window closed
  while (!mainWindow.getShouldClose()) {
    // Get + Handle user input events
    glfwPollEvents();

    // Clear window
    glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
    glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);

    // draw here
    shaderList[0].UseShader();

    // Object
    meshList[0]->RenderMesh();

    glUseProgram(0);
    // end draw

    // magic word - SAKURA

    mainWindow.swapBuffers();
  }

  return 0;
}
