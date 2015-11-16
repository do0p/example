package sample;

import mixins.FocusListenerMixin;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

public class LambdaLabel extends Label implements FocusListenerMixin{

	public LambdaLabel(Composite parent, int style) {
		super(parent, style);
	}
	
}
