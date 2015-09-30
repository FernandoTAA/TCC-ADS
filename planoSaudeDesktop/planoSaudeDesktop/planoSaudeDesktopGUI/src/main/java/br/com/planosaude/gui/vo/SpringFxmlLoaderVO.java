package br.com.planosaude.gui.vo;

import javafx.scene.Parent;

public class SpringFxmlLoaderVO {

	private Parent parent;
	private Object controller;

	public SpringFxmlLoaderVO(Parent parent, Object controller) {
		super();
		this.parent = parent;
		this.controller = controller;
	}

	public Parent getParent() {
		return parent;
	}

	public void setParent(Parent parent) {
		this.parent = parent;
	}

	public Object getController() {
		return controller;
	}

	public void setController(Object controller) {
		this.controller = controller;
	}
}
