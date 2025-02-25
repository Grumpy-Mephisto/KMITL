public class ImageManager {
	private DisplayRenderer renderer;

	public void setRenderer(DisplayRenderer renderer) {
		this.renderer = renderer;
	}

	public void show() {
		if (renderer != null) {
			renderer.showImage();
		} else {
			throw new IllegalStateException("No renderer set...");
		}
	}
}

