package com.example.GlDemo;

import android.app.Activity;
import android.opengl.GLSurfaceView;
import android.os.Bundle;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class MainActivity extends Activity {

    private GLSurfaceView glSurfaceView;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        glSurfaceView = new GLSurfaceView(this);
        //OpenGL使用Renderer做类似View的onDraw的事情
        glSurfaceView.setRenderer(new GLSurfaceView.Renderer() {
            @Override
            public void onSurfaceCreated(GL10 gl10, EGLConfig eglConfig) {
                //To change body of implemented methods use File | Settings | File Templates.
            }

            @Override
            public void onSurfaceChanged(GL10 gl10, int i, int i2) {
                //To change body of implemented methods use File | Settings | File Templates.
            }

            @Override
            public void onDrawFrame(GL10 gl10) {
                //下面两句，颠倒写也没问题，要了解它们的意思，需要查OpenGL
                gl10.glClear(GL10.GL_COLOR_BUFFER_BIT);
                gl10.glClearColor(0.5f, 0.1f, 0.4f, 0.8f);
            }
        });
        this.setContentView(glSurfaceView);
    }
}
