#version 330

in vec4 vCol;
in vec2 TexCoord;
in vec3 Normal;
in vec3 FragPos;

out vec4 colour;

uniform vec3 lightColour;
uniform float ambientStrength;
uniform float lightPos;
uniform vec3 viewPos;

uniform sampler2D texture2D;

vec3 ambientLight(vec3 lightColour,float ambientStrength)
{
    return lightColour*ambientStrength;
}

vec3 diffuseLight()
{
    float diffuseStrength=.5f;
    vec3 lightDir=normalize(lightPos-FragPos);
    vec3 norm=normalize(Normal);
    float diff=max(dot(norm,lightDir),0.f);
    vec3 diffuse=lightColour*diff*diffuseStrength;
    
    return diffuse;
}

vec3 specularLight()
{
    float specularStrength=.8f;
    float shininess=32.f;
    vec3 lightDir=normalize(lightPos-FragPos);
    vec3 norm=normalize(Normal);
    vec3 reflectDir=reflect(-lightDir,norm);
    vec3 viewDir=normalize(viewPos-FragPos);
    float spec=pow(max(dot(viewDir,reflectDir),0.),shininess);
    vec3 specular=lightColour*spec*specularStrength;
    
    return specular;
}

void main()
{
    vec3 ambient=ambientLight(lightColour,ambientStrength);
    vec3 diffuse=diffuseLight();
    vec3 specular=specularLight();
    
    colour=texture(texture2D,TexCoord)*vec4(ambient+diffuse+specular,1.);
}