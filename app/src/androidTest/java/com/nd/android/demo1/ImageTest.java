package com.nd.android.demo1;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 2019/1/7.
 */
public class ImageTest {
    @Test
    public void getSetImageId() throws Exception {

        Image image1 = new Image(234);
        assertEquals("失败测试",image1.getImageId(), 234);

        int image = 123;
        image1.setImageId(image);
        assertEquals(image1.getImageId(), image);

    }

}