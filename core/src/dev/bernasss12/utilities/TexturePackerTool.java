package dev.bernasss12.utilities;

import com.badlogic.gdx.tools.texturepacker.TexturePacker;

import java.util.Scanner;

public class TexturePackerTool {
    public static void main(String[] args){
        System.out.println("Waiting for user input:\n>");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        TexturePacker.process(
                "utils/unpacked/",
                "utils/packed/",
                name);
    }
}
