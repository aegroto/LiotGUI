uniform sampler2D m_Texture;

varying vec2 texCoord;

void main() {
	gl_FragColor = texture2D(m_Texture, texCoord).rgba;
}