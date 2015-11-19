package mixins;

import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;

/**
 * Provides default implementations to. Subclasses only need to override the
 * methods of interest.
 */
public interface KeyListenerAdapter extends KeyListener {

	@Override
	default void keyPressed(KeyEvent e) {
	}

	@Override
	default void keyReleased(KeyEvent e) {
	}
}
