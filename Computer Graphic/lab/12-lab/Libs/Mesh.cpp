#include "Mesh.h"

Mesh::Mesh() {
  VAO = 0;
  VBO = 0;
  IBO = 0;
  vertexBuffer = 0;
  uvBuffer = 0;
  normalBuffer = 0;
  indexCount = 0;
}

Mesh::~Mesh() { ClearMesh(); }

void Mesh::CreateMesh(GLfloat *vertices, unsigned int *indices,
                      unsigned int numOfVertices, unsigned int numOfIndices) {
  // std::vector<glm::vec3> temp_vertices;
  // std::vector<glm::vec2> temp_uvs;

  // for (unsigned int i = 0; i < numOfVertices; i += 5)
  // {
  //     glm::vec3 vertex;
  //     glm::vec2 uv;

  //     vertex.x = vertices[i];
  //     vertex.y = vertices[i + 1];
  //     vertex.z = vertices[i + 2];
  //     temp_vertices.push_back(vertex);

  //     uv.x = vertices[i + 3];
  //     uv.y = vertices[i + 4];
  //     temp_uvs.push_back(uv);
  // }

  // indexCount = numOfIndices;

  // glGenVertexArrays(1, &VAO);
  // glBindVertexArray(VAO);

  // glGenBuffers(1, &IBO);
  // glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, IBO);
  // glBufferData(GL_ELEMENT_ARRAY_BUFFER, sizeof(indices[0]) * numOfIndices,
  // indices, GL_STATIC_DRAW);

  // glGenBuffers(1, &vertexBuffer);
  // glBindBuffer(GL_ARRAY_BUFFER, vertexBuffer);
  // glBufferData(GL_ARRAY_BUFFER, temp_vertices.size() * sizeof(glm::vec3),
  // &temp_vertices[0], GL_STATIC_DRAW); glVertexAttribPointer(
  //     0,        // attribute
  //     3,        // size
  //     GL_FLOAT, // type
  //     GL_FALSE, // normalized?
  //     0,        // stride
  //     (void *)0 // array buffer offset
  // );
  // glEnableVertexAttribArray(0);

  // glGenBuffers(1, &uvBuffer);
  // glBindBuffer(GL_ARRAY_BUFFER, uvBuffer);
  // glBufferData(GL_ARRAY_BUFFER, temp_uvs.size() * sizeof(glm::vec2),
  // &temp_uvs[0], GL_STATIC_DRAW); glVertexAttribPointer(
  //     1,        // attribute
  //     2,        // size
  //     GL_FLOAT, // type
  //     GL_FALSE, // normalized?
  //     0,        // stride
  //     (void *)0 // array buffer offset
  // );
  // glEnableVertexAttribArray(1);

  // glBindBuffer(GL_ARRAY_BUFFER, 0);

  // glBindVertexArray(0);
  // glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, 0);

  glGenVertexArrays(1, &VAO);
  glBindVertexArray(VAO);

  glGenBuffers(1, &IBO);
  glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, IBO);
  glBufferData(GL_ELEMENT_ARRAY_BUFFER, sizeof(indices[0]) * numOfIndices,
               indices, GL_STATIC_DRAW);

  glGenBuffers(1, &VBO);
  glBindBuffer(GL_ARRAY_BUFFER, VBO);

  glBufferData(GL_ARRAY_BUFFER, sizeof(vertices[0]) * numOfVertices, vertices,
               GL_STATIC_DRAW);

  glVertexAttribPointer(0, 3, GL_FLOAT, GL_FALSE, 5 * sizeof(float), 0);
  glEnableVertexAttribArray(0);
  glVertexAttribPointer(1, 2, GL_FLOAT, GL_FALSE, 5 * sizeof(float),
                        (void *)(3 * sizeof(float)));
  glEnableVertexAttribArray(1);

  glBindBuffer(GL_ARRAY_BUFFER, 0);

  glBindVertexArray(0);
  glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, 0);
}

void Mesh::RenderMesh() {
  glBindVertexArray(VAO);
  glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, IBO);

  glDrawElements(GL_TRIANGLES, indexCount, GL_UNSIGNED_INT, 0);

  glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, 0);
  glBindVertexArray(0);
}

void Mesh::ClearMesh() {
  if (vertexBuffer != 0) {
    glDeleteBuffers(1, &vertexBuffer);
    vertexBuffer = 0;
  }

  if (uvBuffer != 0) {
    glDeleteBuffers(1, &uvBuffer);
    uvBuffer = 0;
  }

  if (normalBuffer != 0) {
    glDeleteBuffers(1, &normalBuffer);
    normalBuffer = 0;
  }

  if (IBO != 0) {
    glDeleteBuffers(1, &IBO);
    IBO = 0;
  }

  if (VAO != 0) {
    glDeleteVertexArrays(1, &VAO);
    VAO = 0;
  }

  indexCount = 0;
}

bool Mesh::CreateMeshFromOBJ(const char *path) {
  std::vector<glm::vec3> vertices;
  std::vector<glm::vec2> texCoords;
  std::vector<glm::vec3> normals;
  std::vector<Face> faces;

  std::ifstream file(path);
  if (!file.is_open()) {
    std::cerr << "Error: could not open " << path << std::endl;
    return false;
  }
  std::string line;
  while (std::getline(file, line)) {
    if (line.substr(0, 2) == "v ") {
      glm::vec3 vertex;
      sscanf(line.c_str(), "v %f %f %f", &vertex.x, &vertex.y, &vertex.z);
      vertices.push_back(vertex);
    } else if (line.substr(0, 3) == "vt ") {
      glm::vec2 texCoord;
      sscanf(line.c_str(), "vt %f %f", &texCoord.x, &texCoord.y);
      texCoords.push_back(texCoord);
    } else if (line.substr(0, 3) == "vn ") {
      glm::vec3 normal;
      sscanf(line.c_str(), "vn %f %f %f", &normal.x, &normal.y, &normal.z);
      normals.push_back(normal);
    } else if (line.substr(0, 2) == "f ") {
      Face face;
      sscanf(line.c_str(), "f %d/%d/%d %d/%d/%d %d/%d/%d", &face.vIndex[0],
             &face.vtIndex[0], &face.vnIndex[0], &face.vIndex[1],
             &face.vtIndex[1], &face.vnIndex[1], &face.vIndex[2],
             &face.vtIndex[2], &face.vnIndex[2]);
      faces.push_back(face);
    }
  }
  file.close();

  // Create and bind the VAO
  glGenVertexArrays(1, &VAO);
  glBindVertexArray(VAO);

  // Create the VBO for vertex positions
  glGenBuffers(1, &VBO);
  glBindBuffer(GL_ARRAY_BUFFER, VBO);
  glBufferData(GL_ARRAY_BUFFER, vertices.size() * sizeof(glm::vec3),
               &vertices[0], GL_STATIC_DRAW);
  glEnableVertexAttribArray(0);
  glVertexAttribPointer(0, 3, GL_FLOAT, GL_FALSE, sizeof(glm::vec3), (void *)0);

  // Create the VBO for texture coordinates
  glGenBuffers(1, &uvBuffer);
  glBindBuffer(GL_ARRAY_BUFFER, uvBuffer);
  glBufferData(GL_ARRAY_BUFFER, texCoords.size() * sizeof(glm::vec2),
               &texCoords[0], GL_STATIC_DRAW);
  glEnableVertexAttribArray(1);
  glVertexAttribPointer(1, 2, GL_FLOAT, GL_FALSE, sizeof(glm::vec2), (void *)0);

  // Create the VBO for normals
  glGenBuffers(1, &normalBuffer);
  glBindBuffer(GL_ARRAY_BUFFER, normalBuffer);
  glBufferData(GL_ARRAY_BUFFER, normals.size() * sizeof(glm::vec3), &normals[0],
               GL_STATIC_DRAW);
  glEnableVertexAttribArray(2); // Create the VBO for normals
  glVertexAttribPointer(2, 3, GL_FLOAT, GL_FALSE, sizeof(glm::vec3), (void *)0);

  // Create the IBO
  glGenBuffers(1, &IBO);
  glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, IBO);
  std::vector<unsigned int> indices;
  for (Face face : faces) {
    for (int i = 0; i < 3; i++) {
      indices.push_back(face.vIndex[i] - 1);
    }
  }

  indexCount = faces.size() * 3;

  glBufferData(GL_ELEMENT_ARRAY_BUFFER, indices.size() * sizeof(unsigned int),
               &indices[0], GL_STATIC_DRAW);

  // Unbind the VAO, VBO, and IBO
  glBindVertexArray(0);
  glBindBuffer(GL_ARRAY_BUFFER, 0);
  glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, 0);

  return true;
}
