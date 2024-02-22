#version 330

in vec4 vCol;
in vec2 TexCoord;
out vec4 colour;

uniform vec3 lightColour;
uniform float ambientStrength;
uniform sampler2D texture2D;

void main()
{
    vec3 ambient=ambientStrength*lightColour;
    
    colour=texture(texture2D,TexCoord)*vec4(ambient,1.);
}