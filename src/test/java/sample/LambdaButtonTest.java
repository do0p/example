package sample;

import mixins.FocusListenerAdapter;

import org.eclipse.swt.events.FocusEvent;
import org.junit.Before;
import org.junit.Test;

public class LambdaButtonTest {

	private LambdaButton lButton;
	private LambdaLabel lLabel;

	@Before
	public void setUp() {
		lButton = new LambdaButton(null, 0);
		lLabel = new LambdaLabel(null, 0);
	}
	
	@Test
	public void addListeners() {
		lButton.addDisposeListener(e -> onDispose());
		lButton.addFocusListener(new FocusListenerAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				onFocusGained();
			}
		});
		lButton.addFocusGainedListener(e -> onFocusGained());
		lLabel.addFocusGainedListener(e -> onFocusGained());
	}


	private void onFocusGained() {
		// TODO Auto-generated method stub
		
	}
	
	private void onDispose() {
		// dispose code
	}
}
