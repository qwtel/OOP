
public class SoftwareStufe5 extends SoftwareStufe{
	public SoftwareStufe5() {
		
	}

	@Override
	public void fuerSoftwareBauarbeiter(SoftwareBauarbeiter softwareBauarbeiter) {
		softwareBauarbeiter.setSoftwareStufe(null);
	}

	@Override
	public void fuerSoftwareServicetechniker(
			SoftwareServicetechniker softwareServicetechniker) {
		softwareServicetechniker.setSoftwareStufe(null);
	}

	@Override
	public void fuerSoftwareTransportarbeiter(
			SoftwareTransportarbeiter softwareTransportarbeiter) {
		softwareTransportarbeiter.setSoftwareStufe(null);
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
		softwarekaempfer.setSoftwareStufe(this);
	}


	
}