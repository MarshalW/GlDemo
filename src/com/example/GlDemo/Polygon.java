package com.example.GlDemo;

import javax.microedition.khronos.opengles.GL10;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

/**
 * 用于画指定的多边形
 * User: marshal
 * Date: 13-1-9
 * Time: 下午2:40
 * To change this template use File | Settings | File Templates.
 */
public class Polygon {
    private int[] textures = new int[1];

    private FloatBuffer vertexBuffer;
    private float f = .5f;
    private float vertices[] = {
            -f,-f,
            -f,f,
            f,-f,
            f,f
    };

    public Polygon() {
        vertexBuffer = GlTools.getNativeOrderFloatBuffer(vertices);
    }

    public void draw(GL10 gl10) {
        gl10.glEnableClientState(GL10.GL_VERTEX_ARRAY);//begin

        gl10.glPointSize(5f);
        //设置顶点数据
        gl10.glVertexPointer(2, GL10.GL_FLOAT, 0, vertexBuffer);
        //设置图形颜色
        gl10.glColor4f(0.5f, 0.5f, 1.0f, 1.0f);
        //绘制多边形
        gl10.glDrawArrays(GL10.GL_TRIANGLE_STRIP, 0, vertices.length / 2);

        gl10.glDisableClientState(GL10.GL_VERTEX_ARRAY); //end
    }
}
