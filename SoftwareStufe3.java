
public class SoftwareStufe3 extends SoftwareStufe{
	public SoftwareStufe3() {
		
	}

	@Override
	public void fuerSoftwareBauarbeiter(SoftwareBauarbeiter softwareBauarbeiter) {
		softwareBauarbeiter.setSoftwareStufe(this);
	}

	@Override
	public void fuerSoftwareServicetechniker(
			SoftwareServicetechniker softwareServicetechniker) {
		softwareServicetechniker.setSoftwareStufe(this);
	}

	@Override
	public void fuerSoftwareTransportarbeiter(
			SoftwareTransportarbeiter softwareTransportarbeiter) {
		softwareTransportarbeiter.setSoftwareStufe(this);
	}

	@Override
	public void fuerSoftwareHilfskraft(SoftwareHilfskraft softwareHilfskraft) {
		softwareHilfskraft.setSoftwareStufe(null);
	}

	@Override
	public void fuerSoftwareGesellschafter(
			SoftwareGesellschafter softwareGesellschafter) {
		softwareGesellschafter.setSoftwareStufe(null);
	}

	@Override
	public void fuerSoftwareObjektbewacher(
			SoftwareObjektbewacher softwareObjektbewacher) {
		softwareObjektbewacher.setSoftwareStufe(null);
	}

	@Override
	public void fuerSoftwareLeibwaechter(
			SoftwareLeibwaechter softwareLeibwaechter) {
		softwareLeibwaechter.setSoftwareStufe(null);
	}

	@Override
	public void fuerSoftwareKaempfer(SoftwareKaempfer softwarekaempfer) {
		softwarekaempfer.setSoftwareStufe(null);
	}

	
	
}