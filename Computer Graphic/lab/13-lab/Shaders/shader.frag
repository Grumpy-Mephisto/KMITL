#version 330

out vec4 colour;
in vec4 vCol;
in vec2 TexCoord;
in vec3 Normal;
in vec3 FragPos;

uniform vec3 lightColour;
uniform vec3 lightPos;
uniform vec3 viewPos;

uniform sampler2D texture2D;

vec3 specularLight(){
    float specularStrength=.8f;
    float shininess=64.f;
    vec3 lightDir=normalize(lightPos-FragPos);
    vec3 norm=normalize(Normal);
    vec3 reflectDir=reflect(-lightDir,norm);
    vec3 viewDir=normalize(viewPos-FragPos);
    float spec=pow(max(dot(viewDir,reflectDir),0.f),shininess);
    vec3 specular=lightColour*spec*specularStrength;
    return specular;
}

vec3 diffuseLight(){
    float diffuseStrength=.5f;
    vec3 lightDir=normalize(lightPos-FragPos);
    vec3 norm=normalize(Normal);
    float diff=max(dot(norm,lightDir),0.f);
    vec3 diffuse=lightColour*diff*diffuseStrength;
    return diffuse;
}

vec3 ambientLight(){
    float ambientStrength=.2f;
    vec3 ambient=lightColour*ambientStrength;
    return ambient;
}

void main(){
    colour=texture(texture2D,TexCoord)*vec4(ambientLight()+diffuseLight()+specularLight(),1.f);
}