package com.file;

import com.imagesFile.MapPNG;
import lombok.Getter;
import lombok.Setter;

import java.io.File;

/*
* 背景图片文件路径
* */
@Setter
@Getter
public class MapFile {

    private MapPNG mapPNG = new MapPNG();

    private File map = new File(mapPNG.getMap());
    private File map1 = new File(mapPNG.getMap1());
}
