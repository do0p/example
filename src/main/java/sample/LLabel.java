package sample;

import mixins.FocusListenerMixin;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

public class LLabel extends Label implements FocusListenerMixin{

	public LLabel(Composite parent, int style) {
		super(parent, style);
	}
	
}
