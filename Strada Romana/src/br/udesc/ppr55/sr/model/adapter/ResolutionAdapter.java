package br.udesc.ppr55.sr.model.adapter;

public class ResolutionAdapter extends DefaultResolution implements HighQualityResolution {

	private DefaultResolution defaultResolution;
	
	public ResolutionAdapter(DefaultResolution defaultResolution) {
		this.defaultResolution = defaultResolution;
	}
	
	@Override
	public int provideHighQualityResolution() {
		return changeResolution(defaultResolution.provideDefaultResolution());
	}
	
	private int changeResolution(int resolution) {
		return resolution * 2;
	}
}
