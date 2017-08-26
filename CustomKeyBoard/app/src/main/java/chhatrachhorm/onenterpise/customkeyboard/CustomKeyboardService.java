package chhatrachhorm.onenterpise.customkeyboard;

import android.inputmethodservice.InputMethodService;
import android.inputmethodservice.Keyboard;
import android.inputmethodservice.KeyboardView;
import android.media.AudioManager;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputConnection;

/**
 * credit to :
 * https://code.tutsplus.com/tutorials/create-a-custom-keyboard-on-android--cms-22615
 * https://www.youtube.com/watch?v=7nsa7BuoWhU&t=314s
 */

public class CustomKeyboardService extends InputMethodService
    implements KeyboardView.OnKeyboardActionListener {
    private KeyboardView mKeyboardView;
    private Keyboard mKeyboard;

    private boolean caps = false;

    @Override
    public View onCreateInputView() {
        mKeyboardView = (KeyboardView) getLayoutInflater().inflate(R.layout.keyboard, null);
        mKeyboard = new Keyboard(this, R.xml.qwerty);
        mKeyboardView.setKeyboard(mKeyboard);
        mKeyboardView.setOnKeyboardActionListener(this);
        return mKeyboardView;
    }
    private void playClick(int keyCode){
        AudioManager am = (AudioManager)getSystemService(AUDIO_SERVICE);
        switch (keyCode){
            case 32:
                am.playSoundEffect(AudioManager.FX_KEYPRESS_SPACEBAR);
                break;
            case 10:
                am.playSoundEffect(AudioManager.FX_KEYPRESS_RETURN);
                break;
            case Keyboard.KEYCODE_DELETE:
                am.playSoundEffect(AudioManager.FX_KEYPRESS_DELETE);
                break;
            default:
                am.playSoundEffect(AudioManager.FX_KEYPRESS_STANDARD);

        }
    }

    @Override
    public void onPress(int i) {

    }

    @Override
    public void onRelease(int i) {

    }

    @Override
    public void onKey(int primaryCode, int[] keyCodes) {
        InputConnection ic = getCurrentInputConnection();
        playClick(primaryCode);
        switch(primaryCode){
            case Keyboard.KEYCODE_DELETE:
                ic.deleteSurroundingText(1, 0);
                break;
            case Keyboard.KEYCODE_SHIFT:
                caps = !caps;
                mKeyboard.setShifted(caps);
                mKeyboardView.invalidateAllKeys();
                break;
            case Keyboard.KEYCODE_DONE:
                ic.sendKeyEvent(new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_ENTER));
                break;
            default:
                char code = (char) primaryCode;
                if(Character.isLetter(code) && caps){
                    code = Character.toUpperCase(code);
                }
                ic.commitText(String.valueOf(code), 1);

        }
    }

    @Override
    public void onText(CharSequence charSequence) {

    }

    @Override
    public void swipeLeft() {

    }

    @Override
    public void swipeDown() {

    }

    @Override
    public void swipeRight() {

    }

    @Override
    public void swipeUp() {

    }
}
