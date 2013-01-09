package com.example.GlDemo;

//import android.R;

import android.app.Activity;
import android.opengl.GLSurfaceView;
import android.os.Bundle;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

public class MainActivity extends Activity {
    private static String TAG = "GlDemo";

    private GLSurfaceView glSurfaceView;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        glSurfaceView = new GLSurfaceView(this);

        //OpenGL使用Renderer做类似View的onDraw的事情
        glSurfaceView.setRenderer(new SimpleRenderer(this));

        //设置为dirty再刷屏
        glSurfaceView.setRenderMode(GLSurfaceView.RENDERMODE_WHEN_DIRTY);
        this.setContentView(glSurfaceView);
    }
}
