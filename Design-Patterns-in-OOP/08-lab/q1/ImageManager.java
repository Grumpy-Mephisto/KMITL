public class ImageManager {
	private Object renderer;

	public void setRenderer(Object renderer) {
		this.renderer = renderer;
	}

	public void show() {
		if (renderer instanceof TVRenderer) {
			TVRenderer tvRenderer = (TVRenderer) renderer;
			tvRenderer.showImage();
		} else if (renderer instanceof LaptopRenderer) {
			LaptopRenderer tvRenderer = (LaptopRenderer) renderer;
			tvRenderer.showImage();
		} else if (renderer instanceof SmartphoneRenderer) {
			SmartphoneRenderer tvRenderer = (SmartphoneRenderer) renderer;
			tvRenderer.showImage();
		}

	}
}

