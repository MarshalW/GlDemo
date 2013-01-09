package com.example.GlDemo;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.opengl.GLU;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import java.nio.FloatBuffer;

/**
 * Created with IntelliJ IDEA.
 * User: marshal
 * Date: 13-1-9
 * Time: 下午5:05
 * To change this template use File | Settings | File Templates.
 */
public class SimpleRenderer implements GLSurfaceView.Renderer {

    private Context context;

    private Polygon polygon;

    public SimpleRenderer(Context context) {
        this.context = context;
        this.polygon = new Polygon();
    }

    @Override
    public void onSurfaceCreated(GL10 gl10, EGLConfig eglConfig) {
    }

    @Override
    public void onSurfaceChanged(GL10 gl10, int width, int height) {
        gl10.glViewport(0, 0, width, height);

        //TODO 有关投影方面的知识还需要学习理解，以下代码摘自android文档。
        float ratio = (float) width / height;
//        gl10.glMatrixMode(GL10.GL_PROJECTION);        // set matrix to projection mode
//        gl10.glLoadIdentity();                        // reset the matrix to its default state
        gl10.glFrustumf(-ratio, ratio, -1, 1, 3, 7);  // apply the projection matrix
    }

    @Override
    public void onDrawFrame(GL10 gl10) {
        //清空底色
        gl10.glClear(GL10.GL_COLOR_BUFFER_BIT);

//        gl10.glMatrixMode(GL10.GL_MODELVIEW);
//        gl10.glLoadIdentity();

        GLU.gluLookAt(gl10, 0, 0, -5, 0f, 0f, 0f, 0f, 1.0f, 0.0f);

        //画多边形
        this.polygon.draw(gl10);
    }
}
