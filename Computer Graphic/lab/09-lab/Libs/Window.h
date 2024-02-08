#ifndef WINDOW____H
#define WINDOW____H

#include <GL/glew.h>
#include <GLFW/glfw3.h>
#include <stdio.h>

class Window {
public:
  Window();
  Window(GLint windowWidth, GLint windowHeight, GLint majorVersion,
         GLint minorVersion);
  ~Window();

  int initialise();

  GLint getBufferWidth() { return bufferWidth; }
  GLint getBufferHeight() { return bufferHeight; }

  bool getShouldClose() { return glfwWindowShouldClose(mainWindow); }

  void swapBuffers() { glfwSwapBuffers(mainWindow); }

  GLFWwindow *getWindow() { return mainWindow; }

private:
  GLFWwindow *mainWindow;
  GLint glfwMajorVersion, glfwMinorVersion;
  GLint width, height;
  GLint bufferWidth, bufferHeight;
};

#endif