package sample;

import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.widgets.Composite;

import mixins.KeyListenerMixin;
import mixins.MouseListenerMixin;

/**
 * This class inherits functionality by its superclass {@link CLabel} as well as by the default implementations
 * of its interfaces. 
 */
public class LambdaLabel extends CLabel implements KeyListenerMixin, MouseListenerMixin {

	public LambdaLabel(Composite parent, int style) {
		super(parent, style);
	}
}
