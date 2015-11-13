package mixins;


import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;



public interface FocusListenerAdapter extends FocusListener {

	@Override
	default void focusGained(FocusEvent e) {}
	
	@Override
	default void focusLost(FocusEvent e) {}
}
