package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {

    private boolean upPressed, downPressed, leftPressed, rightPressed, ePressed, qPressed, iPressed, enterPressed;
    private boolean eProcessed, iProcessed;

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();

        if (code == KeyEvent.VK_W) {
            upPressed = true;
        }
        if (code == KeyEvent.VK_S) {
            downPressed = true;
        }
        if (code == KeyEvent.VK_A) {
            leftPressed = true;
        }
        if (code == KeyEvent.VK_D) {
            rightPressed = true;
        }
        if (code == KeyEvent.VK_E) {
            if (!ePressed) {
                ePressed = true;
                eProcessed = false;
            }
        }
        if (code == KeyEvent.VK_Q) {
            qPressed = true;
        }
        if (code == KeyEvent.VK_I) {
            if (!iPressed) {
                iPressed = true;
                iProcessed = false;
            }
        }
        if (code == KeyEvent.VK_ENTER) {
            enterPressed = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();

        if (code == KeyEvent.VK_W) {
            upPressed = false;
        }
        if (code == KeyEvent.VK_S) {
            downPressed = false;
        }
        if (code == KeyEvent.VK_A) {
            leftPressed = false;
        }
        if (code == KeyEvent.VK_D) {
            rightPressed = false;
        }
        if (code == KeyEvent.VK_E) {
            ePressed = false;
            eProcessed = true;
        }
        if (code == KeyEvent.VK_Q) {
            qPressed = false;
        }
        if (code == KeyEvent.VK_I) {
            iPressed = false;
            iProcessed = true;
        }
        if (code == KeyEvent.VK_ENTER) {
            enterPressed = false;
        }
    }

    public boolean isUpPressed() {
        return upPressed;
    }

    public void setUpPressed(boolean upPressed) {
        this.upPressed = upPressed;
    }

    public boolean isDownPressed() {
        return downPressed;
    }

    public void setDownPressed(boolean downPressed) {
        this.downPressed = downPressed;
    }

    public boolean isLeftPressed() {
        return leftPressed;
    }

    public void setLeftPressed(boolean leftPressed) {
        this.leftPressed = leftPressed;
    }

    public boolean isRightPressed() {
        return rightPressed;
    }

    public void setRightPressed(boolean rightPressed) {
        this.rightPressed = rightPressed;
    }

    public boolean isePressed() {
        if (ePressed && !eProcessed) {
            eProcessed = true;
            return true;
        }
        return false;
    }

    public void setePressed(boolean ePressed) {
        this.ePressed = ePressed;
    }

    public boolean isqPressed() {
        return qPressed;
    }

    public void setqPressed(boolean qPressed) {
        this.qPressed = qPressed;
    }

    public boolean isiPressed() {
        if (iPressed && !iProcessed) {
            iProcessed = true;
            return true;
        }
        return false;
    }

    public void setiPressed(boolean iPressed) {
        this.iPressed = iPressed;
    }

    public boolean isEnterPressed() {
        return enterPressed;
    }

    public void setEnterPressed(boolean pressed) {
        enterPressed = pressed;
    }

 
}
