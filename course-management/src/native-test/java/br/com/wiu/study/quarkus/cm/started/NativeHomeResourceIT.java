package br.com.wiu.study.quarkus.cm.started;

import br.com.wiu.study.quarkus.cm.started.resource.HomeResourceTest;
import io.quarkus.test.junit.NativeImageTest;

@NativeImageTest
public class NativeHomeResourceIT extends HomeResourceTest {

    // Execute the same tests but in native mode.
}