package sample;

import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.widgets.Composite;

import mixins.FocusListenerMixin;
import mixins.KeyListenerMixin;
import mixins.MouseListenerMixin;

public class LambdaLabel extends CLabel implements KeyListenerMixin, FocusListenerMixin, MouseListenerMixin{

	public LambdaLabel(Composite parent, int style) {
		super(parent, style);
	}
	
}
