#include "Window.h"
#include "Shader.h"
#include "Mesh.h"
#include <gtest/gtest.h>

// Test suite for the projection and model matrices setup
class ProjectionAndModelMatrixSetupTests : public ::testing::Test {
protected:
    Window mainWindow;
    Shader shader;
    Mesh mesh;

    void SetUp() override {
        mainWindow = Window(WIDTH, HEIGHT, 3, 3);
        mainWindow.initialise();

        shader = Shader();
        shader.initialise();

        mesh = Mesh();
        mesh.initialise();
    }

    void TearDown() override {
        // Clean up resources
        mainWindow.destroy();
        shader.destroy();
        mesh.destroy();
    }
};

// Test the projection matrix setup
TEST_F(ProjectionAndModelMatrixSetupTests, TestProjectionMatrixSetup) {
    // Get buffer size information
    GLfloat bufferWidth = mainWindow.getBufferWidth();
    GLfloat bufferHeight = mainWindow.getBufferHeight();

    // Check if buffer width or height is zero
    ASSERT_NE(bufferWidth, 0);
    ASSERT_NE(bufferHeight, 0);

    // Calculate projection matrix
    glm::mat4 projection = glm::perspective(45.0f, bufferWidth / bufferHeight, 0.1f, 100.0f);

    // Assert that the projection matrix is correctly calculated
    // Add appropriate assertions here
}

// Test the model matrix setup
TEST_F(ProjectionAndModelMatrixSetupTests, TestModelMatrixSetup) {
    // Get uniform locations
    GLuint uniformModel = shader.GetModelLocation();
    GLuint uniformProjection = shader.GetProjectionLocation();

    // Create model matrix
    glm::mat4 model(1.0f); // Identity matrix

    model = glm::translate(model, glm::vec3(0.3f, 0.0f, -2.5f));
    model = glm::rotate(model, 90.0f * 3.1416f / 180.0f, glm::vec3(0.0f, 0.0f, 1.0f));
    model = glm::scale(model, glm::vec3(0.4f, 0.4f, 1.0f));

    // Assert that the model matrix is correctly calculated
    // Add appropriate assertions here
}

// Add more test cases as needed

int main(int argc, char** argv) {
    ::testing::InitGoogleTest(&argc, argv);
    return RUN_ALL_TESTS();
}
