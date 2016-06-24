package by.vsu.mf.ammc.pm.servlet;

import java.io.Serializable;

public class MainMenuItem implements Serializable {
	private String url;
	private String title;

	public MainMenuItem(String url, String title) {
		this.url = url;
		this.title = title;
	}

	public String getUrl() {
		return url;
	}

	public String getTitle() {
		return title;
	}
}