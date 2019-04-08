package com.file;

import com.imagesFile.BirdPNG;
import lombok.Getter;
import lombok.Setter;

import java.io.File;

@Getter
@Setter
public class BirdFile {

    private BirdPNG birdPNG = new BirdPNG();
    private File bird1File = new File(birdPNG.getBird1PNG());
    private File bird2File = new File(birdPNG.getBird2PNG());
}
