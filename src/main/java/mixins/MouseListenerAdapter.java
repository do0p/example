package mixins;

import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;

public interface MouseListenerAdapter extends MouseListener {

	@Override
	default void mouseDoubleClick(MouseEvent e) {
	}

	@Override
	default void mouseDown(MouseEvent e) {
	}

	@Override
	default void mouseUp(MouseEvent e) {
	}

}
