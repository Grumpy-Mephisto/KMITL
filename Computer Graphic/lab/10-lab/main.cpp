#undef GLFW_DLL
#include <iostream>
#include <vector>

#include <GL/glew.h>
#include <GLFW/glfw3.h>

#include <glm/glm.hpp>
#include <glm/gtc/matrix_transform.hpp>
#include <glm/gtc/type_ptr.hpp>

class Mesh; // Forward declaration
#include "Libs/Mesh.h"
#include "Libs/Shader.h"
#include "Libs/Window.h"
#include "Libs/stb_image.h"

const GLint WIDTH = 800, HEIGHT = 600;
const char *vShader = "Shaders/shader.vert";
const char *fShader = "Shaders/shader.frag";
const char *TextureFile = "Textures/uvmap_red_green.jpg";
const char *ModelFile = "Models/suzanne.obj";
const int NumberPyramid = 10;

glm::vec3 cameraPosition(1.0f, 0.5f, 2.0f);
glm::vec3 cameraDirection(0.0f, 0.0f, -1.0f);
glm::vec3 upVector(0.0f, 1.0f, 0.0f);


std::vector<Mesh *> meshList;
std::vector<Shader> shaderList;
GLuint texture;

void CreateTriangle() {
  GLfloat vertices[] = {-1.0f, -1.0f, 0.0f, 0.0f, 0.0f,  0.0,  -1.0f,
                        1.0f,  0.5f,  0.0f, 1.0f, -1.0f, 0.0f, 1.0f,
                        0.0f,  0.0f,  1.0f, 0.0f, 0.5f,  1.0f};

  unsigned int indices[] = {0, 3, 1, 1, 3, 2, 2, 3, 0, 0, 1, 2};

  int numVertices = sizeof(vertices) / sizeof(vertices[0]);
  int numIndices = sizeof(indices) / sizeof(indices[0]);

  Mesh *obj1 = new Mesh();
  obj1->CreateMesh(vertices, indices, numVertices, numIndices);

  meshList.assign(NumberPyramid, obj1);
}

void CreateShaders() {
  Shader *shader1 = new Shader();
  shader1->CreateFromFiles(vShader, fShader);
  shaderList.push_back(*shader1);
}

void CreateObjects() {
  Mesh *obj1 = new Mesh();
  bool loaded = obj1->CreateMeshFromOBJ(ModelFile);

  if (loaded) {
    meshList.assign(NumberPyramid, obj1);
  } else {
    std::cerr << "Failed to load object" << std::endl;
  }
}

void InitializeTexture() {
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
    GLenum format = (nrChannels == 3) ? GL_RGB : GL_RGBA;
    glTexImage2D(GL_TEXTURE_2D, 0, format, width, height, 0, format,
                 GL_UNSIGNED_BYTE, data);
    glGenerateMipmap(GL_TEXTURE_2D);
  } else {
    std::cerr << "Failed to load texture" << std::endl;
  }

  stbi_image_free(data);
}

int main() {
  
  CreateObjects();
  CreateShaders();
  InitializeTexture();

  
  

  if (bufferWidth == 0 || bufferHeight == 0) {
    std::cerr << "Error: Window buffer width or height is zero." << std::endl;
    return -1;
  }

  GLuint uniformModel = 0, uniformProjection = 0, uniformView = 0;
  

  while (!mainWindow.getShouldClose()) {
    // Get + Handle user input events
    glfwPollEvents();

    // Handle Keyboard Input for Camera Movement
    const float cameraSpeed = 0.05f;

    if (glfwGetKey(mainWindow.getMainWindow(), GLFW_KEY_W) == GLFW_PRESS) {
      cameraPosition += cameraSpeed * cameraDirection;
    }
    if (glfwGetKey(mainWindow.getMainWindow(), GLFW_KEY_S) == GLFW_PRESS) {
      cameraPosition -= cameraSpeed * cameraDirection;
    }
    if (glfwGetKey(mainWindow.getMainWindow(), GLFW_KEY_A) == GLFW_PRESS) {
      cameraPosition -=
          glm::normalize(glm::cross(cameraDirection, upVector)) * cameraSpeed;
    }
    if (glfwGetKey(mainWindow.getMainWindow(), GLFW_KEY_D) == GLFW_PRESS) {
      cameraPosition +=
          glm::normalize(glm::cross(cameraDirection, upVector)) * cameraSpeed;
    }
    if (glfwGetKey(mainWindow.getMainWindow(), GLFW_KEY_Q) == GLFW_PRESS) {
      cameraPosition += glm::vec3(0.0f, 1.0f, 0.0f) * cameraSpeed;
    }
    if (glfwGetKey(mainWindow.getMainWindow(), GLFW_KEY_E) == GLFW_PRESS) {
      cameraPosition -= glm::vec3(0.0f, 1.0f, 0.0f) * cameraSpeed;
    }

    // Clear window
    glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
    glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);

    /* Draw Here */
    shaderList[0].UseShader();

    uniformModel = shaderList[0].getModelLocation();    
uniformView = shaderList[0].getViewLocation();             // View

    // Model
    glm::mat4 model = glm::mat4(1.0f);

    // Camera
    glm::mat4 view =
        glm::lookAt(cameraPosition, cameraPosition + cameraDirection, upVector);

    model = glm::translate(model, glm::vec3(0.3f, 0.0f, -2.5f));
    model = glm::rotate(model, 90.0f * 3.1416f / 180.0f,
                        glm::vec3(0.0f, 0.0f, 1.0f));
    model = glm::scale(model, glm::vec3(0.4f, 0.4f, 1.0f));

    glUniformMatrix4fv(uniformModel, 1, GL_FALSE, glm::value_ptr(model));
    glUniformMatrix4fv(uniformProjection, 1, GL_FALSE,
                       glm::value_ptr(projection));
    glUniformMatrix4fv(uniformView, 1, GL_FALSE, glm::value_ptr(view));

    glm::vec3 pyramidPositions[] = {
        glm::vec3(0.0f, 0.0f, -2.5f),   glm::vec3(2.0f, 5.0f, -15.0f),
        glm::vec3(-1.5f, -2.2f, -2.5f), glm::vec3(-3.8f, -2.0f, -12.3f),
        glm::vec3(2.4f, -0.4f, -3.5f),  glm::vec3(-1.7f, 3.0f, -7.5f),
        glm::vec3(1.3f, -2.0f, -2.5f),  glm::vec3(1.5f, 2.0f, -2.5f),
        glm::vec3(1.5f, 0.2f, -1.5f),   glm::vec3(-1.3f, 1.0f, -1.5f)};

    for (int i = 0; i < NumberPyramid; i++) {
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

    glUseProgram(0);
    /* End Here */

    mainWindow.swapBuffers();
  }

  return 0;
}
