#undef GLFW_DLL
#include <iostream>
#include <vector>

#include <GL/glew.h>
#include <GLFW/glfw3.h>

#include <glm/glm.hpp>
#include <glm/gtc/matrix_transform.hpp>
#include <glm/gtc/type_ptr.hpp>

#include "Libs/Mesh.h"
#include "Libs/Shader.h"
#include "Libs/Window.h"
#include "Libs/stb_image.h"

const GLint WIDTH = 800, HEIGHT = 600;
const char *vShader = "Shaders/shader.vert";
const char *fShader = "Shaders/shader.frag";
const char *TextureFile = "Textures/uvmap.png";

Window mainWindow;
std::vector<Mesh *> meshList;
std::vector<Shader> shaderList;

void CreateTriangle() {
  GLfloat vertices[] = {-1.0f, -1.0f, 0.0f, 0.0f, 0.0f,  0.0,  -1.0f,
                        1.0f,  0.5f,  0.0f, 1.0f, -1.0f, 0.0f, 1.0f,
                        0.0f,  0.0f,  1.0f, 0.0f, 0.5f,  1.0f};
  unsigned int indices[] = {0, 3, 1, 1, 3, 2, 2, 3, 0, 0, 1, 2};

  int numVertices = sizeof(vertices) / sizeof(vertices[0]);
  int numIndices = sizeof(indices) / sizeof(indices[0]);

  Mesh *obj1 = new Mesh();
  obj1->CreateMesh(vertices, indices, numVertices, numIndices);

  for (int i = 0; i < 10; i++) {
    meshList.push_back(obj1);
  }
}

void CreateObjects(const char *ModelFile = "Models/suzanne.obj") {
  Mesh *obj1 = new Mesh();
  bool loaded = obj1->CreateMeshFromOBJ(ModelFile);

  if (loaded) {
    for (int i = 0; i < 10; i++) {
      meshList.push_back(obj1);
    }

    std::cout << "Successfully loaded model" << std::endl;
  } else {
    std::cout << "Failed to load model" << std::endl;
  }
}

void CreateShaders(const char *vShader = "Shaders/shader.vert",
                   const char *fShader = "Shaders/shader.frag") {
  Shader *shader1 = new Shader();
  shader1->CreateFromFiles(vShader, fShader);
  shaderList.push_back(*shader1);
}

int main() {
  mainWindow = Window(WIDTH, HEIGHT, 3, 3, "Laboratory 12th");
  mainWindow.initialise();

  // CreateTriangle();
  CreateObjects("Models/suzanne.obj");
  CreateShaders("Shaders/shader.vert", "Shaders/shader.frag");

  unsigned int texture;
  glGenTextures(1, &texture);
  glBindTexture(GL_TEXTURE_2D, texture);
  glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_S, GL_REPEAT);
  glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_T, GL_REPEAT);
  glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER,
                  GL_LINEAR_MIPMAP_LINEAR);
  glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_LINEAR);

  int width, height, nrChannels;
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

  GLuint uniformModel = 0, uniformProjection = 0, uniformView = 0;
  glm::mat4 projection =
      glm::perspective(45.0f,
                       (GLfloat)mainWindow.getBufferWidth() /
                           (GLfloat)mainWindow.getBufferHeight(),
                       0.1f, 100.0f);

  glm::mat4 view(1.0f);
  glm::vec3 cameraPosition = glm::vec3(0.0f, 0.0f, 10.0f);
  glm::mat4 cameraPosMat(1.0f);
  glm::mat4 cameraRotateMat(1.0f);

  // Loop until window closed
  while (!mainWindow.getShouldClose()) {

    // Get + Handle user input events
    glfwPollEvents();

    // Clear window
    glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
    glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);

    /* Draw Here */
    shaderList[0].UseShader();

    uniformModel = shaderList[0].GetUniformLocation("model"); // Model
    uniformProjection =
        shaderList[0].GetUniformLocation("projection");     // Projection
    uniformView = shaderList[0].GetUniformLocation("view"); // View

    // Lights
    glm::vec3 redLight(1.0f, 0.0f, 0.0f);
    glm::vec3 yellowLight(1.0f, 1.0f, 0.0f);
    glm::vec3 blueLight(0.0f, 0.0f, 1.0f);
    glm::vec3 cyanLight(0.0f, 1.0f, 1.0f);
    glm::vec3 whiteLight(1.0f, 1.0f, 1.0f);
    glm::vec3 lightColor[] = {whiteLight, redLight, yellowLight, blueLight,
                              cyanLight};

    // Ambient light
    glm::int16 ambientStrengthPercent = 30;
    glm::float32 ambientStrength = ambientStrengthPercent / 100.0f;

    // Light movement
    glm::vec3 lightPos = glm::vec3(5.0f, 5.0f, 0.0f);

    glm::vec3 pyramidPositions[] = {
        glm::vec3(0.0f, 0.0f, -2.5f),   glm::vec3(2.0f, 5.0f, -15.0f),
        glm::vec3(-1.5f, -2.2f, -2.5f), glm::vec3(-3.8f, -2.0f, -12.3f),
        glm::vec3(2.4f, -0.4f, -3.5f),  glm::vec3(-1.7f, 3.0f, -7.5f),
        glm::vec3(1.3f, -2.0f, -2.5f),  glm::vec3(1.5f, 2.0f, -2.5f),
        glm::vec3(1.5f, 0.2f, -1.5f),   glm::vec3(-1.3f, 1.0f, -1.5f)};

    // Camera
    float cameraSpeed = 0.05f;
    if (glfwGetKey(mainWindow.getWindow(), GLFW_KEY_W) == GLFW_PRESS)
      cameraPosition.z -= cameraSpeed;
    if (glfwGetKey(mainWindow.getWindow(), GLFW_KEY_S) == GLFW_PRESS)
      cameraPosition.z += cameraSpeed;
    if (glfwGetKey(mainWindow.getWindow(), GLFW_KEY_A) == GLFW_PRESS)
      cameraPosition.x -= cameraSpeed;
    if (glfwGetKey(mainWindow.getWindow(), GLFW_KEY_D) == GLFW_PRESS)
      cameraPosition.x += cameraSpeed;
    if (glfwGetKey(mainWindow.getWindow(), GLFW_KEY_LEFT_CONTROL) == GLFW_PRESS)
      cameraPosition.y -= cameraSpeed;
    if (glfwGetKey(mainWindow.getWindow(), GLFW_KEY_SPACE) == GLFW_PRESS)
      cameraPosition.y += cameraSpeed;
    if (glfwGetKey(mainWindow.getWindow(), GLFW_KEY_LEFT) == GLFW_PRESS ||
        glfwGetKey(mainWindow.getWindow(), GLFW_KEY_Q) == GLFW_PRESS) {
      cameraRotateMat =
          glm::rotate(cameraRotateMat, glm::radians(0.05f), glm::vec3(0, 1, 0));
    }
    if (glfwGetKey(mainWindow.getWindow(), GLFW_KEY_RIGHT) == GLFW_PRESS ||
        glfwGetKey(mainWindow.getWindow(), GLFW_KEY_E) == GLFW_PRESS) {
      cameraRotateMat = glm::rotate(cameraRotateMat, glm::radians(-0.05f),
                                    glm::vec3(0, 1, 0));
    }
    cameraPosMat[3][0] = -cameraPosition.x;
    cameraPosMat[3][1] = -cameraPosition.y;
    cameraPosMat[3][2] = -cameraPosition.z;

    view = cameraRotateMat * cameraPosMat;

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

      // Light;
      glUniform3fv(shaderList[0].GetUniformLocation("lightColour"), 1,
                   glm::value_ptr(lightColor[0])); // Light color
      glUniform1f(shaderList[0].GetUniformLocation("ambientStrength"),
                  ambientStrength); // Ambient light
      glUniform3fv(shaderList[0].GetUniformLocation("lightPos"), 1,
                   glm::value_ptr(lightPos)); // Diffuse light
      glUniform3fv(shaderList[0].GetUniformLocation("viewPos"), 1,
                   glm::value_ptr(cameraPosition)); // Specular light

      meshList[i]->RenderMesh();
    }

    glUseProgram(0);

    mainWindow.swapBuffers();
  }

  return 0;
}
