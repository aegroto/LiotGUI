uniform mat4 g_WorldViewProjectionMatrix;

/*uniform float g_Time;
uniform float m_PI;*/

uniform float m_RotationAngle;

attribute vec3 inPosition;
attribute vec2 inTexCoord;

varying vec2 texCoord, position;

void main(){	
	//float angle = (2.0 * m_PI) * fract(g_Time / 2.0);
	
	float x = inTexCoord.x - 0.5;
	float y = inTexCoord.y - 0.5;

	float cos = cos(m_RotationAngle),
		 sin = sin(m_RotationAngle);

	texCoord = vec2(
		(x * cos - y * sin) + 0.5,
		(y * cos + x * sin) + 0.5
	);

	//texCoord=texCoord.yx;
	
    	gl_Position = g_WorldViewProjectionMatrix * vec4(inPosition, 1.0);
}