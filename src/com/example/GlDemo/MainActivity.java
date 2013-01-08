package com.example.GlDemo;

import android.*;
import android.R;
import android.app.Activity;
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.util.Log;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
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
                //清空底色
                gl10.glClear(GL10.GL_COLOR_BUFFER_BIT);

                //开始画三角形
                float f = 0.4f;
                //三角形顶点数据
                float[] array = new float[]{-f, 0,  0, f,  f, 0};
                gl10.glEnableClientState(GL10.GL_VERTEX_ARRAY);
                gl10.glPointSize(5f);
                FloatBuffer triangleBuffer = getNativeOrderFloatBuffer(array);
                //设置顶点数据
                gl10.glVertexPointer(2, GL10.GL_FLOAT, 0, triangleBuffer);
                //画三角形的三个边
                gl10.glPointSize(10f);
                gl10.glDrawArrays(GL10.GL_LINE_LOOP, 0, 3);
            }
        });
        //设置为dirty再刷屏
        glSurfaceView.setRenderMode(GLSurfaceView.RENDERMODE_WHEN_DIRTY);
        this.setContentView(glSurfaceView);
    }

    /**
     * 将浮点数组转换为FloatBuffer
     * @param array
     * @return
     */
    public static FloatBuffer getNativeOrderFloatBuffer(float[] array) {
        ByteBuffer buffer = ByteBuffer.allocateDirect(array.length * 4);
        buffer.order(ByteOrder.nativeOrder());
        FloatBuffer floatBuffer = buffer.asFloatBuffer();
        floatBuffer.put(array);
        floatBuffer.position(0);
        return floatBuffer;
    }
}
