#include "Shader.h"
#include <gtest/gtest.h>

// Test SetShaderColor function
TEST(SetShaderColorTest, SetsColorCorrectly) {
  // Create a shader object
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
  return RUN_ALL_TESTS();
}
