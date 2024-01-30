#version 330 core

in vec4 vCol;

out vec4 colour;

uniform vec4 inputColor;

void main()
{
    colour=inputColor*vCol;
}
