package mixins;

import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;

public interface KeyListenerAdapter extends KeyListener {

	@Override
	default void keyPressed(KeyEvent e) {
	}

	@Override
	default void keyReleased(KeyEvent e) {
	}
	
}
