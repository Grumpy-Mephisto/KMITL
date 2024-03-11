#version 330

layout(location=0)in vec3 aPos;

out vec4 fragPosLightSpace;

uniform mat4 projection;
uniform mat4 view;
uniform mat4 model;

uniform mat4 lightProjection;
uniform mat4 lightView;

void main(){
    vec3 fragPos=vec3(model*vec4(aPos,1.));
    fragPosLightSpace=lightProjection*lightView*vec4(fragPos,1.);
    gl_Position=projection*view*vec4(fragPos,1.);
}