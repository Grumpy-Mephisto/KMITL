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

/**
 * CreateTriangle - Create a triangle mesh and add it to the mesh list.
 */
void CreateTriangle() {
  GLfloat vertices[] = {-1.0f, -1.0f, 0.0f, 1.0f, -1.0f,
                        0.0f,  0.0f,  1.0f, 0.0f};

  unsigned int indices[] = {0, 3, 1, 1, 3, 2, 2, 3, 0, 0, 1, 2};

  int numVertices = sizeof(vertices) / sizeof(vertices[0]);
  int numIndices = sizeof(indices) / sizeof(indices[0]);

  Mesh *obj1 = new Mesh();
  obj1->CreateMesh(vertices, indices, numVertices, numIndices);
  meshList.push_back(obj1);
}

/**
 * CreateShaders - Create shaders and add them to the shader list.
 */
void CreateShaders() {
  Shader *shader1 = new Shader();
  shader1->CreateFromFiles(vShader, fShader);
  shaderList.push_back(*shader1);
}

/**
 * SetShaderColor - Set the color for the given shader.
 *
 * @param shader - The shader for which the color needs to be set.
 * @param red - The value of the red channel (0.0 - 1.0).
 * @param green - The value of the green channel (0.0 - 1.0).
 */
void SetShaderColor(Shader &shader, const GLfloat red, const GLfloat green,
                    const GLfloat blue, const GLfloat alpha) {
  GLuint uniformLocation = shader.GetUniformLocation("inputColor");

  if (uniformLocation != GL_INVALID_INDEX) {
    glUniform4f(uniformLocation, red, green, blue, alpha);
  } else {
    std::cerr << "Could not find uniform inputColor location" << std::endl;
  }
}

/**
 * main - The main function for the program.
 *
 * @return int - The exit code.
 */
int main() {
  mainWindow = Window(WIDTH, HEIGHT, 3, 3);
  mainWindow.initialise();

  CreateTriangle();
  CreateShaders();

  CreateTriangle();

  // Get buffer size information
  GLfloat bufferWidth = mainWindow.getBufferWidth();
  GLfloat bufferHeight = mainWindow.getBufferHeight();

  // Check if buffer width or height is zero
  if (bufferWidth == 0 || bufferHeight == 0) {
    std::cerr << "Error: Window buffer width or height is zero." << std::endl;
    return -1;
  }

  // Declare variables for Model
  GLuint uniformModel = 0, uniformProjection = 0;

  glm::mat4 projection =
      glm::perspective(45.0f, bufferWidth / bufferHeight, 0.1f, 100.0f);

  // Loop until window closed
  /**
   * While loop to handle program execution while the main window is open.
   */
  while (!mainWindow.getShouldClose()) {
    // Get + Handle user input events
    glfwPollEvents();

    // Clear window
    glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
    glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);

    // draw here
    shaderList[0].UseShader();

    // Model
    uniformModel = shaderList[0].GetModelLocation();
    uniformProjection = shaderList[0].GetProjectionLocation();

    glm::mat4 model1 = glm::mat4(1.0f);

    // model1 = glm::translate(model1, glm::vec3(0.3f, 0.0f, -2.5f));

    model1 = glm::translate(model1, glm::vec3(0.3f, 0.0f, -2.5f));
    model1 = glm::rotate(model1, 90.0f * 3.1416f / 180.0f,
                         glm::vec3(0.0f, 0.0f, 1.0f));
    /**
     * Scale the model by the given factors.
     *
     * @param model1 - The model to be scaled.
     * @param glm::vec3(0.4f, 0.4f, 1.0f) - The scale factors along the x, y, and z axes.
     */
    model1 = glm::scale(model1, glm::vec3(0.4f, 0.4f, 1.0f));

    // Pass the matrices to the shader (projection, model)
    glUniformMatrix4fv(uniformModel, 1, GL_FALSE, glm::value_ptr(model1));
    glUniformMatrix4fv(uniformProjection, 1, GL_FALSE,
                       glm::value_ptr(projection));

    // Set shader color
    float timeValue = glfwGetTime();
    float redValue =
        sinf(timeValue * 1.0f) * 0.5f + 0.5f; // Frequency = 1.0, range [0, 1]
    float greenValue = sinf(timeValue * 1.2f + 2.0f) * 0.5f +
                       0.5f; // Frequency = 1.2, phase offset
    float blueValue =
        cosf(timeValue * 1.0f) * 0.5f + 0.5f; // Frequency = 1.0, range [0, 1]

    SetShaderColor(shaderList[0], redValue, greenValue, blueValue, 1.0f);

    // Object
    meshList[0]->RenderMesh();

    // Another object
    glm::mat4 model2 = glm::mat4(1.0f);

    model2 = glm::translate(model2, glm::vec3(-0.3f, 0.0f, -2.5f));
    model2 = glm::scale(model2, glm::vec3(0.4f, 0.4f, 1.0f));

    glUniformMatrix4fv(uniformModel, 1, GL_FALSE, glm::value_ptr(model2));

    meshList[0]->RenderMesh();

    glUseProgram(0);
    /**
     * Perform end of draw operations.
     */
    // end draw

    mainWindow.swapBuffers();
  }

  return 0;
}
