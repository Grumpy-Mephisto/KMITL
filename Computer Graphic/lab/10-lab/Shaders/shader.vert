#version 330 core

layout(location=0)in vec3 pos;
layout(location=1)in vec2 aTexCoord;

out vec4 vCol;
out vec2 TexCoord;

uniform mat4 model;
uniform mat4 view;
uniform mat4 projection;

void main()
{
    gl_Position=projection*view*model*vec4(pos,1.);
    vCol=vec4(clamp(pos,0.,1.),1.);// Colorize the cube.
    TexCoord=aTexCoord;// Pass the texture
}