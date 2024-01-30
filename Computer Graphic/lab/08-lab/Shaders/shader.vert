#version 330 core

layout(location=0)in vec3 pos;

out vec4 vCol;

uniform mat4 model;
uniform mat4 projection;

void main()
{
    gl_Position=projection*model*vec4(pos,1.);
    vCol=vec4(clamp(pos,0.,1.),1.);// Colorize the cube.
}