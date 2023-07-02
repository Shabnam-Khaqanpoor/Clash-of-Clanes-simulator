package com.example.game;

import javafx.scene.Node;

public class DraggableMaker {
    public static double mouseAnchorX;
    public static double mouseAnchorY;

    public static void makeDraggable(Node node,Node node1) {
        node.setOnMousePressed(mouseEvent -> {
            mouseAnchorX = mouseEvent.getX();
            mouseAnchorY = mouseEvent.getY();
        });

        node.setOnMouseDragged(mouseEvent -> {
            node.setLayoutX(mouseEvent.getSceneX() - mouseAnchorX);
            node.setLayoutY(mouseEvent.getSceneY() - mouseAnchorY);
            node1.setLayoutX(mouseEvent.getSceneX() - mouseAnchorX);
            node1.setLayoutY(mouseEvent.getSceneY() - mouseAnchorY);
        });

//        node.setOnMouseReleased(mouseEvent->{
//            node.setOnMousePressed(null);
//            node.setOnMouseDragged(null);
//            node.setOnMouseReleased(null);
//        });
    }
}
