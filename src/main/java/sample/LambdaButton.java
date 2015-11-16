package sample;

import mixins.FocusListenerMixin;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;

public class LambdaButton extends Button implements FocusListenerMixin {

	public LambdaButton(Composite parent, int style) {
		super(parent, style);
	}

}
