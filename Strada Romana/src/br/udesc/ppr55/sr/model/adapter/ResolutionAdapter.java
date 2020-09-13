package br.udesc.ppr55.sr.model.adapter;

public class ResolutionAdapter extends DefaultResolution implements HighQualityResolution {

	private DefaultResolution defaultResolution;
	
	public ResolutionAdapter(int screenSize) {
		if(screenSize == 50) {
			provideHighQualityResolution();
		}else {
			defaultResolution.provideDefaultResolution();
		}
	}
	
	@Override
	public int provideHighQualityResolution() {
		return 5;
	}
}
