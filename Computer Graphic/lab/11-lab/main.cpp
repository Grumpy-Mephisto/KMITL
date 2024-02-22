#undef GLFW_DLL
#include <GL/glew.h>
#include <GLFW/glfw3.h>
#include <glm/glm.hpp>
#include <glm/gtc/matrix_transform.hpp>
#include <glm/gtc/type_ptr.hpp>
#include <iostream>
#include <stdio.h>
#include <string.h>
#include <string>

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

// Vertex Shader
static const char *vShader = "Shaders/shader.vert";

// Fragment Shader
static const char *fShader = "Shaders/shader.frag";

void CreateTriangle() {
  GLfloat vertices[] = {// pos //TexCoord
                        -1.0f, -1.0f, 0.0f, 0.0f, 0.0f,  0.0,  -1.0f,
                        1.0f,  0.5f,  0.0f, 1.0f, -1.0f, 0.0f, 1.0f,
                        0.0f,  0.0f,  1.0f, 0.0f, 0.5f,  1.0f};
  unsigned int indices[] = {0, 3, 1, 1, 3, 2, 2, 3, 0, 0, 1, 2};

  Mesh *obj1 = new Mesh();
  obj1->CreateMesh(vertices, indices, 20, 12);
  for (int i = 0; i < 10; i++) {
    meshList.push_back(obj1);
  }
}

void CreateOBJ() {
  Mesh *obj1 = new Mesh();
  bool loaded = obj1->CreateMeshFromOBJ("Models/suzanne.obj");
  // bool loaded = obj1->CreateMeshFromOBJ("Models/Test.obj");

  if (loaded) {
    for (int i = 0; i < 10; i++) {
      meshList.push_back(obj1);
    }
    std::cout << "model Loaded" << std::endl;
  } else {
    std::cout << "Failed to load model" << std::endl;
  }
}

void CreateShaders() {
  Shader *shader1 = new Shader();
  shader1->CreateFromFiles(vShader, fShader);
  shaderList.push_back(*shader1);
}

int main() {
  mainWindow = Window(WIDTH, HEIGHT, 3, 3);
  mainWindow.initialise();

  // CreateTriangle();
  CreateOBJ();
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
  unsigned char *data = stbi_load("Textures/uvmap.png", &width, &height,
                                  &nrChannels, 0); // test png

  if (data) {
    if (nrChannels == 3) {
      glTexImage2D(GL_TEXTURE_2D, 0, GL_RGB, width, height, 0, GL_RGB,
                   GL_UNSIGNED_BYTE, data);
    } else if (nrChannels == 4) {
      glTexImage2D(GL_TEXTURE_2D, 0, GL_RGBA, width, height, 0, GL_RGBA,
                   GL_UNSIGNED_BYTE, data);
    } else {
      std::cout << "nrChannels not 3 or 4" << std::endl;
      return 1;
    }

    glGenerateMipmap(GL_TEXTURE_2D);
  } else {
    std::cout << "Failed to load texture" << std::endl;
  }
  stbi_image_free(data);

  GLuint uniformModel = 0, uniformProjection = 0, uniformView = 0;
  glm::mat4 projection =
      glm::perspective(45.0f,
                       (GLfloat)mainWindow.getBufferWidth() /
                           (GLfloat)mainWindow.getBufferHeight(),
                       0.1f, 100.0f);
  // glm::mat4 projection = glm::ortho(-4.0f, 4.0f, -3.0f, 3.0f, 0.1f, 100.0f);

  glm::mat4 view(1.0f);
  glm::vec3 cameraPos = glm::vec3(0.0f, 0.0f, 10.0f);
  glm::vec3 cameraTarget = glm::vec3(0.0f, 0.0f, -1.0f);
  glm::vec3 up = glm::vec3(0.0f, 1.0f, 0.0f);
  glm::vec3 cameraDirection = glm::normalize(cameraTarget - cameraPos);
  glm::vec3 cameraRight = glm::normalize(glm::cross(cameraDirection, up));
  glm::vec3 cameraUp = glm::normalize(glm::cross(cameraRight, cameraDirection));
  glm::mat4 cameraPosMat(1.0f);
  glm::mat4 cameraRotateMat(1.0f);

  // Loop until window closed
  while (!mainWindow.getShouldClose()) {
    // Get + Handle user input events
    glfwPollEvents();

    // Clear window
    glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
    glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);

    // draw here
    shaderList[0].UseShader();
    uniformModel = shaderList[0].GetUniformLocation("model");
    uniformProjection = shaderList[0].GetUniformLocation("projection");
    uniformView = shaderList[0].GetUniformLocation("view");
    glm::vec3 pyramidPositions[] = {
        glm::vec3(0.0f, 0.0f, -2.5f),   glm::vec3(2.0f, 5.0f, -15.0f),
        glm::vec3(-1.5f, -2.2f, -2.5f), glm::vec3(-3.8f, -2.0f, -12.3f),
        glm::vec3(2.4f, -0.4f, -3.5f),  glm::vec3(-1.7f, 3.0f, -7.5f),
        glm::vec3(1.3f, -2.0f, -2.5f),  glm::vec3(1.5f, 2.0f, -2.5f),
        glm::vec3(1.5f, 0.2f, -1.5f),   glm::vec3(-1.3f, 1.0f, -1.5f)};

    // camera
    float cameraSpeed = 0.05f;
    if (glfwGetKey(mainWindow.getWindow(), GLFW_KEY_W) == GLFW_PRESS)
      cameraPos.z -= cameraSpeed;
    if (glfwGetKey(mainWindow.getWindow(), GLFW_KEY_S) == GLFW_PRESS)
      cameraPos.z += cameraSpeed;
    if (glfwGetKey(mainWindow.getWindow(), GLFW_KEY_A) == GLFW_PRESS)
      cameraPos.x -= cameraSpeed;
    if (glfwGetKey(mainWindow.getWindow(), GLFW_KEY_D) == GLFW_PRESS)
      cameraPos.x += cameraSpeed;
    if (glfwGetKey(mainWindow.getWindow(), GLFW_KEY_LEFT_SHIFT) == GLFW_PRESS)
      cameraPos.y -= cameraSpeed;
    if (glfwGetKey(mainWindow.getWindow(), GLFW_KEY_SPACE) == GLFW_PRESS)
      cameraPos.y += cameraSpeed;
    if (glfwGetKey(mainWindow.getWindow(), GLFW_KEY_LEFT) == GLFW_PRESS) {
      cameraRotateMat =
          glm::rotate(cameraRotateMat, glm::radians(0.05f), glm::vec3(0, 1, 0));
    }
    if (glfwGetKey(mainWindow.getWindow(), GLFW_KEY_RIGHT) == GLFW_PRESS) {
      cameraRotateMat = glm::rotate(cameraRotateMat, glm::radians(-0.05f),
                                    glm::vec3(0, 1, 0));
    }
    cameraPosMat[3][0] = -cameraPos.x;
    cameraPosMat[3][1] = -cameraPos.y;
    cameraPosMat[3][2] = -cameraPos.z;

    // cameraRotateMat[0] = glm::vec4(cameraRight.x, cameraUp.x,
    // -cameraDirection.x, 0.0f); cameraRotateMat[1] = glm::vec4(cameraRight.y,
    // cameraUp.y, -cameraDirection.y, 0.0f); cameraRotateMat[2] =
    // glm::vec4(cameraRight.z, cameraUp.z, -cameraDirection.z, 0.0f);
    view = cameraRotateMat * cameraPosMat;
    // view = glm::lookAt(cameraPos, cameraPos + cameraDirection, cameraUp);

    // moving camera

    // Object
    for (int i = 0; i < 10; i++) {
      glUniformMatrix4fv(uniformView, 1, GL_FALSE, glm::value_ptr(view));
      glm::mat4 model(1.0f);
      model = glm::translate(model, pyramidPositions[i]);
      model = glm::rotate(model, glm::radians(2.0f * i),
                          glm::vec3(1.0f, 0.3f, 0.5f));
      model = glm::scale(model, glm::vec3(0.8f, 0.8f, 1.0f));
      glUniformMatrix4fv(uniformModel, 1, GL_FALSE, glm::value_ptr(model));
      glUniformMatrix4fv(uniformProjection, 1, GL_FALSE,
                         glm::value_ptr(projection));
      glActiveTexture(GL_TEXTURE0);
      glBindTexture(GL_TEXTURE_2D, texture);
      meshList[i]->RenderMesh();
    }

    glUseProgram(0);

    mainWindow.swapBuffers();
  }

  return 0;
}
