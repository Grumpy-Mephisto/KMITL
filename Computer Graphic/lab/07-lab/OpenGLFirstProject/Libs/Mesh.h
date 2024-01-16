#ifndef MESH____H
#define MESH____H

#include <GL/glew.h>

class Mesh
{
    public:
        Mesh();
        ~Mesh();

        void CreateMesh(GLfloat* vertices, unsigned int* indices, unsigned int numOfVertices, unsigned int numOfIndices);
        void RenderMesh();
        void ClearMesh();

    private:
        GLuint VAO, VBO, IBO;
        GLsizei indexCount;
};

#endif