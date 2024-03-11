#version 330

layout(location=0)in vec3 pos;
layout(location=1)in vec2 aTexCoord;
layout(location=2)in vec3 aNormal;

uniform mat4 model;
uniform mat4 projection;
uniform mat4 view;

out vec4 vCol;
out vec2 TexCoord;
out vec3 Normal;
out vec3 FragPos;

void main(){
    gl_Position=projection*view*model*vec4(pos,1.);
    FragPos=vec3(model*vec4(pos,1.));
    vCol=vec4(clamp(pos,0.f,1.f),1.);
    TexCoord=aTexCoord;
    Normal=aNormal;
}