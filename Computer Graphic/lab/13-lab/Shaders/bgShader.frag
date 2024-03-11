#version 330

out vec4 colour;

in vec4 fragPosLightSpace;

uniform vec3 bgColour;
uniform sampler2D shadowMap;

float ShadowCalculation(){
    vec3 projCoords=fragPosLightSpace.xyz/fragPosLightSpace.w;
    projCoords=projCoords*.5+.5;
    float closestDepth=texture(shadowMap,projCoords.xy).r;
    float currentDepth=projCoords.z;
    float bias=.005;
    float shadow=0.;
    vec2 texelSize=1./textureSize(shadowMap,0);
    for(int x=-1;x<=1;++x)
    {
        for(int y=-1;y<=1;++y)
        {
            float pcfDepth=texture(shadowMap,projCoords.xy+vec2(x,y)*texelSize).r;
            shadow+=currentDepth-bias>pcfDepth?1.:0.;
        }
    }
    
    shadow/=9.;
    
    if(projCoords.z>1.)
    shadow=0.;
    
    return shadow;
}

void main(){
    float shadow=ShadowCalculation();
    colour=vec4((1.-shadow)*bgColour,1.f);
}