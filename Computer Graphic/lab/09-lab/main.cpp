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
#include "Libs/stb_image.h"

const GLint WIDTH = 800, HEIGHT = 600;

Window mainWindow;
std::vector<Mesh *> meshList;
std::vector<Shader> shaderList;

// Vertex Shader & Fragment Shader
static const char *vShader = "Shaders/shader.vert";
static const char *fShader = "Shaders/shader.frag";

// Pyramid
static const int NumberPyramid = 10;

// Texture file
static const char *TextureFile = "Textures/abstract.jpg";

void CreateTriangle() {
  GLfloat vertices[] = {-1.0f, -1.0f, 0.0f, 0.0f, 0.0f,  0.0,  -1.0f,
                        1.0f,  0.5f,  0.0f, 1.0f, -1.0f, 0.0f, 1.0f,
                        0.0f,  0.0f,  1.0f, 0.0f, 0.5f,  1.0f};

  unsigned int indices[] = {0, 3, 1, 1, 3, 2, 2, 3, 0, 0, 1, 2};

  int numVertices = sizeof(vertices) / sizeof(vertices[0]);
  int numIndices = sizeof(indices) / sizeof(indices[0]);

  Mesh *obj1 = new Mesh();
  obj1->CreateMesh(vertices, indices, numVertices, numIndices);

  for (int i = 0; i < NumberPyramid; i++) {
    meshList.push_back(obj1);
  }
}

void CreateShaders() {
  Shader *shader1 = new Shader();
  shader1->CreateFromFiles(vShader, fShader);
  shaderList.push_back(*shader1);
}

int main() {
  mainWindow = Window(WIDTH, HEIGHT, 3, 3, "Laboratory 9th");
  mainWindow.initialise();

  CreateTriangle();
  CreateShaders();

  unsigned int texture;

  glGenTextures(1, &texture);
  glBindTexture(GL_TEXTURE_2D, texture);

  glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_S, GL_REPEAT);
  glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_T, GL_REPEAT);
  glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER,
                  GL_LINEAR_MIPMAP_LINEAR);
  glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_LINEAR);

  int width, height, nrChannels;
  stbi_set_flip_vertically_on_load(true);
  unsigned char *data = stbi_load(TextureFile, &width, &height, &nrChannels, 0);

  if (data) {
    glTexImage2D(GL_TEXTURE_2D, 0, GL_RGB, width, height, 0, GL_RGB,
                 GL_UNSIGNED_BYTE, data);
    glGenerateMipmap(GL_TEXTURE_2D);
  } else {
    std::cerr << "Failed to load texture" << std::endl;
  }

  stbi_image_free(data);

  GLfloat bufferWidth = mainWindow.getBufferWidth();
  GLfloat bufferHeight = mainWindow.getBufferHeight();

  if (bufferWidth == 0 || bufferHeight == 0) {
    std::cerr << "Error: Window buffer width or height is zero." << std::endl;
    return -1;
  }

  GLuint uniformModel = 0, uniformProjection = 0, uniformView = 0;

  glm::mat4 projection = glm::ortho(-4.0f, 4.0f, -3.0f, 3.0f, 0.1f, 100.0f);

  while (!mainWindow.getShouldClose()) {
    // Get + Handle user input events
    glfwPollEvents();

    // Clear window
    glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
    glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);

    /* Draw Here */
    shaderList[0].UseShader();

    uniformModel = shaderList[0].getModelLocation();           // Model
    uniformProjection = shaderList[0].getProjectionLocation(); // Projection
    uniformView = shaderList[0].getViewLocation();             // View

    // Model
    glm::mat4 model = glm::mat4(1.0f);

    // Camera
    glm::mat4 view = glm::mat4(1.0f);
    glm::vec3 cameraPosition = glm::vec3(1.0f, 0.5f, 2.0f);
    glm::vec3 cameraTarget = glm::vec3(0.0f, -0.3f, -1.0f);
    glm::vec3 upVector = glm::vec3(0.0f, 1.0f, 0.0f);

    glm::vec3 cameraDirection = glm::normalize(cameraPosition - cameraTarget);
    glm::vec3 cameraRight =
        glm::normalize(glm::cross(upVector, cameraDirection));
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

    view = cameraRotationMatrix * cameraPositionMatrix;

    view = glm::lookAt(cameraPosition, cameraTarget, upVector);

    model = glm::translate(model, glm::vec3(0.3f, 0.0f, -2.5f));
    model = glm::rotate(model, 90.0f * 3.1416f / 180.0f,
                        glm::vec3(0.0f, 0.0f, 1.0f));
    model = glm::scale(model, glm::vec3(0.4f, 0.4f, 1.0f));

    glUniformMatrix4fv(uniformModel, 1, GL_FALSE, glm::value_ptr(model));
    glUniformMatrix4fv(uniformProjection, 1, GL_FALSE,
                       glm::value_ptr(projection));

    glm::vec3 pyramidPositions[] = {
        glm::vec3(0.0f, 0.0f, -2.5f),   glm::vec3(2.0f, 5.0f, -15.0f),
        glm::vec3(-1.5f, -2.2f, -2.5f), glm::vec3(-3.8f, -2.0f, -12.3f),
        glm::vec3(2.4f, -0.4f, -3.5f),  glm::vec3(-1.7f, 3.0f, -7.5f),
        glm::vec3(1.3f, -2.0f, -2.5f),  glm::vec3(1.5f, 2.0f, -2.5f),
        glm::vec3(1.5f, 0.2f, -1.5f),   glm::vec3(-1.3f, 1.0f, -1.5f)};

    for (int i = 0; i < NumberPyramid; i++) {
      glUniformMatrix4fv(uniformView, 1, GL_FALSE, glm::value_ptr(view));

      glm::mat4 model = glm::mat4(1.0f);

      model = glm::translate(model, pyramidPositions[i]);
      model = glm::rotate(model, glm::radians(2.0f * i),
                          glm::vec3(1.0f, 0.3f, 0.5f));
      model = glm::scale(model, glm::vec3(0.8f, 0.8f, 1.0f));

      glUniformMatrix4fv(uniformModel, 1, GL_FALSE, glm::value_ptr(model));
      glUniformMatrix4fv(uniformProjection, 1, GL_FALSE,
                         glm::value_ptr(projection));

      meshList[i]->RenderMesh();
    }

    glActiveTexture(GL_TEXTURE0);
    glBindTexture(GL_TEXTURE_2D, texture);
    meshList[0]->RenderMesh();

    meshList[0]->RenderMesh();

    glUseProgram(0);
    /* End Here */

    mainWindow.swapBuffers();
  }

  return 0;
}
