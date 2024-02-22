#include "Window.h"
#include <iostream>

Window::Window()
    : width(800), height(600), glfwMajorVersion(3), glfwMinorVersion(1),
      windowTitle("Default Window") {}

Window::Window(GLint windowWidth, GLint windowHeight, GLint majorVersion,
               GLint minorVersion, const std::string &title)
    : width(windowWidth), height(windowHeight), glfwMajorVersion(majorVersion),
      glfwMinorVersion(minorVersion), windowTitle(title) {}

Window::~Window() {
  glfwDestroyWindow(mainWindow);
  glfwTerminate();
}

int Window::initialise() {
  if (!glfwInit()) {
    std::cout << "GLFW initialization failed!" << std::endl;
    glfwTerminate();
    return 1;
  }

  glfwWindowHint(GLFW_CONTEXT_VERSION_MAJOR, glfwMajorVersion);
  glfwWindowHint(GLFW_CONTEXT_VERSION_MINOR, glfwMinorVersion);
  glfwWindowHint(GLFW_OPENGL_PROFILE, GLFW_OPENGL_CORE_PROFILE);
  glfwWindowHint(GLFW_OPENGL_FORWARD_COMPAT, GL_TRUE);

  mainWindow =
      glfwCreateWindow(width, height, windowTitle.c_str(), nullptr, nullptr);
  if (!mainWindow) {
    std::cout << "GLFW window creation failed!" << std::endl;
    glfwTerminate();
    return 1;
  }

  glfwGetFramebufferSize(mainWindow, &bufferWidth, &bufferHeight);
  glfwMakeContextCurrent(mainWindow);
  glewExperimental = GL_TRUE;

  if (glewInit() != GLEW_OK) {
    std::cout << "GLEW initialization failed!" << std::endl;
    glfwDestroyWindow(mainWindow);
    glfwTerminate();
    return 1;
  }

  glEnable(GL_DEPTH_TEST);
  glViewport(0, 0, bufferWidth, bufferHeight);

  return 0;
}