package com.example.GlDemo;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

/**
 * Created with IntelliJ IDEA.
 * User: marshal
 * Date: 13-1-9
 * Time: 下午5:04
 * To change this template use File | Settings | File Templates.
 */
public class GlTools {
    /**
     * 将浮点数组转换为FloatBuffer
     *
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
