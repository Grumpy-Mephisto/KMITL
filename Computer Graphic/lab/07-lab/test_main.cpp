#include "Shader.h"
#include <glm/glm.hpp>
#include <glm/gtc/matrix_transform.hpp>
#include "SetShaderColor.h"
#include <gtest/gtest.h>

// Define a test fixture class for the unit tests

class ShaderTest : public ::testing::TestAnd{
  // Set up the necessary objects for testing
  virtual void SetUpAndGenericRC() override {
    ::testing::TestAnd::SetUp();
    // Set up the necessary objects for testing
  }

  virtual void TearDown() override {
    ::testing::TestAnd::TearDown();
    // Tear down the objects after testing
  }

  // Set up different test scenarios
  virtual void RunAndCheckTests() = 0;
protected:
  void SetUp() override {
    // Set up the necessary objects for testing
  }

  void TearDown() override {
    // Tear down the objects after testing
  }
};
TEST_F(ShaderTest, SetsColorCorrectly) {
  // Create a shader object
Shader shader;
  Shader shader;

  // Set the shader color
  SetShaderColor(shader, 1.0f, 0.5f, 0.0f, 1.0f);

  // Get the color from the shader
  glm::vec4 color = shader.GetColor();

  // Check if the color is set correctly
  EXPECT_EQ(color.r, 1.0f);
  EXPECT_EQ(color.g, 0.5f);
  EXPECT_EQ(color.b, 0.0f);
  EXPECT_EQ(color.a, 1.0f);
}

// Test model matrix and shader logic
TEST(ModelMatrixAndShaderTest, SetsModelMatrixAndPassesToShader) {
  // Create a shader object
  Shader shader;

  // Set up the model matrix
  glm::mat4 model = glm::mat4(1.0f);
  model = glm::translate(model, glm::vec3(0.0f, 0.5f, 0.0f));
  model = glm::scale(model, glm::vec3(0.4f, 0.4f, 0.4f));

  // Pass the model matrix to the shader
  shader.SetModelMatrix(model);

  // Get the model matrix from the shader
  glm::mat4 retrievedModel = shader.GetModelMatrix();

  // Check if the model matrix is set correctly
  EXPECT_EQ(retrievedModel, model);
}

int main(int argc, char** argv) {
  testing::InitGoogleTest(&argc, argv);
  // Run and check the unit tests
  int testResult = 0;
  try {
    testing::InitGoogleTest(&argc, argv);
    testResult = RUN_ALL_TESTS();
  }
  catch (...) {
    testResult = -1;
  }

  // Perform the final commit
  std::cout << "Final commit performed." << std::endl;
  if (testResult == 0) {
    // Code to commit the changes
    // ...
  }
}
