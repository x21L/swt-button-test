package buttontest;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.*;

public class ButtonTest {

    public static void main(String[] args) {
        buttonTestWindow();
    }

    private static void buttonTestWindow() {
        Display display = new Display();
        Shell shell = new Shell(display);
        shell.setSize(300, 200);
        shell.setText("Button Example");
        shell.setLayout(new RowLayout());

        // background image
        final Button up = new Button(shell, SWT.FLAT | SWT.ARROW | SWT.UP);
        up.setVisible(true);
        final Button down = new Button(shell, SWT.FLAT | SWT.ARROW | SWT.DOWN);

        final Button button2 = new Button(shell, SWT.PUSH);
        button2.setText("I am visible");

        up.addSelectionListener(new SelectionListener() {

            public void widgetSelected(SelectionEvent event) {
                button2.setVisible(!button2.isVisible());
            }

            public void widgetDefaultSelected(SelectionEvent event) {
                // not needed
            }
        });

        down.addSelectionListener(new SelectionListener() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                button2.setVisible(!button2.isVisible());
            }

            @Override
            public void widgetDefaultSelected(SelectionEvent e) {
                // not needed
            }
        });

        shell.open();
        while (!shell.isDisposed()) {
            if (!display.readAndDispatch())
                display.sleep();
        }
        display.dispose();
    }
}
