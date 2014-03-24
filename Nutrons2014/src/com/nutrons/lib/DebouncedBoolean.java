/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nutrons.lib;

/**
 *
 * @author John
 */
public class DebouncedBoolean {

    private int length;
    private boolean state = false;
    private int count;

    public DebouncedBoolean(int length) {
        this.length = length;
        count = 0;
    }

    public void feed(boolean in) {
        if(state) {
            state = in;
        } else if(in) {
            if(count > length) {
                state = true;
            } else {
                count++;
            }
        }
        if(!in) {
            reset();
        }
    }

    public boolean get() {
        return state;
    }

    public void reset() {
        count = 0;
    }


}
