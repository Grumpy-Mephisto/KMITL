#undef GLFW_DLL
#include <iostream>
#include <stdio.h>
#include <string.h>
#include <string>

#include <GL/glew.h>
#include <GLFW/glfw3.h>

#include <glm/glm.hpp>
#include <glm/gtc/matrix_transform.hpp>
#include <glm/gtc/type_ptr.hpp>

#include <cmath>
#include <vector>

#include "Libs/Mesh.h"
#include "Libs/Shader.h"
#include "Libs/Window.h"

const GLint WIDTH = 800, HEIGHT = 600;

Window mainWindow;
std::vector<Mesh *> meshList;
std::vector<Shader> shaderList;

// Vertex Shader
static const char *vShader = "Shaders/shader.vert";

// Fragment Shader
static const char *fShader = "Shaders/shader.frag";

void CreateTriangle() {
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

void CreateShaders() {
  Shader *shader1 = new Shader();
  shader1->CreateFromFiles(vShader, fShader);
  shaderList.push_back(*shader1);
}

void SetShaderColor(Shader &shader, const GLfloat red, const GLfloat green,
                    const GLfloat blue, const GLfloat alpha) {
  GLuint uniformLocation = shader.GetUniformLocation("inputColor");

  if (uniformLocation != GL_INVALID_INDEX) {
    glUniform4f(uniformLocation, red, green, blue, alpha);
  } else {
    std::cerr << "Could not find uniform inputColor location" << std::endl;
  }
}

int main() {
  mainWindow = Window(WIDTH, HEIGHT, 3, 3);
  mainWindow.initialise();

  CreateTriangle();
  CreateShaders();

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

    // Model
    glm::mat4 model = glm::mat4(1.0f); // Identity matrix
    model = glm::translate(
        model, glm::vec3(0.0f, 0.5f, 0.0f)); // Translate by 0.5 on x axis
    model = glm::scale(model,
                       glm::vec3(0.4f, 0.4f, 0.4f)); // Scale by 0.4 on all axis

    // Pass model (matrix) to shader
    unsigned int modelLoc = shaderList[0].GetUniformLocation("model");
    glUniformMatrix4fv(modelLoc, 1, GL_FALSE, glm::value_ptr(model));

    // Set the color
    SetShaderColor(shaderList[0], sinf(glfwGetTime() * 2.0f), 0.0f,
                   cosf(glfwGetTime() * 2.0f), 1.0f);

    // Object
    meshList[0]->RenderMesh();

    glUseProgram(0);
    // end draw

    // magic word - SAKURA

    mainWindow.swapBuffers();
  }

  return 0;
}
