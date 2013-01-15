package com.example.GlDemo;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.opengl.GLUtils;

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
    private FloatBuffer vertexBuffer;
    private float f = 1.f;
    private float vertices[] = {
            -f, -f,
            -f, f,
            f, -f,
            f, f
    };

    private FloatBuffer textureBuffer;
    private float texture[] = {
            0.0f, 1f,
            0.0f, 0.0f,
            1f, 1f,
            1f, 0.0f
    };
    private int[] textures = new int[1];

    public Polygon() {
        vertexBuffer = GlTools.getNativeOrderFloatBuffer(vertices);
        textureBuffer = GlTools.getNativeOrderFloatBuffer(texture);
    }

    /**
     * 加载纹理
     * @param gl10
     * @param context
     */
    public void loadTexture(GL10 gl10, Context context) {
        Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(),
                R.drawable.test);

        gl10.glGenTextures(1, textures, 0);//创建纹理对象
        gl10.glBindTexture(GL10.GL_TEXTURE_2D, textures[0]);//绑定纹理对象

        //设置放大和缩小过滤器
        gl10.glTexParameterf(GL10.GL_TEXTURE_2D, GL10.GL_TEXTURE_MIN_FILTER, GL10.GL_LINEAR);
        gl10.glTexParameterf(GL10.GL_TEXTURE_2D, GL10.GL_TEXTURE_MAG_FILTER, GL10.GL_LINEAR);

        GLUtils.texImage2D(GL10.GL_TEXTURE_2D, 0, bitmap, 0);  //指定纹理

        bitmap.recycle();
    }

    public void draw(GL10 gl10) {
        //绑定纹理数据
        gl10.glBindTexture(GL10.GL_TEXTURE_2D, textures[0]);

        gl10.glEnableClientState(GL10.GL_VERTEX_ARRAY);//begin
        gl10.glEnableClientState(GL10.GL_TEXTURE_COORD_ARRAY);

        //设置顶点数据
        gl10.glVertexPointer(2, GL10.GL_FLOAT, 0, vertexBuffer);
        //纹理映射
        gl10.glTexCoordPointer(2, GL10.GL_FLOAT, 0, textureBuffer);

        //绘制多边形
        gl10.glDrawArrays(GL10.GL_TRIANGLE_STRIP, 0, vertices.length / 2);

        gl10.glDisableClientState(GL10.GL_VERTEX_ARRAY); //end
        gl10.glDisableClientState(GL10.GL_TEXTURE_COORD_ARRAY);
    }
}
