package com.example.game;

import javafx.scene.Node;

public class DraggableMaker {
    public static double mouseAnchorX;
    public static double mouseAnchorY;

    public static void makeDraggable(Node node){
        node.setOnMousePressed(mouseEvent ->{
            mouseAnchorX=mouseEvent.getX();
            mouseAnchorY=mouseEvent.getY();
        });

        node.setOnMouseDragged(mouseEvent ->{
            node.setLayoutX(mouseEvent.getSceneX()-mouseAnchorX);
            node.setLayoutY(mouseEvent.getSceneY()-mouseAnchorY);
        });
    }
}
