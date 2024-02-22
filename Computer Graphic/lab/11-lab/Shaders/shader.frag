#version 330

in vec4 vCol;
in vec2 TexCoord;
out vec4 colour;

uniform sampler2D texture2D;
void main()
{
    colour=texture(texture2D,TexCoord);
    
}