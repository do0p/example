package sample;

import mixins.FocusListenerMixin;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;

public class LButton extends Button implements FocusListenerMixin {

	public LButton(Composite parent, int style) {
		super(parent, style);
	}

}
