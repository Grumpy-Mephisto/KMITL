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

#define NumPyramid 10

const GLint WIDTH = 800, HEIGHT = 600;

Window mainWindow;
std::vector<Mesh *> meshList;
std::vector<Shader> shaderList;

// Vertex Shader
static const char *vShader = "Shaders/shader.vert";

// Fragment Shader
static const char *fShader = "Shaders/shader.frag";

void CreateTriangle() {
  GLfloat vertices[] = {-1.0f, -1.0f, 0.0f, 0.0f, -1.0f, 1.0f,
                        1.0f,  -1.0f, 0.0f, 0.0f, 1.0f,  0.0f};

  unsigned int indices[] = {0, 3, 1, 1, 3, 2, 2, 3, 0, 0, 1, 2};

  int numVertices = sizeof(vertices) / sizeof(vertices[0]);
  int numIndices = sizeof(indices) / sizeof(indices[0]);

  Mesh *obj1 = new Mesh();
  obj1->CreateMesh(vertices, indices, numVertices, numIndices);

  for (int i = 0; i < NumPyramid; i++) {
    meshList.push_back(obj1);
  }
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

  // Get buffer size information
  GLfloat bufferWidth = mainWindow.getBufferWidth();
  GLfloat bufferHeight = mainWindow.getBufferHeight();

  // Check if buffer width or height is zero
  if (bufferWidth == 0 || bufferHeight == 0) {
    std::cerr << "Error: Window buffer width or height is zero." << std::endl;
    return -1;
  }

  // Declare variables for Model
  GLuint uniformModel = 0, uniformProjection = 0, uniformView = 0;

  // glm::mat4 projection =
  //     glm::perspective(45.0f, bufferWidth / bufferHeight, 0.1f, 100.0f); //
  //     Perspective

  glm::mat4 projection = glm::ortho(-4.0f, 4.0f, -3.0f, 3.0f, 0.1f,
                                    100.0f); // Orthographic projection

  // Loop until window closed
  while (!mainWindow.getShouldClose()) {
    // Get + Handle user input events
    glfwPollEvents();

    // Clear window
    glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
    glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);

    // draw here
    shaderList[0].UseShader();

    uniformModel = shaderList[0].GetModelLocation();           // Model
    uniformProjection = shaderList[0].GetProjectionLocation(); // Projection
    uniformView = shaderList[0].GetViewLocation();             // View

    // Model
    glm::mat4 model = glm::mat4(1.0f); // Identity matrix

    // Camera
    glm::mat4 view = glm::mat4(1.0f); // Identity matrix
    // glm::vec3 cameraPosition = glm::vec3(0.0f, 0.0f, 0.0f);
    // glm::vec3 cameraTarget = glm::vec3(0.0f, 0.0f, -1.0f);
    // glm::vec3 upVector = glm::vec3(0.0f, 1.0f, 0.0f);
    glm::vec3 cameraPosition = glm::vec3(1.0f, 0.5f, 2.0f);
    glm::vec3 cameraTarget = glm::vec3(0.0f, -0.3f, -1.0f);
    glm::vec3 upVector = glm::vec3(0.0f, 1.0f, 0.0f);

    glm::vec3 cameraDirection = glm::normalize(cameraPosition - cameraTarget);
    glm::vec3 cameraRight =
        glm::normalize(glm::cross(upVector, cameraDirection)); // Cross product
    glm::vec3 cameraUp = glm::cross(cameraDirection, cameraRight);

    glm::mat4 cameraPositionMatrix = glm::mat4(1.0f);
    cameraPositionMatrix[3][0] = -cameraPosition.x;
    cameraPositionMatrix[3][1] = -cameraPosition.y;
    cameraPositionMatrix[3][2] = -cameraPosition.z;

    glm::mat4 cameraRotationMatrix = glm::mat4(1.0f);
    cameraRotationMatrix[0] =
        glm::vec4(cameraRight.x, cameraUp.x, cameraDirection.x, 0.0f);
    cameraRotationMatrix[1] =
        glm::vec4(cameraRight.y, cameraUp.y, cameraDirection.y, 0.0f);
    cameraRotationMatrix[2] =
        glm::vec4(cameraRight.z, cameraUp.z, cameraDirection.z, 0.0f);

    view = cameraRotationMatrix * cameraPositionMatrix; // Order matters

    view = glm::lookAt(cameraPosition, cameraTarget, upVector);

    // model = glm::translate(model, glm::vec3(0.3f, 0.0f, -2.5f));

    model = glm::translate(model, glm::vec3(0.3f, 0.0f, -2.5f));
    model = glm::rotate(model, 90.0f * 3.1416f / 180.0f,
                        glm::vec3(0.0f, 0.0f, 1.0f));
    model = glm::scale(model, glm::vec3(0.4f, 0.4f, 1.0f));

    // Pass the matrices to the shader (projection, model)
    glUniformMatrix4fv(uniformModel, 1, GL_FALSE, glm::value_ptr(model));
    glUniformMatrix4fv(uniformProjection, 1, GL_FALSE,
                       glm::value_ptr(projection));

    // Pyramid
    glm::vec3 pyramidPositions[] = {
        glm::vec3(0.0f, 0.0f, -2.5f),   glm::vec3(2.0f, 5.0f, -15.0f),
        glm::vec3(-1.5f, -2.2f, -2.5f), glm::vec3(-3.8f, -2.0f, -12.3f),
        glm::vec3(2.4f, -0.4f, -3.5f),  glm::vec3(-1.7f, 3.0f, -7.5f),
        glm::vec3(1.3f, -2.0f, -2.5f),  glm::vec3(1.5f, 2.0f, -2.5f),
        glm::vec3(1.5f, 0.2f, -1.5f),   glm::vec3(-1.3f, 1.0f, -1.5f)};

    for (int i = 0; i < NumPyramid; i++) {
      glUniformMatrix4fv(uniformView, 1, GL_FALSE, glm::value_ptr(view));

      glm::mat4 model = glm::mat4(1.0f); // Identity matrix

      model = glm::translate(model, pyramidPositions[i]);
      model = glm::rotate(model, glm::radians(2.0f * i),
                          glm::vec3(1.0f, 0.3f, 0.5f));
      model = glm::scale(model, glm::vec3(0.8f, 0.8f, 1.0f));

      glUniformMatrix4fv(uniformModel, 1, GL_FALSE, glm::value_ptr(model));
      glUniformMatrix4fv(uniformProjection, 1, GL_FALSE,
                         glm::value_ptr(projection));

      meshList[i]->RenderMesh();
    }

    // Set shader color
    float timeValue = glfwGetTime();
    float redValue = sinf(timeValue * 1.0f) * 0.5f + 0.5f;
    float greenValue = sinf(timeValue * 1.2f + 2.0f) * 0.5f + 0.5f;
    float blueValue = cosf(timeValue * 1.0f) * 0.5f + 0.5f;

    SetShaderColor(shaderList[0], redValue, greenValue, blueValue, 1.0f);

    // Object
    meshList[0]->RenderMesh();

    glUseProgram(0);
    // end draw

    mainWindow.swapBuffers();
  }

  return 0;
}
