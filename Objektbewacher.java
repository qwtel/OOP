
public class Objektbewacher extends Beschuetzer {
	
	public Objektbewacher(Skin skin, Software software) {
		super(skin);
		software.fuerObjektbewacher(this);
	}
}
