package com.example.GlDemo;

import android.app.Activity;
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.util.Log;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import java.util.Random;

public class MainActivity extends Activity {
    private static String TAG = "GlDemo";

    private GLSurfaceView glSurfaceView;

    private Random random;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        random = new Random();
        glSurfaceView = new GLSurfaceView(this);
        //OpenGL使用Renderer做类似View的onDraw的事情
        glSurfaceView.setRenderer(new GLSurfaceView.Renderer() {

            private boolean rendered;

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
                gl10.glClearColor(random.nextFloat(), random.nextFloat(), random.nextFloat(), random.nextFloat());
                gl10.glClear(GL10.GL_COLOR_BUFFER_BIT);

                if(!rendered){
                    rendered=true;
                    Log.d(TAG,"GL render thread: "+Thread.currentThread().toString());

                    if(getMainLooper().getThread()!=Thread.currentThread()){
                        Log.d(TAG,">>>> render thread is not ui thread!");
                    }
                }
            }
        });
        this.setContentView(glSurfaceView);

        Log.d(TAG,"UI thread: "+Thread.currentThread().toString());
    }
}
