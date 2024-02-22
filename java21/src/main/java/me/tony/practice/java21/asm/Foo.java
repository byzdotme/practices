package me.tony.practice.java21.asm;

import org.objectweb.asm.ClassWriter;

import static org.objectweb.asm.ClassWriter.COMPUTE_FRAMES;

public class Foo {

    public static void main(String[] args) {
        var cw = new ClassWriter(COMPUTE_FRAMES);
    }
}
