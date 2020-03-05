package rosterBuilder;

import javax.swing.*;
import java.io.Serializable;
import java.util.Vector;

public class OneOrZeroButtonGroup extends ButtonGroup implements Serializable {
    protected Vector<AbstractButton> buttons = new Vector();
    ButtonModel selection = null;

    @Override
    public void setSelected(ButtonModel m, boolean b) {
        if (b && m != null && m != this.selection) {
            ButtonModel oldSelection = this.selection;
            this.selection = m;
            if (oldSelection != null)
                oldSelection.setSelected(false);
        }
        else{
            ButtonModel oldSelection = this.selection;
            this.selection = null;
            if (oldSelection != null) {
                oldSelection.setSelected(false);
            }
        }
    }
    @Override
    public boolean isSelected(ButtonModel m) {
        return m == this.selection;
    }
}
